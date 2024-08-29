package Interface;
// Interface Repositório de Locação (Contratos)

import java.util.ArrayList;

import Entity.Lease;

public interface ILeaseRepository {
    public abstract void addLease(Lease lease);

    public abstract void removeLease(int id);

    public abstract void changeLease(int id);

    public ArrayList<Lease> listLease();

    public Lease searchLease(int id);
}
