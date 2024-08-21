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
        this.id = getId();
        this.endereco = endereco;
        this.tipo = tipo;
        this.status = status;
        this.valorAluguel = valorAluguel;
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
        this.tipo = tipo;
    }

    public StatusProperty getStatus() {
        return status;
    }

    public void setStatus(StatusProperty status) {
        this.status = status;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    // Metodos personalizados
    private double calcularValorAluguel() {
        return 0.0;
    }

    private void alterarStatus(String novoStatus) {

    }

}
