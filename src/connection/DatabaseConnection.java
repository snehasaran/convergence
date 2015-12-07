package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class for Database connection
 * 
 * @author marri.r
 *
 */
public class DatabaseConnection {
	
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "hw5";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "admin"; 
		String password = "";

		try {
			Class.forName(driver).newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = DriverManager.getConnection(url+dbName,userName,password);
		return conn;
	}
}
