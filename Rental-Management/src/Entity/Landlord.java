package entity;

import java.util.List;

// Proprietário (Espefico de imovel)

public class Landlord {
	// ATTRIBUTES

	private int id;
	private String name, cpf, telephone, email;
	private List<Property> property;

	// CONSTRUCTOR
	
	public Landlord(String name, String cpf, String telephone, String email) {
		this.name = name;
		this.cpf = cpf;
		this.telephone = telephone;
		this.email = email;
	}

	// METODOS ESPECIAS

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Property> getProperty() {
		return property;
	}

	public void setProperty(List<Property> property) {
		this.property = property;
	}
}
