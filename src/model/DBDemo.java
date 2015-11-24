package model;

import java.sql.*;


public class DBDemo {
	
	private String uname;
	private String pwd;
	public int person_id;

	  String url = "jdbc:mysql://localhost:3306/";
	  String dbName = "hw5";
	  String driver = "com.mysql.jdbc.Driver";
	  String userName = "admin"; 
	  String password = "";
	
	  public boolean chkuser = true;
	
	public String getUserName() 
	{
		return uname;
	}

	public void setUserName(String username) 
	{
		this.uname = username;
	}
	
	public String getPassword() 
	{
		return pwd;
	}

	public void setPassword(String password) 
	{
		this.pwd = password;
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

	
	public boolean validateUser(DBDemo d) throws SQLException
	{
		PreparedStatement ps;
		try
		{
			String q = "select password, person_id from person where user_name = '"+d.uname+"'";
			ps = getConnection().prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			int resultsCounter = 0; 
			while (rs.next())
					{
						person_id = rs.getInt(2);
						resultsCounter++;
						System.out.println("resultsCounter = " + resultsCounter);
						if (resultsCounter == 0)
						{
							System.out.println("result set is empty");
							chkuser = true;
							return false;
						}
						else
						{
							System.out.println("Inside else loop....");
							if (rs.getString(1).equals(d.pwd))
							{
								System.out.println("User name and password is validated");
								chkuser = false;
								return true;
							}
							else
							{
								System.out.println("Inside else of else....");
								chkuser = true;
							}
						}
					}
	
			rs.close();
			ps.close();
	    }
		catch (SQLException e) 
		{
			System.out.println("Cannot run the query");
			e.printStackTrace();
			return false;
		}
		
		return false;

		}
	
	public boolean isRole(DBDemo d) throws SQLException
	{
		PreparedStatement ps;
		try
		{
			ps = getConnection().prepareStatement
					("select role_name from person where user_name = '"+d.uname+"'");
			ResultSet rs = ps.executeQuery();
			int resultsCounter = 0; 
			while(rs.next())
			{
				resultsCounter++;
				if (resultsCounter == 0)
				{
					System.out.println("result set is empty");
					return false;
				}
				else
				{
					if (rs.getString(1).toLowerCase().equals("user"))
					{
						System.out.println("Role is User");
						return true;
					}
					if (rs.getString(1).toLowerCase().equals("admin"))
					{
						System.out.println("Role is Admin");
						return false;
					}
				}
			}

			rs.close();
			ps.close();
	    }
		catch (SQLException e) 
		{
			System.out.println("Cannot run the query");
			e.printStackTrace();
		}
		
		return false;

	}
}
