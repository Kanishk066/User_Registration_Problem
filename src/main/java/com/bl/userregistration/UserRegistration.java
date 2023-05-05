package com.bl.userregistration;

import java.util.Scanner;

public class UserRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstName = getValidFirstName(sc);
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
}
