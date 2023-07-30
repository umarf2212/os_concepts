package multithreading.threads_basics;

public class BasicRunnable implements Runnable {
    @Override 
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread is running " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        // create runnable instance
        Runnable basicRunnable = new BasicRunnable(); 

        // create a thread for the runnable
        Thread t1 = new Thread(basicRunnable);

        // start the thread
        t1.start();

    }
}
