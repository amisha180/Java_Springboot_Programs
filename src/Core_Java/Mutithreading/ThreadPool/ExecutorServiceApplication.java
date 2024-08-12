package Core_Java.Mutithreading.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements Runnable {
    private final int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskId + " is starting.");
        try {
            // Simulate work by sleeping for a random time
            Thread.sleep((int) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task " + taskId + " is completed.");
    }
}

public class ExecutorServiceApplication {
    public static void main(String[] args) {
        int numberOfTasks = 5;
        int numberOfThreads = 3;

        // Create an ExecutorService with a fixed thread pool of 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        // Submit tasks to the executor
        for(int i=1;i<=numberOfTasks;i++){
            executor.submit(new Task(i));
        }
        // Initiate shutdown of the executor after all tasks are submitted
            executor.shutdown();

        try {
            // Wait for all tasks to finish before terminating
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("All tasks are completed.");
    }
}

