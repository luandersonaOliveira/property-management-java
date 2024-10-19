package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.Connections;
import entity.Landlord;
import entity.Lease;
import entity.Property;
import entity.Tenant;

public class DAO {

	public void addTenant(Tenant tenant) {
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

	public void addLandlord(Landlord landlord) {
		String sql = "INSERT INTO LANDLORD (NAME, CPF, TELEPHONE, EMAIL) VALUES (?, ?, ?, ?)";

		PreparedStatement ps = null;

		try {
			ps = Connections.getConnections().prepareStatement(sql);
			ps.setString(1, landlord.getName());
			ps.setString(2, landlord.getCpf());
			ps.setString(3, landlord.getTelephone());
			ps.setString(4, landlord.getEmail());

			ps.execute();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addLease(Lease lease) {
		String sql = "INSERT INTO LEASE (START_DATE, END_DATE, ID_PROPERTY, CPF_LANDLORD, CPF_TENANT) VALUES (?, ?, ?, ?, ?)";

		PreparedStatement ps = null;

		try {
			ps = Connections.getConnections().prepareStatement(sql);
			ps.setString(1, lease.getStartDate());
			ps.setString(2, lease.getEndDate());
			ps.setInt(3, lease.getProperty().getId());
			ps.setString(4, lease.getLandlord().getCpf());
			ps.setString(5, lease.getTenant().getCpf());

			ps.execute();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addProperty(Property property) {
		String sql = "INSERT INTO PROPERTY (ADDRESS, RENTAL_VALUE, TYPE, OCCUPATION, CPF_LANDLORD) VALUES (?, ?, ?, ?, ?)";

		PreparedStatement ps = null;

		try {
			ps = Connections.getConnections().prepareStatement(sql);
			ps.setString(1, property.getAddress());
			ps.setDouble(2, property.getRentalValue());
			ps.setString(3, property.getType().name());
			ps.setString(4, property.getOccupation().name());
			ps.setString(5, property.getLandlord().getCpf());

			ps.execute();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addTenantLease(Tenant tenant, Lease lease) {
	    String sqlCheckTenant = "SELECT COUNT(*) FROM tenant WHERE id = ?";
	    String sqlCheckLease = "SELECT COUNT(*) FROM lease WHERE id = ?";
	    String sqlInsertTenantLease = "INSERT INTO TENANT_LEASE (ID_TENANT, ID_LEASE) VALUES (?, ?)";
	    
	    try (Connection conn = Connections.getConnections();
	         PreparedStatement psCheckTenant = conn.prepareStatement(sqlCheckTenant);
	         PreparedStatement psCheckLease = conn.prepareStatement(sqlCheckLease);
	         PreparedStatement psInsert = conn.prepareStatement(sqlInsertTenantLease)) {
	         
	        psCheckTenant.setInt(1, tenant.getId());
	        ResultSet rsTenant = psCheckTenant.executeQuery();
	        if (rsTenant.next() && rsTenant.getInt(1) == 0) {
	            throw new SQLException("Tenant não encontrado");
	        }
	        
	        psCheckLease.setInt(1, lease.getId());
	        ResultSet rsLease = psCheckLease.executeQuery();
	        if (rsLease.next() && rsLease.getInt(1) == 0) {
	            throw new SQLException("Lease não encontrado");
	        }
	        
	        psInsert.setInt(1, tenant.getId());
	        psInsert.setInt(2, lease.getId());
	        psInsert.execute();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


}
