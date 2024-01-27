package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connex {

	public Connection getConnex() {
        String url = "jdbc:postgresql://localhost:5432/epicerie";
        String username = "postgres";
        String password = "root";
        Connection conn = null;

        try {    
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load PostgreSQL JDBC driver.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
	        return conn;
	    }
	}



