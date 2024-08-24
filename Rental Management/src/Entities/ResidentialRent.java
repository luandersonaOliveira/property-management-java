//HERANÇA ALUGUEL RESIDENCIAL

import Enum.OccupationProprietary;
import Enum.TypesRent;

public class ResidentialRent extends Contract {
    // ATRIBUTOS

    private String dataInicio, dataFim;

    // METODOS ESPECIAS
    
    // CONSTRUCTOR
    
    public ResidentialRent(Property imovel, Tenant inquilino, String dataInicio, String dataFim) {
        super(imovel, inquilino);
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    // METODOS PERSONALIZADOS

}
