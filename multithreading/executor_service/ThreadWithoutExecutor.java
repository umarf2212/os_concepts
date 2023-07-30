package multithreading.executor_service;

public class ThreadWithoutExecutor {
    public static void main(String[] args) {
        /*
         * These numbers will not print necessarily in order.
         * The order of their execution depends on how the threads
         * are scheduled internally.
         */
        for (int i=1; i<=100; i++) {
            final int num = i;
            new Thread(() -> System.out.println(num)).start();
        }
    }
}
