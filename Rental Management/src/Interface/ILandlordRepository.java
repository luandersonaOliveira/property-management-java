package Interface;
// Interface Repositório de Proprietário

import java.util.ArrayList;

import Entity.Landlord;

public interface ILandlordRepository {
    public abstract void addLandlord(Landlord landlord);

    public abstract void removeLandlord(int id);

    public abstract void changeLandlord(int id);

    public ArrayList<Landlord> listLandlord();

    public Landlord searchLandlord(int id);
}
