package Core_Java.PractiseJava;

public class Vehicle {
    String engine;
    int headlight;
    public Vehicle(String engine,int headlight){
        this.engine = engine;
        this.headlight = headlight;
    }
    public void startEngine(){
        System.out.println("started engine- "+ engine+" with headlights- "+headlight);
    }

}
