package com.ecommerce.service;

public class UserService {

    private EmailService emailService;

    public UserService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void registerUser() {

        System.out.println("User Registered");

        emailService.sendEmail();

    }

}