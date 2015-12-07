package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class GroupAdminHome {

	String url = "jdbc:mysql://localhost:3306/";
	String dbName = "hw5";
	String driver = "com.mysql.jdbc.Driver";
	String userName = "admin"; 
	String password = "";
	
	public int count;
	public String[] first_name = new String[1000];
	public String[] group_name = new String[1000];
	public Integer[] group_id = new Integer[1000];
	public Integer[] person_id = new Integer[1000];
	
	public Connection getConnection() throws SQLException 
	{
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
	
	public void displayRequests(int groupAdminId)
	{
		
		//int groupId = 0;
		PreparedStatement ps;
		PreparedStatement ps1;
		PreparedStatement ps2;
		
		String q0 = "select group_id from group_admins where person_id = "+groupAdminId;
		
/*		String q1 = "select first_name, group_name, gp.group_id, gp.person_id "
				+ "from person p, groups grp, group_person gp "
				+ "where gp.group_id = grp.group_id and gp.person_id = p.person_id and gp.flag = 'Pending' and gp.group_id ="+groupId;*/
		
		
		try
		{
			ps2 = getConnection().prepareStatement(q0);
			ResultSet rs0 = ps2.executeQuery();
			rs0.next();
			int groupId = rs0.getInt(1);
			System.out.println("groupid inside displayRequests method " +groupId);
			
			String q1 = ""
					+ "select first_name, group_name, gp.group_id, gp.person_id "
					+ "from person p, groups grp, group_person gp "
					+ "where gp.group_id = grp.group_id and gp.person_id = p.person_id and gp.flag = 'Pending' and gp.group_id = "+groupId;
			
			String q2 = "select count(group_id) "
					+ "from group_person "
					+ "where flag = 'Pending' and group_id = "+groupId;
			
			ps = getConnection().prepareStatement(q1);
			ps1 = getConnection().prepareStatement(q2);
			
			ResultSet rs1 = ps.executeQuery();
			ResultSet rs2 = ps1.executeQuery();
			
			int i = 0;
			rs2.next();
			count = rs2.getInt(1);
			System.out.println("count inside displayRequests method " + count);
			
			while (rs1.next())
			{
				System.out.println(rs1.getString(1)+":"+rs1.getString(2)+":"+rs1.getInt(3)+":"+rs1.getInt(4));
				first_name[i] = rs1.getString(1);
				group_name[i] = rs1.getString(2);
				group_id[i]=rs1.getInt(3);
				person_id[i]=rs1.getInt(4);
				
				System.out.println(first_name[i] + " " + group_name[i]);
				
				i++;
			}
			
			
			rs1.close();
			rs2.close();
			ps.close();
			ps1.close();
			
	    }
		catch (SQLException e) 
		{
			System.out.println("Cannot run the query");
			e.printStackTrace();
			
		}
	}
	
	public void addUpdate(Map<Integer, String> chkbox)
	{
		System.out.println("Inside addUpdate() method");
		PreparedStatement ps;
		String q1;
		int j = 0;
		try
		{
			System.out.println("Inside try of addUpdate() method");
			for (Integer key : chkbox.keySet()) 
			{
	            System.out.println("Key = " + key);
	            System.out.println("Value = " + chkbox.get(key));
	            j = Integer.parseInt(chkbox.get(key));
	            q1 = "Update group_person set flag = 'Approved' where group_id = '" + group_id[j] + "' and person_id = '" + person_id[j] + "'";
	            ps = getConnection().prepareStatement(q1);
	            int i = ps.executeUpdate();
	            System.out.println("Updated " + i + " row as approved");
	            ps.close();
	        }
			
		}
		catch (SQLException e) 
		{
			System.out.println("Cannot run the query");
			e.printStackTrace();
			
		}
	}
	
	public void rejectUpdate(Map<Integer, String> chkbox)
	{
		System.out.println("Inside rejectUpdate() method");
		PreparedStatement ps;
		String q1;
		int j = 0;
		try
		{
			System.out.println("Inside try of rejectUpdate() method");
			for (Integer key : chkbox.keySet()) 
			{
	            System.out.println("Key = " + key);
	            System.out.println("Value = " + chkbox.get(key));
	            j = Integer.parseInt(chkbox.get(key));
	            q1 = "Update group_person set flag = 'Rejected' where group_id = '" + group_id[j] + "' and person_id = '" + person_id[j] + "'";
	            ps = getConnection().prepareStatement(q1);
	            int i = ps.executeUpdate();
	            System.out.println("Updated " + i + " row as rejected");
	            ps.close();
	        }
			
		}
		catch (SQLException e) 
		{
			System.out.println("Cannot run the query");
			e.printStackTrace();
		}
	}
}
