package Core_Java.Collections.Sort.Comparator;

import java.util.Comparator;

public class Sortbycomp implements Comparator<Banker> {
    @Override
    public int compare(Banker b1,Banker b2){
        int byage =  b1.age- b2.age;
        if(byage!=0){
            return byage;
        }
       return b1.name.compareTo(b2.name);
    }

}
