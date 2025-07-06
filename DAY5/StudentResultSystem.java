import java.util.*;

abstract class Student {
    protected String name;
    protected String rollNumber;

    public Student(String name, String rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public abstract String calculateGrade(Double marks) throws InvalidMarksException;
}

class UGStudent extends Student {

    public UGStudent(String name, String rollNumber) {
        super(name, rollNumber);
    }

    @Override
    public String calculateGrade(Double marks) throws InvalidMarksException {
        if (marks < 0 || marks > 100) {
            throw new InvalidMarksException("Invalid marks: " + marks);
        }
        if (marks >= 85) return "A";
        else if (marks >= 70) return "B";
        else if (marks >= 55) return "C";
        else if (marks >= 40) return "D";
        else return "F";
    }
}

class PGStudent extends Student {

    public PGStudent(String name, String rollNumber) {
        super(name, rollNumber);
    }

    @Override
    public String calculateGrade(Double marks) throws InvalidMarksException {
        if (marks < 0 || marks > 100) {
            throw new InvalidMarksException("Invalid marks: " + marks);
        }
        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 50) return "D";
        else return "F";
    }
}

class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) {
        super(message);
    }
}

public class StudentResultSystem {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new UGStudent("Alice", "UG101"));
        students.add(new PGStudent("Bob", "PG201"));
        students.add(new UGStudent("Charlie", "UG102"));
        students.add(new PGStudent("Diana", "PG202"));

        Double[] marks = {88.5, 91.0, 47.0, 105.0};

        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            try {
                String grade = s.calculateGrade(marks[i]);
                System.out.println("Name: " + s.name + ", Roll: " + s.rollNumber + ", Grade: " + grade);
            } catch (InvalidMarksException e) {
                System.out.println("Name: " + s.name + ", Roll: " + s.rollNumber + ", Error: " + e.getMessage());
            }
        }
    }
}

