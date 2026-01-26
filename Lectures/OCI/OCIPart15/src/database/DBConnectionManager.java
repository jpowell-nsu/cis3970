package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
	
	private Connection connection;
	
	private static class DBCM {
		private static final DBConnectionManager instance = new DBConnectionManager();
	}

	private DBConnectionManager() {
		try {
			String url = "jdbc:derby:myDB;create=true";
            connection = DriverManager.getConnection(url);
            System.out.println("Connection successful");
		} catch (SQLException e) {
			throw new RuntimeException("Failed to connect", e);
		}
	}
	
	public static DBConnectionManager getInstance() {
		return DBCM.instance;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
