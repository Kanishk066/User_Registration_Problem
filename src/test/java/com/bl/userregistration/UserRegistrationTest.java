package com.bl.userregistration;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserRegistrationTest {
    @Test
    public void testValidFirstName() {
        assertTrue(UserRegistration.isValidFirstName("Kanishk"));
    }
    @Test
    public void testInvalidFirstName() {
        assertFalse(UserRegistration.isValidFirstName("kanishk"));
    }
    @Test
    public void testValidLastName() {
        assertTrue(UserRegistration.isValidLastName("Singhal"));
    }
    @Test
    public void testInvalidLastName() {
        assertFalse(UserRegistration.isValidLastName("singhal"));
    }
    @Test
    public void testValidEmail() {
        assertTrue(UserRegistration.isValidEmail("kanishk.singhal@example.com"));
    }

    @Test
    public void testInvalidEmail() {
        assertFalse(UserRegistration.isValidEmail("kanishksinghalexample.com"));
    }

    @Test
    public  void testValidMobileNumber() {
        assertTrue(UserRegistration.isValidMobileNumber("91 1234567890"));
    }

    @Test
    public void testInvalidMobileNumber() {
        assertFalse(UserRegistration.isValidMobileNumber("1234567890"));
    }

    @Test
    public void testValidPassword() {
        assertTrue(UserRegistration.isValidPassword("P@ssword123"));
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(UserRegistration.isValidPassword("password"));
    }
}
