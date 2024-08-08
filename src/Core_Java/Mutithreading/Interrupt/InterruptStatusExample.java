package Core_Java.Mutithreading.Interrupt;

class InterruptExample implements Runnable {
    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + " - Interrupted flag is set.");
                break; // Exit the loop if interrupted
            }
            try {
                Thread.sleep(1000); // Simulate work
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " - Caught InterruptedException.");
                // Re-interrupt the thread to set the interrupt flag again
                Thread.currentThread().interrupt();
                //System.out.println(Thread.interrupted());

            }
            System.out.println(Thread.currentThread().getName() + " - Working...");
        }
    }
}

public class InterruptStatusExample {
    public static void main(String[] args) {
        Thread thread = new Thread(new InterruptExample(), "WorkerThread");

        thread.start();

        try {
            Thread.sleep(3000); // Let the thread run for 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread is interrupting the worker thread.");
        thread.interrupt(); // Interrupt the worker thread

        try {
            thread.join(); // Wait for the worker thread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread has finished.");
    }
}
