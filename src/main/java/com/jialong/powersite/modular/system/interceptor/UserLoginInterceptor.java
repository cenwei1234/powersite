package com.jialong.powersite.modular.system.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jialong.powersite.core.thread.UserThreadLocal;
import com.jialong.powersite.core.utils.CookieUtils;
import com.jialong.powersite.core.wrapper.CustomHttpServletRequestWrapper;
import com.jialong.powersite.modular.system.mapper.UserMapper;
import com.jialong.powersite.modular.system.model.User;
import com.jialong.powersite.modular.system.service.impl.UserServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
@SpringBootConfiguration
public class UserLoginInterceptor implements HandlerInterceptor {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getParameter("token");

        if (StringUtils.isEmpty(token))
        {
            return false;
        }

        User user = this.userMapper.queryUserByToken(token);
        if(user == null)
        {
            return false;
        }
        //此处user已经得到，需要将user传递给后续的处理方法即可
        //修改session中保存的时间
        HttpSession session = request.getSession(true);
        session.setAttribute(user.getUsername(), token);
        session.setMaxInactiveInterval(3600);

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
