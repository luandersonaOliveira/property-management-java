package Interface;
// Interface Repositório de Pagamento

import java.util.ArrayList;

import Entity.Payment;

public interface IPaymentRepository {
    public abstract void addPayment(Payment payment);

    public abstract void removePayment(int id);

    public abstract void changePayment(int id);

    public ArrayList<Payment> listPayment();

    public Payment searchPayment(int id);
}
