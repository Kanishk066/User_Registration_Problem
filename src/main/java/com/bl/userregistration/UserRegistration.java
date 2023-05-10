package com.bl.userregistration;
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
    public static void validateFirstName(String firstName) throws InvalidUserDetailsException {
        if (!firstName.matches("[A-Z][a-zA-Z]{2,}")) {
            throw new InvalidUserDetailsException(InvalidUserDetailsException.ExceptionType.INVALID_FIRST_NAME,"Invalid first name! Please enter a valid first name");
        }
    }

    public static void validateLastName(String lastName) throws InvalidUserDetailsException {
        if (!lastName.matches("[A-Z][a-zA-Z]{2,}")) {
            throw new InvalidUserDetailsException(InvalidUserDetailsException.ExceptionType.INVALID_LAST_NAME,"Invalid last name! Please enter a valid last name");
        }
    }

    public static void validateEmail(String email) throws InvalidUserDetailsException {
        if (!email.matches("[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+([.][a-zA-Z]{2,}){1,2}")) {
            throw new InvalidUserDetailsException(InvalidUserDetailsException.ExceptionType.INVALID_EMAIL,"Invalid email! Please enter a valid email address");
        }
    }

    public static void validateMobileNumber(String mobileNumber) throws InvalidUserDetailsException {
        if (!mobileNumber.matches("\\d{2} \\d{10}")) {
            throw new InvalidUserDetailsException(InvalidUserDetailsException.ExceptionType.INVALID_MOBILE_NUMBER,"Invalid mobile number! Please enter a valid mobile number");
        }
    }

    public static void validatePassword(String password) throws InvalidUserDetailsException {
        // Rule 1: minimum 8 characters
        boolean isValidLength = password.length() >= 8;
        // Rule 2: should have at least 1 uppercase letter
        boolean hasUppercase = password.matches(".*[A-Z].*");
        // Rule 3: should have at least 1 numeric number
        boolean hasNumber = password.matches(".*\\d.*");
        // Rule 4: should have exactly 1 special character
        boolean hasSpecialChar = password.matches(".*[!@#$%^&*()_+].*") && password.replaceAll("[!@#$%^&*()_+]", "").length() == password.length() - 1;

        if (!(isValidLength && hasUppercase && hasNumber && hasSpecialChar)) {
            throw new InvalidUserDetailsException(InvalidUserDetailsException.ExceptionType.INVALID_PASSWORD,"Invalid password! Please enter a valid password");
        }
    }
}


