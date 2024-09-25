package Core_Java.String;

import java.util.ArrayList;
import java.util.List;

public class FinalEx {
    public static void main(String[] args) {
       final List<Integer> list = new ArrayList<>();
       list.add(5);
       list.add(8);
       list.add(10);
       list.set(0,34);
       for(int e:list){
           System.out.println(e);
       }

    }
}
