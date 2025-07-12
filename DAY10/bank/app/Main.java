package bank.app;

import bank.core.BankAccount;
import bank.core.Customer;
import bank.core.SavingsAccount;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("John Doe", 12345, 1000.0);
        BankAccount account = new SavingsAccount(customer);

        if (account instanceof SavingsAccount savingsAccount) {
            System.out.println("""
                    === Bank Receipt ===
                    Customer Name: %s
                    Account No: %d
                    Account Type: Savings Account
                    Balance: $%.2f
                    """.formatted(savingsAccount.customer.name(), savingsAccount.customer.accountNo(),
                    savingsAccount.customer.balance()));
        } else {
            System.out.println("Account is not a Savings Account.");
        }
    }
}
