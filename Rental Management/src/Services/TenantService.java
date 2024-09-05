package Services;
// Sreviço Inquilino

import java.util.ArrayList;
import java.util.Scanner;

import Containers.TenantRepository;
import Entity.Tenant;
import Enum.EnumTenantException;
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
            throw new TenantException("Erro: " + EnumTenantException.TenantInvalidCPF);
        } else if (telephone.length() != 9 && telephone.length() != 11) {
            throw new TenantException("Erro: " + EnumTenantException.TenantInvalidTelephone);
        } else if (balance < 0) {
            throw new TenantException("Erro: " + EnumTenantException.TenantInvalidBalance);
        }

        Tenant tenant = createTenant(name, cpf, telephone, email, balance);
        if (tenant != null) {
            tenantRepository.addTenant(tenant);
            System.out.println("\nInquilino adicionado com sucesso! ID: " + tenant.getId());
        } else {
            throw new TenantException("Erro: " + EnumTenantException.TenantInvalid);
        }
    }

    private Tenant createTenant(String name, String cpf, String telephone, String email, double balance)
            throws TenantException {
        return new Tenant(nameFormart(name), cpfFormart(cpf), telephoneFormart(telephone), email, balance);
    }

    private String nameFormart(String name) {
        String nameFormart = name.toUpperCase();
        return nameFormart;
    }

    private String cpfFormart(String cpf) throws TenantException {
        validarCPF(cpf);
        if (cpf.length() == 11) {
            return String.format("%s.%s.%s-%s",
                    cpf.substring(0, 3),
                    cpf.substring(3, 6),
                    cpf.substring(6, 9),
                    cpf.substring(9, 11));
        } else {
            cpf = null;
            throw new TenantException("Erro: " + EnumTenantException.TenantInvalidCPF);
        }
    }

    public static String validarCPF(String cpf) {
        while (true) {
            String CPF = cpf.trim();
            if (CPF.length() != 11 || CPF.contains(" ") || CPF.isBlank() || CPF.isEmpty()) {
                System.out.print("\nCPF inválido, tente novamente: ");
                return null;
            } else {
                for (int i = 0; i < CPF.length(); i++) {
                    if (!Character.isDigit(CPF.charAt(i))) {
                        return null;
                    }
                }
                return CPF;
            }
        }
    }

    private String telephoneFormart(String telephone) throws TenantException {
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
            telephone = null;
            throw new TenantException("Erro: " + EnumTenantException.TenantInvalidTelephone);
        }
    }

    // REMOVE
    public void removeTenant(int id) throws TenantException {
        if (tenantRepository.tenants.isEmpty()) {
            throw new TenantException("Erro: " + EnumTenantException.TenantNoRegistered);
        } else {
            tenantRepository.tenants.remove(id);
            Tenant removed = new Tenant(null, null, null, null, 0);
            removed.setId(id);
            tenantRepository.addTenant(removed);
            System.out.println("\nInquilino: " + id + ". Removido com sucesso!");
        }
    }

    // LIST
    public void listTenant() throws TenantException {
        ArrayList<Tenant> tenants = tenantRepository.listTenant();
        if (tenants.isEmpty()) {
            throw new TenantException("Erro: " + EnumTenantException.TenantNoRegistered);
        } else {
            for (int i = 0; i < tenants.size(); i++) {
                Tenant t = tenants.get(i);
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
    public void changeTenant(int id) throws TenantException {
        if (tenantRepository.tenants.isEmpty()) {
            throw new TenantException("Erro: " + EnumTenantException.TenantNoRegistered);
        } else {
            if (id < 0 || id >= tenantRepository.tenants.size()) {
                throw new TenantException("Erro: " + EnumTenantException.TenantInvalidIndex);
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

    public void searchTenant(int id) {
        Tenant tenant = tenantRepository.searchTenant(id);
        System.out.println(tenant.getName());
        System.out.println(tenant.getId());
    }

}
