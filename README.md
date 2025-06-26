
# 📚 Task 3: Library Management System (Java CLI)

### 💼 Java Developer Internship – Task 3

## 🎯 Objective
Develop a mini system using Java and Object-Oriented Programming to manage books and users in a library.

---

## 🧰 Tools Used

- **Java (JDK 8 or higher)**
- **VS Code / Eclipse IDE**
- **Terminal / Command Prompt**

---

## 📦 Deliverables

- Multi-class Java project (`Book`, `User`, `Library`, `Main`)
- CLI-based interaction with file persistence

---

## 🧭 Hints / Mini Guide

1. ✅ Create classes: `Book`, `User`, and `Library`
2. 📥 Implement add/register logic
3. 🔁 Implement book issue and return features
4. 🧼 Add remove and view functionality
5. 💾 Ensure persistent storage using `.txt` files

---

## ✅ Features

- ➕ Add & Remove Books
- ➕ Register & Remove Users
- 📄 View All Books & Users
- 🔁 Issue and Return Books
- 💾 Persistent storage with `books.txt` and `users.txt`
- 🧠 Input validation to handle user errors

---

## 🚀 How to Run

### 📂 Compile and Run from Terminal:

```bash
javac task3/*.java
java task3.Main
```

Or run using **Eclipse/VS Code**:
1. Open the project folder
2. Run `Main.java` as a Java Application

---

## 📁 Project Structure

```
task3/
├── Main.java         # Entry point for console app
├── Book.java         # Book class with issue/return tracking
├── User.java         # User class
├── Library.java      # Core logic & file I/O
├── books.txt         # Auto-generated book storage
├── users.txt         # Auto-generated user storage
```

---

## 🖥️ Menu Sample

```
--- Library Menu ---
1. Add Book
2. Register User
3. Show All Books
4. Show All Users
5. Issue Book
6. Return Book
7. Remove Book
8. Remove User
9. Exit
```

---

## 🛡️ Exception Handling

- Input validation using `try-catch`
- Prevents crashes from alphabetic input in numeric fields

---

## 🧠 Outcome

> Gain a **solid understanding of Object-Oriented Programming (OOP)** principles, class interaction, and basic file I/O using Java.

---

## 👨‍💻 Developed By

**Jatin Gangare**  
Java Developer Intern – 2025

---

## 📝 License

Free to use for learning and academic purposes.
