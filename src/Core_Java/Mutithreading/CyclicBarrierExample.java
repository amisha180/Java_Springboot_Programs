package Core_Java.Mutithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Workers implements Runnable {
    private final CyclicBarrier barrier;
    private final String workerName;

    public Workers(CyclicBarrier barrier, String workerName) {
        this.barrier = barrier;
        this.workerName = workerName;
    }

    @Override
    public void run() {
        try {
            System.out.println(workerName + " is performing task part 1.");
            Thread.sleep((long) (Math.random() * 1000)); // Simulate work for part 1
            System.out.println(workerName + " has reached the barrier after part 1.");

            barrier.await(); // Wait for other threads

            System.out.println(workerName + " is performing task part 2.");
            Thread.sleep((long) (Math.random() * 1000)); // Simulate work for part 2
            System.out.println(workerName + " has reached the barrier after part 2.");

            barrier.await(); // Wait for other threads

            System.out.println(workerName + " is performing task part 3.");
            Thread.sleep((long) (Math.random() * 1000)); // Simulate work for part 3
            System.out.println(workerName + " has completed the task.");
        } catch (InterruptedException | BrokenBarrierException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class CyclicBarrierExample {
    public static void main(String[] args) {
        int numberOfWorkers = 3;
        CyclicBarrier barrier = new CyclicBarrier(numberOfWorkers, new Runnable() {
            @Override
            public void run() {
                System.out.println("All workers have reached the barrier. Proceeding to the next part...");
            }
        });

        Thread worker1 = new Thread(new Workers(barrier, "Worker 1"));
        Thread worker2 = new Thread(new Workers(barrier, "Worker 2"));
        Thread worker3 = new Thread(new Workers(barrier, "Worker 3"));

        worker1.start();
        worker2.start();
        worker3.start();
    }
}

