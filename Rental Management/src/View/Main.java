// MAIN

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean sair = false;

    // CONTAINERS
    private static final TenantRepository tenantRepository = new TenantRepository();
    private static final PropertyRepository propertyRepository = new PropertyRepository();
    private static final ContractRepository contractRepository = new ContractRepository();

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
                    criarContratos();
                    break;
                case 7:
                    checarContratos();
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

    // MENU
    public static void menuPrincipal() {
        System.out.println("\n--------------------------------");
        System.out.println("SELECIONE SUA OPÇÃO:");
        System.out.println("--------------------------------");
        System.out.print("| 1 Para cadastrar Inquilinos. |");
        System.out.print(" 2 Para Checar Inquilinos. |");
        System.out.print(" 3 Para Editar um Inquilino. |");
        System.out.print("\n--------------------------------");
        System.out.print("\n| 4 Para Cadastrar um Inquilino no Imovel. |"); // Cria o imovel e o contrato é feito.
        System.out.print(" 5 Para Checar Inquilino no Imovel. |"); // Lista de contrato.
        System.out.print(" 6 Para Deletar Contratos. |"); // Remove o inquilino do imovel.
        // OU Apaga o iquilino e o imovel.
        System.out.print("\n--------------------------------");
        System.out.print("\n0 Para Sair do Menu.");
        System.out.println("\n--------------------------------");
        System.out.print("Opção: ");
    }

    // CRIAR INQUILINOS
    public static void criarInquilinos() {
        System.out.println("\nNome: ");
        String nome = scanner.nextLine();
        System.out.println("CPF: ");
        String cpf = scanner.nextLine();
        System.out.println("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.println("Saldo: ");
        int saldo = scanner.nextInt();
        Tenant tenant = new Tenant(nome, cpf, telefone, saldo);
        tenantRepository.adicionarInquilinos(tenant);
    }

    // LISTA INQUILINOS
    public static void checarInquilinos() {
        tenantRepository.listarInquilinos();
    }

    // EDITAR INQUILINOS
    public static void alterarInquilinos() {
        System.out.print("\nInsira o índice do Inquilino à editar: ");
        int id = scanner.nextInt();
        tenantRepository.alterarInquilinos(id);
    }

    // CRIAR IMOVEIS
    public static void criarImoveis() {
        System.out.print("\nLimite de Vagas: ");
        int vagas = scanner.nextInt();
        System.out.println("Tipo: 1 Comercial | 2 Residencial |");
        System.out.print("Opção: ");
        int tipo = scanner.nextInt();
        Property property = new Property(vagas, tipo);
        propertyRepository.adicionarImoveis(property);
    }

    // LISTA IMOVEIS
    public static void checarImoveis() {
        propertyRepository.listarImoveis();
    }

    // EDITAR IMOVEIS
    public static void alterarImoveis() {
        System.out.print("\nInsira o índice do Imovel à editar: ");
        int id = scanner.nextInt();
        propertyRepository.alterarImoveis(id);
    }

    // CRIAR CONTRATO
    public static void criarContratos() {
        System.out.print("\nÍndice do inquilino: ");
        int idInquilino = scanner.nextInt();
        System.out.print("\nÍndice do imovel: ");
        int idImovel = scanner.nextInt();
        Contract contract = new Contract(idImovel, idInquilino);
        contractRepository.adicionarContratos(contract);
    }

    // LISTA CONTRATOS
    public static void checarContratos() {
        contractRepository.listarContratos();
    }

    // CADASTRA INQUILINO NO IMOVEL
    public static void cadastrarInquilinoNoImovel() {

    }

    // DELETAR CONTRATOS (INQUILINOS E IMOVEIS)
    public static void excluirContrato() {

    }

}
