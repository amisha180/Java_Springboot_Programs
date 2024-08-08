package Core_Java.Mutithreading.Problems;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

class Restaurant {
    private final Semaphore seats;

    public Restaurant(int capacity) {
        this.seats = new Semaphore(capacity, true); // true for fair scheduling
    }

    public void enterRestaurant(String customerName) {
        try {
            seats.acquire();
            System.out.println(customerName + " has entered and seated.");
            // Simulate time spent in the restaurant
            Thread.sleep((long) (Math.random() * 10000));
            leaveRestaurant(customerName);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(customerName + " was interrupted while waiting for a seat.");
        }
    }

    public void leaveRestaurant(String customerName) {
        System.out.println(customerName + " has left the restaurant.");
        seats.release();
    }
}

class Customer implements Runnable {
    private final Restaurant restaurant;
    private final String name;

    public Customer(Restaurant restaurant, String name) {
        this.restaurant = restaurant;
        this.name = name;
    }

    @Override
    public void run() {
        restaurant.enterRestaurant(name);
    }
}

public class RestaurantProblem {
    public static void main(String[] args) {
        final int CAPACITY = 3;
        Restaurant restaurant = new Restaurant(CAPACITY);

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 1; i <= 6; i++) { // Let's simulate 200 customers
            Customer customer = new Customer(restaurant, "Customer " + i);
            executorService.submit(customer);
        }

        executorService.shutdown();
    }
}

