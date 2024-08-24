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
                    criarInquilinos();
                    break;
                case 2:
                    checarInquilinos();
                    break;
                case 3:
                    alterarInquilinos();
                    break;
                case 4:
                    criarImoveis();
                    break;
                case 5:
                    checarImoveis();
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
        System.out.print(" 6 Para deletar Contratos |"); // Remove o inquilino do imovel.
        // OU Apaga o iquilino e o imovel.
        System.out.print("\n--------------------------------");
        System.out.print("\n0 Para sair do menu");
        System.out.println("\n===========================");
        System.out.print("Opção: ");
    }

    // CRIAR INQUILINOS
    public static void criarInquilinos() {
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("CPF: ");
        String cpf = scanner.nextLine();
        System.out.println("Telefone: ");
        String telefone = scanner.nextLine();
        Tenant tenant = new Tenant(nome, cpf, telefone);
        tenantRepository.adicionarInquilinos(tenant);
    }

    // LISTA INQUILINOS
    public static void checarInquilinos() {
        tenantRepository.listarInquilinos();
    }

    // EDITAR INQUILINOS
    public static void alterarInquilinos() {

    }

    // CRIAR IMOVEIS
    public static void criarImoveis() {
        System.out.print("Limite de Vagas: ");
        int vagas = scanner.nextInt();
        System.out.println("Tipo: \n1 Comercial | 2 Residencial |");
        int tipo = scanner.nextInt();
        System.out.println("Ocupação: \n1 Vago | 2 Ocupado");
        int ocupacao = scanner.nextInt();
        Property property = new Property(vagas, tipo, ocupacao);
        propertyRepository.adicionarImoveis(property);
    }

    // LISTA IMOVEIS
    public static void checarImoveis() {
        propertyRepository.listarImoveis();
    }

    // EDITAR IMOVEIS
    public static void alterarImoveis(){

    }

    // CRIAR CONTRATO
    public static void criarContratos() {

    }

    // CADASTRA INQUILINO NO IMOVEL
    public static void cadastrarInquilinoNoImovel() {

    }

    // DELETAR CONTRATOS (INQUILINOS E IMOVEIS)
    public static void excluirContrato(){
        
    }

}
