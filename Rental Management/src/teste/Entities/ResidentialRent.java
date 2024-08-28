//HERANÇA ALUGUEL RESIDENCIAL

import Exceptions.PropertyException;

public class ResidentialRent extends Property {
    // ATRIBUTOS

    // CONSTRUCTOR

    public ResidentialRent(int limiteVagas, int tipo, String dataInicio) throws PropertyException {
        super(limiteVagas, tipo, dataInicio);
    }

    // METODOS ESPECIAS

    // METODOS PERSONALIZADOS

    private void calcularDescontoResidencial() {

    }

}
