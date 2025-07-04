public class ConstOverload {
    private  int x, y;
    public ConstOverload(int x,int y) {
        this.x=x;
        this.y=y;
    }
    public ConstOverload(){
        x=0;
        y=0;
    }

    public void display(){
        System.out.println("x = "+x+" y = "+y);
    }
    public static void main(String[] args) {
        ConstOverload c1 = new ConstOverload(10,20);
        ConstOverload c2 = new ConstOverload();
        c1.display();
        c2.display();
    }
}
