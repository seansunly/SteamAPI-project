package exception;

public class UserNotFoundException extends Exception{
   // public UserNotFoundException(){super();}
    public UserNotFoundException(String message){super(message);}

    public UserNotFoundException(String s, UserNotFoundException e) {
    }
}
