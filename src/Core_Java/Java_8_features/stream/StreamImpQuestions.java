package Core_Java.Java_8_features.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamImpQuestions {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve","Amisha");
        List<String> filteredNames = names.stream().filter(n->n.startsWith("A")).collect(Collectors.toList());
        filteredNames.stream().forEach(n-> System.out.println(n));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream().reduce(0,(sums,price)->sums+price);
        System.out.println(sum);
        int product = numbers.stream().reduce(1,(sums,price)->sums*price);;
        System.out.println(product);

        List<Integer> num = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> distinctNumbers = num.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctNumbers); // Output: [1, 2, 3, 4, 5]

       // Q. How do you sort a list of strings by their length using streams?
        List<String> name = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");
        List<String> sortedNames = name.stream().sorted((a,b)->a.length()-b.length()).collect(Collectors.toList());
        System.out.println(sortedNames); // Output: [Bob, Eve, Alice, David, Charlie]

       // Q. How do you flatMap a list of lists using streams?
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("a", "b", "c"),
                Arrays.asList("d", "e", "f"),
                Arrays.asList("g", "h", "i"));
        List<String> flatList = listOfLists.stream().flatMap(List::stream).collect(Collectors.toList());
        flatList.stream().forEach(n-> System.out.println(n));

       // Q. How do you count the number of occurrences of each character in a string using streams?
        String strs = "hello world";
        Map<Character, Long> map = strs.chars().mapToObj(c->(char) c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(map);

       // Q.How do you partition a list of numbers into even and odd using streams?
        List<Integer> listi =Arrays.asList(2,5,3,6,54,7,87,32,97,94);
        Map<Boolean, List<Integer>> partitioned = listi.stream().collect(Collectors.partitioningBy(n->n%2==0));
        System.out.println("Even numbers: " + partitioned.get(true));
        System.out.println("Odd numbers: " + partitioned.get(false));

       // Q. How do you find the second highest number in a list using streams?
        List<Integer> number = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5);
        Optional<Integer> secondHighest = number.stream().sorted((a,b)->b-a).skip(1).findFirst();
        System.out.println(secondHighest.get());





    }
}
