package Core_Java.Collections.Sort.Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CallingClass {
    public static void main(String[] args) {
        List<Banker> list3 = new ArrayList<>();
        list3.add(new Banker (1,"mina",23));
        list3.add(new Banker (4,"sona",43));
        list3.add(new Banker (6,"tina",67));
        list3.add(new Banker (2,"ritu",98));
        list3.add(new Banker (8,"misa",43));

        Collections.sort(list3,new Sortbycomp());
        list3.stream().forEach(x-> System.out.println("id: "+x.id+" ,name: "+x.name+" ,age: "+x.age));

        System.out.println("============================================================================");
        List<Dancer> list4 = new ArrayList<>();
        list4.add(new Dancer (1,"mina",23));
        list4.add(new Dancer (4,"sona",43));
        list4.add(new Dancer (6,"tina",67));
        list4.add(new Dancer (2,"ritu",98));
        list4.add(new Dancer (8,"misa",43));
        Collections.sort(list4, new Comparator<Dancer>() {
            @Override
            public int compare(Dancer o1, Dancer o2) {
                return o1.age - o2.age;
            }
        });
        list4.stream().forEach(x-> System.out.println("id: "+x.id+" ,name: "+x.name+" ,age: "+x.age));
    }
}
