package com.bl.userregistration;

import java.util.function.Predicate;
class InvalidUserDetailsException extends Exception {
    public enum ExceptionType {
        INVALID_FIRST_NAME, INVALID_LAST_NAME, INVALID_EMAIL, INVALID_MOBILE_NUMBER, INVALID_PASSWORD
    }

    ExceptionType type;

    public InvalidUserDetailsException(ExceptionType type, String errorMessage) {
        super(errorMessage);
        this.type = type;
    }
}

public class UserRegistration {

    public static void validateUserEntry(String userInput, Predicate<String> predicate, InvalidUserDetailsException.ExceptionType exceptionType) throws InvalidUserDetailsException {
        if (!predicate.test(userInput)) {
            throw new InvalidUserDetailsException(exceptionType, "Invalid entry! Please enter a valid " + exceptionType.name().toLowerCase().replace("_", " "));
        }
    }

    public static void main(String[] args) {
        try {
            String firstName = "Kanishk";
            String lastName = "Singhal";
            String email = "kanishksinghal@example.com";
            String mobileNumber = "91 1234567890";
            String password = "password!";

            validateUserEntry(firstName, name -> name.matches("[A-Z][a-zA-Z]{2,}"), InvalidUserDetailsException.ExceptionType.INVALID_FIRST_NAME);
            validateUserEntry(lastName, name -> name.matches("[A-Z][a-zA-Z]{2,}"), InvalidUserDetailsException.ExceptionType.INVALID_LAST_NAME);
            validateUserEntry(email, emailAddr -> emailAddr.matches("[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+([.][a-zA-Z]{2,}){1,2}"), InvalidUserDetailsException.ExceptionType.INVALID_EMAIL);
            validateUserEntry(mobileNumber, mobNo -> mobNo.matches("\\d{2} \\d{10}"), InvalidUserDetailsException.ExceptionType.INVALID_MOBILE_NUMBER);
            validateUserEntry(password, pass -> pass.length() >= 8 && pass.matches(".*[A-Z].*") && pass.matches(".*\\d.*") && pass.matches(".*[!@#$%^&*()_+].*") && pass.replaceAll("[!@#$%^&*()_+]", "").length() == pass.length() - 1, InvalidUserDetailsException.ExceptionType.INVALID_PASSWORD);

            System.out.println("All entries are valid");
        } catch (InvalidUserDetailsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

