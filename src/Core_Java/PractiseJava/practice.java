package Core_Java.PractiseJava;




import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class practice {
    public static void main(String[] args) {

       // IntStream.rangeClosed(2,4).forEach((x)-> System.out.println(x));
        Stream.iterate(1,n->n*2).limit(5).forEach((x)-> System.out.println(x));
        List<List<Integer>> nestedList = Arrays.asList(Arrays.asList(1,2,3),Arrays.asList(4,5),Arrays.asList(6,7,8,9));
        List<Integer> flost = nestedList.stream().flatMap(List::stream).collect(Collectors.toList());
        flost.stream().forEach((x)-> System.out.println(x));

    }
}
