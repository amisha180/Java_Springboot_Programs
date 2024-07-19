package Core_Java.Inheritance.example2;

public class Cats extends Animals{
    Cats(int no, String br) {
        super(no, br);
        System.out.println("Cat constructor called");
    }

    void eat() {
        System.out.println("Cat is eating");
    }
    void display() {
        System.out.println("cat display called");
        System.out.println(number+" "+breed);
    }
}
