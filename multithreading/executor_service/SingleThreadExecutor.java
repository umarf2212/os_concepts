package multithreading.executor_service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {
    public static void main(String[] args) {
        /*
         * This will create and run only one thread at a time.
         * So the order of print statements will be naturally sequential.
         */
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i=0; i<100; i++) {
            final int num = i;
            executorService.submit(() -> System.out.println(num + ", id: " + Thread.currentThread().getId()));
        }
        executorService.shutdown();
    }   
}
