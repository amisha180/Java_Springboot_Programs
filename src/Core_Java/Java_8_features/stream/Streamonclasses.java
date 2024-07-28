package Core_Java.Java_8_features.stream;

import Core_Java.Collections.Sort.Comparable.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Streamonclasses {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(23,"John", 50000),
                new Employee(56,"Jane", 60000),
                new Employee(56,"Jane", 60000),
                new Employee(12,"Jack", 55000) );

        //Q. How do you find the highest salaried employee from a list using streams?
        Employee higheshtsalemp = employees.stream().max((p1,p2)->p1.getAge()>p2.getAge()?1:-1).get();
        System.out.println(higheshtsalemp.getName());

      // Q. How do you remove duplicates from a list using streams?
        String str = "swiss";
        Character result = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println("First non-repeated character: " + result);

      // Q. How do you convert a Map<K, V> to a List<String> where each element is in the format "key=value"?
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        List<String> list = map.entrySet().stream().map(x->x.getKey()).collect(Collectors.toList());
        list.stream().forEach(n-> System.out.println(n));

       // Q.How do you find the longest string in a list using streams?
        List<String> strings = Arrays.asList("short", "medium", "longest", "longer");
        String longest = strings.stream().max((a,b)->a.length()>b.length()?1:-1).get();
        System.out.println(longest);

      //  Q. How do you perform a "group by" operation on a list of objects and calculate the sum of a specific field?
        List<Employee> items = Arrays.asList(
                new Employee(2,"Apple", 10),
                new Employee(4,"Banana", 20),
                new Employee(7,"Apple", 30),
                new Employee(3,"Banana", 40)
        );
        Map<Employee,Long> maps = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        maps.entrySet().stream().forEach(x-> System.out.println(x.getKey()+" "+x.getValue()));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        double average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println("Average: " + average); // Output: Average: 3.0

        List<String> item = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        Map<Integer, List<String>> groupedByLength = item.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(groupedByLength);

        List<String> itemse = Arrays.asList("apple", "banana", "cherry", "banana","apricot", "blueberry","blueberry");
       Map<String,Long> groupedByFirstCharacter =  itemse.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()));
        System.out.println(groupedByFirstCharacter);

        List<Employee> employee = Arrays.asList(
                new Employee(34, "HR", 50000),
                new Employee(54, "IT", 60000),
                new Employee(23, "HR", 70000),
                new Employee(65, "IT", 80000)
        );
        Map<String, Double> averageSalaryByDepartment = employee.stream().collect(Collectors.groupingBy(Employee::getName,Collectors.averagingDouble(Employee::getAge)));
        averageSalaryByDepartment.entrySet().stream().forEach(n-> System.out.println(n.getKey()+" "+n.getValue()));






    }
}
