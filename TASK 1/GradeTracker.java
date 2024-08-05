import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Student {
    private String name;
    private ArrayList<Double> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public double calculateAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public ArrayList<Double> getGrades() {
        return grades;
    }
}

public class GradeTracker {
    private Map<String, Student> students;

    public GradeTracker() {
        students = new HashMap<>();
    }

    public void addStudent(String name) {
        if (!students.containsKey(name)) {
            students.put(name, new Student(name));
            System.out.println("Student " + name + " added.");
        } else {
            System.out.println("Student " + name + " already exists.");
        }
    }

    public void addGrade(String name, double grade) {
        Student student = students.get(name);
        if (student != null) {
            student.addGrade(grade);
            System.out.println("Grade " + grade + " added for student " + name + ".");
        } else {
            System.out.println("Student " + name + " not found.");
        }
    }

    public void showAverage(String name) {
        Student student = students.get(name);
        if (student != null) {
            double average = student.calculateAverage();
            System.out.println("Average grade for " + name + ": " + average);
        } else {
            System.out.println("Student " + name + " not found.");
        }
    }

    public void displayAllStudents() {
        System.out.println("Students and their grades:");
        for (Student student : students.values()) {
            System.out.println(student.getName() + ": " + student.getGrades());
        }
    }

    public static void main(String[] args) {
        GradeTracker tracker = new GradeTracker();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to the Student Grade Tracker!");

        while (true) {
            System.out.println("\nCommands: add_student, add_grade, show_average, display_all, exit");
            System.out.print("Enter command: ");
            command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "add_student":
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    tracker.addStudent(name);
                    break;
                case "add_grade":
                    System.out.print("Enter student name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter grade: ");
                    double grade = Double.parseDouble(scanner.nextLine());
                    tracker.addGrade(name, grade);
                    break;
                case "show_average":
                    System.out.print("Enter student name: ");
                    name = scanner.nextLine();
                    tracker.showAverage(name);
                    break;
                case "display_all":
                    tracker.displayAllStudents();
                    break;
                case "exit":
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Unknown command. Please try again.");
            }
        }
    }
}
