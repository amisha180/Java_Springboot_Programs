package Core_Java.Java_8_features.FunctionalInterfaces;

import java.util.function.Predicate;

public class PredicateExp {
    public static void main(String[] args) {
        Predicate<String> isLongerThan5 = (s)->s.length()>5;
        System.out.println(isLongerThan5.test("life"));
        System.out.println(isLongerThan5.test("heaven"));
     }
}
