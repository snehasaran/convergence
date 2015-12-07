package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.LikePostPerson;
import model.LikePostPersonModel;

@WebServlet("/like") 
public class LikePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LikePostPersonModel model;

	public LikePostServlet() throws SQLException
	{
		super();
		model = new LikePostPersonModel();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		LikePostPerson likePostPerson = new LikePostPerson();
		likePostPerson.setPersonId((int) session.getAttribute("person_id"));
		likePostPerson.setPostId(Integer.parseInt(request.getParameter("id")));
		model.setLikePostPerson(likePostPerson);	
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(String.valueOf(model.isInsertedIntoLikePostTable()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
