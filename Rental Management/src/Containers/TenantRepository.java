// Repositório de Contratos

import java.util.ArrayList;

public class TenantRepository {
    private ArrayList<Tenant> tenants = new ArrayList<>();

    public void adicionarInquilino(Tenant inquilino) {
        tenants.add(inquilino);
    }

    public void removerInquilino(int id) {
        tenants.remove(id);
    }

    public Contract buscarInquilino(int id) {
        if (id >= 0 && id < tenants.size()) {
            tenants.get(id);
        }
        return null;
    }

    public void listarInquilino() {
        for (int i = 0; i < tenants.size(); i++) {
            tenants.get(i).statusInfo(i);
        }
    }

    public void alterarContrato() {
        throw new UnsupportedOperationException("Unimplemented method 'alterarContrato'");
    }
}
