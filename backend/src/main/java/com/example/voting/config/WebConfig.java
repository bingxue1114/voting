package com.example.voting.config;  // 根據專案包結構修改

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 允許來自 localhost:8081 的請求
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8081")  // 前端應用的 URL
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // 允許的 HTTP 方法
                .allowedHeaders("*"); 
    }
}
