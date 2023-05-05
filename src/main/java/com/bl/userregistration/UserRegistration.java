package com.bl.userregistration;

import java.util.Scanner;

public class UserRegistration {
    public static boolean isValidFirstName(String firstName) {
        return firstName.matches("[A-Z][a-zA-Z]{2,}");
    }
    public static boolean isValidLastName(String lastName) {
        return lastName.matches("[A-Z][a-zA-Z]{2,}");
    }
    public static boolean isValidEmail(String email) {
        return email.matches("[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+([.][a-zA-Z]{2,}){1,2}");
    }
    public static boolean isValidMobileNumber(String mobileNumber) {
        return mobileNumber.matches("\\d{2} \\d{10}");
    }
    public static boolean isValidPassword(String password) {
        return password.length() >= 8;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        String firstName = sc.nextLine();
        boolean isValidFirstName = isValidFirstName(firstName);

        System.out.println("Enter your last name: ");
        String lastName = sc.nextLine();
        boolean isValidLastName = isValidLastName(lastName);

        System.out.println("Enter your email: ");
        String email = sc.nextLine();
        boolean isValidEmail = isValidEmail(email);

        System.out.println("Enter your mobile number: ");
        String mobileNumber = sc.nextLine();
        boolean isValidMobileNumber = isValidMobileNumber(mobileNumber);

        System.out.println("Enter your password: ");
        String password = sc.nextLine();
        boolean isValidPassword = isValidPassword(password);

        if (isValidFirstName && isValidLastName && isValidEmail && isValidMobileNumber && isValidPassword) {
            System.out.println("Valid first name, last name, email, mobile number, and password!");
        } else {
            if (!isValidFirstName) {
                System.out.println("Invalid first name! Please enter a valid first name");
            }
            if (!isValidLastName) {
                System.out.println("Invalid last name! Please enter a valid last name");
            }
            if (!isValidEmail) {
                System.out.println("Invalid email! Please enter a valid email address");
            }
            if (!isValidMobileNumber) {
                System.out.println("Invalid mobile number! Please enter a valid mobile number");
            }
            if (!isValidPassword) {
                System.out.println("Invalid password! Please enter a valid password");
            }
        }
    }
}

