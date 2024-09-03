package Services;
// Sreviço Contrato

import java.util.Date;
import java.util.Scanner;

import Containers.LeaseRepository;
import Entity.Landlord;
import Entity.Lease;
import Entity.Property;
import Entity.Tenant;
import Exceptions.LeaseException;

public class LeaseService {
    // ATRIBUTOS
    private static final Scanner scanner = new Scanner(System.in);
    private LeaseRepository leaseRepository = new LeaseRepository();

    // CONSTRUCTOR

    public LeaseService(LeaseRepository leaseRepository) {
        this.leaseRepository = leaseRepository;
    }

    // METODOS ESPECIAS

    // METODOS PERSONALIZADOS

    // CREATE
    public void addLease(Date starDate, Date endDate, double value, Landlord landlord, Property property, Tenant tenant)
            throws LeaseException {
        if (value < 0) {
            throw new LeaseException("Erro: Valor negativo!");
        } else if (starDate != null || endDate != null) {
            throw new LeaseException("Erro: Data de inicio ou fim estão vazio!");
        } else if (landlord != null || property != null || tenant != null) {
            throw new LeaseException("Erro: Proprietário, Imovel ou Inquilino estão vazios!");
        }

        Lease lease = createLease(starDate, endDate, value, landlord, property, tenant);
        if (lease != null) {
            leaseRepository.addLease(lease);
            System.out.println("\nContrato adicionado com sucesso!");
        } else {
            throw new LeaseException("Erro: ");
        }
    }

    public Lease createLease(Date starDate, Date endDate, double value, Landlord landlord, Property property,
            Tenant tenant) {
        return new Lease(starDate, endDate, value, landlord, property, tenant);
    }

    // REOMVE

    // LIST

    // CHANGE
}
