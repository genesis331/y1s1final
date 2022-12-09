package oopfinalsecb;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    // Default admin credentials
    String username = "root";
    String password = "iloveoop";

    // Stores the list of assistant managers and postgraduate students
    static ArrayList<AssistantManager> assistantManagers = new ArrayList<AssistantManager>();
    static ArrayList<PostgradStud> postgradStuds = new ArrayList<PostgradStud>();

    public void login(String username, String password) {
        // Check if the username and password is correct
        if (username.equals(this.username) && password.equals(this.password)) {
            System.out.println("Logged in");
            // If the credentials are correct, print the admin menu
            adminMenu();
        } else {
            System.out.println("Invalid username or password");
        }
    }

    private void adminMenu() {
        Scanner input = new Scanner(System.in);
        boolean menuStatus = true;
        while (menuStatus) {
            System.out.println("1. Create Assistant Manager");
            System.out.println("2. Edit Assistant Manager");
            System.out.println("3. Delete Assistant Manager");
            System.out.println("4. Logout");

            System.out.print("Option: ");
            int option = input.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Create Assistant Manager");
                    // Get username and password
                    System.out.print("New Account Username: ");
                    String username = input.next();
                    System.out.print("New Account Password: ");
                    String password = input.next();
                    // Create a new assistant manager object
                    createAssistantManager(username, password);
                    break;
                case 2:
                    System.out.println("Edit Assistant Manager");
                    // List all the assistant managers
                    listAssistantManagers();
                    // Get the ID number of the assistant manager to edit
                    System.out.println("Enter the ID of the assistant manager you want to edit: ");
                    int id = input.nextInt();
                    // Edit the assistant manager details
                    System.out.println("Enter the new username: ");
                    String newUsername = input.next();
                    System.out.println("Enter the new password: ");
                    String newPassword = input.next();
                    editAssistantManager(id, newUsername, newPassword);
                    break;
                case 3:
                    System.out.println("Delete Assistant Manager");
                    // List all the assistant managers
                    listAssistantManagers();
                    System.out.println("Enter the ID of the assistant manager you want to delete: ");
                    int id2 = input.nextInt();
                    // Delete the assistant manager
                    deleteAssistantManager(id2);
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

    private void createAssistantManager(String username, String password) {
        AssistantManager assistantManager = new AssistantManager(assistantManagers.size() + 1, username, password);
        assistantManagers.add(assistantManager);
        System.out.println("Created account with username: " + username);
    }

    private void listAssistantManagers() {
        System.out.println("ID\tUsername");
        for (AssistantManager assistantManager : assistantManagers) {
            System.out.println(assistantManager.userIDNum + "\t" + assistantManager.username);
        }
    }

    public int checkAssistantManagerCredentials(String username, String password) {
        for (AssistantManager assistantManager : assistantManagers) {
            if (assistantManager.username.equals(username) && assistantManager.password.equals(password)) {
                return assistantManager.userIDNum;
            }
        }
        return -1;
    }

    public int checkPostgradStudCredentials(String username, String password) {
        for (PostgradStud postgradStud : Admin.postgradStuds) {
            if (postgradStud.username.equals(username) && postgradStud.password.equals(password)) {
                return postgradStud.userIDNum;
            }
        }
        return -1;
    }

    private void editAssistantManager(int userIDNum, String username, String password) {
        for (AssistantManager assistantManager : assistantManagers) {
            if (assistantManager.userIDNum == userIDNum) {
                assistantManager.username = username;
                assistantManager.password = password;
                System.out.println("Edited assistant manager with ID: " + userIDNum);
                return;
            }
        }
        System.out.println("Assistant manager with ID: " + userIDNum + " does not exist!");
    }

    private void deleteAssistantManager(int userIDNum) {
        for (AssistantManager assistantManager : assistantManagers) {
            if (assistantManager.userIDNum == userIDNum) {
                assistantManagers.remove(assistantManager);
                System.out.println("Deleted account with ID: " + userIDNum);
                return;
            }
        }
        System.out.println("Assistant manager with ID: " + userIDNum + " does not exist!");
    }
}
