public class Example{
    void a(){

    }
    void b(){
        int x = 5/0;
    }
    public static void main(String[] args) {
        Example e = new Example();
        e.a();//Here method B throws Arithmrtic exception
    }
}