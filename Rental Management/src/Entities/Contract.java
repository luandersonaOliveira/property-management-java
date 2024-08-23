// CONTRATOS

import java.util.Date;
import java.util.ArrayList;
import Enum.OccupationProprietary;
import Enum.TypesRent;

public class Contract {
    // ATRIBUTOS

    private int vagas;
    private ArrayList<Property> imovel;
    private ArrayList<Tenant> inquilino;

    // CONSTRUCTOR

    public Contract(TypesRent tipo, OccupationProprietary status, Property imovel, Tenant inquilino) {
        this.imovel = new ArrayList<>();
        this.inquilino = new ArrayList<>(this.getVagas());
    }

    // METODOS ESPECIAS

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int limiteVagas) {
        Property property = new Property(limiteVagas, null, null);
        if (limiteVagas <= 0) {
            property.setLimiteVagas(limiteVagas);
        }else {
            this.vagas = property.getLimiteVagas();
        }
    }

    public ArrayList<Property> getImovel() {
        return imovel;
    }

    public void setImovel(ArrayList<Property> imovel) {
        this.imovel = imovel;
    }

    public ArrayList<Tenant> getInquilino() {
        return inquilino;
    }

    public void setInquilino(ArrayList<Tenant> inquilino) {
        this.inquilino = inquilino;
    }

    // METODOS PERSONALIZADOS

    private double calcularValorTotal() {
        return 0.0;
    }

    private void renovarContrato(Date novaData) {

    }

    public void contractInfo(int id) {
        System.out.println("Contrato: " + id);
        System.out.print("Imovel: " + imovel + " | ");
        System.out.print("Inquilino: " + inquilino + " |\n");
        System.out.println("-------------------------------------------------------------------------");
    }

}
