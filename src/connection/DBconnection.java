package connection;


import java.sql.*;

import model.DBQuery;

public class DBconnection {

	public static Connection conn = null;
	public static Statement stmt = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs = null;
	public static ResultSet rs1 = null;
	public static ResultSet rs2 = null;

	public static String username = "admin";
	public static String password = "";
	public static String url = "jdbc:oracle:thin:@INGNRILPINFM01:1521:ORCL";

	public static void connectToDB() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, username, password);
			
		} catch (ClassNotFoundException ce) {
			System.out.println("Error message : " + ce.getMessage());
		} catch (SQLException se) {
			System.out.println("Error message : " + se.getMessage());
		}
	}
}