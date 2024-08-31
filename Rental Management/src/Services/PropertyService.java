package Services;
// Sreviço Imovel

import java.util.ArrayList;

import Containers.PropertyRepository;
import Entity.CommercialProperty;
import Entity.Property;
import Entity.ResidentialProperty;
import Enum.PropertyOccupation;
import Enum.PropertyType;
import Exceptions.PropertyInvalidOccupationException;
import Exceptions.PropertyInvalidTypeException;
import Interface.IPropertyRepository;

public class PropertyService {
    // ATRIBUTOS
    private PropertyRepository propertyRepository = new PropertyRepository();

    // CONSTRUCTOR

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    // METODOS ESPECIAS

    // METODOS PERSONALIZADOS

    public void addProperty(String anddress, double rentalValue, PropertyType type,
            PropertyOccupation occupation) throws PropertyInvalidTypeException, PropertyInvalidOccupationException {
        if (type == null) {
            throw new PropertyInvalidTypeException("Tipo Inválido! Deve ser Residencial ou Comercial.");
        }

        Property property = createProperty(anddress, rentalValue, type, occupation);
        if (property != null) {
            propertyRepository.addProperty(property);
            System.out.println("Imovel adicionado com sucesso!");
        } else {
            throw new PropertyInvalidOccupationException("Ocupação Inválida! Deve estar Desocupado ou Ocupado.");
        }
    }

    private Property createProperty(String anddress, double rentalValue, PropertyType type,
            PropertyOccupation occupation) {
        switch (type) {
            case RESIDENTIAL:
                return new ResidentialProperty(anddress, rentalValue, type, occupation);
            case COMMERCIAL:
                return new CommercialProperty(anddress, rentalValue, type, occupation);
            default:
                return null;
        }
    }

    public void listProperty() {
        ArrayList<Property> properties = propertyRepository.listProperty();
        if (properties.isEmpty()) {
            System.out.println("Nenhum Imovel cadastrada.");
        } else {
            for (int i = 0; i < properties.size(); i++) {
                Property p = properties.get(i);
                System.out.println("\n-------------------------------------------------------------------------------");
                System.out.print("Imovel " + (i + 1) + "\n");
                System.out.print(" | Anddress: " + p.getAnddress());
                System.out.print(" | RentalValue: " + p.getRentalValue() );
                System.out.print(" | Type: " + p.getType());
                System.out.print(" | Occupation: " + p.getOccupation() + " |");
                System.out.println("\n-------------------------------------------------------------------------------");
            }
        }
    }

}
