package Core_Java.Inheritance.example1;

public class Dog extends Animal {
    int age;
    String color;
    String breed;
    String name;

    public Dog(int age,String color, String breed,String name){
        super(age,color,breed);
        this.name = name;
        System.out.println("Dog constructor");
    }
    @Override
    public void run(){
        System.out.println("Dog running");
    }
}
