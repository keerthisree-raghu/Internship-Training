package day21;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;

public class JDBCDemo5 {
	public static void main(String[] args) throws Exception {
		// Step 1: Load or register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2: Establish a connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "root");
	
		System.out.println("Connection: " + conn);
		
		CallableStatement cs = conn.prepareCall("{call proc1(?,?)}");
		
		int userId = 3;
		cs.setInt(1, userId);
		
		cs.registerOutParameter(2, Types.VARCHAR);
		
		cs.execute();
		
		System.out.println("Username of " + userId + " is " + cs.getString(2));
	}
}
