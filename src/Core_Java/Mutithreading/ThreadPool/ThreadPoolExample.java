package Core_Java.Mutithreading.ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

class Tasks implements Runnable {
    private final String name;

    public Tasks(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " executing task: " + name);
        try {
            Thread.sleep(1000); // Simulate some work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
class Worker extends Thread {
    private final BlockingQueue<Runnable> taskQueue;
    private final AtomicBoolean isStopped;

    public Worker(BlockingQueue<Runnable> taskQueue) {
        this.taskQueue = taskQueue;
        this.isStopped = new AtomicBoolean(false);
    }

    @Override
    public void run() {
        while (!isStopped.get()) {
            try {
                Runnable task = taskQueue.poll(1, TimeUnit.SECONDS);
                if (task != null) {
                    task.run();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void stopWorker() {
        isStopped.set(true);
        this.interrupt();
    }
}
class ThreadPool {
    private final int corePoolSize;
    private final int maxPoolSize;
    private final long keepAliveTime;
    private final TimeUnit timeUnit;
    private final BlockingQueue<Runnable> taskQueue;
    private final List<Worker> workers;
    private final AtomicBoolean isStopped;
    private final RejectedExecutionHandler handler;

    public ThreadPool(int corePoolSize, int maxPoolSize, long keepAliveTime, TimeUnit timeUnit,
                      BlockingQueue<Runnable> taskQueue, RejectedExecutionHandler handler) {
        this.corePoolSize = corePoolSize;
        this.maxPoolSize = maxPoolSize;
        this.keepAliveTime = keepAliveTime;
        this.timeUnit = timeUnit;
        this.taskQueue = taskQueue;
        this.workers = new ArrayList<>(maxPoolSize);
        this.isStopped = new AtomicBoolean(false);
        this.handler = handler;

        // Start core workers
        for (int i = 0; i < corePoolSize; i++) {
            Worker worker = new Worker(taskQueue);
            workers.add(worker);
            worker.start();
        }
    }

    public void execute(Runnable task) {
        if (isStopped.get()) {
            handler.rejectedExecution(task, null);
            return;
        }

        if (taskQueue.offer(task)) {
            return;
        }

        synchronized (workers) {
            if (workers.size() < maxPoolSize) {
                Worker worker = new Worker(taskQueue);
                workers.add(worker);
                worker.start();
                taskQueue.offer(task);  // Add the task to the queue now
            } else {
                handler.rejectedExecution(task, null);
            }
        }
    }

    public void shutdown() {
        isStopped.set(true);
        for (Worker worker : workers) {
            worker.stopWorker();
        }
    }
}
class CustomRejectedExecutionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task rejected: " + r.toString());
    }
}
public class ThreadPoolExample {
    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(5); // Queue size of 5
        RejectedExecutionHandler handler = new CustomRejectedExecutionHandler();

        ThreadPool threadPool = new ThreadPool(3, 5,
                60, TimeUnit.SECONDS, queue, handler);

        for (int i = 1; i <= 10; i++) {
            try {
                threadPool.execute(new Tasks("Task "+i));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        threadPool.shutdown();
    }
}
