// IMOVEIS

import Enum.TypesRent;
import Enum.OccupationProprietary;

public class Property {
    // ATRIBUTOS

    private int limiteVagas, tipo, ocupacao;
    private TypesRent typesRent;
    private OccupationProprietary oProprietary;

    // CONSTRUCTOR

    public Property(int limiteVagas, int tipo) {
        this.setLimiteVagas(limiteVagas);
        this.setTipo(tipo);
        this.setOcupacao(1);
    }

    // METODOS ESPECIAS

    public int getLimiteVagas() {
        return limiteVagas;
    }

    public void setLimiteVagas(int limiteVagas) {
        int maxVagas = 200;
        if (limiteVagas <= 0) {
            this.limiteVagas = 0;
            System.out.println("\n| Número de vagas inferior ou igual a zero! |");
        } else if (limiteVagas >= maxVagas) {
            this.limiteVagas = maxVagas;
            System.out.println("\n| Limite de vagas atingido. Limite máximo foi adicionado! |");
        } else if (limiteVagas > 0 && limiteVagas <= maxVagas) {
            this.limiteVagas = limiteVagas;
        }
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        if (tipo == 1) {
            if (getLimiteVagas() <= 0 || getLimiteVagas() > 200) {
                this.tipo = 0;
                setOcupacao(0);
                setTypesRent(TypesRent.NENHUM);
            } else {
                this.tipo = 1;
                setTypesRent(TypesRent.COMMERCIAL);
            }
        } else if (tipo == 2) {
            if (getLimiteVagas() <= 0 || getLimiteVagas() > 200) {
                this.tipo = 0;
                setOcupacao(0);
                setTypesRent(TypesRent.NENHUM);
            } else {
                this.tipo = 2;
                setTypesRent(TypesRent.RESIDENTIAL);
            }
        } else if (tipo <= 0 || tipo > 2) {
            this.tipo = 0;
            setOcupacao(0);
            setTypesRent(TypesRent.NENHUM);
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

    // METODOS PERSONALIZADOS

    public void alterarTipo(int novoTipo) {
        if (novoTipo == 1) {
            setTipo(novoTipo);
        } else if (novoTipo == 2) {
            setTipo(novoTipo);
        } else {
            setTipo(novoTipo);
        }
    }

    public void alterarOcupacao(int novoStatus) {
        if (novoStatus == 1) {
            setOcupacao(novoStatus);
        } else if (novoStatus == 2) {
            setOcupacao(novoStatus);
        } else {
            setOcupacao(novoStatus);
        }
    }

    public void alterarVagas(int limiteVagas) {

    }

    public void imovelInfo(int id) {
        System.out.println("\n-------------------------------------------------------------------------------");
        System.out.print("Imovel " + id + "\n");
        System.out.print(" | Valor do Aluguel: ");
        System.out.print(" | Limite de Vagas: " + this.getLimiteVagas());
        System.out.print(" | Tipo: " + this.getTypesRent());
        System.out.print(" | Ocupação: " + this.getoProprietary() + " |");
        System.out.println("\n-------------------------------------------------------------------------------");
    }

}
