package com.jialong.powersite.config;

import com.jialong.powersite.modular.system.interceptor.UserLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private UserLoginInterceptor userLoginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> pathPatternList = new ArrayList<>();
        pathPatternList.add("/admin/**");
        pathPatternList.add("/api/**");
        registry.addInterceptor(userLoginInterceptor).addPathPatterns(pathPatternList).excludePathPatterns("/admin/user/login");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {

    }

    @Bean
    public UserLoginInterceptor loginInterceptor(){
        return new UserLoginInterceptor();
    }

}
