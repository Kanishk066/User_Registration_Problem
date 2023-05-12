package com.bl.userregistration;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserRegistrationTest {
    @Test
    public void testValidUserEntry() {
        try {
            String firstName = "John";
            String lastName = "Doe";
            String email = "johndoe@example.com";
            String mobileNumber = "91 1234567890";
            String password = "passw0rd!";

            UserRegistration.validateUserEntry(firstName, name -> name.matches("[A-Z][a-zA-Z]{2,}"), InvalidUserDetailsException.ExceptionType.INVALID_FIRST_NAME);
            UserRegistration.validateUserEntry(lastName, name -> name.matches("[A-Z][a-zA-Z]{2,}"), InvalidUserDetailsException.ExceptionType.INVALID_LAST_NAME);
            UserRegistration.validateUserEntry(email, emailAddr -> emailAddr.matches("[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+([.][a-zA-Z]{2,}){1,2}"), InvalidUserDetailsException.ExceptionType.INVALID_EMAIL);
            UserRegistration.validateUserEntry(mobileNumber, mobNo -> mobNo.matches("\\d{2} \\d{10}"), InvalidUserDetailsException.ExceptionType.INVALID_MOBILE_NUMBER);
            UserRegistration.validateUserEntry(password, pass -> pass.length() >= 8 && pass.matches(".*[A-Z].*") && pass.matches(".*\\d.*") && pass.matches(".*[!@#$%^&*()_+].*") && pass.replaceAll("[!@#$%^&*()_+]", "").length() == pass.length() - 1, InvalidUserDetailsException.ExceptionType.INVALID_PASSWORD);

            // If the program execution reaches this line, it means all entries are valid
            assertTrue(true);
        } catch (InvalidUserDetailsException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testInvalidFirstName() {
        try {
            String firstName = "kanishk";
            UserRegistration.validateUserEntry(firstName, name -> name.matches("[A-Z][a-zA-Z]{2,}"), InvalidUserDetailsException.ExceptionType.INVALID_FIRST_NAME);

            fail("Expected InvalidUserDetailsException");
        } catch (InvalidUserDetailsException e) {
            assertEquals(InvalidUserDetailsException.ExceptionType.INVALID_FIRST_NAME, e.type);
            assertEquals("Invalid entry! Please enter a valid first name", e.getMessage());
        }
    }
    @Test
    public void testInvalidLastName() {
        try {
            String lastName = "Singhal";
            UserRegistration.validateUserEntry(lastName, name -> name.matches("[A-Z][a-zA-Z]{2,}"), InvalidUserDetailsException.ExceptionType.INVALID_LAST_NAME);

            fail("Expected InvalidUserDetailsException");
        } catch (InvalidUserDetailsException e) {
            assertEquals(InvalidUserDetailsException.ExceptionType.INVALID_LAST_NAME, e.type);
            assertEquals("Invalid entry! Please enter a valid first name", e.getMessage());
        }
    }
    @Test
    public void testInvalidEmail() {
        try {
            String email = "kanishksinghal@example.com";
            UserRegistration.validateUserEntry(email, name -> name.matches("[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+([.][a-zA-Z]{2,}){1,2}"), InvalidUserDetailsException.ExceptionType.INVALID_EMAIL);

            fail("Expected InvalidUserDetailsException");
        } catch (InvalidUserDetailsException e) {
            assertEquals(InvalidUserDetailsException.ExceptionType.INVALID_EMAIL, e.type);
            assertEquals("Invalid entry! Please enter a valid first name", e.getMessage());
        }
    }
}
