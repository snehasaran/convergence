package model;

import java.sql.*;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class InsertUserDemo {
	
	private String to_insert_txtUsrName;
	private String to_insert_txtPassword;
	private String to_insert_txtFirstName;
	private String to_insert_txtLastName; 
	private	String to_insert_txtCity;
	private	String to_insert_txtState;
	private	int to_insert_txtAge;
	private	int to_insert_phone_type;
	private	long to_insert_txtPhoneNo;
	private	String to_insert_txteMail;
	private	String to_insert_rdGender;
	
	private String pwd;
	
	 String url = "jdbc:mysql://localhost:3306/";
	  String dbName = "hw5";
	  String driver = "com.mysql.jdbc.Driver";
	  String userName = "root"; 
	  String password = "mysql";
	


	public void setInsertUser(String txtUsrName,
							  String txtPassword,
							  String txtFirstName,
							  String txtLastName, 
							  String txtCity,
							  String txtState,
							  int txtAge,
							  int phone_type,
							  long txtPhoneNo,
							  String txteMail,
							  String rdGender) 
	{
		this.to_insert_txtUsrName = txtUsrName;
		this.to_insert_txtPassword = txtPassword;
		this.to_insert_txtFirstName = txtFirstName;
		this.to_insert_txtUsrName = txtUsrName;
		this.to_insert_txtLastName = txtLastName;
		this.to_insert_txtCity = txtCity;
		this.to_insert_txtState = txtState;
		this.to_insert_txtAge = txtAge;
		this.to_insert_phone_type = phone_type;
		this.to_insert_txtPhoneNo = txtPhoneNo;
		this.to_insert_rdGender = rdGender;
		this.to_insert_txteMail = txteMail;
		
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

	
	public boolean InsertUser(InsertUserDemo d) throws SQLException
	{
		System.out.println("comes to InsertDemo");
		PreparedStatement ps;
		try
		{
			
			System.out.println("now inserting the data");
			System.out.println("Now inserting the data in table to_insert_txtFirstName = "+ this.to_insert_txtFirstName);
			System.out.println("Now inserting the data in table to_insert_txtUsrName = "+ this.to_insert_txtUsrName);
			System.out.println("Now inserting the data in table to_insert_txtPassword = "+ this.to_insert_txtPassword);
			System.out.println("Now inserting the data in table to_insert_txtLastName = "+ this.to_insert_txtLastName);
			System.out.println("Now inserting the data in table to_insert_txtCity = "+ this.to_insert_txtCity);
			System.out.println("Now inserting the data in table to_insert_rdGender = "+ this.to_insert_rdGender);
			System.out.println("Now inserting the data in table to_insert_txtState = "+ this.to_insert_txtState);
			System.out.println("Now inserting the data in table to_insert_txteMail = "+ this.to_insert_txteMail);
			
			
			String insertSQL = "INSERT INTO `test1`.`person` (`first_name`, `user_name`, `password`, `role_name`, `last_name`, `user_city`, `user_gender`, `user_state`, `user_age`, `user_email`) "
					+ "VALUES (?, ?, ?, 'User', ?, ?, ?, ?, ?, ?);";
			PreparedStatement preparedStatement = getConnection().prepareStatement(insertSQL);
			preparedStatement.setString(1, this.to_insert_txtFirstName);
			preparedStatement.setString(2, this.to_insert_txtUsrName);
			preparedStatement.setString(3, this.to_insert_txtPassword);
			preparedStatement.setString(4, this.to_insert_txtLastName);
			preparedStatement.setString(5, this.to_insert_txtCity);
			preparedStatement.setString(6, this.to_insert_rdGender);
			preparedStatement.setString(7, this.to_insert_txtState);
			preparedStatement.setInt(8, this.to_insert_txtAge);
			preparedStatement.setString(9, this.to_insert_txteMail);
			
			preparedStatement.executeUpdate();
			
			System.out.println("The data for phone table is : " + this.to_insert_phone_type );
			
	    }
		catch (SQLException e) 
		{
			System.out.println();
			System.out.println("Cannot run the query for inserting the user.");
			e.printStackTrace();
			return false;
		}
		
		return false;

		}
}