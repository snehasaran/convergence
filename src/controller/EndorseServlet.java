package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Post;
import model.PostModel;

@WebServlet("/endorse")
public class EndorseServlet extends HttpServlet {
	
	private PostModel postModel;	

	public EndorseServlet() throws SQLException {
		postModel = new PostModel();
	}
	
	public PostModel getPostModel() {
		return postModel;
	}

	public void setPostModel(PostModel postModel) {
		this.postModel = postModel;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
		Post post = new Post();
		post.setId(Integer.parseInt(request.getParameter("id")));
		postModel.setPost(post);	
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");	
		response.getWriter().write(String.valueOf(postModel.endorsePost()));
	}
}
