package Core_Java.Java_8_features.FunctionalInterfaces;
interface Draw{
    void drawdiagram(int x);
}
public class functionalInterfaceExp {
    public static void main(String[] args) {
        Draw d = (x)->{
            System.out.println("drawing diagram = "+x);
        };
        d.drawdiagram(5);
    }
}
