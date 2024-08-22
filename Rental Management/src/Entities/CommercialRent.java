//Herança Aluguel Comercial

import Enum.StatusProperty;
import Enum.TypesRent;

public class CommercialRent extends Contract {
    // Atributos

    // Metodos especias

    public CommercialRent(int id, String dataInicio, String dataFim, double valor, TypesRent tipo,
            StatusProperty status, Property imovel, Tenant inquilino) {
        super(id, dataInicio, dataFim, valor, tipo, status, imovel, inquilino);
        // TODO Auto-generated constructor stub
    }

    // Metodos personalizados
    private double calcularDescontoResidencial() {
        return 0.0;
    }
}
