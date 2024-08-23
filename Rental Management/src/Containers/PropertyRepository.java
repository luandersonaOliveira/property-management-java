// REPOSITÓRIO INQUILINOS

import java.util.ArrayList;

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

    public void alterarImoveis() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alterarInquilinos'");
    }
}
