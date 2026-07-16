package com.ecommerce.config;

import com.ecommerce.service.EmailService;
import com.ecommerce.service.EmployeeService;
import com.ecommerce.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DIConfig {

    @Bean
    public EmailService emailService() {
        return new EmailService();
    }

    @Bean
    public UserService userService() {
        return new UserService(emailService());
    }
    @Bean
    public EmployeeService employeeService() {

        EmployeeService employeeService = new EmployeeService();

        employeeService.setEmailService(emailService());

        return employeeService;
    }

}