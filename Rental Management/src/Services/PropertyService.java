package Services;
// Sreviço Imovel

import java.util.ArrayList;
import java.util.Scanner;

import Containers.LandlordRepository;
import Containers.PropertyRepository;
import Entity.CommercialProperty;
import Entity.Landlord;
import Entity.Property;
import Entity.ResidentialProperty;
import Entity.Tenant;
import Enum.EnumLandlordException;
import Enum.EnumPropertyException;
import Enum.EnumTenantException;
import Enum.PropertyOccupation;
import Enum.PropertyType;
import Exceptions.LandlordException;
import Exceptions.PropertyException;

public class PropertyService {
    // ATRIBUTOS
    private static final Scanner scanner = new Scanner(System.in);
    private PropertyRepository propertyRepository = new PropertyRepository();

    // CONSTRUCTOR

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    // METODOS ESPECIAS

    // METODOS PERSONALIZADOS

    // CREATE
    public void addProperty(String anddress, double rentalValue, PropertyType type,
            PropertyOccupation occupation)
            throws PropertyException {
        if (type == null) {
            throw new PropertyException("Erro: " + EnumPropertyException.PropertyInvalidType);
        } else if (rentalValue < 0) {
            throw new PropertyException("Erro: " + EnumPropertyException.PropertyInvalidRentalValue);
        }

        Property property = createProperty(anddress, rentalValue, type, occupation);
        if (property != null) {
            propertyRepository.addProperty(property);
            System.out.println("\nImovel adicionado com sucesso! ID: " + property.getId());
        } else {
            throw new PropertyException("Erro: " + EnumPropertyException.PropertyInvalid);
        }
    }

    private Property createProperty(String anddress, double rentalValue, PropertyType type,
            PropertyOccupation occupation) {
        switch (type) {
            case RESIDENTIAL:
                return new ResidentialProperty(anddressFormart(anddress), rentalValue, type, occupation);
            case COMMERCIAL:
                return new CommercialProperty(anddressFormart(anddress), rentalValue, type, occupation);
            default:
                return null;
        }
    }

    private String anddressFormart(String anddress) {
        String anddressFormart = anddress.toUpperCase();
        return anddressFormart;
    }

    // REMOVE
    public void removeProperty(int id) throws PropertyException {
        if (propertyRepository.properties.isEmpty()) {
            throw new PropertyException("Erro: " + EnumPropertyException.PropertyNoRegistered);
        } else {
            propertyRepository.properties.remove(id);
            Property removed = new Property(null, 0, null, null);
            removed.setId(id);
            propertyRepository.addProperty(removed);
            System.out.println("\nImovel: " + id + ". Removido com sucesso!");
        }
    }

    // LIST
    public void listProperty() throws PropertyException {
        ArrayList<Property> properties = propertyRepository.listProperty();
        if (properties.isEmpty()) {
            throw new PropertyException("Erro: " + EnumPropertyException.PropertyNoRegistered);
        } else {
            for (int i = 0; i < properties.size(); i++) {
                Property p = properties.get(i);
                System.out.println("\n-------------------------------------------------------------------------------");
                System.out.print("Imovel: " + p.getId() + "\n");
                System.out.print(" | Endereço: " + p.getAnddress());
                System.out.print(" | Valor do Aluguel: " + p.getRentalValue() + " |");
                System.out.print("\n | Tipo: " + p.getType());
                System.out.print(" | Ocupação: " + p.getOccupation() + " |");
                System.out.println("\n-------------------------------------------------------------------------------");
            }
        }
    }

    // CHANGE
    public void changeProperty(int id) throws PropertyException {
        if (propertyRepository.properties.isEmpty()) {
            throw new PropertyException("Erro: " + EnumPropertyException.PropertyNoRegistered);
        } else {
            if (id < 0 || id >= propertyRepository.properties.size()) {
                throw new PropertyException("Erro: " + EnumPropertyException.PropertyInvalidIndex);
            }

            Property property = propertyRepository.properties.get(id);
            System.out.println(
                    "\nQuais as novas informações do Imovel deseja mudar? \n0.Nenhum | 1.Endereço | 2.Valor do Aluguel | 3.Tipo | 4.Ocupação |");
            System.out.print("\nOpção: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("\nDigite as novas informações: ");
                    System.out.print("\nEndereço: ");
                    String newAnddress = scanner.nextLine();
                    property.setAnddress(anddressFormart(newAnddress));
                    System.out.println("\nImovel atualizado com sucesso!");
                    break;
                case 2:
                    System.out.println("\nDigite as novas informações: ");
                    System.out.print("Valor do Aluguel: ");
                    double newRentalValue = scanner.nextDouble();
                    property.setRentalValue(newRentalValue);
                    System.out.println("\nImovel atualizado com sucesso!");
                    break;
                case 3:
                    System.out.print("Tipo: \n1.Residencial | 2.Comercial |");
                    System.out.print("\nOpção: ");
                    int newType = scanner.nextInt();

                    if (newType == 1) {
                        PropertyType propertyType = PropertyType.RESIDENTIAL;
                        property.setType(propertyType);
                    } else if (newType == 2) {
                        PropertyType propertyType = PropertyType.COMMERCIAL;
                        property.setType(propertyType);
                    } else {
                        throw new PropertyException("Erro: " + EnumPropertyException.PropertyInvalidType);
                    }
                    System.out.println("\nImovel atualizado com sucesso!");
                    break;
                case 4:
                    System.out.print("Ocupação: \n1.Desocupado | 2.Ocupado |");
                    System.out.print("\nOpção: ");
                    int newOccupation = scanner.nextInt();

                    if (newOccupation == 1) {
                        PropertyOccupation propertyOccupation = PropertyOccupation.UNOCCUPIED;
                        property.setOccupation(propertyOccupation);
                    } else if (newOccupation == 2) {
                        PropertyOccupation propertyOccupation = PropertyOccupation.OCCUPIED;
                        property.setOccupation(propertyOccupation);
                    } else {
                        throw new PropertyException("Erro: " + EnumPropertyException.PropertyInvalidOccupation);
                    }
                    System.out.println("\nImovel atualizado com sucesso!");
                    break;
                default:
                    option = 0;
                    System.out.println("\nImovel não foi atualizado!");
                    break;
            }
        }
    }
    /*
     * public void listProperties() {
     * Property property01 =
     * createProperty("Rua Gonçalo de Carvalho – Porto Alegre (RS)", 500,
     * PropertyType.RESIDENTIAL, PropertyOccupation.UNOCCUPIED);
     * Property property02 = createProperty("Rua do Mucugê – Arraial d’Ajuda (BA)",
     * 800, PropertyType.COMMERCIAL,
     * PropertyOccupation.UNOCCUPIED);
     * Property property03 = createProperty("Rua das Pedras – Búzios (RJ)", 480,
     * PropertyType.RESIDENTIAL,
     * PropertyOccupation.UNOCCUPIED);
     * Property property04 = createProperty("Rua da Aurora – Recife (PE)", 780,
     * PropertyType.COMMERCIAL,
     * PropertyOccupation.UNOCCUPIED);
     * Property property05 = createProperty("Rua Bento Gonçalves – Erechim (RS)",
     * 550, PropertyType.RESIDENTIAL,
     * PropertyOccupation.UNOCCUPIED);
     * }
     */

    public void searchProperty(int id) throws PropertyException {
        Property property = propertyRepository.searchProperty(id);
        System.out.println(property.getId());
    }

}
