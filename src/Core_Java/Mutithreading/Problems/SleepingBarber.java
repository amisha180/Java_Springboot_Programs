package Core_Java.Mutithreading.Problems;

import java.util.concurrent.Semaphore;

class BarberShop {
    private final int numberOfChairs;
    private final Semaphore chairsSemaphore;
    private final Semaphore barberSemaphore;
    private final Semaphore customerSemaphore;

    public BarberShop(int numberOfChairs) {
        this.numberOfChairs = numberOfChairs;
        this.chairsSemaphore = new Semaphore(numberOfChairs); // Available waiting chairs
        this.barberSemaphore = new Semaphore(0); // Initially, the barber is asleep
        this.customerSemaphore = new Semaphore(0); // No customers initially
    }

    public void customerArrives(int customerId) throws InterruptedException {
        System.out.println("Customer " + customerId + " arrives.");

        // Try to find a waiting chair
        if (chairsSemaphore.tryAcquire()) {
            System.out.println("Customer " + customerId + " sits in a waiting chair.");

            // Notify the barber that a customer is available
            customerSemaphore.release();

            // Wait until the barber is ready
            barberSemaphore.acquire();

            // The customer now gets a haircut
            System.out.println("Customer " + customerId + " is getting a haircut.");
        } else {
            System.out.println("No waiting chairs available. Customer " + customerId + " leaves.");
        }
    }

    public void barber() throws InterruptedException {
        while (true) {
            // Wait for a customer to arrive
            customerSemaphore.acquire();

            // A customer is ready; release the barber
            chairsSemaphore.release(); // Free up a waiting chair
            barberSemaphore.release();

            System.out.println("Barber is cutting hair.");

            // Simulate haircut time
            Thread.sleep(1000);

            System.out.println("Barber has finished cutting hair.");
        }
    }
}

public class SleepingBarber {
    public static void main(String[] args) {
        BarberShop shop = new BarberShop(3); // Barber shop with 3 waiting chairs

        // Barber thread
        Thread barberThread = new Thread(() -> {
            try {
                shop.barber();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        barberThread.start();

        // Customer threads
        for (int i = 1; i <= 10; i++) {
            int customerId = i;
            new Thread(() -> {
                try {
                    shop.customerArrives(customerId);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

            // Simulate random customer arrival time
            try {
                Thread.sleep((int) (Math.random() * 2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

