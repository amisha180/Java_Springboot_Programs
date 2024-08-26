package Core_Java.Mutithreading.Problems;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TokenBucketExp {
    private final int maxTokens;
    private int tokens;
    private final Lock lock = new ReentrantLock();
    private final Condition tokenAvailable = lock.newCondition();

    public TokenBucketExp(int maxTokens) {
        this.maxTokens = maxTokens;
        this.tokens = 0;
        startTokenFiller();
    }

    private void startTokenFiller() {
        Thread fillerThread = new Thread(() -> {
            try {
                while (true) {
                    lock.lock();
                    try {
                        if (tokens < maxTokens) {
                            tokens++;
                            tokenAvailable.signal(); // Signal that a token is available
                        }
                        else {
                            System.out.println("Bucket is full, cannot add more tokens at " + System.currentTimeMillis() / 1000);
                        }
                    } finally {
                        lock.unlock();
                    }
                    Thread.sleep(1000); // Fill the bucket at a rate of 1 token per second
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Handle interruption
            }
        });
        fillerThread.setDaemon(true);
        fillerThread.start(); // Start the filler thread
    }

    public void getToken() throws InterruptedException {
        lock.lock();
        try {
            while (tokens == 0) {
                tokenAvailable.await(); // Wait until a token is available
            }
            tokens--; // Consume a token
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        TokenBucketExp bucket = new TokenBucketExp(3); // Bucket can hold 5 tokens

        Runnable task = () -> {
            try {
                bucket.getToken();
                System.out.println(Thread.currentThread().getName() + " got a token");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        for (int i = 0; i < 10; i++) {
            new Thread(task).start();
        }
    }
}

