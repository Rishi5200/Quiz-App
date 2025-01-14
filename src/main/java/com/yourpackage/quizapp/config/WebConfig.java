package com.yourpackage.quizapp.config; // Package for configuration classes

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/quiz/**")
                .allowedOrigins("http://localhost:8080") // Frontend URL
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}
