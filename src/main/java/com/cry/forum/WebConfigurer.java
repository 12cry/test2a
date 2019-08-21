package com.cry.forum;

import com.cry.forum.common.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(RequestInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public RequestInterceptor RequestInterceptor() {
        return new RequestInterceptor();
    }

}
