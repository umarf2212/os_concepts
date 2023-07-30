package multithreading.executor_service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
    public static void main(String[] args) {
        /*
         * This thread pool will create 10 worker threads internally and schedule 
         * 10 threads at a time simultaneously to these workers.
         */
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i=0; i<100; i++) {
            final int num = i;
            executorService.submit(() -> System.out.println(num + ", id: " + Thread.currentThread().getId()));
        }
        executorService.shutdown();
    }
}
