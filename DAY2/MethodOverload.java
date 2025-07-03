import java.util.*;
public class MethodOverload {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of side :");
        System.out.println("Area of square: "+area(25));
        System.out.println("Area of circle "+area(5.28));
    }
    static int area(int length){
        return length*length;
    }
    static double area(double radius){
        return 3.14*radius*radius;
    }
}
