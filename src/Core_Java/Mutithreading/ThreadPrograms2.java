package Core_Java.Mutithreading;

public class ThreadPrograms2 extends Thread{
    public void run() {
        for(int i=0;i<=5;i++) {
            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(i+" "+this);
        }
    }
    public static void main(String[] args) {
        ThreadPrograms2 t1 =  new ThreadPrograms2();
        ThreadPrograms2 t2 =  new ThreadPrograms2();
        t1.start();
        t2.start();


    }
}

