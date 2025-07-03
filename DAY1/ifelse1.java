import java.util.*;
public class ifelse1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double usage= sc.nextDouble();
        double totalbill=0.0;
        if(usage<0){
            System.out.println("Usage cannot be negative");
        }
        else if(usage>0 && usage<2){
            System.out.println("Low usage no billing");
        }
        else if(usage>=1 && usage<=3){
            totalbill = usage*10;
        }
        else{
            totalbill = usage*20+20;
        }
        System.out.println("The total bill is: "+totalbill);
    }
}
