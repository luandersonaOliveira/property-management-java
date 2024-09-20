package Interface;
// Interface Repositório de Locação (Contratos)

import java.util.ArrayList;

import Entity.Lease;

public interface ILeaseRepository {
    public void addLease(Lease lease);

    public void removeLease(int id);

    public void changeLease(int id);

    public ArrayList<Lease> listLease();

    public Lease searchLease(int id);
}
