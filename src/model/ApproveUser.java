package model;

import java.sql.*;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ApproveUser {
	
	private int group_id;
	private int person_id;
	
	  String url = "jdbc:mysql://localhost:3306/";
	  String dbName = "test1";
	  String driver = "com.mysql.jdbc.Driver";
	  String userName = "root"; 
	  String password = "";
	


	public void setApproveUser(int group_id,int person_id) 
	{
		this.group_id = group_id;
		this.person_id = person_id;
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

	
	public boolean ApproveUser(ApproveUser d, int group_id, int person_id) throws SQLException
	{
		//System.out.println("comes to InsertDemo");
		PreparedStatement ps;
		//System.out.println("Made prepares statement" );
		try
		{
			
			//System.out.println("now inserting the data");
			//System.out.println("Now inserting the data in table group_id = "+ group_id + this.post_to_insert);
			
			String insertSQL = "UPDATE group_person SET flag = 'Approved' WHERE group_id =? and person_id = ?;";
			PreparedStatement preparedStatement = getConnection().prepareStatement(insertSQL);
			preparedStatement.setInt(1, group_id);
			preparedStatement.setInt(2, person_id);
			preparedStatement.executeUpdate();
	    }
		catch (SQLException e) 
		{
			System.out.println("Cannot run the query for approve user.");
			e.printStackTrace();
			return false;
		}
		
		return false;

		}
}

