package Services;
// Sreviço Inquilino

import java.util.Scanner;
import java.util.ArrayList;

import Containers.TenantRepository;
import Entity.Tenant;
import Exceptions.TenantException;

public class TenantService {
    // ATRIBUTOS
    private static final Scanner scanner = new Scanner(System.in);
    private TenantRepository tenantRepository = new TenantRepository();

    // CONSTRUCTOR

    public TenantService(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    // METODOS ESPECIAS

    // METODOS PERSONALIZADOS

    // CREATE
    public void addTenant(String name, String cpf, String telephone, String email, double balance)
            throws TenantException {
        if (cpf.length() != 11) {
            throw new TenantException("| CPF Inválido! Deve conter 11 digitos. |");
        } else if (telephone.length() != 9 && telephone.length() != 11) {
            throw new TenantException("| Telefone Inválido! Deve conter 9 a 11 digitos. |");
        } else if (balance < 0) {
            throw new TenantException("| Saldo Inválido! Não pode ser negativo. |");
        }

        Tenant tenant = createTenant(name, cpf, telephone, email, balance);
        if (tenant != null) {
            tenantRepository.addTenant(tenant);
            System.out.println("\nInquilino adicionado com sucesso!");
        } else {
            throw new TenantException("| Inquilino Inválido! |");
        }
    }

    private Tenant createTenant(String name, String cpf, String telephone, String email, double balance) {
        return new Tenant(nameFormart(name), cpfFormart(cpf), telephoneFormart(telephone), email, balance);
    }

    private String nameFormart(String name) {
        String nameFormart = name.toUpperCase();
        return nameFormart;
    }

    private String cpfFormart(String cpf) {
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

    private String telephoneFormart(String telephone) {
        if (telephone.length() == 9) {
            return String.format("%s-%s",
                    telephone.substring(0, 5),
                    telephone.substring(5, 9));
        } else if (telephone.length() == 11) {
            return String.format("(%s) %s-%s",
                    telephone.substring(0, 2),
                    telephone.substring(2, 7),
                    telephone.substring(7, 11));
        } else {
            System.out.println("\n| Telefone inválido, número de dígitos incorreto! |");
            return null;
        }
    }

    // REMOVE
    public void removeTenant(int id) {
        if (tenantRepository.tenants.isEmpty()) {
            System.out.println("\n| Nenhum Inquilino cadastrado! |");
        } else {
            tenantRepository.tenants.remove(id);
            System.out.println("\nInquilino: " + id + ". Removido com sucesso!");
        }
    }

    // LIST
    public void listTenant() {
        ArrayList<Tenant> tenants = tenantRepository.listTenant();
        if (tenants.isEmpty()) {
            System.out.println("\n| Nenhum Inquilino cadastrado! |");
        } else {
            for (int i = 0; i < tenants.size(); i++) {
                Tenant t = tenants.get(i);
                t.setId(i);
                System.out.println("\n-------------------------------------------------------------------------------");
                System.out.print("Inquilino " + t.getId() + "\n");
                System.out.print(" | Nome: " + t.getName());
                System.out.print(" | CPF: " + t.getCpf());
                System.out.print("\n | Telefone: " + t.getTelephone());
                System.out.print(" | Email: " + t.getEmail());
                System.out.print(" | Saldo: " + t.getBalance() + " |");
                System.out.println("\n-------------------------------------------------------------------------------");
            }
        }
    }

    // CHANGE
    public void changeTenant(int id) {
        if (tenantRepository.tenants.isEmpty()) {
            System.out.println("\n| Nenhum Inquilino cadastrado! |");
        } else {
            if (id < 0 || id >= tenantRepository.tenants.size()) {
                System.out.println("Índice Inválido. Tente novamente!");
                return;
            }

            Tenant tenant = tenantRepository.tenants.get(id);
            System.out.println("\nDigite as novas informações do Inquilino: ");
            System.out.print("\nNome: ");
            String newName = scanner.nextLine();
            System.out.print("Telefone: ");
            String newTelephone = scanner.nextLine();
            System.out.print("Email: ");
            String newEmail = scanner.nextLine();
            System.out.print("Saldo: ");
            double newBalance = scanner.nextDouble();

            tenant.setName(nameFormart(newName));
            tenant.setTelephone(telephoneFormart(newTelephone));
            tenant.setEmail(newEmail);
            tenant.setBalance(newBalance);
            System.out.println("\nInquilino atualizado com sucesso!");
        }
    }
}
