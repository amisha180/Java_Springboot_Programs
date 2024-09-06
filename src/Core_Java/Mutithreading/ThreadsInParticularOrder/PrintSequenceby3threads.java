package Core_Java.Mutithreading.ThreadsInParticularOrder;

// 3 threads- 1 - 1stthread ,2-2nd thread,3rd Thread
class PrintNum{
    private int counter=1;
    private final int maxSize=15;
    private final int numOfThreads = 3;
    private int turn = 1;
    public void printn(int threadId){
        synchronized (this){
            while (counter<=maxSize){
                if (turn!=threadId){
                    try{
                        wait();
                    }
                    catch (InterruptedException e){
                        throw  new RuntimeException();
                    }
                }
                if (counter<=maxSize){
                    System.out.println(Thread.currentThread().getName()+" "+counter);
                    counter++;
                    turn = turn%numOfThreads + 1;
                    notifyAll();
                }
            }
        }
    }

}
public class PrintSequenceby3threads {
    public static void main(String[] args) {
        PrintNum p = new PrintNum();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                p.printn(1);
            }
        },"t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                p.printn(2);
            }
        },"t2");
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                p.printn(3);
            }
        },"t3");
        t1.start();
        t2.start();
        t3.start();
    }
}
