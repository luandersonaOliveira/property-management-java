import Dao.TenantDAO;
import Entity.Tenant;

public class App {
    public static void main(String[] args) throws Exception {
        Tenant tenant = new Tenant();
        tenant.setName("Guru");
        tenant.setCpf("12345678900");
        tenant.setTelephone("12345678900");
        tenant.setEmail("guru@gmail.com");
        tenant.setBalance(90000);

        new TenantDAO().addTenant(tenant);
    }
}
