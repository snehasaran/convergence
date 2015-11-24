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

import model.ApproveUser;
import model.InsertDemo;
@WebServlet("/ApproveServlet")
public class ApproveServlet extends HttpServlet 
{
private static final long serialVersionUID = 1L;
	int group_id;
	ApproveUser demo = new ApproveUser();
	
	public ApproveServlet() 
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("THe control comes to doget of Approve Servlet");
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int group_id = Integer.parseInt(request.getParameter("group_id"));
		int person_id = Integer.parseInt(request.getParameter("person_id"));
		System.out.println("The value from page id :" + group_id +" and "+ person_id);
		this.ApproveRequest(request, response);
}

	public void ApproveRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("The control comes to ApproveRequest function");
		int group_id = Integer.parseInt(request.getParameter("group_id"));
		int person_id = Integer.parseInt(request.getParameter("person_id"));
		String name = request.getParameter("user_name");
		System.out.println("The value from page id :" + group_id +" and "+ person_id);
		demo.setApproveUser(group_id,person_id);
		try {
				this.demo.ApproveUser(demo, group_id, person_id );
				System.out.println("the User is approved");
				RequestDispatcher rd = request.getRequestDispatcher("loginservlet?&continue="+name);
				rd.forward(request, response);
		} catch (SQLException e) {
			System.out.println("The error comes from here");
			e.printStackTrace();
		}
	}

}

