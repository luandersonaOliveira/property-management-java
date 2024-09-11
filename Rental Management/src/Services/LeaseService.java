package Services;
// Sreviço Contrato

import java.text.ParseException;
import java.util.Scanner;

import Containers.LandlordRepository;
import Containers.LeaseRepository;
import Containers.PropertyRepository;
import Containers.TenantRepository;
import Entity.Landlord;
import Entity.Lease;
import Entity.Property;
import Entity.Tenant;
import Enum.EnumLeaseException;
import Enum.EnumPropertyException;
import Enum.EnumTenantException;
import Enum.PropertyOccupation;
import Exceptions.LeaseException;
import Exceptions.PropertyException;
import Utils.DatetimeExtensions;

public class LeaseService {
    // ATRIBUTOS
    private static final Scanner scanner = new Scanner(System.in);
    private LeaseRepository leaseRepository = new LeaseRepository();
    private static LandlordRepository landlordRepository = new LandlordRepository();
    private static PropertyRepository propertyRepository = new PropertyRepository();
    private static TenantRepository tenantRepository = new TenantRepository();

    // CONSTRUCTOR

    public LeaseService(LeaseRepository leaseRepository) {
        this.leaseRepository = leaseRepository;
    }

    // METODOS ESPECIAS

    // METODOS PERSONALIZADOS

    // CREATE
    public void addLease(String startDate, String endDate, double value, Landlord landlord, Property property,
            Tenant tenant)
            throws LeaseException, ParseException {
        if (value < 0) {
            throw new LeaseException("Erro: " + EnumLeaseException.LeaseInvalidValue);
        } else if (startDate != null || endDate != null) {
            throw new LeaseException("Erro: " + EnumLeaseException.LeaseInvalidStartOrEndDate);
        } else if (landlord != null || property != null || tenant != null) {
            throw new LeaseException("Erro: " + EnumLeaseException.LeaseInvalidRegistered);
        }

        Lease lease = createLease(startDate, endDate, value, landlord, property, tenant);
        if (lease != null) {
            leaseRepository.addLease(lease);
            System.out.println("\nContrato adicionado com sucesso!");
        } else {
            throw new LeaseException("Erro: " + EnumLeaseException.LeaseInvalid);
        }
    }

    public Lease createLease(String startDate, String endDate, double value, Landlord landlord, Property property,
            Tenant tenant) throws ParseException, LeaseException {
        if (landlord.getCpf().equals(tenant.getCpf())) {
            throw new LeaseException("Erro: " + EnumLeaseException.LeaseInvalidCpfEqual);
        } else if (tenant.getBalance() < value) {
            throw new LeaseException("Erro: " + EnumTenantException.TenantInvalidBalance);
        } else if (property.getOccupation() == PropertyOccupation.OCCUPIED) {
            throw new LeaseException("Erro: " + EnumPropertyException.PropertyInvalidOccupation);
        } else if (!toCheckId()) {
            throw new LeaseException("Erro: " + EnumLeaseException.LeaseNoRegistered);
        }
        return new Lease(dateTimeExtensions(startDate), dateTimeExtensions(endDate), value, landlord, property, tenant);
    }

    private String dateTimeExtensions(String date) throws ParseException {
        DatetimeExtensions.toDate(date);
        return date;
    }

    public boolean toCheckId() {
        System.out.print("\nAtribuir Inquilino ao Imovel");
        System.out.print("\nInsira o índice do Inquilino: ");
        int tenant = scanner.nextInt();
        System.out.print("\nInsira o índice do Imovel: ");
        int property = scanner.nextInt();
        Property properties = propertyRepository.searchProperty(property);
        Tenant tenants = tenantRepository.searchTenant(tenant);
        if (properties.getId() != property || tenants.getId() != tenant) {
            return false;
        }
        return true;
    }

    public void assignTenantToProperty(int propertyId, Tenant tenant) throws PropertyException {
        Property property = propertyRepository.searchProperty(propertyId);

        if (property == null) {
            throw new PropertyException("Erro: " + EnumPropertyException.PropertyNoRegistered);
        } else if (tenant == null) {
            throw new PropertyException("Erro: " + EnumTenantException.TenantNoRegistered);
        }

        if (property.getTenant() != null) {
            throw new PropertyException("Erro: O imóvel já tem um inquilino associado");
        }

        property.setTenant(tenant);
        tenant.setProperty(property);

        System.out.println(
                "Inquilino: " + tenant.getName() + " adicionado ao Imovel " + property.getId() + " com sucesso!");
    }
    

    // REOMVE

    // LIST

    // CHANGE

}
