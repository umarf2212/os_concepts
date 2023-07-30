package multithreading.locking_mechanism;

import java.util.concurrent.locks.ReentrantLock;

public class Adder implements Runnable {

    private Count count;
    private ReentrantLock lock;

    public Adder(Count count, ReentrantLock lock) {
        this.count = count;
        this.lock = lock;
    }

    @Override
    public void run(){
        for(int i=1; i<10000; i++) {
            lock.lock();
            count.value += i;
            lock.unlock();
        }
    }
}
