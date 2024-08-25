//HERANÇA ALUGUEL RESIDENCIAL

public class ResidentialRent extends Contract {
    // ATRIBUTOS

    private int tipoResidencia;
    private String dataInicio, dataFim;

    // CONSTRUCTOR

    public ResidentialRent(int imovel, int inquilino, int tipoResidencia, String dataInicio, String dataFim) {
        super(imovel, inquilino);
        this.tipoResidencia = tipoResidencia;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    // METODOS ESPECIAS

    public int getTipoResidencia() {
        return tipoResidencia;
    }

    public void setTipoResidencia(int tipoResidencia) {
        this.tipoResidencia = tipoResidencia;
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

    public void calcularDescontoResidencial() {

    }

}
