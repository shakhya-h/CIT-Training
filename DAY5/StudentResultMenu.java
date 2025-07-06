import java.util.*;

class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) {
        super(message);
    }
}

abstract class Student {
    protected String name;
    protected int rollNumber;
    protected Double marks;

    public Student(String name, int rollNumber, Double marks) throws InvalidMarksException {
        if (marks < 0 || marks > 100) {
            throw new InvalidMarksException("Marks must be between 0 and 100.");
        }
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public abstract String calculateGrade();

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
        System.out.println("-----------------------------");
    }
}

class UGStudent extends Student {
    public UGStudent(String name, int rollNumber, Double marks) throws InvalidMarksException {
        super(name, rollNumber, marks);
    }

    @Override
    public String calculateGrade() {
        if (marks >= 80)
            return "A";
        else if (marks >= 60)
            return "B";
        else if (marks >= 40)
            return "C";
        else
            return "F";
    }
}

class PGStudent extends Student {
    public PGStudent(String name, int rollNumber, Double marks) throws InvalidMarksException {
        super(name, rollNumber, marks);
    }

    @Override
    public String calculateGrade() {
        if (marks >= 85)
            return "A";
        else if (marks >= 70)
            return "B";
        else if (marks >= 50)
            return "C";
        else
            return "F";
    }
}

public class StudentResultMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();
        int choice;

        do {
            System.out.println("\nSTUDENT RESULT MENU:");
            System.out.println("1. Add UG Student");
            System.out.println("2. Add PG Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter UG Student Name: ");
                        String ugName = sc.nextLine();
                        System.out.print("Enter Roll Number: ");
                        int ugRoll = sc.nextInt();
                        System.out.print("Enter Marks (0-100): ");
                        Double ugMarks = sc.nextDouble();

                        Student ugStudent = new UGStudent(ugName, ugRoll, ugMarks);
                        studentList.add(ugStudent);
                        System.out.println("UG Student Added!");
                    } catch (InvalidMarksException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Enter PG Student Name: ");
                        String pgName = sc.nextLine();
                        System.out.print("Enter Roll Number: ");
                        int pgRoll = sc.nextInt();
                        System.out.print("Enter Marks (0-100): ");
                        Double pgMarks = sc.nextDouble();

                        Student pgStudent = new PGStudent(pgName, pgRoll, pgMarks);
                        studentList.add(pgStudent);
                        System.out.println("PG Student Added!");
                    } catch (InvalidMarksException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("\nStudent Details:");
                    if (studentList.isEmpty()) {
                        System.out.println("No students to display.");
                    } else {
                        for (Student s : studentList) {
                            s.display();
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}
