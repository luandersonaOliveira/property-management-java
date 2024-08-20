// Interface Repositório de Contratos

public interface IContractRepository {
    public void adicionarContrato(Contract contrato);

    public void removerContrato(int id);

    public Contract buscarContrato(int id);
}
