package view;

import dao.DAO;
import entity.Tenant;

public class App {
	public static void main(String[] args) throws Exception {
		Tenant t = new Tenant();
		t.setName("Guru Guru");
		t.setCpf("14725836910");
		t.setTelephone("14725836910");
		t.setEmail("guru@gmail.com");

		new DAO().addTenant(t);
	}
}
