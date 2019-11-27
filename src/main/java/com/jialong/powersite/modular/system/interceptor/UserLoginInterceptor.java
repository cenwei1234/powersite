package com.jialong.powersite.modular.system.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.jialong.powersite.core.common.constant.Constant;
import com.jialong.powersite.core.exception.BizExceptionEnum;
import com.jialong.powersite.core.thread.UserThreadLocal;
import com.jialong.powersite.modular.system.mapper.UserMapper;
import com.jialong.powersite.modular.system.model.User;
import com.jialong.powersite.modular.system.model.response.BaseResp;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
@SpringBootConfiguration
public class UserLoginInterceptor implements HandlerInterceptor {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getParameter("token");

        BaseResp baseResp = new BaseResp();
        response.setContentType("text/html;charset=UTF-8");
        //需要传递token的接口却没有传递 需要拦截住
        if (StringUtils.isEmpty(token))
        {
            baseResp.setErrorCode(String.valueOf(BizExceptionEnum.TOKEN_EMPTY.getCode()));
            baseResp.setErrorMsg(BizExceptionEnum.TOKEN_EMPTY.getMessage());
            response.getWriter().write(JSONObject.toJSONString(baseResp));
            return false;
        }

        //传递的token都没有对应的用户 说明是错误的token 需要拦截住
        User user = this.userMapper.queryUserByToken(token);
        if(user == null)
        {
            baseResp.setErrorCode(String.valueOf(BizExceptionEnum.TOKEN_INVALID.getCode()));
            baseResp.setErrorMsg(BizExceptionEnum.TOKEN_INVALID.getMessage());
            response.getWriter().write(JSONObject.toJSONString(baseResp));
            return false;
        }
        //此处user已经得到，需要将user传递给后续的处理方法即可
        //修改session中保存的时间
        HttpSession session = request.getSession(true);

        //至此证明token是正确的 从session里面是否能取出对应的token 取不出证明是失效的
        String sessionToken = (String)session.getAttribute(user.getUsername());

        if (StringUtils.isEmpty(sessionToken))
        {
            //这里证明token是失效的
            baseResp.setErrorCode(String.valueOf(BizExceptionEnum.TOKEN_EXPIRED.getCode()));
            baseResp.setErrorMsg(BizExceptionEnum.TOKEN_EXPIRED.getMessage());
            response.getWriter().write(JSONObject.toJSONString(baseResp));
            return false;
        }
        //取得出token需要把token的有效期刷新为新的时间周期
        session.setAttribute(user.getUsername(), token);
        session.setMaxInactiveInterval(Constant.SESSION_VALIDTIME);

        //通过拦截器==到达Controller==到达service 一个线程
        UserThreadLocal.set(user);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //完成方法中，在视图渲染完成后，擦除本地线程中的User对象
        UserThreadLocal.set(null);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
