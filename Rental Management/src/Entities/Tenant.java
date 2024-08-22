// Inquilino

public class Tenant {
    // Atributos
    private int id;
    private String nome, cpf, telefone;

    public Tenant(String nome, String cpf, String telefone) {
        this.setId(id);
        this.setNome(nome);
        this.setCpf(cpf);
        this.setTelefone(telefone);
    }

    // Metoods especias
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Metodos persolizados
    private void atualizarDados(String novoTelefone) {

    }

    private void verificarHistorico() {

    }

    public void statusInfo(int id) {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.print("Usuário " + id + "\n");
        System.out.print("| Nome: " + this.getNome());
        System.out.print(" | Idade: " + this.getCpf());
        System.out.print(" | Telefone: " + this.getTelefone() + " |");
        System.out.println("\n-------------------------------------------------------------------------------");
    }

}
