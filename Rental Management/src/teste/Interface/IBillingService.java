// Interface Serviço de Cobrança

public interface IBillingService {
    public void gerarCobranca(Contract contrato);

    public void enviarCobranca(Contract contrato);
}
