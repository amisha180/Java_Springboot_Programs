package Core_Java.String;

import java.util.ArrayList;

public class MainImmutable {
    public static void main(String[] args) {
        ImmutableClass imm = new ImmutableClass(5,new ArrayList<>());
        System.out.println(imm.getValue());
        imm = new ImmutableClass(7,new ArrayList<>());
        imm.getValue();




    }
}
