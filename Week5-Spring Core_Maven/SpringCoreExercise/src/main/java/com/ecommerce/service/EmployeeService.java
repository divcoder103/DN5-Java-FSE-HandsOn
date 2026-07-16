package com.ecommerce.service;

public class EmployeeService {

    private EmailService emailService;

    public EmployeeService() {
    }

    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void addEmployee() {
        System.out.println("Employee Added");
        emailService.sendEmail();
    }
}