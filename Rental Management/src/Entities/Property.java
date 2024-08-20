// Imóvel

public class Property {
    // Atributos
    private int id;
    private String endereco, tipo, status;
    private double valorAluguel;

    public Property(int id, String endereco, String tipo, String status, double valorAluguel) {
        this.id = id;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getValorAluguel() {
        return valorAluguel;
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
