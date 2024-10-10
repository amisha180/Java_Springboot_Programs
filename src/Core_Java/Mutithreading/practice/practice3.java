package Core_Java.Mutithreading.practice;


class Solve{
    private int count=0;
    public void increment(){
        System.out.println(Thread.currentThread().getName()+" = " +count);
        count++;
    }
}
public class practice3 {
    public static void main(String[] args) {
        Solve s = new Solve();
        Thread t1 = new Thread(()->s.increment());
        Thread t2 = new Thread(()->s.increment());
        Thread t3 = new Thread(()->s.increment());
        t1.start();
        t2.start();
        t3.start();
    }
}
