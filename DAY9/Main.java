class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running...");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();  // Create thread object
        t1.start(); // Start the thread start() internally calls the run method in a new thread.
    }
}