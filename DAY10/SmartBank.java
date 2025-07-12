public class SmartBank {

    public record Customer(String name, int accountNo, double balance) {
    }

    public sealed static abstract class BankAccount permits SavingsAccount, CurrentAccount {
        protected Customer customer;

        public BankAccount(Customer customer) {
            this.customer = customer;
        }

        public Customer getCustomer() {
            return customer;
        }

        public abstract String getAccountType();
    }

    public static final class SavingsAccount extends BankAccount {
        public SavingsAccount(Customer customer) {
            super(customer);
        }

        @Override
        public String getAccountType() {
            return "Savings Account";
        }
    }

    public static final class CurrentAccount extends BankAccount {
        public CurrentAccount(Customer customer) {
            super(customer);
        }

        @Override
        public String getAccountType() {
            return "Current Account";
        }
    }

    public static void main(String[] args) {

        Customer cust1 = new Customer("Rushat Sharma", 1001, 18500.75);
        Customer cust2 = new Customer("Anita Kapoor", 1002, 40250.00);
        BankAccount acc1 = new SavingsAccount(cust1);
        BankAccount acc2 = new CurrentAccount(cust2);

        printReceipt(acc1);
        printReceipt(acc2);
    }

    static void printReceipt(BankAccount account) {
        String accType;

        if (account instanceof SavingsAccount sa) {
            accType = sa.getAccountType();
        } else if (account instanceof CurrentAccount ca) {
            accType = ca.getAccountType();
        } else {
            accType = "Unknown";
        }

        Customer c = account.getCustomer();

        String receipt = """
                ========== Bank Receipt ==========
                Customer Name   : %s
                Account Number  : %d
                Account Type    : %s
                Balance         : %.2f
                ==================================
                """.formatted(c.name(), c.accountNo(), accType, c.balance());

        System.out.println(receipt);
    }
}























// public class SmartBank {

//     public record Customer(String name, int accountNo, double balance) {
//     }

//     public sealed static abstract class BankAccount permits SavingsAccount, CurrentAccount {
//         protected Customer customer;

//         public BankAccount(Customer customer) {
//             this.customer = customer;
//         }

//         public Customer getCustomer() {
//             return customer;
//         }

//         public abstract String getAccountType();
//     }

//     public static final class SavingsAccount extends BankAccount {
//         public SavingsAccount(Customer customer) {
//             super(customer);
//         }

//         @Override
//         public String getAccountType() {
//             return "Savings Account";
//         }
//     }

//     public static final class CurrentAccount extends BankAccount {
//         public CurrentAccount(Customer customer) {
//             super(customer);
//         }

//         @Override
//         public String getAccountType() {
//             return "Current Account";
//         }
//     }

//     public static void main(String[] args) {

//         Customer cust1 = new Customer("Shakhya Halder", 1001, 18952.75);
//         Customer cust2 = new Customer("Indrani Halder", 1002, 40250.00);
//         BankAccount acc1 = new SavingsAccount(cust1);
//         BankAccount acc2 = new CurrentAccount(cust2);

//         printReceipt(acc1);
//         printReceipt(acc2);
//     }

//     static void printReceipt(BankAccount account) {
//         String accType;

//         if (account instanceof SavingsAccount sa) {
//             accType = sa.getAccountType();
//         } else if (account instanceof CurrentAccount ca) {
//             accType = ca.getAccountType();
//         } else {
//             accType = "Unknown";
//         }

//         Customer c = account.getCustomer();

//         String receipt = """
//                 ========== Bank Receipt ==========
//                 Customer Name   : %s
//                 Account Number  : %d
//                 Account Type    : %s
//                 Balance         : %.2f
//                 ==================================
//                 """.formatted(c.name(), c.accountNo(), accType, c.balance());

//         System.out.println(receipt);
//     }
// }