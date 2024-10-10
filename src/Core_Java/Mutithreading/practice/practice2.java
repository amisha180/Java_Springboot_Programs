package Core_Java.Mutithreading.practice;

class PrintEvenOdd{
    private int count=1;
    private final int maxcount=10;
    public void print(int id){
        synchronized (this){
            while(count<=maxcount){
                if(id==1){
                    if(count%2!=0){
                        System.out.println(Thread.currentThread().getName()+" = "+count);
                        count++;
                        notifyAll();
                    }
                    else{
                        try {
                            wait();
                        }
                        catch (InterruptedException e){
                            System.out.println(e.getMessage());
                        }
                    }
                }
                else if(id==2){
                    if(count%2==0){
                        System.out.println(Thread.currentThread().getName()+" = "+count);
                        count++;
                        notifyAll();
                    }
                    else{
                        try {
                            wait();
                        }
                        catch (InterruptedException e){
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }
        }
    }
}
public class practice2 {
    public static void main(String[] args) {
        PrintEvenOdd p = new PrintEvenOdd();
        Thread t1 = new Thread(()->p.print(1));
        Thread t2 = new Thread(()->p.print(2));
        t1.start();
        t2.start();
    }
}
