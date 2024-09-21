package Interface;
// Interface Repositório de Locação (Contratos)

import Containers.PilhaRepository;
import Entity.Lease;

public interface ILeaseRepository {
    public void addLease(Lease lease);

    public void removeLease();

    public void changeLease(int id);

    public PilhaRepository<Lease> listLease();

    public Lease searchLease(int id);
}
