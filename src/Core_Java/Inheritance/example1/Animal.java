package Core_Java.Inheritance.example1;

public class Animal {
    int age;
    String color;
    String breed;
    public Animal(int age,String color,String breed){
        this.age = age;
        this.color = color;
        this.breed = breed;
        System.out.println("Animal constructor");
    }
    public  void run(){
        System.out.println("Animal running");
    }
}
