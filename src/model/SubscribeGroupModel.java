package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			String getNumberOfUsers = "select count(*) from group_person where group_id ='" + groupPerson.getGroupId()+"'";

			System.out.println("Query : " + getNumberOfUsers);
			String query = "insert into group_person(group_id, person_id, flag) values(?, ?, ?)";
			conn = getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(getNumberOfUsers);

			ResultSet rs = preparedStatement.executeQuery();
			int userFound =0;
			while(rs.next()){
				userFound = rs.getInt(1);
			}
			
			
			preparedStatement = conn.prepareStatement(query);
			
			System.out.println("Number of Users Found: " + userFound);
			if(userFound == 0){
				System.out.println("No users found");
				String queryMakeAdmin = "insert into group_admins (group_id, person_id) values(?,?)";
				PreparedStatement preparedStatementNew = conn.prepareStatement(queryMakeAdmin);
				preparedStatementNew.setInt(1,groupPerson.getGroupId());
				preparedStatementNew.setInt(2,groupPerson.getPersonId());
				preparedStatementNew.executeUpdate();
				
				String makeGroupAdmin = "UPDATE person SET role_name ='GroupAdmin' WHERE person_id='"+ groupPerson.getPersonId()+ "';";
				preparedStatementNew = conn.prepareStatement(makeGroupAdmin);
				preparedStatementNew.executeUpdate();
				
				preparedStatement.setInt(1, groupPerson.getGroupId());
				preparedStatement.setInt(2, groupPerson.getPersonId());
				preparedStatement.setString(3, "Approved");
				preparedStatement.executeUpdate();
			}

			else{
				preparedStatement.setInt(1, groupPerson.getGroupId());
				preparedStatement.setInt(2, groupPerson.getPersonId());
				preparedStatement.setString(3, groupPerson.getStatus());
				preparedStatement.executeUpdate();
			}
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
			
			query = "select count(*) from group_admins where group_id = '"+groupPerson.getGroupId()+"' and person_id = '"+groupPerson.getPersonId()+"'";
			preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			int admin_count = 0;
			while(rs.next()){
				admin_count = rs.getInt(1);
			}
			
			// If the deleting user is admin
			if(admin_count != 0){
				String makeGroupAdmin = "UPDATE person SET role_name ='User' WHERE person_id='"+ groupPerson.getPersonId()+ "';";
				PreparedStatement preparedStatementNew = conn.prepareStatement(makeGroupAdmin);
				preparedStatementNew.executeUpdate();
				
				String removeFromGroupAdmin = "Delete from group_admins WHERE group_id = '"+groupPerson.getGroupId()+"' and person_id = '"+groupPerson.getPersonId()+"'";
				preparedStatementNew = conn.prepareStatement(removeFromGroupAdmin);
				preparedStatementNew.executeUpdate();
				
				// Remove Pending requests
				String removeAllPendingRequests = "Delete from group_person WHERE group_id = '"+groupPerson.getGroupId()+"' and flag = 'Pending'";
				preparedStatementNew = conn.prepareStatement(removeAllPendingRequests);
				preparedStatementNew.executeUpdate();
				
				// Make someone else admin
				String getUserId = "Select g.person_id from group_person g ,person p where g.group_id = '" + groupPerson.getGroupId() +"' and  g.flag = 'Approved' and p.role_name = 'User' and p.person_id = g.person_id" ;
				preparedStatement = conn.prepareStatement(getUserId);
				rs = preparedStatement.executeQuery();
				int newAdminId =-1;
				
				//check if this rs exists in joined table
				while(rs.next()){
					newAdminId = rs.getInt(1);
				}
				
				if(newAdminId != -1){
					String queryMakeAdmin = "insert into group_admins (group_id, person_id) values(?,?)";
					preparedStatementNew = conn.prepareStatement(queryMakeAdmin);
					preparedStatementNew.setInt(1,groupPerson.getGroupId());
					preparedStatementNew.setInt(2,newAdminId);
					preparedStatementNew.executeUpdate();
					
					makeGroupAdmin = "UPDATE person SET role_name ='GroupAdmin' WHERE person_id='"+ newAdminId+ "';";
					preparedStatementNew = conn.prepareStatement(makeGroupAdmin);
					preparedStatementNew.executeUpdate();
				}
				
			}
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

