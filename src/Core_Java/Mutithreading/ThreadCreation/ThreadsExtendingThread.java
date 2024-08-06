package Core_Java.Mutithreading.ThreadCreation;

public class ThreadsExtendingThread extends Thread{
   private static int count=0;
    @Override
    public  void run(){
        for (int i=0;i<5;i++){
            synchronized (this){
                count++;
                System.out.println(Thread.currentThread().getName()+" "+i+" count "+count);
            }

        }
    }
    public static void main(String[] args) {
        ThreadsExtendingThread t1 = new ThreadsExtendingThread();
        ThreadsExtendingThread t2 = new ThreadsExtendingThread();
        ThreadsExtendingThread t3 = new ThreadsExtendingThread();

        System.out.println(t1.getState());
        t1.start();
        System.out.println(t1.getState());
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        t3.setName("t3");
        //t3.setPriority(10);
        t3.start();

    }
}
