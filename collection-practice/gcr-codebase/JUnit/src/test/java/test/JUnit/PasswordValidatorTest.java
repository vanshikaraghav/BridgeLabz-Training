package test.JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {

    PasswordValidator validator = new PasswordValidator();

    @Test
    void testValidPassword() {
        assertTrue(validator.isValid("Secure123"));
    }

    @Test
    void testInvalidPassword_NoUppercase() {
        assertFalse(validator.isValid("secure123"));
    }

    @Test
    void testInvalidPassword_Short() {
        assertFalse(validator.isValid("Ab1"));
    }
}