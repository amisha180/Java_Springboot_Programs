package Core_Java.Java_8_features.FunctionalInterfaces;

import java.util.function.Consumer;

public class ConsumerExp {
    public static void main(String[] args) {
        Consumer<String> stringToUppercase = (s)-> System.out.println(s.toUpperCase());
        stringToUppercase.accept("hello world");
    }
}
