package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.LikePostPerson;
import beans.Post;
import connection.DatabaseConnection;

public class LikePostPersonModel {

	private LikePostPerson likePostPerson;
	private Connection conn;
	
	public LikePostPerson getLikePostPerson() {
		return likePostPerson;
	}

	public void setLikePostPerson(LikePostPerson likePostPerson) {
		this.likePostPerson = likePostPerson;
	}

	public LikePostPersonModel() throws SQLException {
		conn = DatabaseConnection.getConnection();
	}
	
	/**
	 * Insert into like_post_person table that records user has liked the post 
	 * @return true if the person previously have not liked the post
	 * @throws SQLException 
	 */
	public boolean isInsertedIntoLikePostTable() throws SQLException {
		
		String query = "select * from like_post_person where post_id = ? and person_id = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(query);
		preparedStatement.setInt(1, likePostPerson.getPostId());
		preparedStatement.setInt(2, likePostPerson.getPersonId());
		ResultSet rs = preparedStatement.executeQuery();
		int likeCount = 0;
		
		while(rs.next()) {
			likeCount += 1;
		}
		
		if(likeCount == 0){
			query = "insert into like_post_person(post_id, person_id) values(?, ?)";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, likePostPerson.getPostId());
			preparedStatement.setInt(2, likePostPerson.getPersonId());
			preparedStatement.executeUpdate();
			return true;
		}
		
		preparedStatement.close();
		rs.close();
		return false;
	}
	
}
