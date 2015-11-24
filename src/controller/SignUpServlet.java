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

import model.CheckUserDemo;
import model.InsertUserDemo;
@WebServlet("/signup")
public class SignUpServlet extends HttpServlet 
{
private static final long serialVersionUID = 1L;
	InsertUserDemo demo = new InsertUserDemo();
	
	CheckUserDemo demo1 = new CheckUserDemo();
	
	public SignUpServlet() 
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String txtUsrName = request.getParameter("txtUsrName");
		String txtPassword = request.getParameter("txtPassword");
		String txtFirstName = request.getParameter("txtFirstName");
		String txtLastName = request.getParameter("txtLastName");
		String txtCity = request.getParameter("txtCity");
		String txtState = request.getParameter("txtState");
		String txtAge = request.getParameter("txtAge");
		String phone_type = request.getParameter("phone_type");
		String txtPhoneNo = request.getParameter("txtPhoneNo");
		String txteMail = request.getParameter("txteMail");
		String rdGender = request.getParameter("rdGender");
		System.out.println("The control comes to SignUpServlet page");
		
		this.insertRequest(request, response);
		
	}

	public void insertRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String txtUsrName = request.getParameter("txtUsrName");
		String txtPassword = request.getParameter("txtPassword");
		String txtFirstName = request.getParameter("txtFirstName");
		String txtLastName = request.getParameter("txtLastName");
		String txtCity = request.getParameter("txtCity");
		String txtState = request.getParameter("txtState");
		int txtAge = Integer.parseInt(request.getParameter("txtAge"));
		int phone_type = Integer.parseInt(request.getParameter("phone_type"));
		long txtPhoneNo = Long.parseLong(request.getParameter("txtPhoneNo"));
		String txteMail = request.getParameter("txteMail");
		String rdGender = request.getParameter("rdGender");
		
		
		demo.setInsertUser(txtUsrName,txtPassword,txtFirstName,txtLastName,txtCity,txtState,txtAge,phone_type,txtPhoneNo,txteMail,rdGender);
		
		demo1.setCheckUser(txtUsrName);
		
		try {
			HttpSession session = request.getSession();
				
				if (this.demo1.checkUser(demo1))
				{
					System.out.println("Now inserting the user");
				this.demo.InsertUser(demo);
				}
				
				RequestDispatcher rd = request.getRequestDispatcher("View_Login.jsp");
				
				rd.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

