package Core_Java.GarbageCollector;

public class GarbageCollectorDemo {
        public static void main(String[] args) {
            // Creating objects
            for (int i = 0; i < 100000; i++) {
                new Object();
            }

            // Requesting garbage collection
            System.gc();

            // Adding a delay to allow GC to complete
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Garbage collection completed.");
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println("An object is being garbage collected.");
        }
}
