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
        String cpfFormatado = formatarCpf(cpf);
        if (cpfFormatado != null) {
            this.cpf = cpfFormatado;
        } else {
            this.cpf = null;
        }
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        String telefoneFormatado = formatarTelefone(telefone);
        if (telefoneFormatado != null) {
            this.telefone = telefoneFormatado;
        } else {
            this.telefone = null;
        }
    }

    // METODOS PERSONALIZADOS

    private String formatarCpf(String cpf) {
        if (cpf.length() == 11) {
            return String.format("%s.%s.%s-%s",
                    cpf.substring(0, 3),
                    cpf.substring(3, 6),
                    cpf.substring(6, 9),
                    cpf.substring(9, 11));
        } else {
            System.out.println("| CPF inválido, número de dígitos incorreto! |");
            return null;
        }
    }

    private String formatarTelefone(String telefone) {
        if (telefone.length() == 9) {
            return String.format("%s-%s",
                    telefone.substring(0, 5),
                    telefone.substring(5, 9));
        } else if (telefone.length() == 11) {
            return String.format("(%s) %s-%s",
                    telefone.substring(0, 2),
                    telefone.substring(2, 7),
                    telefone.substring(7, 11));
        } else {
            System.out.println("\n| Telefone inválido, número de dígitos incorreto! |");
            return null;
        }
    }

    private void verificarHistorico() {

    }

    public void tenantInfo(int id) {
        System.out.println("\n-------------------------------------------------------------------------------");
        System.out.print("Inquilino " + id + "\n");
        System.out.print(" | Nome: " + this.getNome());
        System.out.print(" | CPF: " + this.getCpf());
        System.out.print(" | Telefone: " + this.getTelefone() + " |");
        System.out.println("\n-------------------------------------------------------------------------------");
    }

}
