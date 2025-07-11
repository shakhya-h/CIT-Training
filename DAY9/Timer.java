class TimerThread extends Thread {
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Seconds elapsed = " + i);
                Thread.sleep(1000);
            }
            System.out.println(" Timer ended.");
        } catch (InterruptedException e) {
            System.out.println("Timer interrupted.");
        }
    }
}

public class Timer {
    public static void main(String[] args) {
        TimerThread timer = new TimerThread(); 
        timer.start(); 
    }
}
