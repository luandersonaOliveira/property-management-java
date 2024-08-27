//HERANÇA ALUGUEL COMERCIAL

import Exceptions.PropertyException;

public class CommercialRent extends Property {
    // ATRIBUTOS

    // CONSTRUCTOR

    public CommercialRent(int limiteVagas, int tipo, String dataInicio) throws PropertyException {
        super(limiteVagas, tipo, dataInicio);
    }

    // METODOS ESPECIAS

    // METODOS PERSONALIZADOS

    private void calcularTaxaComercial() {

    }

}
