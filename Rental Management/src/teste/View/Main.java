// MAIN

import java.util.Scanner;

import Exceptions.PropertyException;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean sair = false;

    // CONTAINERS
    private static final TenantRepository tenantRepository = new TenantRepository();
    private static final PropertyRepository propertyRepository = new PropertyRepository();
    private static final ContractRepository contractRepository = new ContractRepository();

    // METODOS

    public static void main(String[] args) throws PropertyException {
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
                    alterarImoveis();
                    break;
                case 7:
                    cadastrarInquilinoNoImovel();
                    break;
                case 8:
                    checarContratos();
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
        System.out.print("| 1. Para cadastrar Inquilinos. |");
        System.out.print(" 2. Para Checar Inquilinos. |");
        System.out.print(" 3. Para Editar um Inquilino. |");
        System.out.print("\n| 4. Para Cadastrar um Inquilino no Imovel. |"); // Cria o imovel e o contrato é feito.
        System.out.print(" 5. Para Checar Inquilino no Imovel. |"); // Lista de contrato.
        System.out.print(" 6. Para Deletar Contratos. |"); // Remove o inquilino do imovel.
        // OU Apaga o iquilino e o imovel.
        System.out.print("\n--------------------------------");
        System.out.print("\n| 0. Para Sair do Menu.");
        System.out.println("\n--------------------------------");
        System.out.print("Opção: ");
    }

    // CRIAR INQUILINOS
    private static void criarInquilinos() {
        System.out.print("\nNome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        Tenant tenant = new Tenant(nome, cpf, telefone);
        tenantRepository.adicionarInquilinos(tenant);
    }

    // LISTA INQUILINOS
    private static void checarInquilinos() {
        tenantRepository.listarInquilinos();
    }

    // EDITAR INQUILINOS
    private static void alterarInquilinos() {
        System.out.print("\nInsira o índice do Inquilino à editar: ");
        int id = scanner.nextInt();
        tenantRepository.alterarInquilinos(id);
    }

    // CRIAR IMOVEIS
    private static void criarImoveis() throws PropertyException {
        System.out.print("\nLimite de Vagas: ");
        int vagas = scanner.nextInt();
        System.out.print("Tipo: \n1 Comercial | 2 Residencial |");
        System.out.print("\nOpção: ");
        int tipo = scanner.nextInt();
        System.out.print("Data: ");
        String data = scanner.next();

        Property property = null;
        switch (tipo) {
            case 1:
                property = new CommercialRent(vagas, tipo, data);
                break;
            case 2:
                property = new ResidentialRent(vagas, tipo, data);
                break;
            default:
                System.out.println("Tipo inválido!");
                break;
        }
        propertyRepository.adicionarImoveis(property);
    }

    // LISTA IMOVEIS
    private static void checarImoveis() {
        propertyRepository.listarImoveis();
    }

    // EDITAR IMOVEIS
    private static void alterarImoveis() throws PropertyException {
        System.out.print("\nInsira o índice do Imovel à editar: ");
        int id = scanner.nextInt();
        propertyRepository.alterarImoveis(id);
    }

    // CADASTRA INQUILINO NO IMOVEL
    private static void cadastrarInquilinoNoImovel() throws PropertyException {
        System.out.print("\nÍndice do inquilino: ");
        int idInquilino = scanner.nextInt();
        System.out.print("\nÍndice do imovel: ");
        int idImovel = scanner.nextInt();
        Tenant tenant = tenantRepository.tenants.get(idImovel);
        Property property = propertyRepository.properties.get(idImovel);
        Contract contract = new Contract(idImovel, idInquilino);
        contract.cadastrarInquilinoNoImovel(tenant, property, idInquilino);
        contractRepository.adicionarContratos(contract);
    }

    // LISTA CONTRATOS
    private static void checarContratos() {
        contractRepository.listarContratos();
    }

    // DELETAR CONTRATOS (INQUILINOS E IMOVEIS)
    private static void excluirContrato() {

    }

}
