package Containers;
// Repositório da Locação (Contrato)

import java.util.ArrayList;

import Entity.Lease;
import Interface.ILeaseRepository;

public class LeaseRepository implements ILeaseRepository {
    public ArrayList<Lease> leases = new ArrayList<>();

    @Override
    public void addLease(Lease lease) {
        leases.add(lease);
    }

    @Override
    public void removeLease(int id) {
        leases.remove(id);
    }

    @Override
    public void changeLease(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changeLease'");
    }

    @Override
    public ArrayList<Lease> listLease() {
        return leases;
    }

    @Override
    public Lease searchLease(int id) {
        if (id >= 0 && id < leases.size()) {
            return leases.get(id);
        }
        return null;
    }
}
