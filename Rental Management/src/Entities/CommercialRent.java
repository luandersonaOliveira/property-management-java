//Herança Aluguel Comercial

import java.util.Date;

import Enum.StatusProperty;
import Enum.TypesRent;

public class CommercialRent extends Contract {
    // Atributos

    // Metodos especias
    public CommercialRent(int id, Date dataInicio, Date dataFim, double valor, Property imovel,
            Tenant inquilino, TypesRent tipo, StatusProperty status) {
        super(id);
        // TODO Auto-generated constructor stub
    }

    // Metodos personalizados
    private double calcularDescontoResidencial() {
        return 0.0;
    }

}
