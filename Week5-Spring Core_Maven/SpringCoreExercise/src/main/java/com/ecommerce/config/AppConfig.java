package com.ecommerce.config;

import com.ecommerce.service.GreetingService;
import com.ecommerce.service.GreetingServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public GreetingService greetingService() {
        return new GreetingServiceImpl();
    }

}