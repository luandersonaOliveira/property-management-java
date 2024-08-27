// REPOSITÓRIO INQUILINOS

import java.util.ArrayList;
import java.util.Scanner;

public class PropertyRepository {
    public ArrayList<Property> properties = new ArrayList<Property>();

    public void adicionarImoveis(Property property) {
        properties.add(property);
    }

    public void removerImoveis(int id) {
        properties.remove(id);
    }

    public void listarImoveis() {
        for (int i = 0; i < properties.size(); i++) {
            properties.get(i).imovelInfo(i);
        }
    }

    public void alterarImoveis(int id) {
        Scanner scanner = new Scanner(System.in);
        if (id < 0 || id >= properties.size()) {
            System.out.println("Índice Inválido. Tente novamente!");
            return;
        }

        Property property = properties.get(id);
        System.out.println("Informações do Inquilino selecionado:");
        property.imovelInfo(id);
        System.out.println("\nDigite as novas informações do Imovel: ");
        System.out.print("Limite de Vagas: ");
        int novoLimiteVagas = scanner.nextInt();
        System.out.println("Tipo: 1 Comercial | 2 Residencial |");
        System.out.print("Opção: ");
        int novoTipo = scanner.nextInt();
        System.out.println("Ocupação: 1 Vago | 2 Ocupado | ");
        System.out.print("Opção: ");
        int novaOcupacao = scanner.nextInt();
        System.out.print("Data: ");
        String novaData = scanner.nextLine();
        property.setLimiteVagas(novoLimiteVagas);
        property.setTipo(novoTipo);
        property.setOcupacao(novaOcupacao);
        property.setData(novaData);
        System.out.println("\nImovel atualizado com sucesso!");
    }
}
