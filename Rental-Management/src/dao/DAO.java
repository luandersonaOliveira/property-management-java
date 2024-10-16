package dao;

import java.sql.PreparedStatement;
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
			ps.setInt(3, lease.getIdProperty());
			ps.setString(4, lease.getCpfLandlord());
			ps.setString(5, lease.getCpfTenant());

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
			ps.setString(3, property.getCpfLandlord());

			ps.execute();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addTenantLease(Tenant tenant, Lease lease) {
		String sql = "INSERT INTO TENANT_LEASE (ID_TENANT, ID_LEASE) VALUES (?, ?)";

		PreparedStatement ps = null;

		try {
			ps = Connections.getConnections().prepareStatement(sql);
			ps.setInt(1, tenant.getId()+1);
			ps.setInt(2, lease.getId()+1);

			ps.execute();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
