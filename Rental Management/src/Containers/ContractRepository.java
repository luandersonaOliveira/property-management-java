// Repositório de Contratos

import java.util.ArrayList;

public class ContractRepository {
    private ArrayList<Contract> contracts = new ArrayList<>();

    public void adicionarContratos(Contract contract){
        contracts.add(contract);
    }

    public ArrayList<Contract> listarContracts(){
        return contracts;
    }

    public Contract buscarContractsPorIndice(int index){
        if(index >=0 && index <contracts.size()){
            return contracts.get(index);
        }
        return null;
    }
}
