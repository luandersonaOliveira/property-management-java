package entity;
// Locação (Contrato)

public class Lease {
	// ATTRIBUTES

	private int id, idProperty;
	private String startDate, endDate, cpfLandlord, cpfTenant;
	private Property property;
	private Landlord landlord;
	private Tenant tenant;

	// CONSTRUCTOR
	
	public Lease () {
		
	}

	public Lease(int idProperty, String startDate, String endDate, String cpfLandlord, String cpfTenant) {
		this.idProperty = idProperty;
		this.startDate = startDate;
		this.endDate = endDate;
		this.cpfLandlord = cpfLandlord;
		this.cpfTenant = cpfTenant;
	}

	// METODOS ESPECIAS

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdProperty() {
		return idProperty;
	}

	public void setIdProperty(int idProperty) {
		this.idProperty = idProperty;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
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

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public Landlord getLandlord() {
		return landlord;
	}

	public void setLandlord(Landlord landlord) {
		this.landlord = landlord;
	}

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

}
