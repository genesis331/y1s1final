package oopfinalsecb;

import java.util.Scanner;

public class AssistantManager {
    int userIDNum;
    String username;
    String password;

    public AssistantManager(int userIDNum, String username, String password) {
        this.userIDNum = userIDNum;
        this.username = username;
        this.password = password;
    }

    public void login() {
        System.out.println("Logged in");
        assistantManagerMenu();
    }
    private void assistantManagerMenu() {
        Scanner input = new Scanner(System.in);
        boolean menuStatus = true;
        while (menuStatus) {
            System.out.println("1. Create Postgraduate Student");
            System.out.println("2. List Postgraduate Student");
            System.out.println("3. Edit Postgraduate Student");
            System.out.println("4. Delete Postgraduate Student");
            System.out.println("5. View Postgraduate Student Thesis");
            System.out.println("6. Add Postgraduate Student Thesis");
            System.out.println("7. Edit Postgraduate Student Thesis");
            System.out.println("8. Delete Postgraduate Student Thesis");
            System.out.println("9. Logout");

            System.out.print("Option: ");
            int option = input.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Create Postgraduate Student");
                    // Get username, password and email address
                    System.out.print("New Account Username: ");
                    String username = input.next();
                    System.out.print("New Account Password: ");
                    String password = input.next();
                    System.out.println("New Account Email Address: ");
                    String email = input.next();
                    // Create new postgraduate student
                    createPostgradStud(username, password, email);
                    break;
                case 2:
                    System.out.println("List Postgraduate Student");
                    // List all postgraduate students
                    listPostgradStuds();
                    break;
                case 3:
                    System.out.println("Edit Postgraduate Student");
                    // List all postgraduate students
                    listPostgradStuds();
                    System.out.println("Enter the ID of the postgraduate student you want to edit: ");
                    int id = input.nextInt();
                    System.out.println("Enter the new username: ");
                    String newUsername = input.next();
                    System.out.println("Enter the new password: ");
                    String newPassword = input.next();
                    // Edit the postgraduate student details
                    editPostgradStud(id, newUsername, newPassword);
                    break;
                case 4:
                    System.out.println("Delete Postgraduate Student");
                    // List all postgraduate students
                    listPostgradStuds();
                    System.out.println("Enter the ID of the student you want to delete: ");
                    int id2 = input.nextInt();
                    // Delete the postgraduate student
                    deletePostgradStud(id2);
                    break;
                case 5:
                    System.out.println("View Postgraduate Student Thesis");
                    // List all postgraduate students
                    listPostgradStuds();
                    System.out.println("Enter the ID of the student you want to view: ");
                    int id3 = input.nextInt();
                    // View the thesis of the student
                    viewStudThesis(id3);
                    break;
                case 6:
                    System.out.println("Add Thesis to Postgraduate Student");
                    // List all postgraduate students
                    listPostgradStuds();
                    System.out.println("Enter the ID of the student you want to add thesis to: ");
                    int id4 = input.nextInt();
                    input.nextLine();
                    System.out.println("Enter the title of the thesis: ");
                    String title = input.nextLine();
                    System.out.println("Enter the content of the thesis: ");
                    String content = input.nextLine();
                    // Add the thesis to the postgraduate student
                    addThesisToStud(id4, title, content);
                    break;
                case 7:
                    System.out.println("Edit Thesis of Postgraduate Student");
                    // List all postgraduate students
                    listPostgradStuds();
                    System.out.println("Enter the ID of the student you want to edit thesis of: ");
                    int id5 = input.nextInt();
                    // Edit thesis of postgraduate student
                    editStudThesis(id5);
                    break;
                case 8:
                    System.out.println("Delete Thesis of Postgraduate Student");
                    // List all postgraduate students
                    listPostgradStuds();
                    System.out.println("Enter the ID of the student you want to edit thesis of: ");
                    int id6 = input.nextInt();
                    // Delete thesis of postgraduate student
                    deleteStudThesis(id6);
                    break;
                case 9:
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

    private void createPostgradStud(String username, String password, String email) {
        // Create new postgraduate student object
        PostgradStud postgradStud = new PostgradStud(Admin.postgradStuds.size() + 1, username, password, email);
        // Add postgraduate student to the list
        Admin.postgradStuds.add(postgradStud);
        System.out.println("Created account with username: " + username);
    }

    private void listPostgradStuds() {
        // List all postgraduate students
        System.out.println("ID\tUsername");
        for (PostgradStud postgradStud : Admin.postgradStuds) {
            System.out.println(postgradStud.userIDNum + "\t" + postgradStud.username);
        }
    }

    private void editPostgradStud(int userIDNum, String username, String password) {
        // Edit postgraduate student details
        for (PostgradStud postgradStud : Admin.postgradStuds) {
            // Find the postgraduate student with the given ID
            if (postgradStud.userIDNum == userIDNum) {
                postgradStud.username = username;
                postgradStud.password = password;
                System.out.println("Edited postgraduate student with ID: " + userIDNum);
                return;
            }
        }
        System.out.println("Postgraduate student with ID: " + userIDNum + " does not exist!");
    }

    private void addThesisToStud(int userIDNum, String thesisTitle, String thesisDesc) {
        // Add thesis to postgraduate student
        for (PostgradStud postgradStud : Admin.postgradStuds) {
            // Check if postgraduate student exists
            if (postgradStud.userIDNum == userIDNum) {
                // Create new thesis object
                Thesis thesis = new Thesis(postgradStud.thesis.size() + 1, thesisTitle, thesisDesc);
                postgradStud.thesis.add(thesis);
                System.out.println("Added thesis to postgraduate student with ID: " + userIDNum);
                return;
            }
        }
        System.out.println("Postgraduate student with ID: " + userIDNum + " does not exist!");
    }

    private void viewStudThesis(int userIDNum) {
        // View thesis of postgraduate student
        if (Admin.postgradStuds.size() > 0) {
            // Check if postgraduate student exists
            for (PostgradStud postgradStud : Admin.postgradStuds) {
                // Check if postgraduate student exists
                if (postgradStud.userIDNum == userIDNum) {
                    // List all thesis of postgraduate student
                    for (Thesis thesis : postgradStud.thesis) {
                        System.out.println("ID: " + thesis.thesisID);
                        System.out.println("Title: " + thesis.title);
                        System.out.println("Description: " + thesis.content);
                    }
                    return;
                }
            }
            System.out.println("Postgraduate student with ID: " + userIDNum + " does not exist!");
        }else {
            System.out.println("No postgraduate students!");
        }
    }

    private void editStudThesis(int userIDNum) {
        // Edit thesis of postgraduate student
        Scanner input = new Scanner(System.in);
        if (Admin.postgradStuds.size() > 0) {
            // List all postgraduate students
            for (PostgradStud postgradStud : Admin.postgradStuds) {
                // Check if postgraduate student exists
                if (postgradStud.userIDNum == userIDNum) {
                    // List all theses of the postgraduate student
                    for (Thesis thesis : postgradStud.thesis) {
                        System.out.println("ID: " + thesis.thesisID);
                        System.out.println("Thesis Title: " + thesis.title);
                        System.out.println("Thesis Description: " + thesis.content);
                    }
                    System.out.println("Enter the ID of the thesis you want to edit: ");
                    int thesisID = input.nextInt();
                    input.nextLine();
                    System.out.println("Enter the new title of the thesis: ");
                    String newTitle = input.nextLine();
                    System.out.println("Enter the new description of the thesis: ");
                    String newDesc = input.nextLine();
                    // Loop through the thesis list of the postgraduate student
                    for (Thesis thesis : postgradStud.thesis) {
                        // Edit thesis object
                        if (thesis.thesisID == thesisID) {
                            thesis.title = newTitle;
                            thesis.content = newDesc;
                            System.out.println("Edited thesis with ID: " + thesisID);
                            return;
                        }
                    }
                }
            }
            System.out.println("Postgraduate student with ID: " + userIDNum + " does not exist!");
        }else {
            System.out.println("No postgraduate students!");
        }
    }

    private void deleteStudThesis(int userIDNum) {
        Scanner input = new Scanner(System.in);
        if (Admin.postgradStuds.size() > 0) {
            // Loop through all postgraduate students
            for (PostgradStud postgradStud : Admin.postgradStuds) {
                // Check if postgraduate student exists
                if (postgradStud.userIDNum == userIDNum) {
                    // Loop through all theses of postgraduate student
                    for (Thesis thesis : postgradStud.thesis) {
                        System.out.println("ID: " + thesis.thesisID);
                        System.out.println("Thesis Title: " + thesis.title);
                        System.out.println("Thesis Description: " + thesis.content);
                    }
                    System.out.println("Enter the ID of the thesis you want to delete: ");
                    int thesisID = input.nextInt();
                    // Loop through all theses
                    for (Thesis thesis : postgradStud.thesis) {
                        // Check if thesis exists
                        if (thesis.thesisID == thesisID) {
                            // Delete thesis
                            postgradStud.thesis.remove(thesis);
                            System.out.println("Deleted thesis with ID: " + thesisID);
                            return;
                        }
                    }
                }
            }
            System.out.println("Postgraduate student with ID: " + userIDNum + " does not exist!");
        }else {
            System.out.println("No postgraduate students!");
        }
    }

    private void deletePostgradStud(int userIDNum) {
        // Loop through postgraduate students
        for (PostgradStud postgradStud : Admin.postgradStuds) {
            // If postgraduate student ID matches the ID entered
            if (postgradStud.userIDNum == userIDNum) {
                // Remove postgraduate student from the list
                Admin.postgradStuds.remove(postgradStud);
                System.out.println("Deleted account with ID: " + userIDNum);
                return;
            }
        }
        System.out.println("Postgraduate student with ID: " + userIDNum + " does not exist!");
    }
}
