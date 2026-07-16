package com.ecommerce.main;

import com.ecommerce.config.DIConfig;
import com.ecommerce.service.EmployeeService;
import com.ecommerce.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DIApp {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(DIConfig.class);

        UserService userService =
                context.getBean(UserService.class);

        userService.registerUser();

        EmployeeService employeeService =
                context.getBean(EmployeeService.class);

        employeeService.addEmployee();

    }


}