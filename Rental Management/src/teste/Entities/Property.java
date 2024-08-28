// IMOVEIS

import Enum.TypesRent;
import Exceptions.PropertyException;
import Enum.OccupationProprietary;

import java.util.ArrayList;

public class Property {
    // ATRIBUTOS
    public ArrayList<Contract> contract;
    private static final int maxVagas = 200;
    private int limiteVagas, tipo, ocupacao;
    private String data;
    private TypesRent typesRent;
    private OccupationProprietary oProprietary;

    // CONSTRUCTOR

    public Property(int limiteVagas, int tipo, String data) throws PropertyException {
        this.setLimiteVagas(limiteVagas);
        this.setTipo(tipo);
        this.setOcupacao(1);
        this.setData(data);
        this.contract = new ArrayList<>();
    }

    // METODOS ESPECIAS

    public int getLimiteVagas() {
        return limiteVagas;
    }

    public void setLimiteVagas(int limiteVagas) throws PropertyException {
        if (limiteVagas <= 0) {
            this.limiteVagas = 0;
            setOcupacao(0);
            throw new PropertyException("Número de vagas deve ser maior que zero.");
        } else if (limiteVagas >= maxVagas) {
            this.limiteVagas = maxVagas;
            setOcupacao(2);
            throw new PropertyException("Limite de vagas excedido.");
        } else if (limiteVagas > 0 && limiteVagas <= maxVagas) {
            this.limiteVagas = limiteVagas;
        }
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) throws PropertyException {
        if (tipo == 1) {
            if (getLimiteVagas() <= 0 || getLimiteVagas() > maxVagas) {
                this.tipo = 0;
                setOcupacao(0);
                setTypesRent(TypesRent.NENHUM);
            } else {
                this.tipo = 1;
                setTypesRent(TypesRent.COMMERCIAL);
            }
        } else if (tipo == 2) {
            if (getLimiteVagas() <= 0 || getLimiteVagas() > maxVagas) {
                this.tipo = 0;
                setOcupacao(0);
                setTypesRent(TypesRent.NENHUM);
            } else {
                this.tipo = 2;
                setTypesRent(TypesRent.RESIDENTIAL);
            }
        } else {
            this.tipo = 0;
            setOcupacao(0);
            setTypesRent(TypesRent.NENHUM);
            throw new PropertyException("Tipo inválido. Deve ser 1 (comercial) ou 2 (residencial).");
        }
    }

    public int getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(int ocupacao) {
        if (ocupacao == 1) {
            this.ocupacao = 1;
            setoProprietary(OccupationProprietary.VAGO);
        } else if (ocupacao == 2) {
            this.ocupacao = 2;
            setoProprietary(OccupationProprietary.OCUPADO);
        } else if (ocupacao <= 0 || ocupacao > 2) {
            this.ocupacao = 0;
            setoProprietary(OccupationProprietary.NENHUM);
        }
    }

    public TypesRent getTypesRent() {
        return typesRent;
    }

    public void setTypesRent(TypesRent typesRent) {
        this.typesRent = typesRent;
    }

    public OccupationProprietary getoProprietary() {
        return oProprietary;
    }

    public void setoProprietary(OccupationProprietary oProprietary) {
        this.oProprietary = oProprietary;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        String dataFormatada = formatarData(data);
        if (dataFormatada != null) {
            this.data = dataFormatada;
        } else {
            this.data = null;
        }
    }

    // METODOS PERSONALIZADOS

    public void imovelInfo(int id) {
        System.out.println("\n-------------------------------------------------------------------------------");
        System.out.print("Imovel " + id + "\n");
        System.out.print(" | Data: " + this.getData());
        System.out.print(" | Limite de Vagas: " + this.getLimiteVagas());
        System.out.print(" | Tipo: " + this.getTypesRent());
        System.out.print(" | Ocupação: " + this.getoProprietary() + " |");
        System.out.println("\n-------------------------------------------------------------------------------");
    }

    private String formatarData(String data) {
        if (data.length() == 8) {
            String dia = data.substring(0, 2);
            String mes = data.substring(2, 4);
            String ano = data.substring(4);
            return dia + "/" + mes + "/" + ano;
        } else {
            System.out.println("| Data inválida! O formato deve ser Dia/Mês/Ano. |");
            return null;
        }
    }

    public void adicionarInquilinos(int idInquilino, Tenant tenant) throws PropertyException {
        if (contract.contains(tenant)) {
            System.out.println(tenant.getNome() + " já está cadastrado em " + getTypesRent());
        } else {
            if (isPropertyVacant()) {
                // Propriedade está vaga
                setTipo(getTipo()); // Não tenho certeza sobre essa linha; você pode revisar se é necessária
                setLimiteVagas(getLimiteVagas() - 1);
                exibirInformacoesImovel();
                tenant.tenantInfo(idInquilino);
            } else {
                // Propriedade está ocupada
                setTipo(getTipo()); // Novamente, revise essa linha se necessário
                setLimiteVagas(0);
            }
        }
    }

    private boolean isPropertyVacant() {
        return getOcupacao() == 1;
    }

    private void exibirInformacoesImovel() {
        System.out.println("\n-------------------------------------------------------------------------------");
        System.out.print("Imóvel\n");
        System.out.print(" | Data: " + this.getData());
        System.out.print(" | Limite de Vagas: " + this.getLimiteVagas());
        System.out.print(" | Tipo: " + this.getTypesRent());
        System.out.print(" | Ocupação: " + this.getoProprietary() + " |");
        System.out.println("\n-------------------------------------------------------------------------------");
    }
}
