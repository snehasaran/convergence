package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.*;

import model.UpdatePost;
@WebServlet("/updatepost")
public class UpdatePostServlet extends HttpServlet 
{
private static final long serialVersionUID = 1L;
	int group_id;
	UpdatePost demo = new UpdatePost();
	
	public UpdatePostServlet() 
	{
		super();
		
		System.out.println("the control comes in Update post servlet ");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String req = request.getParameter("post");
		int post_id = Integer.parseInt(request.getParameter("post_id"));
		
		System.out.println("The value comes in update servlet is: "+ req);
		System.out.println("The value comes in update servlet is: "+ post_id);
		if(req != null )
		{
			System.out.println("Came in InsertPostServlet");
			this.insertRequest(request, response, req, post_id);
			
		}
		else
		{
			System.out.println("No data to insert");
		}
		
	}

	public void insertRequest(HttpServletRequest request,
			HttpServletResponse response, String req, int post_id) throws ServletException, IOException {
		
		System.out.println("The control comes to insertRequest function");
		HttpSession session  = request.getSession();
		int user_id = (int) session.getAttribute("person_id");
		System.out.println("The value from text box is :" + req);
		demo.setUpdatePost(req,user_id,post_id);
		
		System.out.println("Username from text box is " + req );
		
		try{
			
			System.out.println("The data here is req: " + req);
			System.out.println("The data here is user_id: " + user_id);
			System.out.println("The data here is post_id: " + post_id);
			this.demo.UpdatePost(demo, req, user_id, post_id);
			RequestDispatcher rd = request.getRequestDispatcher("Group_page.jsp?group_id=" + session.getAttribute("group_id") + "&group_name=" +session.getAttribute("group_name") );
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

