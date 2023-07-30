package multithreading.locking_mechanism;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Remove the lock [lock.lock()] from Adder and Subtractor 
 * and race condition will occur between Adder and Subtractor threads.
 */

public class BasicLock {
    public static void main(String[] args) {

        Count count = new Count();
        ReentrantLock lock = new ReentrantLock();

        Adder adder = new Adder(count, lock);
        Subtractor subtractor = new Subtractor(count, lock);

        Thread t1 = new Thread(adder);
        Thread t2 = new Thread(subtractor);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getStackTrace());
        }

        System.out.println(count.value);

    }
}
