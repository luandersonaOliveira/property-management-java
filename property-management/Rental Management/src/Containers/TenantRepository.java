package Containers;
// Repositório do Inquilino

import java.util.ArrayList;

import Entity.Tenant;
import Interface.ITenantRepository;

public class TenantRepository extends PilhaRepository<Tenant> implements ITenantRepository {
    //public ArrayList<Tenant> tenants = new ArrayList<>();

    public TenantRepository(ArrayList<Tenant> pilha) {
        super(pilha);
    }
    
    public PilhaRepository<Tenant> tenants = new PilhaRepository<>(new ArrayList<>());

    @Override
    public void addTenant(Tenant tenant) {
        tenants.push(tenant);
    }

    @Override
    public void removeTenant() {
        tenants.pop();
    }

    @Override
    public void changeTenant(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changeTenant'");
    }
    
    @Override
    public PilhaRepository<Tenant> listTenant() {
        return tenants;
    }

    @Override
    public Tenant searchTenant(int id) {
        if (id >= 0 && id < tenants.size()) {
            return tenants.get(id);
        }
        return null;
    }

}
