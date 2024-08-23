// REPOSITÓRIO CONTRATOS

import java.util.ArrayList;

public class ContractRepository implements IContractRepository {
    private ArrayList<Contract> contracts = new ArrayList<Contract>();

    @Override
    public void adicionarContratos(Contract contract) {
        contracts.add(contract);
    }

    @Override
    public void removerContratos(int id) {
        contracts.remove(id);
    }

    @Override
    public void listarContratos() {
        for (int i = 0; i < contracts.size(); i++) {
            contracts.get(i).contractInfo(i);
        }
    }

    @Override
    public void alterarContratos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alterarContrato'");
    }
}
