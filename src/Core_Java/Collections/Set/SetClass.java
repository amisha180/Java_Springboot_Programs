package Core_Java.Collections.Set;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetClass {
    public static void main(String[] args) {
        System.out.println("HashSet");
        HashSet<Integer> hashset = new HashSet<>();
        hashset.add(3);
        hashset.add(6);
        hashset.add(1);
        hashset.add(9);
        hashset.add(2);
       for(int x : hashset){
           System.out.println(x);
       }
        System.out.println("===========================================");
        System.out.println("LinkedHashSet");
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(3);
        linkedHashSet.add(6);
        linkedHashSet.add(1);
        linkedHashSet.add(9);
        linkedHashSet.add(2);
        for(int x : linkedHashSet){
            System.out.println(x);
        }
        System.out.println("===========================================");
        System.out.println("TreeSet");
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(3);
        treeSet.add(6);
        treeSet.add(1);
        treeSet.add(9);
        treeSet.add(2);
        for(int x : treeSet){
            System.out.println(x);
        }
    }
}
