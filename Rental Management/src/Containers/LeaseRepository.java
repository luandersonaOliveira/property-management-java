package Containers;
// Repositório da Locação (Contrato)

import java.util.ArrayList;

import Entity.Lease;
import Interface.ILeaseRepository;

public class LeaseRepository extends PilhaRepository<Lease> implements ILeaseRepository {
    //public ArrayList<Lease> leases = new ArrayList<>();
    public PilhaRepository<Lease> leases = new PilhaRepository<>(new ArrayList<>());

    public LeaseRepository(ArrayList<Lease> pilha) {
        super(pilha);
    }

    @Override
    public void addLease(Lease lease) {
        leases.push(lease);
    }

    @Override
    public void removeLease() {
        leases.pop();
    }

    @Override
    public void changeLease(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changeLease'");
    }

    @Override
    public PilhaRepository<Lease> listLease() {
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
