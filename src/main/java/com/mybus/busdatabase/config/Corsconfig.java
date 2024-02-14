package com.mybus.busdatabase.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Corsconfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/bus/") // Replace "/api/**" with the path of your API
            .allowedOrigins("http://localhost:63697/") // Replace with the origin of your Flutter web app
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            // Add allowed HTTP methods
            .allowCredentials(true); // Allow sending cookies with the request
    }
}
