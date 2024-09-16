package Containers;
// Repositório do Inquilino

import java.util.ArrayList;

import Entity.Tenant;
import Interface.ITenantRepository;

public class TenantRepository implements ITenantRepository {
    public ArrayList<Tenant> tenants = new ArrayList<>();
    private static int nextLeaseId = 0;

    private int getNextLeaseId() {
        return nextLeaseId++;
    }

    @Override
    public void addTenant(Tenant tenant) {
        tenants.add(tenant);
        tenant.setId(getNextLeaseId());
    }

    @Override
    public void removeTenant(int id) {
        tenants.remove(id);
    }

    @Override
    public void changeTenant(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changeTenant'");
    }

    @Override
    public ArrayList<Tenant> listTenant() {
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
