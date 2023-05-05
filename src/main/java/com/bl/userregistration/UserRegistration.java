package com.bl.userregistration;

import java.util.Scanner;

public class UserRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstName = getValidFirstName(sc);
        String lastName = getValidLastName(sc);
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
    public static String getValidLastName(Scanner sc){
        System.out.println("Enter your last  name: ");
        String lastName = sc.nextLine();
        boolean isValidLastName = lastName.matches("[A-Z][a-zA-Z]{2,}");
        if (!isValidLastName) {
            System.out.println("Invalid First Name");
            lastName = getValidLastName(sc);
        }
        return lastName;
    }

}
