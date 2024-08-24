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
        Property property = new Property(limiteVagas, 0, 0);
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
        System.out.println("Contrato: " + id);
        System.out.print("Imovel: " + imovel + " | ");
        System.out.print("Inquilino: " + inquilino + " |\n");
        System.out.println("-------------------------------------------------------------------------");
    }

    public void cadastrarInquilinoNoImovel(Tenant tenant, Property property, int idInquilino) {
        if (property.getLimiteVagas() > 0) {
            if (property.getOcupacao() == 2 || (property.getOcupacao() <= 0)) {
                System.out.println("Imovel esta Ocupado. Não é possivel adicionar inquilino " + idInquilino);
            } else {
                if (property.getOcupacao() == 1) {
                    imovel.add(property);
                    inquilino.add(tenant);
                    System.out.println("-----------------------------------------------");
                    System.out.println(tenant.getNome() + " foi cadastrado em " + property.getTypesRent());
                    property.setLimiteVagas(getVagas() - 1);
                    tenant.tenantInfo(idInquilino);
                }
            }
        }
    }

}
