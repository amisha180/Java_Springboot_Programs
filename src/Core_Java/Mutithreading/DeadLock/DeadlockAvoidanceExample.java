package Core_Java.Mutithreading.DeadLock;

public class DeadlockAvoidanceExample {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            acquireLocks(lock1, lock2);
            try {
                System.out.println("Thread 1: Acquired both locks!");
                // Perform some work
            } finally {
                releaseLocks(lock1, lock2);
            }
        });

        Thread thread2 = new Thread(() -> {
            acquireLocks(lock1, lock2);
            try {
                System.out.println("Thread 2: Acquired both locks!");
                // Perform some work
            } finally {
                releaseLocks(lock1, lock2);
            }
        });

        thread1.start();
        thread2.start();
    }

    private static void acquireLocks(Object lock1, Object lock2) {
        synchronized (lock1) {
            synchronized (lock2) {
                // Acquired both locks
            }
        }
    }

    private static void releaseLocks(Object lock1, Object lock2) {
        // Explicitly releasing the locks is not necessary in this context
        // as the synchronized block will automatically release them.
    }
}

