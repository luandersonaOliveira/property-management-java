// REPOSITÓRIO INQUILINOS

import java.util.ArrayList;

public class TenantRepository implements ITenantRepository {
    private ArrayList<Tenant> tenants = new ArrayList<Tenant>();

    @Override
    public void adicionarInquilinos(Tenant tenant) {
        tenants.add(tenant);
    }

    @Override
    public void removerInquilinos(int id) {
        tenants.remove(id);
    }

    @Override
    public void listarInquilinos() {
        for (int i = 0; i < tenants.size(); i++) {
            tenants.get(i).tenantInfo(i);
        }
    }

    @Override
    public void alterarInquilinos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alterarInquilinos'");
    }
}
