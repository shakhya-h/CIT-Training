import java.util.Scanner;

public class TrafficLightAdv {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter time in seconds since midnight: ");
        double time = sc.nextDouble();

        System.out.print("Is it Sunday? (true/false): ");
        boolean isSunday = sc.nextBoolean();

        System.out.print("Is it a Festival Day? (true/false): ");
        boolean isFestival = sc.nextBoolean();

        double green = 60;
        double yellow = 5;
        double red = 55;

        if (isSunday) {
            red += 10;
        }

        if (isFestival) {
            green *= 1.5;
            yellow *= 1.5;
            red *= 1.5;
        }

        if(isSunday && isFestival){
            red +=10;
            green *= 1.5;
            yellow *= 1.5;
            red *= 1.5;
        }

        double cycle = green + yellow + red;
        double position = time % cycle;

        if (position <= green) {
            System.out.println("Green Light");
        } else if (position <= green + yellow) {
            System.out.println("Yellow Light");
        } else {
            System.out.println("Red Light");
        }

        sc.close();
    }
}