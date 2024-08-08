package Core_Java.Mutithreading.Synchronization;

class Table{
     synchronized void printTable(int n){//method not synchronized
        for(int i=1;i<=5;i++){
            System.out.println(Thread.currentThread().getName()+" = "+n*i);
            try{
                Thread.sleep(400);
            }catch(Exception e){System.out.println(e);}
        }

    }
}


public class SynchronizeExp{
    public static void main(String args[]){
        Table obj = new Table();//only one object
        Thread t1=new Thread(()->obj.printTable(5));
        Thread t2=new Thread(()->obj.printTable(100));
        Thread t3=new Thread(()->obj.printTable(10));
        t1.start();
        t2.start();
        t3.start();
    }
}