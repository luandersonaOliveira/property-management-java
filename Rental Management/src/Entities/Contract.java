// Contrato

import java.util.Date;
import java.util.ArrayList;
import Enum.StatusProperty;
import Enum.TypesRent;

public class Contract {
    // Atributos
    private int id;
    private String dataInicio, dataFim;
    private double valor;
    private int limiteVagas;
    private TypesRent tipo;
    private StatusProperty status;
    private ArrayList<Property> imovel;
    private ArrayList<Tenant> inquilino;

    public Contract(int id, String dataInicio, String dataFim, double valor, int limiteVagas, TypesRent tipo,
            StatusProperty status,
            Property imovel, Tenant inquilino) {
        this.setId(id);
        this.setDataInicio(dataInicio);
        this.setDataFim(dataFim);
        this.setValor(valor);
        this.setLimiteVagas(limiteVagas);
        this.setTipo(tipo);
        this.setStatus(status);
        this.imovel = new ArrayList<>();
        this.inquilino = new ArrayList<>(this.getLimiteVagas());
    }

    // Metodos especias
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
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

    public int getLimiteVagas() {
        return limiteVagas;
    }

    public void setLimiteVagas(int limiteVagas) {
        this.limiteVagas = limiteVagas;
    }

    // Metodos personalizados
    private double calcularValorTotal() {
        return 0.0;
    }

    private void renovarContrato(Date novaData) {

    }

    public void contratoInfo(int id) {
        System.out.println("Id Contrato: " + id + ": ");
        System.out.print("Data de Inicio: " + this.getDataInicio() + "Data Finalizada: " + getDataFim() + " | ");
        System.out.print("Valor: " + this.getValor() + " | ");
        System.out.print("Limite de Vagas: " + this.getLimiteVagas() + " | ");
        System.out.print("Tipo: " + this.getTipo() + " | ");
        System.out.print("Status: " + this.getStatus() + " | ");
        System.out.print("Imovel: " + imovel + " | ");
        System.out.print("Inquilino: " + inquilino + " |\n");
        System.out.println("-------------------------------------------------------------------------");
    }

}
