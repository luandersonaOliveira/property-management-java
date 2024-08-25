// CONTRATOS

import java.util.ArrayList;

public class Contract {
    // ATRIBUTOS

    private int imovel, inquilino;
    private double valor;
    private String dataInicio, dataFim;

    // CONSTRUCTOR

    public Contract(int imovel, int inquilino) {
        this.setImovel(imovel);
        this.setInquilino(inquilino);
    }

    // METODOS ESPECIAS

    public int getImovel() {
        return imovel;
    }

    public void setImovel(int imovel) {
        this.imovel = imovel;
    }

    public int getInquilino() {
        return inquilino;
    }

    public void setInquilino(int inquilino) {
        this.inquilino = inquilino;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
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

    // METODOS PERSONALIZADOS

    private void renovarContrato(String novaData) {

    }


    public void contractInfo(int id) {
        System.out.println("\n-------------------------------------------------------------------------");
        System.out.println("Contrato: " + id);
        System.out.print("Imovel: " + this.getImovel() + " | ");
        System.out.print("Inquilino: " + this.getInquilino() + " |\n");
        System.out.println("\n-------------------------------------------------------------------------");
    }

    public void cadastrarInquilinoNoImovel(Tenant tenant, Property property, int idInquilino) {
        
    }

}
