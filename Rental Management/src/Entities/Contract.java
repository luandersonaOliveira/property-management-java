// Contrato

import java.util.Date;

import Enum.StatusProperty;
import Enum.TypesRent;

public class Contract {
    // Atributos
    private int id;
    private Date dataInicio, dataFim;
    private double valor;
    private TypesRent tipo;
    private StatusProperty status;
    private Property imovel;
    private Tenant inquilino;

    public Contract(int id) {
        this.id = id;
        this.dataInicio = getDataInicio();
        this.dataFim = getDataFim();
        this.valor = getValor();
        this.imovel = getImovel();
        this.inquilino = getInquilino();
        this.tipo = getTipo();
        this.status = getStatus();
    }

    // Metodos especias
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Property getImovel() {
        return imovel;
    }

    public void setImovel(Property imovel) {
        this.imovel = imovel;
    }

    public Tenant getInquilino() {
        return inquilino;
    }

    public void setInquilino(Tenant inquilino) {
        this.inquilino = inquilino;
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

    // Metodos personalizados
    private double calcularValorTotal() {
        return 0.0;
    }

    private void renovarContrato(Date novaData) {

    }

}
