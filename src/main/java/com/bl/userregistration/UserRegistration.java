package com.bl.userregistration;

import java.util.Scanner;

public class UserRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        getValidFirstName(sc);
        getValidLastName(sc);
        getValidEmail(sc);
        getValidMobileNumber(sc);
        System.out.println("Valid first name, last name, email, and mobile number!");
    }
    public static String getValidFirstName(Scanner sc) {
        System.out.println("Enter your first  name: ");
        String firstName = sc.nextLine();
        boolean isValidFirstName = firstName.matches("[A-Z][a-zA-Z]{2,}");
        if (!isValidFirstName) {
            System.out.println("Invalid First Name");
            firstName = getValidFirstName(sc);
        }
        return firstName;
    }
    public static String getValidLastName(Scanner sc) {
        System.out.println("Enter your last  name: ");
        String lastName = sc.nextLine();
        boolean isValidLastName = lastName.matches("[A-Z][a-zA-Z]{2,}");
        if (!isValidLastName) {
            System.out.println("Invalid First Name");
            lastName = getValidLastName(sc);
        }
        return lastName;
    }
    public static String getValidEmail(Scanner sc) {
        System.out.println("Enter your email id: ");
        String email = sc.nextLine();
        boolean isValidEmail = email.matches("[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+([.][a-zA-Z]{2,}){1,2}");
        if (!isValidEmail) {
            System.out.println("Invalid Email Id");
            email = getValidEmail(sc);
        }
        return email;
    }
    public static String getValidMobileNumber(Scanner sc){
        System.out.println("Enter your mobile number: ");
        String mobileNumber = sc.nextLine();
        boolean isValidMobileNumber = mobileNumber.matches("[0-9]{2} [0-9]{10}");
        if (!isValidMobileNumber){
            System.out.println("Invalid mobile number!");
            mobileNumber = getValidMobileNumber(sc);
        }
        return mobileNumber;
    }
}

