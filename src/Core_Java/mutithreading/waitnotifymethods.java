package Core_Java.mutithreading;

public class waitnotifymethods {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    resource.produce(i);
                    System.out.println("Produced: " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    int value = resource.consume();
                    System.out.println("Consumed: " + value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}

