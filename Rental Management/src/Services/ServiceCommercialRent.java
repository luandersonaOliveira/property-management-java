// Serviço Aluguel Comercial

import java.util.Date;

import Enum.TypesRent;

public class ServiceCommercialRent extends Contract {
    // Atributos

    // Metodos especias
    public ServiceCommercialRent(int id, Date dataInicio, Date dataFim, double valor, Property imovel,
            Tenant inquilino) {
        super(id, dataInicio, dataFim, valor, imovel, inquilino, TypesRent.COMMERCIAL);
        // TODO Auto-generated constructor stub
    }

    // Metodos personalizados
    private double calcularDescontoResidencial() {
        return 0.0;
    }

}
