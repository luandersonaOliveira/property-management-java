package Entity;
// Imovel

import Enum.PropertyType;
import Enum.PropertyOccupation;

public class Property {
    // ATRIBUTOS

    private int id;
    private String anddress;
    private double rentalValue;
    private PropertyType type;
    private PropertyOccupation occupation;

    // CONSTRUCTOR

    public Property(int id, String anddress, double rentalValue, PropertyType type, PropertyOccupation occupation) {
        this.id = id;
        this.anddress = anddress;
        this.rentalValue = rentalValue;
        this.type = type;
        this.occupation = occupation;
    }

    // METODOS ESPECIAS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnddress() {
        return anddress;
    }

    public void setAnddress(String anddress) {
        this.anddress = anddress;
    }

    public double getRentalValue() {
        return rentalValue;
    }

    public void setRentalValue(double rentalValue) {
        this.rentalValue = rentalValue;
    }

    public PropertyType getType() {
        return type;
    }

    public void setType(PropertyType type) {
        this.type = type;
    }

    public PropertyOccupation getOccupation() {
        return occupation;
    }

    public void setOccupation(PropertyOccupation occupation) {
        this.occupation = occupation;
    }

    // METODOS PERSONALIZADOS
}
