package Core_Java.Mutithreading.Synchronization;
class Nested{
    public synchronized void Outer(){
        System.out.println(Thread.currentThread().getName()+" Entered outer method");
        inner(); // calling another synchronized method
        System.out.println(Thread.currentThread().getName()+" Exited outer function");
    }
    public synchronized void inner(){
        System.out.println(Thread.currentThread().getName()+" Entered inner method");
        System.out.println("inner method running");
        System.out.println(Thread.currentThread().getName()+" Exited inner function");
    }
}
public class ReentrantLockExp {
    public static void main(String[] args) {
        Nested n = new Nested();
        Thread t1 = new Thread(()->{
            n.Outer();
        });
        t1.start();
    }
}
