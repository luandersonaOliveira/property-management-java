package View;
// MAIN

import java.util.Scanner;

import Containers.PropertyRepository;
import Entity.Property;
import Enum.PropertyOccupation;
import Enum.PropertyType;
import Exceptions.PropertyInvalidOccupationException;
import Exceptions.PropertyInvalidTypeException;
import Services.PropertyService;

public class Main {
    private static PropertyRepository propertyRepository = new PropertyRepository();
    private static PropertyService propertyService = new PropertyService(propertyRepository);
    private static final Scanner scanner = new Scanner(System.in);

    // CONTAINERS

    public static void main(String[] args) throws PropertyInvalidTypeException, PropertyInvalidOccupationException {
        // OPÇÕES DO MENU
        boolean sair = false;
        do {
            menuPrincipal();
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    createProperty();
                    break;
                case 5:
                    propertyService.listProperty();
                    break;
                case 6:
                    changeProperty();
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    removeProperty();
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
        System.out.print(" 12. Para Remover Imoveis |");
        System.out.print("\n--------------------------------");
        System.out.print("\n| 0. Para Sair do Menu.");
        System.out.println("\n--------------------------------");
        System.out.print("Opção: ");
    }

    // CRIAR INQUILINOS
    private static void createTenants() {

    }

    // LISTA INQUILINOS
    private static void listTenants() {

    }

    // EDITAR INQUILINOS
    private static void changeTenants() {

    }

    // CRIAR IMOVEIS
    private static void createProperty() {
        try {
            System.out.print("\nEndereço: ");
            String anddress = scanner.nextLine();
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
                    throw new PropertyInvalidTypeException("Type Property Invalid!");
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
                    throw new PropertyInvalidOccupationException("Occupation Property Invalid!");
            }

            propertyService.addProperty(anddress, rentalValue, propertyType, propertyOccupation);
        } catch (PropertyInvalidTypeException | PropertyInvalidOccupationException e) {
            System.out.println("\nErro: " + e.getMessage());
        }

    }

    // EDITAR IMOVEIS
    private static void changeProperty() throws PropertyInvalidTypeException, PropertyInvalidOccupationException {
        System.out.print("\nInsira o índice do Imovel à editar: ");
        int id = scanner.nextInt();
        propertyService.changeProperty(id);
    }

    // REMOVE IMOVEIS

    private static void removeProperty() {
        System.out.print("\nInsira o índice do Imovel para remover: ");
        int id = scanner.nextInt();
        propertyService.removeProperty(id);
    }

    // CRIAR PROPRIETARIO
    private static void createLandlord() {

    }

    // LISTA PROPRIETARIO
    private static void listLandlord() {

    }

    // EDITAR PROPRIETARIO
    private static void changeLandlord() {

    }

    // REMOVE INQUILINO DO IMOVEL
    private static void removeTenants() {

    }

    // CADASTRA INQUILINO NO IMOVEL (Criar o contrato)
    private static void createLease() {

    }

    // LISTA CONTRATOS
    private static void listLease() {

    }

    // DELETAR CONTRATOS
    private static void deleteLease() {

    }

}
