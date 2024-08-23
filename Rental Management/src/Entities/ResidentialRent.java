//HERANÇA ALUGUEL RESIDENCIAL

import Enum.OccupationProprietary;
import Enum.TypesRent;

public class ResidentialRent extends Contract {
    // ATRIBUTOS

    private String dataInicio, dataFim;
    private double valor;

    // METODOS ESPECIAS

    // CONSTRUCTOR

    public ResidentialRent(TypesRent tipo, OccupationProprietary status, Property imovel, Tenant inquilino) {
        super(tipo, status, imovel, inquilino);
        //TODO Auto-generated constructor stub
    }

    // METODOS PERSONALIZADOS

    private double calcularTaxaComercial() {
        return 0.0;
    }
}
