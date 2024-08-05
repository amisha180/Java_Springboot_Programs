package Core_Java.Mutithreading;

import java.util.concurrent.locks.ReentrantLock;

class  SharedResources{
    private final ReentrantLock lock = new ReentrantLock();
    private int counter=0;
    public void increment(){
        lock.lock();
        try{
            counter++;
            System.out.println(Thread.currentThread().getName()+" "+counter);
        }
        finally {
            lock.unlock();
        }
    }
    public void decrement(){
        lock.lock();
        try{
            counter--;
            System.out.println(Thread.currentThread().getName()+" "+counter);
        }
        finally {
            lock.unlock();
        }
    }
    public int getCounter() {
        lock.lock();
        try {
            return counter;
        } finally {
            lock.unlock();
        }
    }

}
public class ReentrantLockImpl {
    public static void main(String[] args) {
        SharedResources s = new SharedResources();
        Runnable r = ()->{
            for (int i=0;i<5;i++){
                s.increment();
                try{
                    Thread.sleep(100);
                }
                catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
                s.decrement();
            }
        };
        Thread t1 = new Thread(r,"t1");
        Thread t2 = new Thread(r,"t2");
        t1.start();
        t2.start();
    }
}
//Reentrant locks in Java are a type of lock that allows the thread that holds the lock to re-enter it.
// This means that if a thread already holds the lock and then attempts to acquire it again, it will be allowed
// to proceed without getting blocked. This is particularly useful in scenarios where a method that needs to
// acquire the lock calls another method that also requires the same lock.