/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2;
import java.util.Scanner;
/**
 *
 * @author BED
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        final int MAX_USERS = 100;
        String[][] users = new String[MAX_USERS][2];
        int userCount = 0;
        boolean running = true;

        while (running) {
            System.out.println("\n==== LOGIN SYSTEM ====");
            System.out.println("[1] Login");
            System.out.println("[2] Register");
            System.out.println("[3] Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String loginUser = sc.nextLine();

                    System.out.print("Enter password: ");
                    String loginPass = sc.nextLine();

                    boolean found = false;

                    for (int i = 0; i < userCount; i++) {
                        if (users[i][0].equals(loginUser) && users[i][1].equals(loginPass)) {
                            System.out.println("Hello, " + loginUser + "!");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Invalid username or password!");
                    }
                    break;

                case 2:
                    System.out.print("Enter new username: ");
                    String newUser = sc.nextLine();

                    boolean exists = false;
                    for (int i = 0; i < userCount; i++) {
                        if (users[i][0].equals(newUser)) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("Username already exists!");
                        break;
                    }

                    System.out.print("Enter password: ");
                    String newPass = sc.nextLine();

                    System.out.print("Confirm password: ");
                    String confirmPass = sc.nextLine();

                    if (!newPass.equals(confirmPass)) {
                        System.out.println("Passwords do not match!");
                    } else {
                        users[userCount][0] = newUser;
                        users[userCount][1] = newPass;
                        userCount++;
                        System.out.println("Registration successful!");
                    }
                    break;

                case 3:
                    System.out.println("Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }

        sc.close();
    }
}
