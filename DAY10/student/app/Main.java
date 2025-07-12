package employee;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new FullTimeEmployee("Alice", 60000),
                new PartTimeEmployee("Bob", 20, 500),
                new Intern("Charlie", 10000),
                new PartTimeEmployee("David", 25, 450),
                new FullTimeEmployee("Eve", 75000),
                new Intern("Fay", 12000)
        );

        System.out.println("\n--- Salary Report ---");

        for (Employee e : employees) {
            String report = switch (e) {
                case FullTimeEmployee f -> """
                        ------------------------------
                        Name        : %s
                        Type        : Full-Time
                        Salary      : ₹%.2f/month
                        ------------------------------
                        """.formatted(f.getName(), f.calculateSalary());

                case PartTimeEmployee p -> """
                        ------------------------------
                        Name        : %s
                        Type        : Part-Time
                        Salary      : ₹%.2f
                        ------------------------------
                        """.formatted(p.getName(), p.calculateSalary());

                case Intern i -> """
                        ------------------------------
                        Name        : %s
                        Type        : Intern
                        Stipend     : ₹%.2f
                        ------------------------------
                        """.formatted(i.getName(), i.calculateSalary());
            };

            System.out.println(report);
        }
    }
}
