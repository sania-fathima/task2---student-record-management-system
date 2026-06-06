import java.io.*;
import java.util.*;

public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();
    private final String FILE_NAME = "students.txt";

    public ArrayList<Student> getStudents() {
        return students;
    }

    public boolean addStudent(Student student) {

        for (Student s : students) {
            if (s.getId() == student.getId()) {
                return false;
            }
        }

        students.add(student);
        return true;
    }

    public Student searchById(int id) {

        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }

        return null;
    }

    public ArrayList<Student> searchByName(String name) {

        ArrayList<Student> result = new ArrayList<>();

        for (Student s : students) {

            if (s.getName().toLowerCase()
                    .contains(name.toLowerCase())) {

                result.add(s);
            }
        }

        return result;
    }

    public boolean updateStudent(int id,
                                 String newName,
                                 double newMarks) {

        Student s = searchById(id);

        if (s == null) {
            return false;
        }

        s.setName(newName);
        s.setMarks(newMarks);

        return true;
    }

    public boolean deleteStudent(int id) {

        Student s = searchById(id);

        if (s == null) {
            return false;
        }

        students.remove(s);
        return true;
    }

    public void viewAllStudents() {

        if (students.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        for (Student s : students) {
            System.out.println(s);
        }
    }

    public void sortByMarks() {

        students.sort(
                (s1, s2) ->
                        Double.compare(
                                s2.getMarks(),
                                s1.getMarks()));
    }

    public Student getTopPerformer() {

        if (students.isEmpty()) {
            return null;
        }

        return Collections.max(
                students,
                Comparator.comparingDouble(
                        Student::getMarks));
    }

    public double getAverageMarks() {

        if (students.isEmpty()) {
            return 0;
        }

        return students.stream()
                .mapToDouble(Student::getMarks)
                .average()
                .orElse(0);
    }

    public void showStatistics() {

        if (students.isEmpty()) {
            System.out.println("No data available.");
            return;
        }

        double highest = students.stream()
                .mapToDouble(Student::getMarks)
                .max()
                .orElse(0);

        double lowest = students.stream()
                .mapToDouble(Student::getMarks)
                .min()
                .orElse(0);

        System.out.println("\n===== STATISTICS =====");
        System.out.println("Total Students : " + students.size());
        System.out.println("Highest Marks  : " + highest);
        System.out.println("Lowest Marks   : " + lowest);
        System.out.printf("Average Marks  : %.2f%n",
                getAverageMarks());
    }

    public synchronized void saveToFile() {

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(FILE_NAME))) {

            for (Student s : students) {

                writer.write(
                        s.getId() + "," +
                                s.getName() + "," +
                                s.getMarks());

                writer.newLine();
            }

        } catch (IOException e) {

            System.out.println(
                    "Error saving file.");
        }
    }

    public void loadFromFile() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine())
                    != null) {

                String[] data =
                        line.split(",");

                students.add(
                        new Student(
                                Integer.parseInt(data[0]),
                                data[1],
                                Double.parseDouble(data[2])));
            }

        } catch (IOException e) {

            System.out.println(
                    "Error loading file.");
        }
    }

    public void clearAllRecords() {
        students.clear();
    }
}
