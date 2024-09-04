package Services;
// Sreviço Proprietário

import java.util.ArrayList;
import java.util.Scanner;

import Containers.LandlordRepository;
import Entity.Landlord;
import Entity.Property;
import Enum.EnumLandlordException;
import Exceptions.LandlordException;

public class LandlordService {
    // ATRIBUTOS
    private static final Scanner scanner = new Scanner(System.in);
    private LandlordRepository landlordRepository = new LandlordRepository();

    // CONSTRUCTOR

    public LandlordService(LandlordRepository landlordRepository) {
        this.landlordRepository = landlordRepository;
    }

    // METODOS ESPECIAS

    // METODOS PERSONALIZADOS

    // CREATE
    public void addLandlord(String name, String cpf, String telephone, String email) throws LandlordException {
        if (cpf.length() != 11) {
            throw new LandlordException("Erro: " + EnumLandlordException.LandlorInvalidCPF);
        } else if (telephone.length() != 9 && telephone.length() != 11) {
            throw new LandlordException("Erro: " + EnumLandlordException.LandlordInvalidTelephone);
        }

        Landlord landlord = createLandlord(name, cpf, telephone, email);
        if (landlord != null) {
            landlordRepository.addLandlord(landlord);
            System.out.println("\nProprietário adicionado com sucesso! ID: " + landlord.getId());
        } else {
            throw new LandlordException("Erro: " + EnumLandlordException.LandlordInvalid);
        }
    }

    public Landlord createLandlord(String name, String cpf, String telephone, String email) throws LandlordException {
        return new Landlord(nameFormart(name), cpfFormart(cpf), telephoneFormart(telephone), email);
    }

    private String nameFormart(String name) {
        String nameFormart = name.toUpperCase();
        return nameFormart;
    }

    private String cpfFormart(String cpf) throws LandlordException {
        if (cpf.length() == 11) {
            return String.format("%s.%s.%s-%s",
                    cpf.substring(0, 3),
                    cpf.substring(3, 6),
                    cpf.substring(6, 9),
                    cpf.substring(9, 11));
        } else {
            cpf = null;
            throw new LandlordException("Erro: " + EnumLandlordException.LandlorInvalidCPF);
        }
    }

    private String telephoneFormart(String telephone) throws LandlordException {
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
            throw new LandlordException("Erro: " + EnumLandlordException.LandlordInvalidTelephone);
        }
    }

    // REMOVE
    public void removeLandlord(int id) throws LandlordException {
        if (landlordRepository.landlords.isEmpty()) {
            throw new LandlordException("Erro: " + EnumLandlordException.LandlordNoRegistered);
        } else {
            landlordRepository.landlords.remove(id);
            Landlord removed = new Landlord(null, null, null, null);
            removed.setId(id);
            landlordRepository.addLandlord(removed);
            System.out.println("\nProprietário: " + id + ". Removido com sucesso!");
        }
    }

    // LIST
    public void listLandlord() throws LandlordException {
        ArrayList<Landlord> landlords = landlordRepository.listLandlord();
        if (landlords.isEmpty()) {
            throw new LandlordException("Erro: " + EnumLandlordException.LandlordNoRegistered);
        } else {
            for (int i = 0; i < landlords.size(); i++) {
                Landlord l = landlords.get(i);
                System.out.println("\n-------------------------------------------------------------------------------");
                System.out.print("Proprietário " + l.getId() + "\n");
                System.out.print(" | Nome: " + l.getName());
                System.out.print(" | CPF: " + l.getCpf());
                System.out.print("\n | Telefone: " + l.getTelephone());
                System.out.print(" | Email: " + l.getEmail() + " |");
                System.out.println("\n-------------------------------------------------------------------------------");
            }
        }
    }

    // CHANGE
    public void changeLandlord(int id) throws LandlordException {
        if (landlordRepository.landlords.isEmpty()) {
            throw new LandlordException("Erro: " + EnumLandlordException.LandlordNoRegistered);
        } else {
            if (id < 0 || id >= landlordRepository.landlords.size()) {
                throw new LandlordException("Erro: " + EnumLandlordException.LandlordInvalidIndex);
            }

            Landlord landlord = landlordRepository.landlords.get(id);
            System.out.println("\nDigite as novas informações do Inquilino: ");
            System.out.print("\nNome: ");
            String newName = scanner.nextLine();
            System.out.print("Telefone: ");
            String newTelephone = scanner.nextLine();
            System.out.print("Email: ");
            String newEmail = scanner.nextLine();

            landlord.setName(nameFormart(newName));
            landlord.setTelephone(telephoneFormart(newTelephone));
            landlord.setEmail(newEmail);
            System.out.println("\nProprietário atualizado com sucesso!");
        }
    }

    public Landlord addProperty(Property property){
        return new Landlord(null, null, null, null);
    }

    public void searchLandlord(int id){
        Landlord landlord = landlordRepository.searchLandlord(id);
        System.out.println(landlord.getName());
        System.out.println(landlord.getId());
    }
}
