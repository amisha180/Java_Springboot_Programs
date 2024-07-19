package Core_Java.Inheritance.example1;

public class InheritanceExp {
    public static void main(String[] args) {
      Animal a = new Animal(2,"black","bull dog");
      a.run();
      System.out.println("=============================================");
      Dog d = new Dog(3,"blue","jack","Elsa");
      d.run();
      System.out.println("=============================================");
      Animal ad = new Dog(3,"red","him","tul"); //upcasting
      ad.run();
      System.out.println("=============================================");
      //Dog da = new Animal(2,"ghj","dsklf"); //downcasting throwing error
        //To resolve downcasting
        System.out.println("=============================================");
        Animal ak = new Dog(5,"dsfg","sdfg","sdfs");
        Dog ds = (Dog) ak;
        ds.run();
    }
}
