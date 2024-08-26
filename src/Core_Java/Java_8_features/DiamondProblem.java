package Core_Java.Java_8_features;
interface A {
    default void show() {
        System.out.println("Interface A");
    }
}

interface B extends A {
    // B inherits the show() method from A
}

interface C extends A {
    // C inherits the show() method from A
}

class D implements B, C {
    // D inherits from both B and C

    @Override
    public void show() {
        // Resolving the diamond problem by specifying which interface's method to use
        B.super.show(); // or C.super.show();
    }
}


public class DiamondProblem {
    public static void main(String[] args) {
        D obj = new D();
        obj.show(); // This will print "Interface A"
    }
}
