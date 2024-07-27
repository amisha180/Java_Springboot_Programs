package Core_Java.Exceptions.Exception;

class PasswordDoesNotMatchException extends RuntimeException{
    public PasswordDoesNotMatchException(String message){
        super(message);
    }
}

class login{
   public void loginPage(String Password) throws PasswordDoesNotMatchException{
       if(Password!="A@1802"){
           throw new PasswordDoesNotMatchException("Password is not matching with the database");
       }
       else{
           System.out.println("Password is correct , logged in");
       }
   }
}
public class PasswordNotMatchException {
    public static void main(String[] args) {
        try {
            login login = new login();
            login.loginPage("hey");
        }
        catch(PasswordDoesNotMatchException e){
            System.out.println("exception is catched: "+e.getMessage());
        }
    }
}
