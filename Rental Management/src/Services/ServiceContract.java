// Sreviço Contrato

import java.util.ArrayList;
import java.util.Date;
import Enum.StatusProperty;
import Enum.TypesRent;

public class ServiceContract {
    private ContractRepository contractRepository = new ContractRepository();

    public void adicionarContratos(int id, Date dataInicio, Date dataFim, double valor, TypesRent tipo,
            StatusProperty status) {
        Contract contrato = null;

        switch (tipo) {
            case COMMERCIAL:
                contrato = new Contract(id);
                break;

            case RESIDENTIAL:
                contrato = new Contract(id);
                break;
        }
        if (contrato != null) {
            contractRepository.adicionarContratos(contrato);
            System.out.println("Contrato adicionado com sucesso!");
        }
    }

    public void listaContratos() {
        ArrayList<Contract> contratos = contractRepository.listarContracts();
        if (contratos.isEmpty()) {
            System.out.println("Nenhum Contrato Cadastrado.");
        } else {
            for (int i = 0; i < contratos.size(); i++) {
                Contract contr = contratos.get(i);
                System.err.println((i + 1) + ".id: " + contr.getId() + " Imovel: " + " Tipo: " + contr.getTipo()
                        + " Status: " + contr.getStatus() + contr.getImovel() + " Valor: " + contr.getInquilino()
                        + " Data Inicio: " + contr.getDataInicio() + " Data Fim: " + contr.getDataFim()
                        + contr.getValor() + " Inquilino ");
            }
        }
    }

    public void renovarContrato(Date dataInicio, Date dataFim) {
        if (dataInicio == null && dataFim == null) {
            System.out.println("As Datas de inicio e fim, Não foram recebidas.");
        } else {
            System.out.println("Contrato renovado em " + dataInicio + " ate " + dataFim);
        }
    }
}
