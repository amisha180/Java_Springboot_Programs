package Core_Java.PractiseJava;

class primer {
   private int counter=1;
   private final int maxsize=10;
   public void printodd(){
       synchronized (this){
           while (counter<=maxsize){
               while (counter%2==0){
                   try {
                       wait();
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
               }
               if(counter<=maxsize){

                   System.out.println(Thread.currentThread().getName()+" "+counter);
                   counter++;
                   notify();
               }
           }
       }
   }
   public void printeven(){
       synchronized (this){
           while (counter<=maxsize){
               while (counter%2!=0){
                   try {
                       wait();
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
               }
               if(counter<=maxsize){
                   System.out.println(Thread.currentThread().getName()+" "+counter);
                   counter++;
                   notify();
               }
           }
       }
   }
}
public class practice{
    public static void main(String[] args) {
        primer p = new primer();
        Thread odd = new Thread(new Runnable(){
            @Override
            public void run(){
                p.printodd();
            }
        },"oddthread");
        Thread even = new Thread(new Runnable(){
            @Override
            public void run(){
                p.printeven();
            }
        },"eventhread");
        odd.start();
        even.start();
    }
}
