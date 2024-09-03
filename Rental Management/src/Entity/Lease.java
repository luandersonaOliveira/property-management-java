package Entity;
// Locação (Contrato)

import java.util.Date;

public class Lease {
    // ATRIBUTOS

    private int id;
    private Date starDate, endDate;
    private double value;
    private Landlord landlord;
    private Property property;
    private Tenant tenant;

    // CONSTRUCTOR

    public Lease(Date starDate, Date endDate, double value, Landlord landlord, Property property, Tenant tenant) {
        this.starDate = starDate;
        this.endDate = endDate;
        this.value = value;
        this.landlord = landlord;
        this.property = property;
        this.tenant = tenant;
    }

    // METODOS ESPECIAS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStarDate() {
        return starDate;
    }

    public void setStarDate(Date starDate) {
        this.starDate = starDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Landlord getLandlord() {
        return landlord;
    }

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
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

    // METODOS PERSONALIZADOS
}
