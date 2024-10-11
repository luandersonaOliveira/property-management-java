package Dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Connection.Connections;
import Entity.Tenant;

public class TenantDAO {
    public void addTenant(Tenant tenant) {
        String sql = "INSERT INTO TENANT (NAME, CPF, TELEPHONE, EMAIL, BALANCE) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = Connections.getConnections().prepareStatement(sql);
            ps.setString(1, tenant.getName());
            ps.setString(2, tenant.getCpf());
            ps.setString(3, tenant.getTelephone());
            ps.setString(4, tenant.getEmail());
            ps.setDouble(4, tenant.getBalance());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
