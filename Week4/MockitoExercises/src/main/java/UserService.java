public class UserService {

    private EmailService emailService;

    public UserService(EmailService emailService) {
        this.emailService = emailService;
    }

    public String register(String email) {
        return emailService.sendEmail(email);
    }

}