package Core_Java.Mutithreading.Synchronizers;

import java.util.concurrent.Semaphore;

class Worker implements Runnable {
    private final Semaphore semaphore;
    private final String workerName;

    public Worker(Semaphore semaphore, String workerName) {
        this.semaphore = semaphore;
        this.workerName = workerName;
    }

    @Override
    public void run() {
        try {
            System.out.println(workerName + " is waiting for a permit.");
            semaphore.acquire(); // Acquire a permit
            System.out.println(workerName + " got a permit.");

            // Simulate work
            Thread.sleep((long) (Math.random() * 1000));

            System.out.println(workerName + " is releasing a permit.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release(); // Release the permit
        }
    }
}

public class SemaphoreExample {
    public static void main(String[] args) {
        int numberOfPermits = 3; // Number of permits
        Semaphore semaphore = new Semaphore(numberOfPermits);

        Thread worker1 = new Thread(new Worker(semaphore, "Worker 1"));
        Thread worker2 = new Thread(new Worker(semaphore, "Worker 2"));
        Thread worker3 = new Thread(new Worker(semaphore, "Worker 3"));
        Thread worker4 = new Thread(new Worker(semaphore, "Worker 4"));
        Thread worker5 = new Thread(new Worker(semaphore, "Worker 5"));

        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();
        worker5.start();
    }
}
//Semaphores are used to control access to a shared resource by multiple threads. A semaphore maintains a set
// of permits, and threads can acquire permits when they need access to the resource and release permits when
// they are done. If no permits are available, a thread trying to acquire a permit will block until one becomes
// available.
