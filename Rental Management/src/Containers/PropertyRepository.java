// REPOSITÓRIO INQUILINOS

import java.util.ArrayList;
import java.util.Scanner;

public class PropertyRepository {
    private ArrayList<Property> properties = new ArrayList<Property>();

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
        System.out.print("Tipo: \n1 Comercial | 2 Residencial |");
        int novoTipo = scanner.nextInt();
        System.out.print("Ocupação: \n1 Vago | 2 Ocupado |");
        int novoOcupacao= scanner.nextInt();
        property.setLimiteVagas(novoLimiteVagas);
        property.setTipo(novoTipo);
        property.setOcupacao(novoOcupacao);
        System.out.println("\nImovel " + id + " atualizado com sucesso!");
    }
}
