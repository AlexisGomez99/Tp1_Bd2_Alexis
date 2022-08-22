package ar.unrn.tp.exception;

public class EmailException extends Exception{
    public EmailException(){
        super("Ingrese un email valido.");
    }
}
