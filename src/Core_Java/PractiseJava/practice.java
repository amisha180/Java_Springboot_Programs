package Core_Java.PractiseJava;

public class practice {

    public static void main(String[] args) {
//        Vehicle v = new Vehicle("volvo",3);
//        v.startEngine();

//        Car c = new Car("maruti",2,4);
//        c.startEngine();
//        c.run();

        Vehicle v1 = new Car("alto",3,4);
        System.out.println(v1.engine);

        if(v1 instanceof Car){
            Car c2 = (Car) v1;
            c2.run();
        }

    }
}
