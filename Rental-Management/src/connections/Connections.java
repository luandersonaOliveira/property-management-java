package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {

	private static final String url = "jdbc:mysql://localhost:3306/property_management";
    private static final String user = "root";
    private static final String password = "mysql0123";

    private static Connections conn;

    public static Connections getConnections() {
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            } else {
                return conn;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}
