# Property-management-java
 Essa é a base do sistema. Envolve o controle dos contratos de locação, datas de início e término, valores dos aluguéis e reajustes. Também inclui o registro de informações sobre os inquilinos e proprietários.

## Sobre o assunto:

Gestão de Aluguéis
    Essa é a base do sistema. Envolve o controle dos Contratos de locação, Datas de início e término, Valores dos aluguéis e reajustes. Também inclui o registro de informações sobre os Inquilinos e Proprietários.

Controle Financeiro
    Um bom sistema deve permitir o acompanhamento das finanças relacionadas aos Aluguéis. Isso inclui registrar os pagamentos dos Inquilinos, Calcular multas por atraso e Gerar relatórios financeiros.

Site Imobiliário Integrado (Implementar, se possivel no proximo semestre)
    Muitos sistemas oferecem a possibilidade de criar um site para divulgar os imóveis disponíveis para aluguel. Isso facilita a exposição das propriedades e a comunicação com potenciais inquilinos.


### Classes Principais:

Proprietário
- Atributos: id, nome, cpf, telefone, email, Imóvel
- Métodos: adicionarImóvel(), removerImóvel()

Imóvel
- Atributos: id, endereço, valorAluguel, tipo, ocupação, Proprietário, Inquilino
- Métodos: calcularValorAluguel(), alterarStatus()

Inquilino
- Atributos: id, nome, cpf, telefone, email, saldo, imovel
- Métodos: atualizarDados(), verificarHistorico()

Contrato
- Atributos: id, dataInicio, dataFim, valor, Proprietário, Imóvel, Inquilino
- Métodos: calcularValorTotal(), renovarContrato()

Pagamento
- Atributos: id, dataPagamento, valor, Contrato
- Métodos: registrarPagamento(), verificarAtraso()

#### Relacionamentos:

- Proprietário pode ter nenhum ou vários Imóveis.
  - Proprietário NÃO depende de imóvel.
- Imóvel tem somente um Proprietário.
  - Imóvel SIM depende de Proprietário.
  - Lista de Imóveis pronta pode ser atribuída ao Proprietário.
- Contrato associa um Imóvel a um Inquilino.
  - Contrato pode remover Inquilino do Imóvel (gerando o fim do contrato).
- Pagamento está relacionado a um Contrato.

##### Explicação: 

    Commercial e Residencial herdam de Imovel.
    Pagamento vai estar relacionado com Contrato.
    Contrato recebe as informações de Imovel, Inquilino e Proprietário.

+-----------------------------------+
|            Sistema de             |
|     Gerenciamento de Aluguéis     |
+-----------------------------------+
| Entidades:                        |
| - Contrato                        |
| - Inquilino                       |
| - Imóvel                          |
| - Proprietário                    |
| - Pagamento                       |
| Interfaces:                       |
| - Repositórios (Todas as Entidades)|
| - Serviço de Cobrança (Pagamentos)|
+-----------------------------------+
| Herança:                          |
| - Aluguel Residencial (Imóvel)    |
| - Aluguel Comercial (Imóvel)      |
+-----------------------------------+
| Enums:                            |
| - Ocupação                        |
| - Tipo                            |
| - EnumsExceptions (Todas as Entidades)|
+-----------------------------------+
| Repositórios:                     |
| - (Todas as Entidades)            |
+-----------------------------------+
| Exceptions:                       |
| - (Todas as Entidades)            |
+-----------------------------------+
| Service:                          |
| - (Todas as Entidades)            |
+-----------------------------------+
