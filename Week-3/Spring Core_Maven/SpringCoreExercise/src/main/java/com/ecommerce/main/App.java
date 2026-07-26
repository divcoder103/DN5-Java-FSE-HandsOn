package com.ecommerce.main;

import com.ecommerce.config.AppConfig;
import com.ecommerce.service.GreetingService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        GreetingService service =
                context.getBean(GreetingService.class);

        service.greet();
    }
}