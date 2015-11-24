package model;

import java.sql.*;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class InsertDemo {
	
	private String post_to_insert;
	
	 String url = "jdbc:mysql://localhost:3306/";
	  String dbName = "hw5";
	  String driver = "com.mysql.jdbc.Driver";
	  String userName = "root"; 
	  String password = "mysql";
	


	public void setInsertPost(String post) 
	{
		this.post_to_insert = post;
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

	
	public boolean InsertPost(InsertDemo d, int group_id, int person_id) throws SQLException
	{
		//System.out.println("comes to InsertDemo");
		PreparedStatement ps;
		//System.out.println("Made prepares statement" );
		try
		{
			
			//System.out.println("now inserting the data");
			//System.out.println("Now inserting the data in table group_id = "+ group_id + this.post_to_insert);
			
			String insertSQL = "INSERT INTO post (group_id, post, person_id) VALUES (?, ?, ?)";
			PreparedStatement preparedStatement = getConnection().prepareStatement(insertSQL);
			preparedStatement.setInt(1, group_id);
			preparedStatement.setString(2, this.post_to_insert);
			preparedStatement.setInt(3,person_id);
			preparedStatement.executeUpdate();
	    }
		catch (SQLException e) 
		{
			System.out.println("Cannot run the query 4");
			e.printStackTrace();
			return false;
		}
		
		return false;

		}
}

