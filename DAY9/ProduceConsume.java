import java.util.*;

class DonutTray {
    private final int CAPACITY = 5;
    private final Queue<Integer> tray = new LinkedList<>();
    private int donutId = 1;
    private final int MAX_DONUTS = 10;

    public synchronized boolean produce(String producerName) throws InterruptedException {
        while (tray.size() == CAPACITY) {
            wait();
        }
        if (donutId > MAX_DONUTS)
            return false;

        tray.add(donutId);
        System.out.println(producerName + " produced Donut #" + donutId);
        donutId++;
        notifyAll();
        return true;
    }

    public synchronized boolean consume(String consumerName) throws InterruptedException {
        while (tray.isEmpty()) {
            wait();
        }
        int donut = tray.poll();
        System.out.println(consumerName + " consumed Donut #" + donut);
        notifyAll();
        return donut < MAX_DONUTS;
    }
}

class Producer extends Thread {
    private final DonutTray tray;
    private final String name;

    public Producer(DonutTray tray, String name) {
        this.tray = tray;
        this.name = name;
    }

    public void run() {
        try {
            while (true) {
                boolean more = tray.produce(name);
                if (!more)
                    break;
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer extends Thread {
    private final DonutTray tray;
    private final String name;

    public Consumer(DonutTray tray, String name) {
        this.tray = tray;
        this.name = name;
    }

    public void run() {
        try {
            while (true) {
                boolean more = tray.consume(name);
                if (!more)
                    break;
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ProduceConsume {
    public static void main(String[] args) {
        DonutTray tray = new DonutTray();

        Thread baker1 = new Producer(tray, " Baker 1");
        Thread baker2 = new Producer(tray, " Baker 2");

        Thread customer1 = new Consumer(tray, " Customer 1");
        Thread customer2 = new Consumer(tray, " Customer 2");

        baker1.start();
        baker2.start();
        customer1.start();
        customer2.start();
    }
}
