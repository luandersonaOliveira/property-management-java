package Interface;
// Interface Repositório de Inquilinos

import java.util.ArrayList;

import Entity.Tenant;

public interface ITenantRepository {
    public abstract void addTenant(Tenant tenant);

    public abstract void removeTenant(int id);

    public abstract void changeTenant(int id);

    public ArrayList<Tenant> listTenant();

    public Tenant searchTenant(int id);
}
