// Repositório de Imóvel

import java.util.ArrayList;

public class PropertyRepository {
    private ArrayList<Property> properties = new ArrayList<>();

    public void adicionarProperties(Property property){
        properties.add(property);
    }

    public ArrayList<Property> listaProperties(){
        return properties;
    }

}
