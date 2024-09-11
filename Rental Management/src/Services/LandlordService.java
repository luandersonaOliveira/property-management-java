package Services;
// Sreviço Proprietário

import java.util.ArrayList;
import java.util.Scanner;

import Containers.LandlordRepository;
import Entity.Landlord;
import Entity.Property;
import Enum.EnumLandlordException;
import Enum.EnumPropertyException;
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
            throw new LandlordException("Erro: " + EnumLandlordException.LandlordInvalidCPF);
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
            throw new LandlordException("Erro: " + EnumLandlordException.LandlordInvalidCPF);
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
            System.out.println(
                    "\nQuais as novas informações do Proprietário deseja mudar? \n| 0.Nenhum | 1.Nome | 2.Telefone | 3.Email |");
            System.out.print("\nOpção: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Novo Nome: ");
                    String newName = scanner.nextLine();
                    landlord.setName(nameFormart(newName));
                    System.out.println("\nProprietário atualizado com sucesso!");
                    break;
                case 2:
                    System.out.print("Novo Telefone: ");
                    String newTelephone = scanner.nextLine();
                    landlord.setTelephone(telephoneFormart(newTelephone));
                    System.out.println("\nProprietário atualizado com sucesso!");
                    break;
                case 3:
                    System.out.print("Novo Email: ");
                    String newEmail = scanner.nextLine();
                    landlord.setEmail(newEmail);
                    System.out.println("\nProprietário atualizado com sucesso!");
                    break;
                default:
                    option = 0;
                    System.out.println("\nProprietário não foi atualizado!");
                    break;
            }
        }
    }

    // ATRIBUIR IMOVEL AO PROPRIETÁRIO
    public void assignPropertyToLandlord(int landlordId, Property property) throws LandlordException {
        Landlord landlord = landlordRepository.searchLandlord(landlordId);

        if (landlord == null) {
            throw new LandlordException("Erro: " + EnumLandlordException.LandlordNoRegistered);
        } else if (property == null) {
            throw new LandlordException("Erro: " + EnumPropertyException.PropertyNoRegistered);
        }

        if (property.getLandlord() != null) {
            throw new LandlordException("Erro: O imóvel já tem um proprietário associado");
        }

        landlord.setProperty(property);
        property.setLandlord(landlord);

        System.out.println(
                "Imóvel: " + property.getId() + " adicionado ao proprietário: " + landlord.getName() + " com sucesso!");
    }

    public void searchLandlord(int id) {
        Landlord landlord = landlordRepository.searchLandlord(id);
        System.out.println(landlord.getName());
        System.out.println(landlord.getId());
    }

    /*
     * public void listProperties() {
     * Property property01 =
     * createProperty("Rua Gonçalo de Carvalho – Porto Alegre (RS)", 500,
     * PropertyType.RESIDENTIAL, PropertyOccupation.UNOCCUPIED);
     * Property property02 = createProperty("Rua do Mucugê – Arraial d’Ajuda (BA)",
     * 800, PropertyType.COMMERCIAL,
     * PropertyOccupation.UNOCCUPIED);
     * Property property03 = createProperty("Rua das Pedras – Búzios (RJ)", 480,
     * PropertyType.RESIDENTIAL,
     * PropertyOccupation.UNOCCUPIED);
     * Property property04 = createProperty("Rua da Aurora – Recife (PE)", 780,
     * PropertyType.COMMERCIAL,
     * PropertyOccupation.UNOCCUPIED);
     * Property property05 = createProperty("Rua Bento Gonçalves – Erechim (RS)",
     * 550, PropertyType.RESIDENTIAL,
     * PropertyOccupation.UNOCCUPIED);
     * }
     */
}
