public class Bonus {

    private String name;
    private double salary;

    public Bonus(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void giveBonus() {
        double bonus = 0.10 * salary;
        salary += bonus;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Salary after bonus: $" + salary);
        System.out.println("--------------------------");
    }

    public static void main(String[] args) {

        Bonus emp1 = new Bonus("Alice", 50000);
        emp1.giveBonus();
        emp1.display();

        Bonus emp2 = new Bonus("Bob", 30000);
        emp2.giveBonus();
        emp2.display();
    }
}
