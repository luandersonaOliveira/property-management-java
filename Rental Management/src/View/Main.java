public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
/*
Classes Principais
    Imóvel
    Atributos: id, endereço, tipo, valorAluguel, status
    Métodos: calcularValorAluguel(), alterarStatus()

    Inquilino
    Atributos: id, nome, cpf,
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