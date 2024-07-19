package Core_Java.Inheritance.example2;

public class Dogs extends Animals{
    String color;
    Dogs(int no,String br, String col){
        super(no, br);
        color = col;
    }
    void run() {
        System.out.println("Dog is running");
    }
    void eat() {
        System.out.println("Dog is eating");
    }
    void display() {
        System.out.println(number+" "+breed+" "+color);
    }
}
