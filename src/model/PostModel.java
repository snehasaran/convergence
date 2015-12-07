package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Post;
import connection.DatabaseConnection;

public class PostModel {
	
	private Post post;
	private Connection conn;
	
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}	
	
	public PostModel() throws SQLException {
		conn = DatabaseConnection.getConnection();
	}
	
	public boolean endorsePost() {
		try{

			String query = "update post set endorse = ? where id=?";
			PreparedStatement ps = conn.prepareStatement(query);
				
		    ps.setBoolean(1,true);
		    ps.setInt(2, post.getId());
		   
		    ps.executeUpdate();
		    ps.close();
		    return true;

		} catch(SQLException se) {
			se.printStackTrace();
		}

		return false;
	}

}
