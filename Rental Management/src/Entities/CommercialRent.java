//HERANÇA ALUGUEL COMERCIAL

import Enum.OccupationProprietary;
import Enum.TypesRent;

public class CommercialRent extends Contract {
    // ATRIBUTOS

    private String dataInicio, dataFim;

    // METODOS ESPECIAS

    // CONSTRUCTOR
    
    public CommercialRent(Property imovel, Tenant inquilino, String dataInicio, String dataFim) {
        super(imovel, inquilino);
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }
    
    // METODOS PERSONALIZADOS
}
