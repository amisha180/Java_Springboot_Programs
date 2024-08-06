package Core_Java.Mutithreading.ThreadsInParticularOrder;

import Core_Java.Collections.Sort.Comparator.Sortbycomp;

class DataQueue{
    private boolean available=false;
    private int counter=0;
    private int maxSize=10;
    public void produce(){
        synchronized (this){
            while(counter<=maxSize) {
                while (available){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                counter++;
                System.out.println(Thread.currentThread().getName()+" : "+counter);

                available = true;
                notify();
            }
            }
    }
    public void consume(){
        synchronized (this){
            while(counter<=maxSize) {
                while (!available){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(Thread.currentThread().getName()+" : "+counter);
                available = false;
                notify();
            }
            }


    }
}


public class ProducerConsumerExample {
    public static void main(String[] args) {
        DataQueue dq  = new DataQueue();
       Thread producer = new Thread(new Runnable() {
           @Override
           public void run() {
               dq.produce();
           }
       },"producer");
       Thread consumer = new Thread(new Runnable() {
           @Override
           public void run() {
               dq.consume();
           }
       },"consumer");
       producer.start();
       consumer.start();

    }
}
