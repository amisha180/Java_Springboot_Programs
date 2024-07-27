package Core_Java.Exceptions.Error;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemory {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        while(true){
            list.add(1);  // Keep adding elements to the list to exhaust heap space
            System.out.println(1);
        }
    }
}
