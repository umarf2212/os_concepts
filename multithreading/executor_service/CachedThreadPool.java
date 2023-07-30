package multithreading.executor_service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    public static void main(String[] args) {
        /*
         * This thread pool will create new worker threads on demand and if a worker 
         * is done executing, it will be rescheduled again for another task.
         */
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0; i<100; i++) {
            final int num = i;
            executorService.submit(() -> System.out.println(num + ", id: " + Thread.currentThread().getId()));
        }
        executorService.shutdown();
    }   
}
