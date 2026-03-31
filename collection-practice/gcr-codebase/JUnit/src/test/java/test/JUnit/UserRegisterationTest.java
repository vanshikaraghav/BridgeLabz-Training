package test.JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserRegisterationTest {

    UserRegisteration registration = new UserRegisteration();

    @Test
    void testValidRegistration() {
        assertDoesNotThrow(() -> {
            registration.registerUser("john", "john@example.com", "Password1");
        });
    }

    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("john", "johnexample.com", "Password1");
        });
    }

    @Test
    void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("john", "john@example.com", "pass");
        });
    }
}