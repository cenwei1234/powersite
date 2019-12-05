package com.jialong.powersite.config;
//记得修改包路径

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class ImageUpLoadConfig implements WebMvcConfigurer {

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //此处为你的绝对路径配置虚拟路径
        //registry.addResourceHandler("/upload/**").addResourceLocations("file:D:/MusicImage/");
    }
}