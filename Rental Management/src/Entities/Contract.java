// CONTRATOS

import java.util.ArrayList;

public class Contract {
    // ATRIBUTOS

    private int imovel, inquilino;

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

    // METODOS PERSONALIZADOS

    private void renovarContrato(String novaData) {

    }

    public void contractInfo(int id) {
        System.out.println("\n-------------------------------------------------------------------------");
        System.out.println("Contrato: " + id);
        System.out.print("Imovel: " + getImovel() + " | ");
        System.out.print("Inquilino: " + getInquilino() + " |\n");
        System.out.println("\n-------------------------------------------------------------------------");
    }

    public void cadastrarInquilinoNoImovel(Tenant tenant, Property property, int idInquilino) {
        if (tenant != null && property != null) {
            property.adicionarInquilinos(idInquilino, tenant);
            System.out.println("Inquilino cadastrado com sucesso no imóvel!");
        } else {
            System.out.println("Erro: Inquilino ou imóvel não podem ser nulos.");
        }
    }

}
