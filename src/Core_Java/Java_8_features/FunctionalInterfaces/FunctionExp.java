package Core_Java.Java_8_features.FunctionalInterfaces;

import java.util.function.Function;

public class FunctionExp {
    public static void main(String[] args) {
        Function<String,Integer> stringlength = (s)->s.length();
        System.out.println(stringlength.apply("hey how are you"));
    }
}
