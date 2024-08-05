package Core_Java.Mutithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class WorkerTask implements Runnable {
    private final String taskName;

    public WorkerTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is executing " + taskName);
        try {
            // Simulate a long-running task
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + " has finished " + taskName);
    }
}

public class ThreadPoolExample {
    public static void main(String[] args) {
        // Create a thread pool with a fixed number of threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Submit tasks to the thread pool
        for (int i = 1; i <= 10; i++) {
            String taskName = "Task " + i;
            WorkerTask task = new WorkerTask(taskName);
            executorService.submit(task);
        }

        // Shut down the executor service
        executorService.shutdown();
        try {
            // Wait for all tasks to finish
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("All tasks have finished.");
    }
}

