package task3;

import java.io.*;
import java.util.*;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    private final String BOOK_FILE = "books.txt";
    private final String USER_FILE = "users.txt";

    public Library() {
        loadBooks();
        loadUsers();
    }

    public void addBook(Book book) {
        books.add(book);
        saveBook(book);
        System.out.println("Book added: " + book);
    }

    public void registerUser(User user) {
        users.add(user);
        saveUser(user);
        System.out.println("User registered: " + user);
    }

    public void showAllBooks() {
        System.out.println("\n--- All Books ---");
        if (books.isEmpty()) {
            System.out.println("No books found.");
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }
    
    public String getAllBooksText() {
        StringBuilder sb = new StringBuilder();
        for (Book book : books) {
            sb.append(book).append("\n");
        }
        return sb.toString().isEmpty() ? "No books available." : sb.toString();
    }


    public void showAllUsers() {
        System.out.println("\n--- Registered Users ---");
        if (users.isEmpty()) {
            System.out.println("No users found.");
        }
        for (User user : users) {
            System.out.println(user);
        }
    }
    
    public String getAllUsersText() {
        if (users.isEmpty()) return "No users found.";
        StringBuilder sb = new StringBuilder();
        for (User user : users) sb.append(user).append("\n");
        return sb.toString();
    }

    public void issueBook(int bookId, int userId) {
        Book book = findBook(bookId);
        User user = findUser(userId);

        if (book == null) {
            System.out.println("Book not found.");
        } else if (user == null) {
            System.out.println("User not found.");
        } else if (book.isIssued()) {
            System.out.println("Book already issued.");
        } else {
            book.issue();
            System.out.println("Book issued to " + user.getName());
        }
    }

    public void returnBook(int bookId) {
        Book book = findBook(bookId);
        if (book == null) {
            System.out.println("Book not found.");
        } else if (!book.isIssued()) {
            System.out.println("Book is not issued.");
        } else {
            book.returnBook();
            System.out.println("Book returned: " + book.getTitle());
        }
    }

    public void removeBook(int bookId) {
        Book book = findBook(bookId);
        if (book != null) {
            books.remove(book);
            updateBooksFile();
            System.out.println("Book removed: " + book.getTitle());
        } else {
            System.out.println("Book not found.");
        }
    }

    public void removeUser(int userId) {
        User user = findUser(userId);
        if (user != null) {
            users.remove(user);
            updateUsersFile();
            System.out.println("User removed: " + user.getName());
        } else {
            System.out.println("User not found.");
        }
    }

    // ---------- Internal Helpers ----------

    private Book findBook(int id) {
        for (Book b : books) {
            if (b.getId() == id) return b;
        }
        return null;
    }

    private User findUser(int id) {
        for (User u : users) {
            if (u.getUserId() == id) return u;
        }
        return null;
    }

    // ---------- File Operations ----------

    private void loadBooks() {
        try (BufferedReader br = new BufferedReader(new FileReader(BOOK_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 3);
                if (parts.length == 3) {
                    books.add(new Book(Integer.parseInt(parts[0]), parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("No books file found, starting fresh.");
        }
    }

    private void loadUsers() {
        try (BufferedReader br = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 2);
                if (parts.length == 2) {
                    users.add(new User(Integer.parseInt(parts[0]), parts[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("No users file found, starting fresh.");
        }
    }

    private void saveBook(Book book) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(BOOK_FILE, true))) {
            bw.write(book.getId() + "," + book.getTitle() + "," + book.getAuthor());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error saving book: " + e.getMessage());
        }
    }

    private void saveUser(User user) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USER_FILE, true))) {
            bw.write(user.getUserId() + "," + user.getName());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error saving user: " + e.getMessage());
        }
    }

    private void updateBooksFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(BOOK_FILE))) {
            for (Book book : books) {
                bw.write(book.getId() + "," + book.getTitle() + "," + book.getAuthor());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error updating book file: " + e.getMessage());
        }
    }

    private void updateUsersFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USER_FILE))) {
            for (User user : users) {
                bw.write(user.getUserId() + "," + user.getName());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error updating user file: " + e.getMessage());
        }
    }
}
