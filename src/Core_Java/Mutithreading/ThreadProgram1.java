package Core_Java.Mutithreading;

public class ThreadProgram1 extends Thread{
    public void run() {
        System.out.println("t1 is running");
    }
    public static void main(String[] args) {
        ThreadProgram1 t1 = new ThreadProgram1();
        ThreadProgram2 r = new ThreadProgram2();
        Thread t2 = new Thread(r);
        System.out.println(t1.getState());
        t1.start();
        t2.start();
        System.out.println(t1.getState());
        try {
            t1.sleep(5000);
            System.out.println(t1.getState());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(t1.getState());

    }
}
class ThreadProgram2 implements Runnable{
    public  void actions() {

        System.out.println("----");
        System.out.println("====");
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("t2 is running");

    }
}
