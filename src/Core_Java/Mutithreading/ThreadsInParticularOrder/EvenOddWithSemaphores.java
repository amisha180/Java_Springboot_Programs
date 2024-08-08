package Core_Java.Mutithreading.ThreadsInParticularOrder;

import java.util.concurrent.Semaphore;

class EvenOdd{
    Semaphore sem = new Semaphore(1,true);
    private int counter=0;
    private int maxSize=25;
     void printEven(){
        while(counter<=maxSize){
            try{
                sem.acquire();
                if(counter%2==0){
                    System.out.println(Thread.currentThread().getName()+" = "+counter);
                    counter++;

                }
                sem.release();
            }
            catch (InterruptedException e){
                System.out.println(e.getMessage());
            }

        }
    }
    void printOdd(){
        while(counter<=maxSize){
            try{
                sem.acquire();
                if(counter%2!=0){
                    System.out.println(Thread.currentThread().getName()+" = "+counter);
                    counter++;

                }
                sem.release();
            }
            catch (InterruptedException e){
                System.out.println(e.getMessage());
            }

        }
    }
}
public class EvenOddWithSemaphores {
    public static void main(String[] args) {
        EvenOdd e = new EvenOdd();
        Thread t1 = new Thread(()->e.printEven(),"evenThread");
        Thread t2 = new Thread(()->e.printOdd(),"oddThread");
        t1.start();
        t2.start();

    }
}
