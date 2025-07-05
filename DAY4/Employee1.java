import java.util.*;
public class Employee1 {
    int empid;
    String name;
    double salary;
    String department;

    public Employee1(int empid,String name,double salary,String department){
        this.empid=empid;
        this.name= name;
        this.salary = salary;
        this.department = department;
    }

    public double calculateAnnualSalary(){
        return salary * 12;
    }

    public double addbonus(){
        return calculateAnnualSalary()*1.1;
    }

    public void display(){

    System.out.println("Employee ID: " + empid);
    System.out.println("Name: " + name);
    System.out.println("Department: " + department);
    System.out.println("Monthly Salary: $" + salary);
    System.out.println("Annual Salary: $" + calculateAnnualSalary());
    System.out.printf("Annual Salary after Bonus (10%%):$ %.2f\n" , addbonus());

    System.out.println();
}
    




    public static void main(String[] args) {
        // Employee1[] emp = new Employee1[5];
        List<Employee1> emp = new ArrayList<>();
        emp.add(new Employee1(1,"Yuvraj",60000.0,"Golang"));
        emp.add(new Employee1(2,"Shakhya",50000.0,"Java"));
        emp.add(new Employee1(3,"Rushat",48000.0,"Big Data"));
        emp.add(new Employee1(4,"Samanta",55000.0,"C#"));
        emp.add(new Employee1(5,"Vedant",58000.0,"React"));
        
        
        
        
        // Collections.sort(emp, new Comparator<Employee1>() {
        //     public int compare(Employee1 e1, Employee1 e2) {
        //         return Double.compare(e2.addbonus(), e1.addbonus());
        //     }
        // });

        Collections.sort(emp, (e1, e2) -> Double.compare(e2.addbonus(), e1.addbonus()));
        System.out.println("Top 3 Earners:\n");
        for (int i = 0; i < 3; i++) {
            emp.get(i).display();
        
        
        
    }
}
}


