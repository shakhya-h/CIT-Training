public class Person{
    int age;
    String name;
    String nationality;
    public Person(String name,int age,String nationality){
        this.name = name;
        this.age = age;
        this.nationality = nationality;
    }

    boolean isAdult(){
        if(age>=18){
            return true;
        }
        return false;
    }

    boolean isCitizen(){
          if(nationality.equals("India")){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Person p = new Person("Shakhya", 20,"India");
        Person p1 = new Person("Shakhya1",17,"USA");
        System.out.println(p.name + " is adult? "+p.isAdult()+ " is citizen? "+p.isCitizen());
        System.out.println(p1.name + " is adult? "+p1.isAdult() + " is citizen? "+p1.isCitizen());
    }
}