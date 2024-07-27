package Core_Java.Static;

public class OuterClass {
    static int outerValue = 100;

    static class StaticNestedClass {
        void display() {
            System.out.println("Outer value: " + outerValue);
        }
    }
}

 class Main {
    public static void main(String[] args) {
        OuterClass.StaticNestedClass nestedObject = new OuterClass.StaticNestedClass();
        nestedObject.display(); // Outputs: Outer value: 100
    }
}
