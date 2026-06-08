Student Record Management System
## Overview

The Student Record Management System is a Java-based Command Line Interface (CLI) application that allows users to manage student records efficiently. The project demonstrates Object-Oriented Programming (OOP), CRUD operations, file handling, collections, multithreading, and data validation concepts in Java.

The system enables users to add, view, update, search, and delete student records while maintaining persistent storage through file operations.

---

## Features

### Core CRUD Operations

* Add Student Records
* View All Students
* Update Student Information
* Delete Student Records
* Search Student by ID
* Search Student by Name

### Academic Features

* Automatic Grade Calculation
* Display Top Performer
* Calculate Class Average
* Student Performance Statistics

### Data Management

* File-Based Record Storage
* Load Existing Records on Startup
* Manual Save Functionality
* Auto-Save Using Background Thread
* Clear All Records

### Validation and Error Handling

* Duplicate Student ID Prevention
* Empty Name Validation
* Marks Range Validation (0–100)
* Safe User Input Handling

### Sorting and Analytics

* Sort Students by Marks
* Highest Marks Analysis
* Lowest Marks Analysis
* Average Marks Calculation

---

## Technologies Used

* Java (JDK)
* Object-Oriented Programming (OOP)
* ArrayList Collection Framework
* File Handling (BufferedReader, BufferedWriter)
* Multithreading
* Java Streams API
* Exception Handling

---

## Project Structure

```text
StudentManagementSystem/
│
├── Student.java
├── StudentManager.java
├── AutoSaveThread.java
└── Main.java
```

## Menu Options

```text
1. Add Student
2. View Students
3. Search by ID
4. Search by Name
5. Update Student
6. Delete Student
7. Sort by Marks
8. Top Performer
9. Average Marks
10. Statistics
11. Save Records
12. Clear Records
13. Exit
```

---

## Sample Student Record

```text
ID: 101
Name: Sania Fathima
Marks: 92.50
Grade: A
```

---

## Learning Outcomes

This project helped in understanding:

* Java Class Design
* Encapsulation and Abstraction
* CRUD Operations
* Collections Framework
* File Persistence
* Multithreading Concepts
* Exception Handling
* Data Validation Techniques
* Stream-Based Data Processing

---
