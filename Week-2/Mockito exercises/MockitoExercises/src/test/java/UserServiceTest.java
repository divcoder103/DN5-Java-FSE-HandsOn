import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private EmailService emailService;

    @InjectMocks
    private UserService userService;

    @Test
    void testRegister() {

        when(emailService.sendEmail("abc@gmail.com"))
                .thenReturn("Mock Email Sent");

        String result = userService.register("abc@gmail.com");

        assertEquals("Mock Email Sent", result);

        verify(emailService).sendEmail("abc@gmail.com");
    }

    @Test
    void testRegisterCalledTwice() {

        when(emailService.sendEmail("abc@gmail.com"))
                .thenReturn("Mock Email Sent");

        userService.register("abc@gmail.com");
        userService.register("abc@gmail.com");

        verify(emailService, times(2))
                .sendEmail("abc@gmail.com");
    }

    @Test
    void testNeverCalled() {

        verify(emailService, never())
                .sendEmail("abc@gmail.com");
    }

    @Test
    void testAtLeastOnce() {

        when(emailService.sendEmail("abc@gmail.com"))
                .thenReturn("Mock Email Sent");

        userService.register("abc@gmail.com");

        verify(emailService, atLeastOnce())
                .sendEmail("abc@gmail.com");
    }
}