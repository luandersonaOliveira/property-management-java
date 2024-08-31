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

    public static void main(String[] args) {
        // OPÇÕES DO MENU
        boolean sair = false;
        do {
            menuPrincipal();
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    createProperty();
                    break;
                case 2:
                    propertyService.listProperty();
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

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
        System.out.print("| 1. Para cadastrar Inquilinos. |");
        System.out.print(" 2. Para Checar Inquilinos. |");
        System.out.print(" 3. Para Editar um Inquilino. |");
        System.out.print("\n| 4. Para Cadastrar um Inquilino no Imovel. |");
        System.out.print(" 5. Para Checar Inquilino no Imovel. |");
        System.out.print(" 6. Para Deletar Contratos. |");
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
            System.out.print("\nAnddress: ");
            String anddress = scanner.nextLine();
            System.out.print("RentalValue: ");
            double rentalValue = scanner.nextDouble();
            System.out.print("Type: \n1.Residencial | 2.Comercial |");
            System.out.print("\nOpção: ");
            int type = scanner.nextInt();
            System.out.print("\nOccupation: \n1.Desocupado | 2.Ocupado |");
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
            System.out.println("Erro: " + e.getMessage());
        }

    }

    // LISTA IMOVEIS
    private static void listProperty() {

    }

    // EDITAR IMOVEIS
    private static void changeProperty() {

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
