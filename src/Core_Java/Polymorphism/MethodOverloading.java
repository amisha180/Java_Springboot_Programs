package Core_Java.Polymorphism;

public class MethodOverloading {
    public static int sum(int a,int b,int c) {
        return a+b+c;
    }
    public static double sum(int a , double b , int c) {
        return a+b+c;
    }
    public static void main(String[]args) {
        System.out.println(sum(1,2,3));
        System.out.println(sum(1,2.0,3));
    }
}
