package Core_Java.PractiseJava;

public class Car extends Vehicle{
    int wheels;
    public Car(String engine,int headlights,int wheels){
        super(engine,headlights);
        this.wheels = wheels;
    }
    public void run(){
        System.out.println("running- "+engine+", "+headlight+" headlights"+wheels+" wheels");
    }
}
