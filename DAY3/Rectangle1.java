public class Rectangle1 {
    public static void main(String[] args) {
        Rectangle1 ob = new Rectangle1();
        System.out.println("The area is: "+ob.area(5,10));
        System.out.println("The perimeter is: "+ob.perimeter(5,10));
        
    }
    public static int area(int wiidth,int length){
        return wiidth*length;
    }
    public static int perimeter(int width,int length){
        return 2*(width+length);
    }
    
}
