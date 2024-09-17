package Entity;
//HERANÇA ALUGUEL RESIDENCIAL

import Enum.PropertyOccupation;
import Enum.PropertyType;

public class ResidentialProperty extends Property {
    // ATRIBUTOS
    private int numberRooms;
    private boolean ItHasALeisureArea;

    // CONSTRUCTOR
    public ResidentialProperty(Landlord landlord, String address, double rentalValue, PropertyType type,
            PropertyOccupation occupation) {
        super(address, rentalValue, type, occupation);
        this.setLandlord(landlord);
    }

    // METODOS ESPECIAS

    public int getNumberRooms() {
        return numberRooms;
    }

    public void setNumberRooms(int numberRooms) {
        this.numberRooms = numberRooms;
    }

    public boolean isItHasALeisureArea() {
        return ItHasALeisureArea;
    }

    public void setItHasALeisureArea(boolean itHasALeisureArea) {
        ItHasALeisureArea = itHasALeisureArea;
    }

    // METODOS PERSONALIZADOS
}
