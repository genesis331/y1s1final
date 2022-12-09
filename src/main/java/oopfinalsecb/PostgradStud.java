package oopfinalsecb;

import java.util.ArrayList;
import java.util.Scanner;

public class PostgradStud {
    int userIDNum;
    String username;
    String password;
    String emailAddr;
    ArrayList<Thesis> thesis = new ArrayList<Thesis>();

    public PostgradStud(int userIDNum, String username, String password, String emailAddr) {
        this.userIDNum = userIDNum;
        this.username = username;
        this.password = password;
        this.emailAddr = emailAddr;
    }

    public void login() {
        System.out.println("Logged in");
        postgradStudMenu();
    }

    private void postgradStudMenu() {
        Scanner input = new Scanner(System.in);
        boolean menuStatus = true;
        // Prints a menu
        while (menuStatus) {
            System.out.println("1. View Thesis Documents");
            System.out.println("2. Check Available Services");
            System.out.println("3. Contact Admin");
            System.out.println("4. Logout");

            System.out.print("Option: ");
            int option = input.nextInt();

            switch (option) {
                case 1:
                    System.out.println("View Thesis Documents");
                    // List all the thesis documents
                    listAddedThesis();
                    break;
                case 2:
                    System.out.println("Check Available Services");
                    // Print the available services
                    checkServices();
                    break;
                case 3:
                    System.out.println("Contact Admin");
                    // Contact admin
                    contactAdmin();
                    break;
                case 4:
                    // Logout
                    System.out.println("Logging out...");
                    menuStatus = false;
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void listAddedThesis() {
        // List all the thesis documents
        for (Thesis thesis : this.thesis) {
            System.out.println("Thesis ID: " + thesis.thesisID);
            System.out.println("Title: " + thesis.title);
            System.out.println("Content: " + thesis.content);
        }
    }

    private void checkServices() {
        // Print the available services
        System.out.println("Available Services");
        System.out.println("1. Academic Transcript Request");
        System.out.println("2. Certificate of Enrollment Request");
        System.out.println("3. Request for Transcript of Records");
    }

    private void contactAdmin() {
        // Contact admin
        Scanner input = new Scanner(System.in);
        System.out.println("Ticket Title: ");
        String title = input.nextLine();
        System.out.println("Ticket Content: ");
        String message = input.nextLine();
        System.out.println("Contacted admin with title: " + title + " and message: " + message);
    }
}
