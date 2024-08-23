//HERANÇA ALUGUEL COMERCIAL

import Enum.OccupationProprietary;
import Enum.TypesRent;

public class CommercialRent extends Contract {
    // ATRIBUTOS

    // METODOS ESPECIAS

    // CONSTRUCTOR

    public CommercialRent(TypesRent tipo, OccupationProprietary status, Property imovel, Tenant inquilino) {
        super(tipo, status, imovel, inquilino);
        //TODO Auto-generated constructor stub
    }

    // METODOS PERSONALIZADOS
    
    private double calcularDescontoResidencial() {
        return 0.0;
    }
}
