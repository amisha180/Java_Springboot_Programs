package Core_Java.Java_8_features.FunctionalInterfaces;

import java.util.function.Supplier;

public class SupplierExp {
    public static void main(String[] args) {
        Supplier<Double> number = ()->Math.random();
        System.out.println(number.get());
    }
}
