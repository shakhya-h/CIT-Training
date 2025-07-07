import java.util.*;

class InvalidCreditsException extends Exception {
    public InvalidCreditsException(String message) {
        super(message);
    }
}

abstract class Course {
    protected int courseId;
    protected String title;
    protected Integer credits;

    public Course(int courseId, String title, Integer credits) throws InvalidCreditsException {
        if (credits < 1 || credits > 10) {
            throw new InvalidCreditsException("Credits must be between 1 and 10. " );
        }
        this.courseId = courseId;
        this.title = title;
        this.credits = credits;
    }

    public abstract double calculateFees();

    public void displayDetails() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Title: " + title);
        System.out.println("Credits: " + credits);
        System.out.println("Fees: $" + calculateFees());
        System.out.println();
    }
}

class TheoryCourse extends Course {
    public TheoryCourse(int courseId, String title, Integer credits) throws InvalidCreditsException {
        super(courseId, title, credits);
    }

    public double calculateFees() {
        return credits * 1500.0;
    }
}

class LabCourse extends Course {
    public LabCourse(int courseId, String title, Integer credits) throws InvalidCreditsException {
        super(courseId, title, credits);
    }

    public double calculateFees() {
        return (credits * 1500.0) + 2000.0;
    }
}

public class Courses {
    public static void main(String[] args) {
        ArrayList<Course> courseList = new ArrayList<>();

        try {
            courseList.add(new TheoryCourse(101, "Research Methodology", 4));
            courseList.add(new LabCourse(102, "Operating Systems Lab", 3));
            courseList.add(new TheoryCourse(103, "Foundation of DS", 5));
            courseList.add(new LabCourse(104, "Networking Lab", 2));
            courseList.add(new TheoryCourse(105, "AI & ML", 17));
        } catch (InvalidCreditsException e) {
            System.out.println("Exception caught in main method " + e.getMessage());
        }

        System.out.println("\nFee Details:\n");
        for (Course c : courseList) {
            c.displayDetails();
        }
    }
}
