package Entity;
// Inquilino

public class Tenant {
    // ATRIBUTOS

    private int id;
    private String name, cpf, telephone, email;
    
    // CONSTRUCTOR

    public Tenant(int id, String name, String cpf, String telephone, String email) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
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
