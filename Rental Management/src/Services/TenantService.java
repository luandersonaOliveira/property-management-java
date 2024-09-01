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

    public void addTenant(String name, String cpf, String telephone, String email, double balance)
            throws TenantException {
        if (cpf != null) {
            throw new TenantException("| CPF Inválido! Deve conter 11 digitos. |");
        }

        Tenant tenant = createTenant(name, cpf, telephone, email, balance);
        if (tenant != null) {
            tenantRepository.addTenant(tenant);
            System.out.println("\nInquilino adicionado com sucesso!");
        } else {
            throw new TenantException("| Telefone Inválido! Deve conter 9 ou 11 digitos. |");
        }
    }

    private Tenant createTenant(String name, String cpf, String telephone, String email, double balance) {
        cpf(cpf);
        telephone(telephone);
        balance(balance);
        return new Tenant(name, cpf, telephone, email, balance);

    }

    private void cpf(String cpf) {
        String formatCpf = cpfFormart(cpf);
        if (formatCpf != null) {
            cpf = formatCpf;
        } else {
            cpf = null;
        }
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

    private void telephone(String telephone) {
        String formartTelephone = telephoneFormart(telephone);
        if (formartTelephone != null) {
            telephone = formartTelephone;
        } else {
            telephone = null;
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

    private void balance(double balance) {
        if (balance < 0) {
            balance = 0;
        }
    }

    public void listTenant() {
        ArrayList<Tenant> tenants = tenantRepository.listTenant();
        if (tenants.isEmpty()) {
            System.out.println("\n| Nenhum Inquilino cadastrado! |");
        } else {
            for (int i = 0; i < tenants.size(); i++) {
                Tenant t = tenants.get(i);
                t.setId(i);
                System.out.println("\n-------------------------------------------------------------------------------");
                System.out.print("Tenant " + t.getId() + "\n");
                System.out.print(" | Name: " + t.getName());
                System.out.print(" | CPF: " + t.getCpf());
                System.out.print("\n | Telephone: " + t.getTelephone());
                System.out.print(" | Email: " + t.getEmail());
                System.out.print(" | Balance: " + t.getBalance() + " |");
                System.out.println("\n-------------------------------------------------------------------------------");
            }
        }
    }
}
