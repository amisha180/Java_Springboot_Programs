package Core_Java.Collections.Sort.Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompImplementation {
    public static void main(String[] args) {
            List<Employee> Emplist = new ArrayList<>();
        Emplist.add(new Employee (1,"mina",23));
        Emplist.add(new Employee (4,"sona",43));
        Emplist.add(new Employee (6,"tina",67));
        Emplist.add(new Employee (2,"ritu",98));
        Emplist.add(new Employee (8,"misa",87));

        //Collections.sort(Emplist);
        Emplist.stream().sorted().forEach(x-> System.out.println("id: "+x.id+" ,name: "+x.name+" ,age: "+x.age));
        System.out.println("===============================================");
        List<Student> Stdlist = new ArrayList<>();
        Stdlist.add(new Student (1,"mina",23));
        Stdlist.add(new Student (4,"sona",43));
        Stdlist.add(new Student (6,"tina",67));
        Stdlist.add(new Student (2,"ritu",98));
        Stdlist.add(new Student (8,"misa",87));
        //using comparator
        //Stdlist.stream().sorted((a,b)->a.age-b.age).forEach(x-> System.out.println(x.roll+", "+x.name+", "+x.age));
        Collections.sort(Stdlist, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.age-o2.age;
            }
        });
        Stdlist.stream().forEach(x-> System.out.println(x.roll+", "+x.name+", "+x.age));

        }
    }
