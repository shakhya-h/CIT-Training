import java.util.*;

public class Timer1 {
    private int seconds;

    public Timer1(int seconds) {
        this.seconds = seconds;
    }

    public void startTimer(int n) {
        Thread t = new Thread(() -> {
            for (int i = 1; i <= seconds; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println("Seconds passed: " + i);
                } catch (InterruptedException e) {
                    System.out.println("Timer interrupted");
                    return;
                }
            }
            System.out.println("Timer completed its mission");
        });

        t.start();
    }

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter the number of seconds you want: ");
        int n = sc.nextInt();
        Timer1 timer = new Timer1(n); 
        timer.startTimer(n);
    }
}

