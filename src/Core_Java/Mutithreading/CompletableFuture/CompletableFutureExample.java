package Core_Java.Mutithreading.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {

    public static void main(String[] args) {
        // First asynchronous task
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Executing task 1");
            try {
                Thread.sleep(1000); // Simulate a long-running task
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Result of task 1";
        });

        // Second asynchronous task
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Executing task 2");
            try {
                Thread.sleep(500); // Simulate a long-running task
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Result of task 2";
        });

        // Compose the two tasks
        CompletableFuture<String> combinedFuture = future1.thenCombine(future2, (result1, result2) -> {
            System.out.println("Combining results");
            return result1 + " + " + result2;
        });

        // Handle the final result
        combinedFuture.thenAccept(result -> System.out.println("Final result: " + result));

        // Ensure the main thread waits for the completion of all tasks
        try {
            combinedFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

