package ar.unrn.tp.exception;

public class NotNullException extends Exception{

    public NotNullException(String message){
        super("El campo "+message+" es null");
    }
}
