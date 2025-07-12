package bank.core;

public sealed class BankAccount permits SavingsAccount, CurrentAccount {
    public Customer customer;

    public BankAccount(Customer customer) {
        this.customer = customer;
    }
}
