package Core_Java.Inheritance.example2;

public class Implementation {
    public static void main(String[] args) {
        //	Animal a = new Animal(1,"pom");
//	Cat c = new Cat(3,"lor");
//	Dog d = new Dog();
//	Cat c2 = new Animal(); ////Down casting
//	Dog d2 = new Animal(); //Down casting
//	Animal ad = new Dog(); //Up casting

        Animals a = new Dogs(1,"pomo","black"); //upcasting
        if(a instanceof Dogs) {
            Dogs d = (Dogs) a;                  //Downcasting
            System.out.println("Downcasting");
        }
    }
}
