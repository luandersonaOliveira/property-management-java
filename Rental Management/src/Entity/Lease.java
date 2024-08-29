package Entity;
// Locação (Contrato)

public class Lease {
    // ATRIBUTOS

    private int id;
    private String starDate, endDate;
    private double value;
    private Property property;
    private Tenant tenant;
    private Landlord landlord;

    // CONSTRUCTOR

    public Lease(int id, String starDate, String endDate, double value, Property property, Tenant tenant,
            Landlord landlord) {
        this.id = id;
        this.starDate = starDate;
        this.endDate = endDate;
        this.value = value;
        this.property = property;
        this.tenant = tenant;
        this.landlord = landlord;
    }

    // METODOS ESPECIAS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStarDate() {
        return starDate;
    }

    public void setStarDate(String starDate) {
        this.starDate = starDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Landlord getLandlord() {
        return landlord;
    }

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }

    // METODOS PERSONALIZADOS
}
