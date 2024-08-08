package Core_Java.Mutithreading.Interrupt;

public class InterruptExp {
    public void print(){
       try{
            for(int i=1;i<=10;i++){
                System.out.println(Thread.currentThread().getName()+" iteration : "+i);
                Thread.sleep(1000);
            }
        }
       catch (InterruptedException e){
            System.out.println(Thread.currentThread().getName() + " was interrupted.");
        }
        System.out.println(Thread.currentThread().getName() + " is terminating.");
    }
    public static void main(String[] args) {
        InterruptExp obj = new InterruptExp();
        Thread t1 = new Thread(()->obj.print());
        t1.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Main thread is interrupting the task thread.");
        t1.interrupt(); // Interrupt the task thread

        try {
            t1.join(); // Wait for the task thread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread has finished.");



    }
}
