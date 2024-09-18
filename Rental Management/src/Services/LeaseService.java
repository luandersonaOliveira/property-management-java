package Services;
// Sreviço Contrato

import java.text.ParseException;
import java.util.ArrayList;
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
import Enum.PropertyOccupation;
import Exceptions.LeaseException;
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
    public void addLease(String startDate, String endDate, Landlord landlord, Property property,
            Tenant tenant) throws LeaseException, ParseException {
        if (landlord == null || property == null || tenant == null) {
            throw new LeaseException("Erro: " + EnumLeaseException.LeaseInvalidRegistered);
        } else if (property.getLandlord().equals(null)) {
            throw new LeaseException("Erro: O imóvel está sem proprietário associado!");
        } else if (startDate.equals(null) || endDate.equals(null)) {
            throw new LeaseException("Erro: " + EnumLeaseException.LeaseInvalidStartOrEndDate);
        }

        Lease lease = createLease(startDate, endDate, landlord, property, tenant);
        if (lease != null) {
            leaseRepository.addLease(lease);
            System.out.println("\nContrato adicionado com sucesso!");
        } else {
            System.out.println("Erro: " + EnumLeaseException.LeaseInvalid);
        }
    }

    public Lease createLease(String startDate, String endDate, Landlord landlord, Property property,
            Tenant tenant) throws ParseException {
        if (landlord.getCpf().equals(tenant.getCpf())) {
            System.out.println("Erro: " + EnumLeaseException.LeaseInvalidCpfEqual);
        } else if (property.getOccupation().equals(PropertyOccupation.OCCUPIED)) {
            System.out.println("Erro: " + EnumPropertyException.PropertyInvalidOccupation);
        }
        assignTenantToProperty(property, tenant);
        //assignPropertyToLandlord(landlord, property);
        return new Lease(dateTimeExtensions(startDate), dateTimeExtensions(endDate), landlord, property, tenant);
    }

    private String dateTimeExtensions(String date) throws ParseException {
        DatetimeExtensions.toDate(date);
        return date;
    }

    // ATRIBUIR INQUILINO AO IMOVEL
    public void assignTenantToProperty(Property property, Tenant tenant) {
        propertyRepository.searchProperty(property.getId());
        tenantRepository.searchTenant(tenant.getId());
        ArrayList<Tenant> tenants = new ArrayList<>();

        if (property.getTenant() != null) {
            System.out.println(("Erro: O imóvel já tem um inquilino associado"));
        }

        tenants.add(tenant);
        property.setTenant(tenants);
        tenant.setProperty(property);

        System.out.println(
                "Inquilino: " + tenant.getName() + " - cadastrado ao Imovel: " + property.getId());
    }

    // ATRIBUIR IMOVEL AO PROPRIETÁRIO
    public void assignPropertyToLandlord(Landlord landlord, Property property) {
        landlordRepository.searchLandlord(landlord.getId());
        propertyRepository.searchProperty(property.getId());
        ArrayList<Property> properties = new ArrayList<>();

        if (property.getLandlord() != null) {
            System.out.println(("Erro: O imóvel já tem um proprietário associado!"));
        }

        properties.add(property);
        landlord.setProperty(properties);
        property.setLandlord(landlord);

        System.out.println("\nImóvel: " + property.getId() + " - cadastrado ao proprietário: " + landlord.getName());
    }

    // REOMVE

    // LIST
    public void listLease() {
        ArrayList<Lease> leases = leaseRepository.listLease();
        if (leases.isEmpty()) {
            System.out.println(("Erro: " + EnumPropertyException.PropertyNoRegistered));
        } else {
            for (int i = 0; i < leases.size(); i++) {
                Lease l = leases.get(i);
                l.setId(i);
                System.out.println("\n-------------------------------------------------------------------------------");
                System.out.print("Contrato: " + l.getId() + "\n");
                System.out.print(
                        " | Proprietário: " + l.getLandlord().getId() + " - " + l.getLandlord().getName() + "\n");
                System.out.print(" | Imovel: " + l.getProperty().getId() + " - " + l.getProperty().getaddress() + "\n");
                System.out.print(" | Inquilino: " + l.getTenant().getId() + " - " + l.getTenant().getName() + "\n");
                System.out.print(" | Data de Inicio: " + l.getstartDate());
                System.out.print(" | Data de Fim: " + l.getEndDate());
                System.out.print(" | Valor: " + l.getProperty().getRentalValue() + " |");
                System.out.println("\n-------------------------------------------------------------------------------");
            }
        }
    }
    // CHANGE

    /*
     * // LISTA DE IMOVEIS
     * public void listProperties() {
     * Property property01 =
     * createProperty("Rua Gonçalo de Carvalho – Porto Alegre (RS)", 500,
     * PropertyType.RESIDENTIAL, PropertyOccupation.UNOCCUPIED);
     * Property property02 = createProperty("Rua do Mucugê – Arraial d’Ajuda (BA)",
     * 800, PropertyType.COMMERCIAL,
     * PropertyOccupation.UNOCCUPIED);
     * Property property03 = createProperty("Rua das Pedras – Búzios (RJ)", 480,
     * PropertyType.RESIDENTIAL,
     * PropertyOccupation.UNOCCUPIED);
     * Property property04 = createProperty("Rua da Aurora – Recife (PE)", 780,
     * PropertyType.COMMERCIAL,
     * PropertyOccupation.UNOCCUPIED);
     * Property property05 = createProperty("Rua Bento Gonçalves – Erechim (RS)",
     * 550, PropertyType.RESIDENTIAL,
     * PropertyOccupation.UNOCCUPIED);
     * }
     */
}
