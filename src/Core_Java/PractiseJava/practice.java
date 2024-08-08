package Core_Java.PractiseJava;


import java.util.Arrays;
import java.util.List;

public class practice{
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,2,4,6);
        System.out.println(list.stream().mapToInt(Integer::intValue).sum());
    }
}
