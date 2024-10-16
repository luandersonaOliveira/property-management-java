package services;
// Serviço Contrato

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Enum.EnumLandlordException;
import Enum.EnumLeaseException;
import Enum.EnumPropertyException;
import Enum.PropertyOccupation;
import containers.LeaseRepository;
import containers.StackRepository;
import dao.DAO;
import entity.Landlord;
import entity.Lease;
import entity.Property;
import entity.Tenant;
import exceptions.LeaseException;
import utils.DatetimeExtensions;

public class LeaseService {
	// ATTRIBUTES

	private static final Scanner scanner = new Scanner(System.in);
	private LeaseRepository leaseRepository = new LeaseRepository(new ArrayList<>());

	// CONSTRUCTOR

	public LeaseService(LeaseRepository leaseRepository) {
		this.leaseRepository = leaseRepository;
	}

	// METHODS PERSONALIZED

	// CREATE
	public void addLease(String startDate, String endDate, Landlord landlord, Property property, Tenant tenant)
			throws LeaseException, ParseException {
		if (landlord == null || property == null || tenant == null) {
			throw new LeaseException("Erro: " + EnumLeaseException.LeaseNoRegistered);
		} else if (property.getCpfLandlord() == null) {
			throw new LeaseException("Erro: " + EnumLeaseException.LandlordNotAddedToProperty);
		} else if (startDate.equals(null) || endDate.equals(null)) {
			throw new LeaseException("Erro: " + EnumLeaseException.LeaseInvalidStartOrEndDate);
		}

		Lease lease = createLease(startDate, endDate, landlord, property, tenant);
		if (lease != null) {
			leaseRepository.addLease(lease);
			//new DAO().addLease(lease);
			//new DAO().addTenantLease(tenant, lease);
			System.out.println("\nContrato adicionado com sucesso!");
		} else {
			System.out.println("Erro: " + EnumLeaseException.LeaseInvalid);
		}
	}

	public Lease createLease(String startDate, String endDate, Landlord landlord, Property property, Tenant tenant)
			throws LeaseException, ParseException {

		if (landlord.getCpf().equals(tenant.getCpf())) {
			throw new LeaseException("Erro: " + EnumLeaseException.LandlordAndTenantHaveTheSameCPF);
		} else if (property.getOccupation().equals(PropertyOccupation.OCCUPIED)) {
			throw new LeaseException("Erro: " + EnumPropertyException.PropertyInvalidOccupation);
		}
		assignTenantToProperty(property, tenant);
		return new Lease(property.getId(), dateTimeExtensions(startDate), dateTimeExtensions(endDate),
				landlord.getCpf(), tenant.getCpf());
	}

	private String dateTimeExtensions(String date) throws ParseException {
		DatetimeExtensions.toDate(date);
		return date;
	}

	public void assignTenantToProperty(Property property, Tenant tenant) {

		if (property.getOccupation() == PropertyOccupation.OCCUPIED) {
			System.out.println("Erro: O imóvel já tem um inquilino associado!");
			return;
		}

		property.setCpfTenant(tenant.getCpf());
		property.setOccupation(PropertyOccupation.OCCUPIED);

		tenant.setProperty(property);

		System.out.println("\n| Inquilino " + tenant.getName() + "\n| Cadastrado ao Imóvel " + property.getAddress());
	}

	public void assignPropertyToLandlord(Landlord landlord, Property property) {

		if (property.getCpfLandlord() != null && !property.getCpfLandlord().isEmpty()) {
			System.out.println("Erro: O imóvel já tem um proprietário associado!");
			return;
		}

		List<Property> propertys = landlord.getPropertys();

		if (propertys == null) {
			propertys = new ArrayList<>();
			landlord.setPropertys(propertys);
		}
		propertys.add(property);

		property.setCpfLandlord(landlord.getCpf());

		System.out.println(
				"\n| Imóvel " + property.getAddress() + "\n| Cadastrado ao proprietário " + landlord.getName());
	}

	// REOMVE (FALTA MEHORAR)
	public void removeLease() {
		if (leaseRepository.leases.empty()) {
			System.out.println(("Erro: " + EnumLandlordException.LandlordNoRegistered));
		} else {
			Lease pop = leaseRepository.leases.pop();
			System.out.println("\nContrato: " + pop.getId() + ". Removido com sucesso!");
		}
	}

	// LIST
	public void listLease() {
		StackRepository<Lease> leases = leaseRepository.listLease();
		if (leases.empty()) {
			System.out.println(("Erro: " + EnumPropertyException.PropertyNoRegistered));
		} else {
			for (int i = 0; i < leases.size(); i++) {
				Lease l = leases.get(i);
				l.setId(i);
				System.out.println("\n-------------------------------------------------------------------------------");
				System.out.print("Contrato: " + l.getId() + "\n");
				System.out.print(" | Proprietário: " + l.getCpfLandlord() + "\n");
				System.out.print(" | Imovel: " + l.getIdProperty() + "\n");
				System.out.print(" | Inquilino: " + l.getCpfTenant() + "\n");
				System.out.print(" | Data de Inicio: " + l.getStartDate());
				System.out.print(" | Data de Fim: " + l.getEndDate());
				System.out.println("\n-------------------------------------------------------------------------------");
			}
		}
	}

	// CHANGE
	public void changeLease(int id) throws LeaseException, ParseException {
		if (leaseRepository.leases.empty()) {
			System.out.println(("Erro: " + EnumLeaseException.LeaseNoRegistered));
		} else {
			if (id < 0 || id >= leaseRepository.leases.size()) {
				System.out.println(("Erro: " + EnumLeaseException.LeaseInvalidIndex));
			}

			Lease lease = leaseRepository.leases.get(id);
			System.out.println(
					"\nQuais as novas informações do Contrato deseja mudar? \n| 0.Nenhum | 1.Data de Inicio | 2.Data de Fim |");
			System.out.print("\nOpção: ");
			int option = scanner.nextInt();
			scanner.nextLine();
			switch (option) {
			case 1:
				System.out.print("\nNova Data de Inicio (DD/MM/AA): ");
				String newStartDate = scanner.nextLine();
				lease.setStartDate(dateTimeExtensions(newStartDate));
				System.out.println("\nContrato atualizado com sucesso!");
				break;
			case 2:
				System.out.print("\nNova Data de Fim (DD/MM/AA): ");
				String newEndDate = scanner.nextLine();
				lease.setEndDate(dateTimeExtensions(newEndDate));
				System.out.println("\nContrato atualizado com sucesso!");
				break;
			default:
				option = 0;
				System.out.println("\nContrato não foi atualizado!");
				break;
			}
		}
	}

	// SEARCH
	public void searchLease(int id) {
		try {
			Lease lease = leaseRepository.searchLease(id);
			System.out.println(lease.getId());
			System.out.println(lease.getCpfLandlord());
			System.out.println(lease.getCpfTenant());
			System.out.println(lease.getIdProperty());
		} catch (Exception e) {
			System.err.println("Erro!!!");
		}
	}
}
