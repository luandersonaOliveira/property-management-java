//HERANÇA ALUGUEL COMERCIAL

public class CommercialRent extends Contract {
    // ATRIBUTOS

    private String dataInicio, dataFim;
    private int tipoComercio;

    // CONSTRUCTOR

    public CommercialRent(int imovel, int inquilino, String dataInicio, String dataFim, int tipoComercio) {
        super(imovel, inquilino);
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.tipoComercio = tipoComercio;
    }

    // METODOS ESPECIAS

    public int getTipoComercio() {
        return tipoComercio;
    }
    
    public void setTipoComercio(int tipoComercio) {
        this.tipoComercio = tipoComercio;
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
   
    public void calcularTaxaComercial(){

    }
    
}
