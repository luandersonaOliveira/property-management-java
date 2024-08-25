// REPOSITÓRIO CONTRATOS

import java.util.ArrayList;

public class ContractRepository implements IContractRepository {
    public ArrayList<Contract> contracts = new ArrayList<Contract>();

    @Override
    public void adicionarContratos(Contract contract) {
        contracts.add(contract);
    }

    @Override
    public void removerContratos(int id) {
        if (id < 0 || id >= contracts.size()) {
            System.out.println("Índice inválido. Tente novamente!");
            return;
        }
        Contract contract = contracts.get(id);
        contract.contractInfo(id);
        contracts.remove(id);
        System.out.println("\nContrato " + id + " deletado com sucesso!");
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
