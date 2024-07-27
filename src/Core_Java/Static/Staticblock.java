package Core_Java.Static;

public class Staticblock {
    static int value;

    static {
        value = 42;
        System.out.println("Static block initialized.");
    }
    public static void main(String[] args) {

            System.out.println("Value: " + Staticblock.value); // Outputs: Value: 4
    }
}
