package Core_Java.GarbageCollector;

public class GarbageCollectorDemo {

        public static void main(String[] args) {
            // Create an object of the Example class
            Example example = new Example();

            // The object is no longer referenced
            example = null;

            // Suggesting the JVM to run the garbage collector
            System.gc();

            System.out.println("End of program");
        }
    }

    class Example {
        // Destructor-like method (finalize) is called before an object is garbage collected
        @Override
        protected void finalize() throws Throwable {
            System.out.println("Garbage collector is called, object is being garbage collected");
        }
    }

