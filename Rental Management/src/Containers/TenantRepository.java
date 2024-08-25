// REPOSITÓRIO INQUILINOS

import java.util.ArrayList;
import java.util.Scanner;

public class TenantRepository implements ITenantRepository {
    public ArrayList<Tenant> tenants = new ArrayList<Tenant>();

    @Override
    public void adicionarInquilinos(Tenant tenant) {
        tenants.add(tenant);
    }

    @Override
    public void removerInquilinos(int id) {
        tenants.remove(id);
    }

    @Override
    public void listarInquilinos() {
        for (int i = 0; i < tenants.size(); i++) {
            tenants.get(i).tenantInfo(i);
        }
    }

    @Override
    public void alterarInquilinos(int id) {
        Scanner scanner = new Scanner(System.in);
        if (id < 0 || id >= tenants.size()) {
            System.out.println("Índice Inválido. Tente novamente!");
            return;
        }
        Tenant tenant = tenants.get(id);
        System.out.println("Informações do Inquilino selecionado:");
        tenant.tenantInfo(id);
        System.out.println("\nDigite as novas informações do Inquilino: ");
        System.out.print("Nome: ");
        String novoNome = scanner.nextLine();
        System.out.print("Telefone: ");
        String novoTelefone = scanner.nextLine();
        System.out.print("Saldo: ");
        double novoSaldo = scanner.nextDouble();
        tenant.setNome(novoNome);
        tenant.setTelefone(novoTelefone);
        tenant.setSaldo(novoSaldo);
        System.out.println("\nInquilino " + tenant.getNome() + " atualizado com sucesso!");
    }
}
