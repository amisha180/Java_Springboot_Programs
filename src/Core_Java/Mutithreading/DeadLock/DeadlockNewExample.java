package Core_Java.Mutithreading.DeadLock;

class Resource {
   private String name;
   public Resource(String name){
       this.name = name;
   }
   public String getName(){
      return name;
   }
}

public class DeadlockNewExample {
   private final Resource resource1 = new Resource("A");
   private final Resource resource2 = new Resource("B");
   public static void main(String[] args) {
     DeadlockNewExample d = new DeadlockNewExample();
     d.execute();
   }
   public void execute(){
      Thread t1 = new Thread(new Task(resource1,resource2),"t1");
      Thread t2 = new Thread(new Task(resource2,resource1),"t2");
      t1.start();
      t2.start();
   }
}

class Task implements Runnable {
   private final Resource resource1 ;
   private final Resource resource2 ;
   public Task(Resource resource1,Resource resource2){
      this.resource1 = resource1;
      this.resource2 = resource2;
   }


   @Override
   public void run(){
      //To Avoid Dead lock
      Resource first = resource1;
      Resource second = resource2;

      if (resource1.getName().compareTo(resource2.getName()) > 0) {
         first = resource2;
         second = resource1;
      }
      //To Avoid Dead lock
      synchronized (first){
         System.out.println(Thread.currentThread().getName() +
                 " locked " + first.getName());

         try {
            // Simulate some work with the first resource
            Thread.sleep(50);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }

         synchronized (second) {
            System.out.println(Thread.currentThread().getName() + " locked " + second.getName());
         }
      }
   }

}

