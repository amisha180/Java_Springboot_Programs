package Core_Java.Mutithreading.Keywords;

public class VolatileExample {
    private volatile boolean running = true;

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void run() {
        System.out.println("Thread started");
        while (running) {
            // Busy-wait
        }
        System.out.println("Thread stopped");
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileExample vol = new VolatileExample();

        Thread thread = new Thread(()->vol.run());
        thread.start();

        Thread.sleep(5000); // Let the thread run for a bit
        vol.setRunning(false); // This will stop the thread

        thread.join(); // Wait for the thread to finish
        System.out.println("Main thread finished");
    }
}
