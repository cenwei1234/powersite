package com.jialong.powersite.config;

import com.jialong.powersite.modular.system.interceptor.UserLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private UserLoginInterceptor userLoginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userLoginInterceptor).addPathPatterns(("/admin/**"));
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {

    }

    @Bean
    public UserLoginInterceptor loginInterceptor(){
        return new UserLoginInterceptor();
    }

}
