
import java.util.*;

class BoundedBuffer{
    private final Queue<Integer> buffer = new LinkedList<>();
    private final int capacity = 5;

public synchronized void produce(int value) throws InterruptedException {
    while(buffer.size()==capacity){wait();}
    buffer.add(value);
    System.out.println("Produced: "+value);
    notifyAll();
}

public synchronized int consume() throws InterruptedException{
    while(buffer.isEmpty()) {wait();}
    int value = buffer.poll();
    System.out.println("Consumed: "+value);
    notifyAll();
    return value;

}
}
class Producer extends Thread {
    BoundedBuffer buffer;
    public Producer(BoundedBuffer buffer){
        this.buffer = buffer;
    }

    public void run(){
        try{
            for (int i = 0; i< 10; i++) {
                buffer.produce(i);
                Thread.sleep(100);

            }
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        }
    
}

class Consumer extends Thread {
    BoundedBuffer buffer;
    public Consumer(BoundedBuffer buffer){
        this.buffer = buffer;
    }
    public void run(){
        try {
            for(int i = 0;i<10;i++){
                buffer.consume();
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ProdCons{
    public static void main(String[] args) {
        BoundedBuffer buffer = new BoundedBuffer();
        Producer producer1 = new Producer(buffer);
        Producer producer2 = new Producer(buffer);
        Consumer consumer1 = new Consumer(buffer);
        Consumer consumer2 = new Consumer(buffer);
        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();

    }
}

