

class OddNumber implements Runnable {
    public void run() {
        for (int i = 1; i < 10; i += 2) {
            System.out.println("Odd number: " + i);
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class EvenNumber implements Runnable {
    public void run() {
        for (int i = 2; i <= 10; i += 2) {
            System.out.println("Even number: " + i);
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class numbertwo {
    public static void main(String[] args) {  
        Thread t2 = new Thread(new EvenNumber());
        Thread t1 = new Thread(new OddNumber());
      

        t1.start();
        t2.start();
    }
}
