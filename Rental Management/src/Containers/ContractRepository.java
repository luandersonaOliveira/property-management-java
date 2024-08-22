// Repositório de Contratos

import java.util.ArrayList;

public class ContractRepository implements IContractRepository {
    private ArrayList<Contract> contracts = new ArrayList<>();

    @Override
    public void adicionarContrato(Contract contrato) {
        contracts.add(contrato);
    }

    @Override
    public void removerContrato(int id) {
        contracts.remove(id);
    }

    @Override
    public Contract buscarContrato(int id) {
        if (id >= 0 && id < contracts.size()) {
            return contracts.get(id);
        }
        return null;
    }

    @Override
    public void listarContrato() {
        for (int i = 0; i < contracts.size(); i++) {
            contracts.get(i).contratoInfo(i);
        }
    }

    @Override
    public void alterarContrato() {
        throw new UnsupportedOperationException("Unimplemented method 'alterarContrato'");
    }
}
