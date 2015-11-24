package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class Login 
{
	private String username;
	private String password;
	
	private final String userName = "root";

	private final String pwd = "mysql";

	private final String serverName = "localhost";

	private final int portNumber = 3306;

	private final String dbName = "hw5";
	
	private final String tableName = "Login";
	
	public String getUserName() 
	{
		return username;
	}

	public void setUserName(String username) 
	{
		this.username = username;
	}
	
	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", "root");
		connectionProps.put("password", "mysql");
		//System.out.println("in get connection");
		conn = DriverManager.getConnection("jdbc:mysql://"
				+ this.serverName + ":" + this.portNumber + "/" + this.dbName,
				connectionProps);
		//System.out.println("conn = " + "jdbc:mysql://"
		//		+ this.serverName + ":" + this.portNumber + "/" + this.dbName);
		return conn;
	}
	
	public boolean validateUser(Login l) throws SQLException
	{
		PreparedStatement ps = null;
		try
		{
			//System.out.println("in try block");
			ps = getConnection().prepareStatement
					("select user_name, password from " + tableName);
			//System.out.println("in try block 1");
			ResultSet rs = ps.executeQuery();
			//System.out.println("in try block 2");
			//System.out.println("rs=" + rs);
			while (rs.next())
			{
				if (rs.getString(1).equals(l.username) & rs.getString(2).equals(l.password))
				{
					System.out.println("User name and password is validated");
					return true;
				}
				
			}
			rs.close();
			 if (ps != null) 
		        { 
		        	ps.close(); 
		        return true;
		        }
	    }
		catch (SQLException e) 
		{
			System.out.println();
			System.out.println("Cannot run the query");
			e.printStackTrace();
			return false;
		}
		
		return false;

}
}
