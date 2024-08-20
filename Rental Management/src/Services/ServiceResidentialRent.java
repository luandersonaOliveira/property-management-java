// Serviço Aluguel Residencial

import java.util.Date;

import Enum.TypesRent;

public class ServiceResidentialRent extends Contract {
    // Atributos

    // Metodos especias

    public ServiceResidentialRent(int id, Date dataInicio, Date dataFim, double valor, Property imovel,
            Tenant inquilino, TypesRent tipo) {
        super(id, dataInicio, dataFim, valor, imovel, inquilino, TypesRent.RESIDENTIAL);
        // TODO Auto-generated constructor stub
    }

    // Metodos persolizados
    private double calcularTaxaComercial() {
        return 0.0;
    }
}
