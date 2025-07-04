public class Rectangle {

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double calculateArea() {
        return width * height;
    }

    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    public void display() {
        System.out.println("----------------------------------");
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());
        System.out.println("----------------------------------");
    }

    public static void main(String[] args) {

        Rectangle rect1 = new Rectangle(5, 10);
        rect1.display();
        Rectangle rect2 = new Rectangle(7.5, 4.2);
        rect2.display();

    }
}
