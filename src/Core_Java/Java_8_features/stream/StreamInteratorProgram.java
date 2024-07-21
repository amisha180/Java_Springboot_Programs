package Core_Java.Java_8_features.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamInteratorProgram {
        public static void main(String[] args) {
            Stream.iterate(3, n->n+2).limit(10).skip(3).forEach(System.out::println);
            IntStream.range(20,30).map(x->x*2).forEach(System.out::println);
           List<List<Integer>> nestedList = Arrays.asList(Arrays.asList(1,2,3),Arrays.asList(4,5),Arrays.asList(6,7,8,9));
            List<Integer> flatlist = nestedList.stream().flatMap(List::stream).collect(Collectors.toList());
            flatlist.stream().forEach(System.out::println);

        }
}
