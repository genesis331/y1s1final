package oopfinalsecb;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Admin admin = new Admin();
        System.out.println("<<Welcome to the program!>>");
        System.out.println("Please select an option:");

        // Prints a menu
        while (true) {
            System.out.println("1. Login as Admin");
            System.out.println("2. Login as Assistant Manager");
            System.out.println("3. Login as Postgraduate Student");
            System.out.println("4. Exit");

            System.out.print("Option: ");
            int option = input.nextInt();

            switch (option) {
                case 1:
                    // Get username and password then login
                    System.out.print("Username: ");
                    String username1 = input.next();
                    System.out.print("Password: ");
                    String password1 = input.next();
                    admin.login(username1, password1);
                    break;
                case 2:
                    // Get username and password
                    System.out.print("Username: ");
                    String username2 = input.next();
                    System.out.print("Password: ");
                    String password2 = input.next();
                    // Check if the username and password is correct
                    int idNum2 = admin.checkAssistantManagerCredentials(username2, password2);
                    if (idNum2 >= 0) {
                        // If the credentials are correct, login
                        AssistantManager assistantManager = new AssistantManager(idNum2, username2, password2);
                        assistantManager.login();
                    } else {
                        System.out.println("Invalid username or password");
                    }
                    break;
                case 3:
                    // Get username and password
                    System.out.print("Username: ");
                    String username3 = input.next();
                    System.out.print("Password: ");
                    String password3 = input.next();
                    // Check if the username and password is correct
                    int idNum3 = admin.checkPostgradStudCredentials(username3, password3);
                    if (idNum3 >= 0) {
                        // If the credentials are correct, login
                        for (PostgradStud postgradStud : Admin.postgradStuds) {
                            if (postgradStud.userIDNum == idNum3) {
                                postgradStud.login();
                            }
                        }
                    } else {
                        System.out.println("Invalid username or password");
                    }
                    break;
                case 4:
                    // Exit the program
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }
}