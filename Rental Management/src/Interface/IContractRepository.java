// Interface Repositório de Contratos

public interface IContractRepository {
    public void adicionarContratos(Contract contract);

    public void removerContratos(int id);
    
    public void listarContratos();

    public void alterarContratos();
}
