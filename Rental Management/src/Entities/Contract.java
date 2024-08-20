// Contrato

import java.util.Date;
import Enum.TypesRent;

public class Contract {
    // Atributos
    private int id;
    private Date dataInicio, dataFim;
    private double valor;
    private Property imovel;
    private Tenant inquilino;
    private TypesRent tipo;

    public Contract(int id, Date dataInicio, Date dataFim, double valor, Property imovel, Tenant inquilino,
            TypesRent tipo) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valor = valor;
        this.imovel = imovel;
        this.inquilino = inquilino;
        this.tipo = tipo;
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

    // Metodos personalizados
    private double calcularValorTotal() {
        return 0.0;
    }

    private void renovarContrato(Date novaData) {

    }

}
