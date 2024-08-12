package Core_Java.Mutithreading.ThreadPool;

import java.util.LinkedList;

public class BlockingQueueImpl<T> {
    private LinkedList<T> queue = new LinkedList<>();
    private int capacity;

    public BlockingQueueImpl(int capacity) {
        this.capacity = capacity;
    }

    // Adds an item to the queue
    public synchronized void enqueue(T item) throws InterruptedException {
        while (queue.size() == capacity) {
            wait(); // Wait until there is space in the queue
        }
        queue.addLast(item); // Add to the end of the list
        notifyAll(); // Notify a waiting thread that an item has been added
    }

    // Removes and returns an item from the queue
    public synchronized T dequeue() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // Wait until there is an item to dequeue
        }
        T item = queue.removeFirst(); // Remove from the front of the list
        notifyAll(); // Notify a waiting thread that an item has been removed
        return item;
    }

    // Returns the number of items in the queue
    public synchronized int size() {
        return queue.size();
    }
}
 class BlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueueImpl<Integer> queue = new BlockingQueueImpl<>(5);

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    queue.enqueue(i);
                    System.out.println("Produced: " + i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    int item = queue.dequeue();
                    System.out.println("Consumed: " + item);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}


