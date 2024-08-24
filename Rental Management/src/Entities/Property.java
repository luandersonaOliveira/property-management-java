// IMOVEIS

import Enum.TypesRent;
import Enum.OccupationProprietary;

public class Property {
    // ATRIBUTOS

    private double valorAluguel;
    private int limiteVagas, tipo, ocupacao;
    private TypesRent typesRent;
    private OccupationProprietary oProprietary;

    // CONSTRUCTOR

    public Property(int limiteVagas, int tipo, int ocupacao) {
        this.setLimiteVagas(limiteVagas);
        this.setTipo(tipo);
        this.setOcupacao(ocupacao);
    }

    // METODOS ESPECIAS

    public double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public int getLimiteVagas() {
        return limiteVagas;
    }

    public void setLimiteVagas(int limiteVagas) {
        this.limiteVagas = limiteVagas;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        if (tipo == 1) {
            this.tipo = tipo;
            this.typesRent = TypesRent.COMMERCIAL;
            this.valorAluguel = valorAluguel + getValorAluguel() + 100;
        } else if (tipo == 2) {
            this.tipo = tipo;
            this.typesRent = TypesRent.RESIDENTIAL;
            this.valorAluguel = valorAluguel + getValorAluguel() + 80;
        } else {
            this.tipo = tipo;
            this.typesRent = null;
        }
    }

    public int getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(int ocupacao) {
        if (ocupacao == 1) {
            this.ocupacao = ocupacao;
            this.oProprietary = OccupationProprietary.VAGO;
        } else if (ocupacao == 2) {
            this.ocupacao = ocupacao;
            this.oProprietary = OccupationProprietary.OCUPADO;
        } else {
            this.ocupacao = ocupacao;
            this.oProprietary = null;
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

    public void calcularValorAluguel() {
        
    }

    public void alterarTipo(int novoTipo) {
        if (novoTipo == 1) {
            setTipo(novoTipo);
        } else if (novoTipo == 2) {
            setTipo(novoTipo);
        } else {
            setTipo(novoTipo);
        }
    }

    public void alterarStatus(int novoStatus) {
        if (novoStatus == 1) {
            setOcupacao(novoStatus);
        } else if (novoStatus == 2) {
            setOcupacao(novoStatus);
        } else {
            setOcupacao(novoStatus);
        }
    }

    public void alterarVagas(int limiteVagas) {
        if (limiteVagas <= 0 || limiteVagas >= 200) {
            System.out.println("| Limite de vagas atingido! |");
        } else if (limiteVagas > getLimiteVagas()) {
            this.limiteVagas = limiteVagas;
            System.err.println("Numero de vagas: " + getLimiteVagas());
        }
    }

    public void imovelInfo(int id) {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.print("Imovel " + id + "\n");
        System.out.print(" | Valor do Aluguel: " + this.getValorAluguel());
        System.out.print(" | Limite de Vagas: " + this.getLimiteVagas());
        System.out.print(" | Tipo: " + this.getTypesRent());
        System.out.print(" | Ocupação: " + this.getoProprietary() + " |");
        System.out.println("\n-------------------------------------------------------------------------------");
    }

}
