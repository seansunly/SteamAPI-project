package exception;

public class EmailValidatorException extends Exception{
    public EmailValidatorException(){
        super();
    }
    public EmailValidatorException(String message){
        super(message);
    }
}
