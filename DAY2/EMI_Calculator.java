import java.util.Scanner;

public class EMI_Calculator {

    public static double calculateEMI(int principal, int months) {
        double rate = 10;
        return calculateEMI(principal, rate, months);
    }

    public static double calculateEMI(int principal, double rate, int months) {
        double monthlyRate = rate / (12 * 100);
        double emi = (principal * monthlyRate * (1 + monthlyRate) * months) / (1 - Math.pow(1 + monthlyRate, -months));
        return emi;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter principal amount: ");
        int principal = sc.nextInt();

        System.out.print("Enter loan period in months: ");
        int months = sc.nextInt();

        double emi1 = calculateEMI(principal, months);
        System.out.println("EMI (default rate 10%): " + emi1);

        System.out.print("\nEnter principal amount: ");
        int principal2 = sc.nextInt();

        System.out.print("Enter annual interest rate: ");
        double rate = sc.nextDouble();

        System.out.print("Enter loan period in months: ");
        int months2 = sc.nextInt();

        double emi2 = calculateEMI(principal2, rate, months2);
        System.out.println("EMI (custom rate " + rate + "%): " + emi2);

        sc.close();
    }
}
