package driver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import database.DBConnectionManager;

public class Driver {
	
	public static void main(String[] args) {
		DBConnectionManager dbManager = DBConnectionManager.getInstance();
		
		try (Connection conn = dbManager.getConnection()) {
				Statement stmt = conn.createStatement();		
				ResultSet rs = stmt.executeQuery("SELECT name, email FROM users");
			
			while (rs.next()) {
				System.out.println(rs.getString("name") + ", " + rs.getString("email"));
			}
			
			dbManager.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
