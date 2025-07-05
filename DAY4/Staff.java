public class Staff {
    // int age;
    String name,department,city,designation,exemp;

    public Staff(String name,String department,String city,String designation,String exemp){
        this.name = name;
        this.department = department;
        this.city = city;
        this.designation = designation;
        this.exemp= exemp;

    }

    boolean isExEmp(){
        // if(designation.equals("NA")){
        //     return true;
        // }
        // return false;
        // if(age>60){
        //     return true;
        // }
        // return false;
        if(exemp.equals("Yes")){
            return true;
        }
        else{
            return false;
        }
    }
    public void display(){
        System.out.println("Name: "+name);
        System.out.println("Department: "+department);
        System.out.println("City :"+city);
        System.out.println("Designation: "+designation);
        if(isExEmp()==true){
            System.out.println("Exempted: Yes");
        }
        else{
             System.out.println("Exempted: No");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Staff s = new Staff("Shakhya","Accounts","Kolkata","Junior Accountant","Yes");
        Staff s1 = new Staff("Rushat","IT","Nagpur","Java dev","No");
        s.display();
        s1.display();
    }
    
}
