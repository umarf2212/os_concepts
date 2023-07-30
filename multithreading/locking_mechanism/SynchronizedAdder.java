package multithreading.locking_mechanism;

import java.util.concurrent.locks.ReentrantLock;

/*
 * This example uses synchronized method which utilizes the 
 * internal locks present in each object.
 */

public class SynchronizedAdder implements Runnable {

    private Count count;

    public SynchronizedAdder(Count count, ReentrantLock lock) {
        this.count = count;
    }

    @Override
    public void run(){
        for(int i=1; i<100; i++) {
            synchronized(count) {
                count.value += i;
            }
        }
    }
}
