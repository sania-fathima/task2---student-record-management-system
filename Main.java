import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final Scanner sc =
            new Scanner(System.in);

    public static void main(String[] args) {

        StudentManager manager =
                new StudentManager();

        manager.loadFromFile();

        AutoSaveThread autoSave =
                new AutoSaveThread(manager);

        autoSave.setDaemon(true);
        autoSave.start();

        int choice;

        do {

            System.out.println(
                    "\n==============================");
            System.out.println(
                    " STUDENT MANAGEMENT SYSTEM");
            System.out.println(
                    "==============================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search by ID");
            System.out.println("4. Search by Name");
            System.out.println("5. Update Student");
            System.out.println("6. Delete Student");
            System.out.println("7. Sort by Marks");
            System.out.println("8. Top Performer");
            System.out.println("9. Average Marks");
            System.out.println("10. Statistics");
            System.out.println("11. Save Records");
            System.out.println("12. Clear Records");
            System.out.println("13. Exit");

            System.out.print("Choice: ");
            choice = getInt();

            switch (choice) {

                case 1:

                    System.out.print("ID: ");
                    int id = getInt();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    if (name.trim().isEmpty()) {
                        System.out.println(
                                "Name cannot be empty.");
                        break;
                    }

                    System.out.print("Marks (0-100): ");
                    double marks = getDouble();

                    if (marks < 0 || marks > 100) {
                        System.out.println(
                                "Invalid marks.");
                        break;
                    }

                    boolean added =
                            manager.addStudent(
                                    new Student(
                                            id,
                                            name,
                                            marks));

                    System.out.println(
                            added ?
                                    "Student Added." :
                                    "Duplicate ID.");
                    break;

                case 2:
                    manager.viewAllStudents();
                    break;

                case 3:

                    System.out.print("Enter ID: ");

                    Student s =
                            manager.searchById(
                                    getInt());

                    System.out.println(
                            s != null ?
                                    s :
                                    "Not Found");
                    break;

                case 4:

                    System.out.print("Enter Name: ");

                    String search =
                            sc.nextLine();

                    ArrayList<Student> list =
                            manager.searchByName(
                                    search);

                    if (list.isEmpty()) {

                        System.out.println(
                                "No matches.");

                    } else {

                        for (Student st : list)
                            System.out.println(st);
                    }
                    break;

                case 5:

                    System.out.print("ID: ");
                    id = getInt();

                    System.out.print(
                            "New Name: ");

                    name = sc.nextLine();

                    System.out.print(
                            "New Marks: ");

                    marks = getDouble();

                    boolean updated =
                            manager.updateStudent(
                                    id,
                                    name,
                                    marks);

                    System.out.println(
                            updated ?
                                    "Updated." :
                                    "Student not found.");
                    break;

                case 6:

                    System.out.print("ID: ");

                    boolean deleted =
                            manager.deleteStudent(
                                    getInt());

                    System.out.println(
                            deleted ?
                                    "Deleted." :
                                    "Student not found.");
                    break;

                case 7:

                    manager.sortByMarks();

                    System.out.println(
                            "Sorted Successfully.");

                    manager.viewAllStudents();

                    break;

                case 8:

                    Student top =
                            manager.getTopPerformer();

                    System.out.println(
                            top != null ?
                                    top :
                                    "No records.");
                    break;

                case 9:

                    System.out.printf(
                            "Average Marks = %.2f%n",
                            manager.getAverageMarks());

                    break;

                case 10:

                    manager.showStatistics();
                    break;

                case 11:

                    manager.saveToFile();

                    System.out.println(
                            "Saved Successfully.");

                    break;

                case 12:

                    manager.clearAllRecords();

                    System.out.println(
                            "Records Cleared.");

                    break;

                case 13:

                    manager.saveToFile();

                    System.out.println(
                            "Exiting...");
                    break;

                default:

                    System.out.println(
                            "Invalid Choice.");
            }

        } while (choice != 13);

        sc.close();
    }

    private static int getInt() {

        while (!sc.hasNextInt()) {

            System.out.print(
                    "Enter valid integer: ");

            sc.next();
        }

        int value = sc.nextInt();
        sc.nextLine();

        return value;
    }

    private static double getDouble() {

        while (!sc.hasNextDouble()) {

            System.out.print(
                    "Enter valid number: ");

            sc.next();
        }

        double value = sc.nextDouble();
        sc.nextLine();

        return value;
    }
}
