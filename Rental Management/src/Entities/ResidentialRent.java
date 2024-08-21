//Herança Aluguel Residencial

import java.util.Date;

import Enum.StatusProperty;
import Enum.TypesRent;

public class ResidentialRent extends Contract {
    // Atributos

    // Metodos especias

    public ResidentialRent(int id, Date dataInicio, Date dataFim, double valor, Property imovel,
            Tenant inquilino, TypesRent tipo, StatusProperty status) {
        super(id);
        // TODO Auto-generated constructor stub
    }

    // Metodos persolizados
    private double calcularTaxaComercial() {
        return 0.0;
    }
}
