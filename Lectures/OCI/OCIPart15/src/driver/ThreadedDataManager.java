package driver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import database.DBConnectionManager;

public class ThreadedDataManager {
	
	public static void main(String[] args) {
		DBConnectionManager dbManager = DBConnectionManager.getInstance();
		
		Runnable task1 = () -> {
			try {
				Connection conn = dbManager.getConnection();
				Statement stmt = conn.createStatement();		
				
				while(true) {
					ResultSet rs = stmt.executeQuery("SELECT name, email FROM users");
				
					while (rs.next()) {
						System.out.println("T1: " + rs.getString("name") + ", " + rs.getString("email"));
					}
					Thread.sleep(1000);
				}
				//dbManager.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
		
		Thread t1 = new Thread(task1);
		t1.start();
		
		Runnable task2 = () -> {
			try {
				Connection conn = dbManager.getConnection();
				Statement stmt = conn.createStatement();		
				
				while(true) {
					ResultSet rs = stmt.executeQuery("SELECT name, email FROM users");
				
					while (rs.next()) {
						System.out.println("T2: " + rs.getString("name") + ", " + rs.getString("email"));
					}
					Thread.sleep(1000);
				}
				//dbManager.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
		Thread t2 = new Thread(task2);
		t2.start();

		while(true) {
			System.out.println("Main runs");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//dbManager.closeConnection();
	}

}
