package Entity;
// Proprietário (Espefico de imovel)

public class Landlord {
    // ATRIBUTOS

    private int id;
    private String name, cpf, cnpj, telephone, email;

    // CONSTRUCTOR

    public Landlord(int id, String name, String cpf, String cnpj, String telephone, String email) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.telephone = telephone;
        this.email = email;
    }

    // METODOS ESPECIAS
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // METODOS PERSONALIZADOS
}
