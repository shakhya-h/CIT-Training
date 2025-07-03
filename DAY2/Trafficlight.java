import java.util.*;
public class Trafficlight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int time;
        double position;
        double green = 50.0;
        double yellow = 5.0;
        double red = 55.0;
        System.out.println("Is it Sunday?");
        boolean isFestival = sc.nextBoolean();
        System.out.println("Is it Festival dayyyy?");
        boolean isSunday = sc.nextBoolean();
        System.out.println("Enter the time in seconds");
        time = sc.nextInt();
        if(time<0 || time>86400){
            System.out.println("Invalid time");
        }
        if(isSunday){
            red = red+10;
        }
        if(isFestival)
        {
            green = green *1.5;
            yellow = yellow *1.5;
            red = red *1.5;
        }
        if(isSunday && isFestival)
        {
            red = red+10;
            green = green *1.5;
            yellow = yellow*1.5;
        }
        double cycletime = red+ green +yellow;
        position = time %cycletime;
        if(position<=green){
            System.out.println("Green");
        }
        else if(position<= green + yellow){
            System.out.println("Yellow");
        }
        else{
            System.out.println("Red");
        }
    }
}
