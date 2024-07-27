package Core_Java.GarbageCollector;

public class FinalizeExample {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize method called");
    }

    public static void main(String[] args) {
        FinalizeExample obj = new FinalizeExample();
        obj = null;
        System.gc(); // Suggests that the JVM runs the garbage collector
        System.out.println("Garbage collection requested.");
    }
}

