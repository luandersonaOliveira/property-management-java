// Interface Repositório de Contratos

public interface ITenantRepository {
    public void adicionarInquilinos(Tenant tenant);

    public void removerInquilinos(int id);
    
    public void listarInquilinos();

    public void alterarInquilinos();
}
