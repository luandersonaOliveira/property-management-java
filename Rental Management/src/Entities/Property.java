// IMOVEIS

import Enum.TypesRent;
import Enum.OccupationProprietary;

public class Property {
    // ATRIBUTOS

    private double valorAluguel;
    private int limiteVagas;
    private TypesRent tipo;
    private OccupationProprietary occupation;

    // CONSTRUCTOR

    public Property(int limiteVagas, TypesRent tipo, OccupationProprietary occupation) {
        this.setLimiteVagas(limiteVagas);
        this.setTipo(tipo);
        this.setOccupation(occupation);
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

    public TypesRent getTipo() {
        return tipo;
    }

    public void setTipo(TypesRent tipo) {
        if (tipo.equals(TypesRent.COMMERCIAL)) {
            this.tipo = TypesRent.COMMERCIAL;
            this.valorAluguel = getValorAluguel() + 100.00;
            System.out.println("| Comercial! |");
        } else if (tipo.equals(TypesRent.RESIDENTIAL)) {
            this.tipo = TypesRent.RESIDENTIAL;
            this.valorAluguel = getValorAluguel() + 50.00;
            System.out.println("| Residencial! |");
        } else {
            this.tipo = null;
            System.out.println("| Invalido! |");
        }
        this.tipo = tipo;
    }

    public OccupationProprietary getOccupation() {
        return occupation;
    }

    public void setOccupation(OccupationProprietary occupation) {
        if (occupation.equals(OccupationProprietary.OCUPADO)) {
            this.occupation = null;
            System.out.println("| Ocupado! |");
        } else if (occupation.equals(OccupationProprietary.VAGO)) {
            this.occupation = occupation;
            System.out.println("| Vago! |");
        } else {
            System.out.println("| Invalido! |");
        }
    }

    // METODOS PERSONALIZADOS

    public void calcularValorAluguel() {
        double novoValor;
        double taxa;
        if (getTipo().equals(TypesRent.COMMERCIAL)) {
            System.out.println("Valor do imovel " + getValorAluguel());
            taxa = 100.00;
            novoValor = getValorAluguel() + taxa;
            this.valorAluguel = novoValor;
            System.out.print(" + Taxa comercial: " + taxa + " \nValor Total: " + novoValor);
        } else if (getTipo().equals(TypesRent.RESIDENTIAL)) {
            System.out.println("Valor do imovel " + getValorAluguel());
            taxa = 80.00;
            novoValor = getValorAluguel() + taxa;
            this.valorAluguel = novoValor;
            System.out.print(" Taxa residencial: " + taxa + " \nValor Total: " + novoValor);
        }
    }

    public void alterarTipo(TypesRent novoTipo) {
        if (novoTipo.equals(TypesRent.COMMERCIAL)) {
            setTipo(TypesRent.COMMERCIAL);
        } else if (novoTipo.equals(TypesRent.RESIDENTIAL)) {
            setTipo(TypesRent.RESIDENTIAL);
        } else {
            setTipo(null);
        }
    }

    public void alterarStatus(OccupationProprietary novoStatus) {
        if (novoStatus.equals(OccupationProprietary.OCUPADO)) {
            setOccupation(OccupationProprietary.OCUPADO);
        } else if (novoStatus.equals(OccupationProprietary.VAGO)) {
            setOccupation(OccupationProprietary.VAGO);
        } else {
            setOccupation(null);
        }
    }

    public void alterarVagas(int limiteVagas){
        if (limiteVagas <= 0 || limiteVagas >= 200) {
            System.out.println("| Limite de vagas atingido! |");
        } else if(limiteVagas > getLimiteVagas()){
            this.limiteVagas = limiteVagas;
            System.err.println("Numero de vagas: " + getLimiteVagas());
        }
    }

    public void imovelInfo(int id) {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.print("Imovel " + id + "\n");
        System.out.print(" | Valor do Aluguel: " + this.getValorAluguel());
        System.out.print(" | Limite de Vagas: " + this.getLimiteVagas());
        System.out.print(" | Tipo: " + this.getTipo());
        System.out.print(" | Ocupação: " + this.getOccupation() + " |");
        System.out.println("\n-------------------------------------------------------------------------------");
    }

}
