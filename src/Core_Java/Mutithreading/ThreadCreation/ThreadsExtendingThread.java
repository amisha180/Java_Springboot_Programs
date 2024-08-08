package Core_Java.Mutithreading.ThreadCreation;

public class ThreadsExtendingThread  {
     private static int count=0;

    public synchronized void print() {
        for (int i = 0; i < 5; i++) {

            count++;
            System.out.println(Thread.currentThread().getName() + " " + i+", count="+count);


        }
    }
}
class Thread1 extends Thread{
    ThreadsExtendingThread th;
    public Thread1(ThreadsExtendingThread th){
        this.th  = th;
    }
    @Override
    public void run(){
        th.print();
    }
}
class mainTh{
    public static void main(String[] args) {
        ThreadsExtendingThread th = new ThreadsExtendingThread();
        Thread1 t1 = new Thread1(th);
        t1.start();
        Thread t2 = new Thread(()->th.print());
        Thread t3 = new Thread(()->th.print());

        // run - It will run in main call stack and run like a normal method
      //  t1.start(); if again try to start a thread after starting once -  IllegalThreadStateException
        System.out.println(t1.getState());
//        try {
//            t1.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        t2.start();
        //IllegalMonitorStateException
        //try {
        //t2.wait();
        // } catch (InterruptedException e) {
        //    throw new RuntimeException(e);
        // }
//        try {
//            t2.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }


        //t3.setName("t3");
        //t3.setPriority(10);
        t3.start();  // It will start in separate call stack and run like a thread

    }
}
