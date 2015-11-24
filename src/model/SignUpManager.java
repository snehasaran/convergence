package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.User;
import connection.DBconnection;

public class SignUpManager{
	public static DBconnection dbCon = new DBconnection();
	ResultSet rs = null;
	ResultSet rs2 = null;
	ResultSet rs3 = null;
	
	public void addUser(User u) {
		try {

			String userName = u.getUserName();
			String userFirstName = u.getUserFirstName();
			String userLastName = u.getUserLastName();
			String userCity = u.getCity();
			int phone_type = u.getPhoneType();
			String userPhone = u.getPhoneNo();
			String userState = u.getState();
			String userGender = u.getGender();
			int userAge = u.getAge();
			String email = u.geteMail();		
			String username = "admin";
			String password = "";
			String url = "jdbc:oracle:thin:@INGNRILPINFM01:1521:ORCL";

			dbCon.connectToDB();
			dbCon.conn.createStatement();
			dbCon.pstmt = dbCon.conn.prepareStatement(DBQuery.INSERT_SQL_USER);
			dbCon.pstmt.setString(1, userName);
			dbCon.pstmt.setString(2, userFirstName);
			dbCon.pstmt.setString(3, userLastName);
			dbCon.pstmt.setString(4, userCity);
			dbCon.pstmt.setInt(5, phone_type);
			dbCon.pstmt.setString(6, userPhone);
			dbCon.pstmt.setString(7, userGender);
			dbCon.pstmt.setString(8, userState);
			dbCon.pstmt.setString(9, Integer.toString(userAge));
			dbCon.pstmt.setString(10, email);
			dbCon.pstmt.executeUpdate();

			
		} catch (SQLException se) {
			System.out.println("Error message : " + se.getMessage());
		} finally {
			try {
				dbCon.pstmt.close();
				rs.close();
				DBconnection.conn.close();
			} catch (SQLException se) {
				System.out.println("Error message : " + se.getMessage());
			}
		}

	}
}

