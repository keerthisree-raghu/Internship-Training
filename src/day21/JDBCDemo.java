package day21;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class JDBCDemo {
	public static void main(String[] args) throws Exception {
		// Step 1: Load or register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Step 2: Establish a connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "root");
		
		System.out.println("Connection: " + conn);
		
		DatabaseMetaData metaData = conn.getMetaData();
		
		System.out.println("Database Product Name: " + metaData.getDatabaseProductName());
		System.out.println("Database Version: " + metaData.getDatabaseMajorVersion());
		System.out.println("URL: " + metaData.getURL());
		System.out.println("Transactins Supported: " + metaData.supportsTransactions());
		
	}
}