package multithreading.semaphores;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
// import java.util.concurrent.locks.Lock;
// import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {
    // private final Lock lock = new ReentrantLock();
    private final Semaphore burgerSemaphore = new Semaphore(0);
    private final Semaphore spaceSemaphore = new Semaphore(10);
    private final Queue<Integer> burgerQueue = new LinkedList<>();

    public void produceBurger() throws InterruptedException {
        // Acquire a space permit: semaphore -= 1
        // this means 1 space is being consumed by producing a burger
        spaceSemaphore.acquire(); 
        
        // Produce a burger
        burgerQueue.add(1);
        System.out.println("Produced. Queue size: " + burgerQueue.size());
        
        // Acquire a burger permit: semaphore += 1
        // this means +1 burger is available for consumption.
        burgerSemaphore.release();
    }

    public void consumeBurger() throws InterruptedException {
        // Acquire a burger permit: semaphore -= 1
        // this means 1 space is being created by consuming a burger
        burgerSemaphore.acquire();

        // Consume a burger
        burgerQueue.poll();
        System.out.println("Consumed. Queue size: " + burgerQueue.size());

        // Release a space permit: semaphore += 1
        // this means +1 space is available for a burger to be produced
        spaceSemaphore.release();
    }
}
