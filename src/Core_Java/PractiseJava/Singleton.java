package Core_Java.PractiseJava;

import java.io.Serializable;
import java.util.Objects;

public class Singleton implements Cloneable, Serializable {
    private static Singleton instance=null;
    private Singleton(){
        if(instance!=null){
            throw new RuntimeException("cant create new instance");
        }
    }
    public static Singleton getInstance(){
        if(instance==null){
            synchronized (Singleton.class){
                if (instance==null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException{
        return instance;
    }

    protected Object readResolve(){
        return instance;
    }
}

class main{
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance1.hashCode());
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance2.hashCode());
    }
}
