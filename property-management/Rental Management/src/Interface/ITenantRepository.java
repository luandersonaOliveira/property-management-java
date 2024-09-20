package Interface;
// Interface Repositório de Inquilinos

import Containers.PilhaRepository;
import Entity.Tenant;

public interface ITenantRepository {
    public void addTenant(Tenant tenant);

    public void removeTenant();

    public void changeTenant(int id);

    public PilhaRepository<Tenant> listTenant();

    public Tenant searchTenant(int id);
}
