// MAIN

import java.util.Scanner;

import Enum.OccupationProprietary;
import Enum.TypesRent;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean sair = false;

    // CONTAINERS
    private static final TenantRepository tenantRepository = new TenantRepository();
    private static final PropertyRepository propertyRepository = new PropertyRepository();

    // METODOS
    
    public static void main(String[] args) {
        // OPÇÕES DO MENU
        do {
            menuPrincipal();
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    criarInquilino();
                    break;
                case 2:
                    checarInquilino();
                    break;
                case 3:
                    criarImovel();
                    break;
                case 4:
                    checarImovel();
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                case 0:
                    sair = true;
            }
        } while (!sair);
    }

    // MENU
    public static void menuPrincipal() {
        System.out.println("==========================");
        System.out.println("SELECIONE SUA OPÇÃO");
        System.out.print("| 1 para cadastrar Inquilinos |");
        System.out.print(" 2 Para ver lista de Inquilinos |");
        System.out.print(" 3 Para editar um Inquilino |");
        System.out.print("\n--------------------------------");
        System.out.print("\n| 4 Para cadastrar Inquilino em um Imovel |"); // Cria o imovel e o contrato é feito.
        System.out.print(" 5 Para checar Inquilino em um Imovel |"); // Lista de contrato.
        System.out.print(" 6 Para deletar Contratos |"); //Remove o inquilino do imovel.
        //OU Apaga o iquilino e o imovel.
        System.out.print("\n--------------------------------");
        System.out.print("\n0 Para sair do menu");
        System.out.println("\n===========================");
        System.out.print("Opção: ");
    }

    public static void criarInquilino(){
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("CPF: ");
        String cpf = scanner.nextLine();
        System.out.println("Telefone: ");
        String telefone = scanner.nextLine();
        Tenant tenant = new Tenant(nome, cpf, telefone);
        tenantRepository.adicionarInquilinos(tenant);
    }

    public static void checarInquilino(){
        tenantRepository.listarInquilinos();
    }

    public static void criarImovel(){
        System.out.println("Limite de Vagas: ");
        int vagas = scanner.nextInt();
        System.out.println("Tipo: 1 Comercial | 2 Residencial |");
        int tipo = scanner.nextInt();
        System.out.println("Ocupação: 1 Vago | 2 Ocupado");
        int occupation = scanner.nextInt();
        Property property = new Property(vagas, null, null);
        propertyRepository.adicionarImoveis(property);
    }

    public static void checarImovel(){
        propertyRepository.listarImoveis();
    }

    public static void criarContrato(){

    }

    public static void cadastraInquilinoNoImovel(){

    }

}
