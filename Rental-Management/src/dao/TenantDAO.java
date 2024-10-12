package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.Connections;
import entity.Tenant;

public class TenantDAO {

	public void cadastrarUsuario(Tenant tenant) {
        String sql = "INSERT INTO TENANT (NAME, CPF, TELEPHONE, EMAIL, BALANCE) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = Connections.getConnections().prepareStatement(sql);
            ps.setString(1, tenant.getName());
            ps.setString(2, tenant.getCpf());
            ps.setString(3, tenant.getTelephone());
            ps.setString(4, tenant.getEmail());
            ps.setDouble(5, tenant.getBalance());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
