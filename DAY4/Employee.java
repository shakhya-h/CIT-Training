public class Employee {
    int empid;
    String name;
    double salary;
    String department;

    public Employee(int empid,String name,double salary,String department){
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
        Employee[] emp = new Employee[5];
        emp[0] = new Employee(1,"Yuvraj",60000.0,"Golang");
        emp[1] = new Employee(2,"Shakhya",50000.0,"Java");
        emp[2] = new Employee(3,"Rushat",48000.0,"Big Data");
        emp[3] = new Employee(4,"Samanta",55000.0,"C#");
        emp[4] = new Employee(5,"Vedant",58000.0,"React");
        
        for(int i = 0;i<emp.length;i++){
            System.out.println("Employee details:");
            emp[i].display();
        }
        
    }
}
