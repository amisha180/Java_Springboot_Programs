package Core_Java.Exceptions.Exception;

public class ExceptionExp {
    public static int divide(int a ,int b) throws ArithmeticException{
        if(b==0){
            throw new ArithmeticException("can not divide by zero , please change your input");
        }
        return a/b;
    }
    public static void main(String[] args) {
        try{
            int result = divide(10,0);
            System.out.println(result);
        }
        catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }
    }
}
