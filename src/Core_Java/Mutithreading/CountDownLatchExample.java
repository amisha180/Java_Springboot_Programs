package Core_Java.Mutithreading;

import java.util.concurrent.CountDownLatch;

class Service implements Runnable{
    private final CountDownLatch countDownLatch;
    private final String serviceName;
    public Service( CountDownLatch countDownLatch,String serviceName){
        this.countDownLatch = countDownLatch;
        this.serviceName = serviceName;
    }
    @Override
    public void run(){
        try {
            System.out.println(serviceName + " is starting...");
            Thread.sleep((long) (Math.random() * 1000)); // Simulate startup time
            System.out.println(serviceName + " has started.");
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        finally {
            countDownLatch.countDown();
        }
    }

}
public class CountDownLatchExample {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Thread service1  = new Thread(new Service(countDownLatch,"s1"));
        Thread service2  = new Thread(new Service(countDownLatch,"s2"));
        Thread service3  = new Thread(new Service(countDownLatch,"s3"));

        service1.start();
        service2.start();
        service3.start();

        System.out.println("Waiting for services to start...");

        try {
            countDownLatch.await(); // Wait until the count reaches zero
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("All services have started. Main thread proceeding...");
    }
}
