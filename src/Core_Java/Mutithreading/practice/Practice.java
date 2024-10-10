package Core_Java.Mutithreading.practice;
class Operation{
    private int count = 1;
    private final int  maxValue = 10;
    private final int  noOfThread = 3;
    private int turn = 1;

    public  void print(int threadId){
        synchronized (this){
            while(maxValue>=count){
                if (threadId!=turn){
                    try{
                        wait();
                    }
                    catch (InterruptedException e){
                        System.out.println(e.getMessage());
                    }
                }
                else {
                    if(maxValue>=count){
                        System.out.println(Thread.currentThread().getName()+" = "+count);
                        count++;
                        turn = (turn % noOfThread)+1;
                        notifyAll();

                    }
                }
            }
        }
    }
}
public class Practice {
    public static void main(String[] args) {
        Operation op = new Operation();
        Thread t1 = new Thread(()->op.print(1));
        Thread t2 = new Thread(()->op.print(2));
        Thread t3 = new Thread(()->op.print(3));
        t1.start();
        t2.start();
        t3.start();
    }
}
