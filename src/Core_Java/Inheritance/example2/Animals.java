package Core_Java.Inheritance.example2;

public class Animals {
    int number;
    String breed;
    Animals(int no,String br){
        number = no;
        breed = br;
        System.out.println("Animal constructor called");
    }
    void run() {
        System.out.println("Animal is running");
    }
    void eat() {
        System.out.println("Animal is eating");
    }
    void display() {
        System.out.println("Animal display called");
        System.out.println(number+" "+breed);
    }
}
