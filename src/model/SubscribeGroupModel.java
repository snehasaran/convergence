package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.GroupPerson;


public class SubscribeGroupModel{

	private GroupPerson groupPerson;
	private Connection conn = null;
	
	public SubscribeGroupModel() throws SQLException {
		conn = getConnection();
	}
	
	public GroupPerson getGroupPerson() {
		return groupPerson;
	}
	
	public void setGroupPerson(GroupPerson groupPerson) {
		this.groupPerson = groupPerson;
	}

	public Connection getConnection() throws SQLException {
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

	/**
	 * Adds the subscription to a group by a person specified in GroupPerson object
	 * @return true if the subscription was added successfully to the database
	 */
	public boolean addGroupSubscription(){
		try{

			String query = "insert into group_person(group_id, person_id, flag) values(?, ?, ?)";
			conn = getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, groupPerson.getGroupId());
			preparedStatement.setInt(2, groupPerson.getPersonId());
			preparedStatement.setString(3, groupPerson.getStatus());
			preparedStatement.executeUpdate();
			return true;

		} catch(SQLException se) {
			se.printStackTrace();
		} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return false;
	}
	
	/**
	 * deletes the subscription to a group by a person specified in GroupPerson object
	 * @return true if the subscription was deleted successfully to the database
	 */
	public boolean deleteGroupSubscription() {
		try{
			conn = getConnection();	
			String query = "delete from group_person where group_id = ? and person_id = ?";
			
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, groupPerson.getGroupId());
			preparedStatement.setInt(2, groupPerson.getPersonId());
			preparedStatement.executeUpdate();
			return true;

		} catch(SQLException se) {
			se.printStackTrace();
		} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return false;
	}
}

