package employee.core;

public sealed abstract class Employee permits employee.core.FullTimeEmployee, employee.core.PartTimeEmployee, employee.core.Intern {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public abstract double calculateSalary();

    public String getName() {
        return name;
    }
}


