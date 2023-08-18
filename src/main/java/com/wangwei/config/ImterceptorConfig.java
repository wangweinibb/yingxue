package com.wangwei.config;

import com.wangwei.interceptor.MyInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class ImterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        拦截的请求
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/api/admin/*");
    }
}
