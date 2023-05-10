package com.bl.userregistration;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserRegistrationTest {
    @Test
    public void givenValidFirstName_ShouldReturnTrue() {
        try {
            UserRegistration.validateFirstName("John");
        } catch (InvalidUserDetailsException e) {
            fail("Should not have thrown any exception");
        }
    }

    @Test
    public void givenInvalidFirstName_ShouldThrowInvalidUserDetailsException() {
        try {
            UserRegistration.validateFirstName("jo");
            fail("Should have thrown InvalidUserDetailsException");
        } catch (InvalidUserDetailsException e) {
            assertEquals("Invalid first name! Please enter a valid first name", e.getMessage());
        }
    }

    @Test
    public void givenValidLastName_ShouldReturnTrue() {
        try {
            UserRegistration.validateLastName("Doe");
        } catch (InvalidUserDetailsException e) {
            fail("Should not have thrown any exception");
        }
    }

    @Test
    public void givenInvalidLastName_ShouldThrowInvalidUserDetailsException() {
        try {
            UserRegistration.validateLastName("do");
            fail("Should have thrown InvalidUserDetailsException");
        } catch (InvalidUserDetailsException e) {
            assertEquals(InvalidUserDetailsException.ExceptionType.INVALID_LAST_NAME, e.type);
        }
    }
    @Test
    public void givenInvalidEmail_ShouldThrowInvalidUserDetailsException() {
        try {
            UserRegistration.validateEmail("abc@.com");
            fail("Should have thrown InvalidUserDetailsException");
        } catch (InvalidUserDetailsException e) {
            assertEquals(InvalidUserDetailsException.ExceptionType.INVALID_EMAIL, e.type);
        }
    }
    @Test
    public void givenInvalidMobileNumber_ShouldThrowInvalidUserDetailsException() {
        try {
            UserRegistration.validateMobileNumber("91 12345678");
            fail("Should have thrown InvalidUserDetailsException");
        } catch (InvalidUserDetailsException e) {
            assertEquals(InvalidUserDetailsException.ExceptionType.INVALID_MOBILE_NUMBER, e.type);
        }
    }

    @Test
    public void givenInvalidPassword_ShouldThrowInvalidUserDetailsException() {
        try {
            UserRegistration.validatePassword("1234567");
            fail("Should have thrown InvalidUserDetailsException");
        } catch (InvalidUserDetailsException e) {
            assertEquals(InvalidUserDetailsException.ExceptionType.INVALID_PASSWORD, e.type);
        }
    }
}
