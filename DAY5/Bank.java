abstract class Account{
    protected double balance;
    public Account(double balance){
        this.balance = balance;
}
    abstract double calculateInterest();   
    public void display(){
        System.out.printf("Account balance: %.2f and after applying interest %.2f ", balance,calculateInterest());
        System.out.println();
    }
}
class Savings extends Account{
    Savings(double balance) {
        super(balance);
    }
    double calculateInterest(){
        balance += balance * 0.04;
        return balance;
    }

}
class Current extends Account{
    Current(double balance) {
        super(balance);
    }
    double calculateInterest(){
        balance += balance * 0.02;
        return balance;
    }
}

public class Bank{
    public static void main(String[] args) {
        Savings s = new Savings(5000);
        s.calculateInterest();
        s.display();
        Current c = new Current(10000);
        c.calculateInterest();
        c.display();
}
}