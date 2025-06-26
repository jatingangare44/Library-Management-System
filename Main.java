package task3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Register User");
            System.out.println("3. Show All Books");
            System.out.println("4. Show All Users");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Remove Book");
            System.out.println("8. Remove User");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");

            int choice;
            try {
                choice = sc.nextInt();
                sc.nextLine(); // consume newline
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input! Please enter a number.");
                sc.nextLine(); // clear the invalid input
                continue;
            }

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Book ID: ");
                        int bookId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Book Title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter Book Author: ");
                        String author = sc.nextLine();
                        library.addBook(new Book(bookId, title, author));
                        break;

                    case 2:
                        System.out.print("Enter User ID: ");
                        int userId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter User Name: ");
                        String name = sc.nextLine();
                        library.registerUser(new User(userId, name));
                        break;

                    case 3:
                        library.showAllBooks();
                        break;

                    case 4:
                        library.showAllUsers();
                        break;

                    case 5:
                        System.out.print("Enter Book ID to issue: ");
                        int issueBookId = sc.nextInt();
                        System.out.print("Enter User ID: ");
                        int issueUserId = sc.nextInt();
                        library.issueBook(issueBookId, issueUserId);
                        break;

                    case 6:
                        System.out.print("Enter Book ID to return: ");
                        int returnId = sc.nextInt();
                        library.returnBook(returnId);
                        break;

                    case 7:
                        System.out.print("Enter Book ID to remove: ");
                        int removeBookId = sc.nextInt();
                        library.removeBook(removeBookId);
                        break;

                    case 8:
                        System.out.print("Enter User ID to remove: ");
                        int removeUserId = sc.nextInt();
                        library.removeUser(removeUserId);
                        break;

                    case 9:
                        System.out.println("Exiting...");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input! Please enter numeric values only.");
                sc.nextLine(); // clear invalid input
            }
        }
    }
}
