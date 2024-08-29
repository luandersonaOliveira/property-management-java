package View;
// MAIN

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean sair = false;

    // CONTAINERS

    public static void main(String[] args) {
        // OPÇÕES DO MENU
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
