// INQUILINOS

public class Tenant {
    // ATRIBUTOS

    private String nome, cpf, telefone;

    // CONSTRUCTOR

    public Tenant(String nome, String cpf, String telefone) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.setTelefone(telefone);
    }

    // METODOS ESPECIAS

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf.length() > 11 || cpf.length() < 11) {
            this.cpf = null;
            System.out.println("| CPF invalido, Número de digitos incorreto! |");
        } else {
            this.cpf = cpf;
        }
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone.length() < 9 || telefone.length() > 13) {
            this.telefone = null;
            System.out.println("\n| Telefone invalido, Número de digitos incorreto! |\n");
        } else {
            this.telefone = telefone;
        }
    }

    // METODOS PERSONALIZADOS

    private void verificarHistorico() {

    }

    public void tenantInfo(int id) {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.print("Inquilino " + id + "\n");
        System.out.print(" | Nome: " + this.getNome());
        System.out.print(" | CPF: " + this.getCpf());
        System.out.print(" | Telefone: " + this.getTelefone() + " |");
        System.out.println("\n-------------------------------------------------------------------------------");
    }

}
