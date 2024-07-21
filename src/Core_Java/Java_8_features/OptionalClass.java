package Core_Java.Java_8_features;

import java.util.Optional;

public class OptionalClass {
    public static void main(String[] args) {
        String str = null;
        Optional<String> opelement = Optional.ofNullable(str);
        if(opelement.isPresent()){
            System.out.println("its there");
        }
        else{
            System.out.println("not there");
        }
    }
}
