import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean sair = false;

    // CONTAINERS
    private static final TenantRepository tenantRepository = new TenantRepository();
    

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
                    
                    break;
                case 4:
                    
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
        tenantRepository.adicionarInquilino(tenant);
    }

    public static void checarInquilino(){
        tenantRepository.listarInquilino();
    }

    public static void criarImovel(){

    }

    public static void criarContrato(){

    }

    public static void cadastraInquilinoNoImovel(){

    }

}
/*
Sistema de Gerenciamento de Aluguéis:
    Entidades: Contrato, Inquilino, Imóvel
    Interfaces: Repositório de Contratos, Serviço de Cobrança
    Herança: Aluguel Residencial, Aluguel Comercial

Classes Principais
    Imóvel
    Atributos: id, endereço, tipo, valorAluguel, status
    Métodos: calcularValorAluguel(), alterarStatus()

    Inquilino
    Atributos: id, nome, cpf, telefone
    Métodos: atualizarDados(), verificarHistorico()

    Contrato
    Atributos: id, dataInicio, dataFim, valor, imóvel, inquilino
    Métodos: calcularValorTotal(), renovarContrato()

Interfaces
    Repositório de Contratos
    Métodos: adicionarContrato(), removerContrato(), buscarContrato()

    Serviço de Cobrança
    Métodos: gerarCobranca(), enviarCobranca()

Herança
    Aluguel Residencial (herda de Contrato)
    Atributos: tipoResidencia
    Métodos: calcularDescontoResidencial()

    Aluguel Comercial (herda de Contrato)
    Atributos: tipoComercio
    Métodos: calcularTaxaComercial()

Relacionamentos
    Imóvel tem um Proprietário.
    Contrato associa um Imóvel a um Inquilino.
    Aluguel Residencial e Aluguel Comercial herdam de Contrato.
    Repositório de Contratos gerencia Contrato.
    Serviço de Cobrança gera cobranças para Contrato.

+----------------+       +----------------+       +----------------+
|    Imóvel      |       |   Inquilino    |       |   Contrato     |
+----------------+       +----------------+       +----------------+
| - id: int      |       | - id: int      |       | - id: int      |
| - endereço:... |       | - nome: String |       | - dataInicio:..|
| - tipo: String |       | - cpf: String  |       | - dataFim: Date|
| - valorAluguel:|       | - telefone:... |       | - valor: double|
| - status: String|      | - email: String|       | - imóvel: Imóvel|
+----------------+       +----------------+       | - inquilino:...|
| + calcular...  |       | + atualizar... |       +----------------+
| + alterar...   |       | + verificar... |       | + calcular...  |
+----------------+       +----------------+       | + renovar...   |
        |                        |                +----------------+
        |                        |                        |
        |                        |                        |
        |                        |                        |
        |                        |                        |
        v                        v                        v
+----------------+       +----------------+       +----------------+
| Aluguel Res.   |       | Aluguel Com.   |       | Repositório de |
+----------------+       +----------------+       | Contratos      |
| - tipoResid... |       | - tipoComercio |       +----------------+
+----------------+       +----------------+       | + adicionar... |
| + calcular...  |       | + calcular...  |       | + remover...   |
+----------------+       +----------------+       | + buscar...    |
        ^                        ^                +----------------+
        |                        |                        |
        |                        |                        |
        |                        |                        |
        |                        |                        |
        +------------------------+                        |
                 herda de                                  |
                                                         v
                                                  +----------------+
                                                  | Serviço de     |
                                                  | Cobrança       |
                                                  +----------------+
                                                  | + gerarCobr... |
                                                  | + enviarCobr...|
                                                  +----------------+

 */