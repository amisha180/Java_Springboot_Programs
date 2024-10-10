package Core_Java.Mutithreading.ThreadCreation;
class Sum{
    private int counter=1;
    private int turn = 1;
    public void print(int threadId){
        synchronized (this){ // Critical section starts here
            System.out.println(Thread.currentThread().getName()+" inside synchronized");
            while (counter<=10){
                System.out.println(Thread.currentThread().getName()+" inside 1st while loop");
                while (turn!=threadId){
                    System.out.println(Thread.currentThread().getName()+" inside turn!=threadid");
                    try {
                        System.out.println(Thread.currentThread().getName()+" waiting started");
                        wait();
                        System.out.println(Thread.currentThread().getName()+" wait endde");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(Thread.currentThread().getName()+" outside while");
                if (counter<=10){
                    System.out.println(Thread.currentThread().getName()+" inside print");
                    System.out.println(Thread.currentThread().getName()+" : "+counter);
                    counter++;
                    turn = turn%3+1;
                    notifyAll();
                }
            }
        }// Critical section ends here

    }
}
public class ThreadImplementingRunnable {
    public static void main(String[] args) {
        Sum s = new Sum();
        Thread t1 = new Thread(()->s.print(1),"t1");
        Thread t4 = new Thread(()->s.print(2),"t4");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
               s.print(2);
            }
        },"t2");
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                s.print(3);
            }
        },"t3");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
