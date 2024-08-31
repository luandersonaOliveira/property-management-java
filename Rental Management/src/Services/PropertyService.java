package Services;
// Sreviço Imovel

import java.util.ArrayList;
import java.util.Scanner;

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
            throw new PropertyInvalidTypeException("| Tipo Inválido! Deve ser Residencial ou Comercial. |");
        }

        Property property = createProperty(anddress, rentalValue, type, occupation);
        if (property != null) {
            propertyRepository.addProperty(property);
            System.out.println("\nImovel adicionado com sucesso!");
        } else {
            throw new PropertyInvalidOccupationException("| Ocupação Inválida! Deve estar Desocupado ou Ocupado. |");
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

    public void removeProperty(int id) {
        if (propertyRepository.properties.isEmpty()) {
            System.out.println("\n| Nenhum Imovel cadastrado! |");
        } else {
            propertyRepository.properties.remove(id);
            System.out.println("\nImovel removido com sucesso!");
        }
    }

    public void listProperty() {
        ArrayList<Property> properties = propertyRepository.listProperty();
        if (properties.isEmpty()) {
            System.out.println("\n| Nenhum Imovel cadastrado! |");
        } else {
            for (int i = 0; i < properties.size(); i++) {
                Property p = properties.get(i);
                p.setId(i);
                System.out.println("\n-------------------------------------------------------------------------------");
                System.out.print("Imovel: " + p.getId() + "\n");
                System.out.print(" | Anddress: " + p.getAnddress());
                System.out.print(" | RentalValue: " + p.getRentalValue() + " |");
                System.out.print("\n | Type: " + p.getType());
                System.out.print(" | Occupation: " + p.getOccupation() + " |");
                System.out.println("\n-------------------------------------------------------------------------------");
            }
        }
    }

    public void changeProperty(int id) throws PropertyInvalidTypeException, PropertyInvalidOccupationException {
        Scanner scanner = new Scanner(System.in);
        if (propertyRepository.properties.isEmpty()) {
            System.out.println("\n| Nenhum Imovel cadastrado! |");
        } else {
            if (id < 0 || id >= propertyRepository.properties.size()) {
                System.out.println("Índice Inválido. Tente novamente!");
                return;
            }

            Property property = propertyRepository.properties.get(id);
            System.out.println("\nDigite as novas informações do Imovel: ");
            System.out.print("\nEndereço: ");
            String newAnddress = scanner.nextLine();
            System.out.print("Valor do Aluguel: ");
            double newRentalValue = scanner.nextDouble();
            System.out.print("Tipo: \n1.Residencial | 2.Comercial |");
            System.out.print("\nOpção: ");
            int newType = scanner.nextInt();
            System.out.print("Ocupação: \n1.Desocupado | 2.Ocupado |");
            System.out.print("\nOpção: ");
            int newOccupation = scanner.nextInt();

            if (newType == 1) {
                PropertyType propertyType = PropertyType.RESIDENTIAL;
                property.setType(propertyType);
            } else if (newType == 2) {
                PropertyType propertyType = PropertyType.COMMERCIAL;
                property.setType(propertyType);
            } else {
                throw new PropertyInvalidTypeException("Type Property Invalid!");
            }

            if (newOccupation == 1) {
                PropertyOccupation propertyOccupation = PropertyOccupation.UNOCCUPIED;
                property.setOccupation(propertyOccupation);
            } else if (newOccupation == 2) {
                PropertyOccupation propertyOccupation = PropertyOccupation.OCCUPIED;
                property.setOccupation(propertyOccupation);
            } else {
                throw new PropertyInvalidOccupationException("Occupation Property Invalid!");
            }

            property.setAnddress(newAnddress);
            property.setRentalValue(newRentalValue);
            System.out.println("\nImovel atualizado com sucesso!");
        }
    }

}
