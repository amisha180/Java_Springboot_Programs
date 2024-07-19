package Core_Java.mutithreading;

public class SharedResource {
        private int data;
        private boolean hasData = false;

        public synchronized void produce(int value) throws InterruptedException {
            while (hasData) {
                wait();
            }
            data = value;
            hasData = true;
            notify();
        }

        public synchronized int consume() throws InterruptedException {
            while (!hasData) {
                wait();
            }
            hasData = false;
            notify();
            return data;
        }
    }
