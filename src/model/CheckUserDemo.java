package model;

import java.sql.*;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CheckUserDemo {
	
	private String to_insert_txtUsrName;
	
	 String url = "jdbc:mysql://localhost:3306/";
	  String dbName = "hw5";
	  String driver = "com.mysql.jdbc.Driver";
	  String userName = "admin"; 
	  String password = "";
	


	public void setCheckUser(String txtUsrName) 
	{
		this.to_insert_txtUsrName = txtUsrName;
		
	}
	



	public Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName(driver).newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn = DriverManager.getConnection(url+dbName,userName,password);
		return conn;
	}

	
	public boolean checkUser(CheckUserDemo d) throws SQLException
	{
		System.out.println("comes to InsertDemo");
		try
		{
			
			System.out.println("now checking the user if existing");
			System.out.println("Now inserting the data in table group_id = "+ this.to_insert_txtUsrName);
			String selectSQL = "SELECT count(person_id) from person WHERE user_name ='" + this.to_insert_txtUsrName +"'";
			
			PreparedStatement preparedStatement = getConnection().prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				if (rs.getInt("count(person_id)") >= 1)
				{
					System.out.println("The user ID already inserted in the system");
					return false;
				}
					
				else
				{
					System.out.println("Came in else part for checl user");
					return true;
				}
			}
	    }
		catch (SQLException e) 
		{
			System.out.println();
			System.out.println("Cannot run the query 3");
			e.printStackTrace();
			return false;
		}
		
		return false;

		}
}