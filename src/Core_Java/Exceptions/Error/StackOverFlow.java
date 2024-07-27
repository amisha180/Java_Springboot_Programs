package Core_Java.Exceptions.Error;

public class StackOverFlow {
    public static void recursiveMethod() {
        recursiveMethod(); // Infinite recursion
    }

    public static void main(String[] args) {
        recursiveMethod();
    }
}
