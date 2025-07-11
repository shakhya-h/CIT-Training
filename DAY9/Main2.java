public class Main2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Thread using lambda is running...");
        });
        t1.start();
    }
}
