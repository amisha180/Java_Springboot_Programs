package Core_Java.Mutithreading.ThreadCreation;

public class MainThreadExp {
    public static void main(String[] args) {
        Thread t1 = Thread.currentThread();
        System.out.println(t1.getName());
        System.out.println(t1.getId());
        System.out.println(t1.getPriority());
        System.out.println(t1.getState());
        System.out.println(t1.getThreadGroup());
    }
}
