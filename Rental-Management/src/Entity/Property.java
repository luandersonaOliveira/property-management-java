package entity;
// Imovel

import Enum.PropertyOccupation;
import Enum.PropertyType;

public class Property {
	// ATTRIBUTES

	private int id;
	private String address;
	private double rentalValue;
	private PropertyType type;
	private PropertyOccupation occupation;
	private String cpfLandlord;
	private String cpfTenant;

	// CONSTRUCTOR
	
	public Property() {
		
	}

	public Property(String address, double rentalValue, PropertyType type, PropertyOccupation occupation,
			String cpfLandlord) {
		this.address = address;
		this.rentalValue = rentalValue;
		this.type = type;
		this.occupation = occupation;
		this.cpfLandlord = cpfLandlord;
	}

	// METODOS ESPECIAS

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getRentalValue() {
		return rentalValue;
	}

	public void setRentalValue(double rentalValue) {
		this.rentalValue = rentalValue;
	}

	public PropertyType getType() {
		return type;
	}

	public void setType(PropertyType type) {
		this.type = type;
	}

	public PropertyOccupation getOccupation() {
		return occupation;
	}

	public void setOccupation(PropertyOccupation occupation) {
		this.occupation = occupation;
	}

	public String getCpfLandlord() {
		return cpfLandlord;
	}

	public void setCpfLandlord(String cpfLandlord) {
		this.cpfLandlord = cpfLandlord;
	}

	public String getCpfTenant() {
		return cpfTenant;
	}

	public void setCpfTenant(String cpfTenant) {
		this.cpfTenant = cpfTenant;
	}
}
