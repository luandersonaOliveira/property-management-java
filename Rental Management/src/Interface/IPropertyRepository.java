package Interface;
// Interface Repositório de Imovel

import java.util.ArrayList;

import Entity.Property;

public interface IPropertyRepository {
    public abstract void addPropery(Property property);

    public abstract void removeProperty(int id);

    public abstract void changeProperty(int id);

    public ArrayList<Property> listProperty();

    public Property searchProperty(int id);
}
