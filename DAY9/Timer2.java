import java.util.*;

public class Timer2 {
    private int seconds;
    private int currentSecond = 0;
    private boolean isPaused = false;
    private boolean isStopped = false;
    private Thread timerThread;
    private final Object lock = new Object();

    public Timer2(int seconds) {
        this.seconds = seconds;
    }

    public void startTimer() {
        timerThread = new Thread(() -> {
            while (currentSecond < seconds) {
                synchronized (lock) {
                    if (isStopped) break;
                    if (isPaused) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            System.out.println("Timer interrupted during pause.");
                            return;
                        }
                        if (isStopped) break;
                    }
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Timer interrupted.");
                    return;
                }

                currentSecond++;
                System.out.println("Seconds passed: " + currentSecond);
            }

            if (!isStopped) {
                System.out.println("Timer completed its mission");
            }
        });

        timerThread.start();
    }

    public void pauseTimer() {
        synchronized (lock) {
            isPaused = true;
            System.out.println("Timer paused.");
        }
    }

    public void resumeTimer() {
        synchronized (lock) {
            if (isPaused) {
                isPaused = false;
                lock.notify();
                System.out.println("Timer resumed.");
            }
        }
    }

    public void stopTimer() {
        synchronized (lock) {
            isStopped = true;
            isPaused = false;
            lock.notify(); 
            System.out.println("Timer stopped.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of seconds: ");
        int n = sc.nextInt();

        Timer2 timer = new Timer2(n);
        timer.startTimer();

        while (true) {
            System.out.println("Options: [p]ause | [r]esume | [s]top");
            String cmd = sc.next();

            switch (cmd.toLowerCase()) {
                case "p":
                    timer.pauseTimer();
                    break;
                case "r":
                    timer.resumeTimer();
                    break;
                case "s":
                    timer.stopTimer();
                    return; 
                default:
                    System.out.println("Invalid command.");
            }
        }
    }
}

