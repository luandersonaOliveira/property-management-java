//Herança Aluguel Residencial

import Enum.StatusProperty;
import Enum.TypesRent;

public class ResidentialRent extends Contract {
    // Atributos

    // Metodos especias

    public ResidentialRent(int id, String dataInicio, String dataFim, double valor, TypesRent tipo,
            StatusProperty status, Property imovel, Tenant inquilino) {
        super(id, dataInicio, dataFim, valor, tipo, status, imovel, inquilino);
        // TODO Auto-generated constructor stub
    }

    // Metodos persolizados
    private double calcularTaxaComercial() {
        return 0.0;
    }
}
