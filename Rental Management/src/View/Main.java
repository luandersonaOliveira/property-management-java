package View;
// MAIN

import java.util.Scanner;

import Containers.LandlordRepository;
import Containers.PropertyRepository;
import Containers.TenantRepository;
import Entity.Property;
import Enum.PropertyOccupation;
import Enum.PropertyType;
import Exceptions.LandlordException;
import Exceptions.PropertyException;
import Exceptions.TenantException;
import Services.LandlordService;
import Services.PropertyService;
import Services.TenantService;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static PropertyRepository propertyRepository = new PropertyRepository();
    private static TenantRepository tenantRepository = new TenantRepository();
    private static LandlordRepository landlordRepository = new LandlordRepository();
    private static PropertyService propertyService = new PropertyService(propertyRepository);
    private static TenantService tenantService = new TenantService(tenantRepository);
    private static LandlordService landlordService = new LandlordService(landlordRepository);

    // CONTAINERS

    public static void main(String[] args)
            throws TenantException, PropertyException, LandlordException {
        // OPÇÕES DO MENU
        boolean sair = false;
        do {
            menuPrincipal();
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    createTenants();
                    break;
                case 2:
                    tenantService.listTenant();
                    break;
                case 3:
                    changeTenants();
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:
                    createLandlord();
                    break;
                case 8:
                    landlordService.listLandlord();
                    break;
                case 9:
                    changeLandlord();
                    break;
                case 10:
                    createLease();
                    break;
                case 11:
                    searchTenant();
                    break;
                case 12:
                    break;
                case 0:
                    sair = true;
            }
        } while (!sair);
    }

    // METODOS PERSONALIZADOS

    // MENU
    public static void menuPrincipal() {
        System.out.println("\n--------------------------------");
        System.out.println("SELECIONE SUA OPÇÃO:");
        System.out.print("| 1. Para Cadastrar Inquilinos |");
        System.out.print(" 2. Para Checar Inquilinos |");
        System.out.println(" 3. Para Editar Inquilinos |");
        System.out.print("\n| 4. Para Cadastrar Imoveis |");
        System.out.print(" 5. Para Checar Imoveis |");
        System.out.println(" 6. Para Editar Imoveis |");
        System.out.print("\n| 7. Para Cadastrar Proprietários |");
        System.out.print(" 8. Para Checar Proprietários |");
        System.out.println(" 9. Para Editar Proprietários |");
        System.out.print("\n| 10. |");
        System.out.print(" 11. |");
        System.out.print(" 12. Para Remover Algo |");
        System.out.print("\n--------------------------------");
        System.out.print("\n| 0. Para Sair do Menu.");
        System.out.println("\n--------------------------------");
        System.out.print("Opção: ");
    }

    // CRIAR INQUILINOS
    private static void createTenants() throws TenantException {
        try {
            System.out.print("\nNome: ");
            String name = scanner.nextLine();
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            System.out.print("Telefone: ");
            String telephone = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Saldo: ");
            double balance = scanner.nextDouble();
            tenantService.addTenant(name, cpf, telephone, email, balance);
        } catch (TenantException e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    // EDITAR INQUILINOS
    private static void changeTenants() throws TenantException {
        System.out.print("\nInsira o índice do Inquilino à editar: ");
        int id = scanner.nextInt();
        tenantService.changeTenant(id);
    }

    // REMOVER INQUILINOS
    private static void removeTenants() throws TenantException {
        System.out.print("\nInsira o índice do Inquilino para remover: ");
        int id = scanner.nextInt();
        tenantService.removeTenant(id);
    }

    // CRIAR IMOVEIS
    private static void createProperty() {
        try {
            System.out.print("\nEndereço: ");
            String anddress = scanner.nextLine();
            scanner.nextLine();
            System.out.print("Valor do Aluguel: ");
            double rentalValue = scanner.nextDouble();
            System.out.print("Tipo: \n1.Residencial | 2.Comercial |");
            System.out.print("\nOpção: ");
            int type = scanner.nextInt();
            System.out.print("Ocupação: \n1.Desocupado | 2.Ocupado |");
            System.out.print("\nOpção: ");
            int occupation = scanner.nextInt();

            PropertyType propertyType = null;
            switch (type) {
                case 1:
                    propertyType = PropertyType.RESIDENTIAL;
                    break;
                case 2:
                    propertyType = PropertyType.COMMERCIAL;
                    break;
                default:
                    throw new PropertyException("Type Property Invalid!");
            }

            PropertyOccupation propertyOccupation = null;
            switch (occupation) {
                case 1:
                    propertyOccupation = PropertyOccupation.UNOCCUPIED;
                    break;
                case 2:
                    propertyOccupation = PropertyOccupation.OCCUPIED;
                    break;
                default:
                    throw new PropertyException("Occupation Property Invalid!");
            }

            propertyService.addProperty(anddress, rentalValue, propertyType, propertyOccupation);
        } catch (PropertyException e) {
            System.out.println("\n" + e.getMessage());
        }

    }

    // EDITAR IMOVEIS
    private static void changeProperty() throws PropertyException {
        System.out.print("\nInsira o índice do Imovel à editar: ");
        int id = scanner.nextInt();
        propertyService.changeProperty(id);
    }

    // REMOVE IMOVEIS
    private static void removeProperty() throws PropertyException {
        System.out.print("\nInsira o índice do Imovel para remover: ");
        int id = scanner.nextInt();
        propertyService.removeProperty(id);
    }

    // CRIAR PROPRIETARIO
    private static void createLandlord() throws LandlordException {
        try {
            System.out.print("\nNome: ");
            String name = scanner.nextLine();
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            System.out.print("Telefone: ");
            String telephone = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            landlordService.addLandlord(name, cpf, telephone, email);

            System.out.println("\nDeseja Criar um imovel? \n1.Sim | 2.Não |");
            System.out.print("Opção: ");
            int option = scanner.nextInt();

            if (option == 1) {
                createProperty();
                System.out.print("\nAtribuir Imovel ao Proprietário");
                System.out.print("\nInsira o índice do Proprietário: ");
                int idLandlord = scanner.nextInt();
                System.out.print("\nInsira o índice do Imovel: ");
                int idProperty = scanner.nextInt();
                Property property = propertyRepository.properties.get(idProperty);
                landlordService.assignPropertyToLandlord(idLandlord, property);
            }

        } catch (LandlordException e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    // EDITAR PROPRIETARIO
    private static void changeLandlord() throws LandlordException {
        System.out.print("\nInsira o índice do Proprietário à editar: ");
        int id = scanner.nextInt();
        landlordService.changeLandlord(id);
    }

    // REMOVE INQUILINO DO IMOVEL
    private static void removeTenantsProperty() throws LandlordException {
        System.out.print("\nInsira o índice do Proprietário à editar: ");
        int id = scanner.nextInt();
        landlordService.removeLandlord(id);
    }

    // CADASTRA INQUILINO NO IMOVEL (Criar o contrato)
    private static void createLease() {
        System.out.print("\nInsira o índice do Inquilino: ");
        int idTenant = scanner.nextInt();
        System.out.print("\nInsira o índice do Imovel: ");
        int idProperty = scanner.nextInt();
        System.out.print("\nInforme a Data de Inicio: ");
        String startDate = scanner.nextLine();
        System.out.print("\nInforme a Data de Fim: ");
        String endDate = scanner.nextLine();
        System.out.print("\nInforme o valor: ");
        double value = scanner.nextDouble();

    }

    // LISTA CONTRATOS
    private static void listLease() {

    }

    // DELETAR CONTRATOS
    private static void deleteLease() {

    }

    private static void searchTenant() throws TenantException {
        System.out.print("\nInsira o índice do Inquilino: ");
        int idTenant = scanner.nextInt();
        tenantService.searchTenant(idTenant);
    }

    private static void searchProperty() throws PropertyException {
        System.out.print("\nInsira o índice do Imovel: ");
        int idProperty = scanner.nextInt();
        propertyService.searchProperty(idProperty);
    }

    private static void searchLandlord() {
        System.out.print("\nInsira o índice do Proprietario: ");
        int idLandlord = scanner.nextInt();
        landlordService.searchLandlord(idLandlord);
    }
}