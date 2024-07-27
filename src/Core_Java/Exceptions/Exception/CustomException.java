package Core_Java.Exceptions.Exception;

public class CustomException {
    public static void validToVote(int age) throws AgeNotMatchedException{
        if(age>=18){
            System.out.println("Age is valid");
        }
        else{
           throw new AgeNotMatchedException("Age is below 18 years") ;
        }
    }
    public static void main(String[] args) {
        int age = 19;
        try {
            validToVote(age);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
