package Exceptions;

public class PaymentException extends Exception{
    public PaymentException(String mensagem) {
        super(mensagem);
    }
}
