// Imóvel

import Enum.TypesRent;
import Enum.StatusProperty;

public class Property {
    // Atributos
    private int id;
    private String endereco;
    private double valorAluguel;
    private TypesRent tipo;
    private StatusProperty status;

    public Property(String endereco, double valorAluguel, TypesRent tipo, StatusProperty status) {
        this.setId(id);
        this.setEndereco(endereco);
        this.setTipo(tipo);
        this.setStatus(status);
        this.setValorAluguel(valorAluguel);
    }

    // Metodos especias
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public TypesRent getTipo() {
        return tipo;
    }

    public void setTipo(TypesRent tipo) {
        if (tipo.equals(TypesRent.COMMERCIAL)) {
            this.tipo = TypesRent.COMMERCIAL;
            System.out.println("Comercial");
        }else if(tipo.equals(TypesRent.RESIDENTIAL)){
            this.tipo = TypesRent.RESIDENTIAL;
            System.out.println("Residencial");
        }else {
            this.tipo = null;
            System.out.println("Invalido...");
        }
        this.tipo = tipo;
    }

    public StatusProperty getStatus() {
        return status;
    }

    public void setStatus(StatusProperty status) {
        if (status.equals(StatusProperty.OCUPADO)) {
            this.status = null;
            System.out.println("Ocupado");
        } else if (status.equals(StatusProperty.VAGO)) {
            this.status = status;
            System.out.println("Vago");
        } else {
            System.out.println("Invalido...");
        }
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    // Metodos personalizados
    public void calcularValorAluguel() {
        double novoValor;
        double taxa;
        if (getTipo().equals(TypesRent.COMMERCIAL)) {
            System.out.println("Valor do imovel " + getValorAluguel());
            taxa = 100.00;
            novoValor = getValorAluguel() + taxa;
            this.valorAluguel = novoValor;
            System.out.print(" + Taxa comercial: " + taxa + " Novo Valor: " + novoValor);
        }else if(getTipo().equals(TypesRent.RESIDENTIAL)){
            System.out.println("Valor do imovel " + getValorAluguel());
            taxa = 80.00;
            novoValor = getValorAluguel() + taxa;
            this.valorAluguel = novoValor;
            System.out.print(" Taxa residencial: " + taxa + " Novo Valor: " + novoValor);
        }
    }

    public void alterarTipo(TypesRent novoTipo){
        if (novoTipo.equals(TypesRent.COMMERCIAL)) {
            setTipo(TypesRent.COMMERCIAL);
        }else if(novoTipo.equals(TypesRent.RESIDENTIAL)){
            setTipo(TypesRent.RESIDENTIAL);
        }else {
            setTipo(null);
        }
    }

    public void alterarStatus(StatusProperty novoStatus) {
        if (novoStatus.equals(StatusProperty.OCUPADO)) {
            setStatus(StatusProperty.OCUPADO);
        } else if (novoStatus.equals(StatusProperty.VAGO)) {
            setStatus(StatusProperty.VAGO);
        } else {
            setStatus(null);
        }
    }

    public void imovelInfo(int id) {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.print(" | Endereço: " + this.getEndereco());
        System.out.print(" | Valor do Aluguel: " + this.getValorAluguel());
        System.out.print(" | Tipo: " + this.getTipo());
        System.out.print(" | Status: " + this.getStatus() + " |");
        System.out.println("\n-------------------------------------------------------------------------------");
    }

}
