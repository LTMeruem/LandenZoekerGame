package exceptions;

public class InvalidRowException extends Exception {

    public InvalidRowException(){
        // empty ctor
    }

    public InvalidRowException(String message){
        super(message);
    }
}
