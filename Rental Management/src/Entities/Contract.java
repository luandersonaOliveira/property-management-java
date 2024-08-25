// CONTRATOS

import java.util.ArrayList;

public class Contract {
    // ATRIBUTOS

    private int vagas;
    private ArrayList<Property> imovel;
    private ArrayList<Tenant> inquilino;

    // CONSTRUCTOR

    public Contract(Property imovel, Tenant inquilino) {
        this.imovel = new ArrayList<>(this.getVagas());
        this.inquilino = new ArrayList<>();
    }

    // METODOS ESPECIAS

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int limiteVagas) {
        Property property = new Property(limiteVagas, 0);
        if (limiteVagas <= 0) {
            property.setLimiteVagas(limiteVagas);
        } else {
            this.vagas = property.getLimiteVagas();
        }
    }

    // METODOS PERSONALIZADOS

    private void renovarContrato(String novaData) {

    }

    public void listarImoveis(Contract contract) {
        for (int i = 0; i < contract.imovel.size(); i++) {
            imovel.get(i).imovelInfo(i);
        }
    }

    public void listarInquilinos(Contract contract) {
        for (int i = 0; i < contract.inquilino.size(); i++) {
            inquilino.get(i).tenantInfo(i);
        }
    }

    public void contractInfo(int id) {
        System.out.println("\n-------------------------------------------------------------------------");
        System.out.println("Contrato: " + id);
        System.out.print("Imovel: " + imovel + " | ");
        System.out.print("Inquilino: " + inquilino + " |\n");
        System.out.println("\n-------------------------------------------------------------------------");
    }

    public void cadastrarInquilinoNoImovel(Tenant tenant, Property property, int idInquilino) {
    
    }

}
