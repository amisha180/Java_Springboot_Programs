package Core_Java.Mutithreading.ThreadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

class CustomThreadPool {
    private final BlockingQueue<Runnable> taskQueue;
    private final Thread[] workers;
    private final AtomicBoolean isShutdownInitiated;

    public CustomThreadPool(int numberOfThreads) {
        taskQueue = new LinkedBlockingQueue<>();
        workers = new Thread[numberOfThreads];
        isShutdownInitiated = new AtomicBoolean(false);

        // Create and start worker threads
        for (int i = 0; i < numberOfThreads; i++) {
            workers[i] = new Worker(taskQueue, isShutdownInitiated);
            workers[i].start();
        }
    }

    public void submit(Runnable task) throws IllegalStateException {
        if (!isShutdownInitiated.get()) {
            taskQueue.offer(task); // Submit task to the queue
        } else {
            throw new IllegalStateException("ThreadPool is already shutdown, unable to accept new tasks.");
        }
    }

    public void shutdown() {
        isShutdownInitiated.set(true);
        for (Thread worker : workers) {
            worker.interrupt(); // Interrupt worker threads to stop them
        }
    }

    private static class Worker extends Thread {
        private final BlockingQueue<Runnable> taskQueue;
        private final AtomicBoolean isShutdownInitiated;

        public Worker(BlockingQueue<Runnable> taskQueue, AtomicBoolean isShutdownInitiated) {
            this.taskQueue = taskQueue;
            this.isShutdownInitiated = isShutdownInitiated;
        }

        @Override
        public void run() {
            while (!isShutdownInitiated.get() || !taskQueue.isEmpty()) {
                Runnable task = taskQueue.poll();
                if (task != null) {
                    task.run(); // Execute the task
                }
            }
        }
    }
}

public class CustomThreadPoolMain {
    public static void main(String[] args) {
        CustomThreadPool threadPool = new CustomThreadPool(3);

        // Submit tasks to the custom thread pool
        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            threadPool.submit(() -> {
                System.out.println("Task " + taskId + " is running in " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // Simulate task execution
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Task " + taskId + " is completed in " + Thread.currentThread().getName());
            });
        }

        // Shutdown the thread pool
        threadPool.shutdown();
    }
}

