package com.shareluntan.xuefeng.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器,多个拦截器时 以此添加 执行顺序按添加顺序
        InterceptorRegistration registration= registry.addInterceptor(getHandlerInterceptor());
        //拦截规则,add表示拦截哪些路径,exclude表示放行哪些
        registration.addPathPatterns("/login");

    }

    @Bean
    public static HandlerInterceptor getHandlerInterceptor() {
        return new CustomHandlerInterceptor();
    }
}