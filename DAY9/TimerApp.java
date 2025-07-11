import java.util.Scanner;

public class TimerApp {
    private final int totalSeconds;
    private int currentSecond = 0;
    private boolean isPaused = false;
    private boolean isStopped = false;
    private Thread timerThread;
    private final Object lock = new Object();

    public TimerApp(int totalSeconds) {
        this.totalSeconds = totalSeconds;
    }

    public void startTimer() {
        timerThread = new Thread(() -> {
            while (currentSecond < totalSeconds) {
                synchronized (lock) {
                    while (isPaused) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            return;
                        }
                    }

                    if (isStopped) break;
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }

                currentSecond++;
                System.out.println("Seconds passed: " + currentSecond);
            }

            if (!isStopped && currentSecond == totalSeconds) {
                System.out.println("Timer completed.");
            }
        });

        timerThread.start();
    }

    public void pauseTimer() {
        synchronized (lock) {
            isPaused = true;
            System.out.println("Timer paused at " + currentSecond + " seconds.");
        }
    }

    public void resumeTimer() {
        synchronized (lock) {
            if (isPaused) {
                isPaused = false;
                lock.notify();
                System.out.println("Timer resumed from " + currentSecond + " seconds.");
            }
        }
    }

    public void stopTimer() {
        synchronized (lock) {
            isStopped = true;
            isPaused = false;
            lock.notify();
            System.out.println("Timer stopped at " + currentSecond + " seconds.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter duration (in seconds): ");
        int n = sc.nextInt();

        TimerApp timer = new TimerApp(n);
        timer.startTimer();

        while (true) {
            System.out.println("Commands: p (pause), r (resume), s (stop)");
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
