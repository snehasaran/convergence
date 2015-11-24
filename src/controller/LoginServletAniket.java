package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DBDemo;
import model.AdminHome;
@WebServlet("/loginservlet")
public class LoginServletAniket extends HttpServlet 
{
private static final long serialVersionUID = 1L;
	
	DBDemo demo = new DBDemo();
	AdminHome admin = new AdminHome();
	
	public LoginServletAniket() 
	{
		super();
		System.out.println("The control comes back to the LoginServlet page");
		System.out.println("The continue value is :" );
	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		System.out.println("The control comes to goGet para again");
		if((request.getParameter("subAdd") != null) && (request.getParameter("continue") == null))
		{
		String req1 = request.getParameter("subAdd");
		if(req1 != null & req1.equals("Add"))
		{
			System.out.println("Now continuing 33");
			this.add();
		}
		}
		else
		{
		System.out.println("The control comes to doGet para now need to check goPost para");
		System.out.println("The value from request.getParameter is: " + request.getParameter("continue"));
		System.out.println("The value from request.getAttribute is: " + request.getAttribute("continue"));
		if (request.getParameter("continue") != null)
		{
			System.out.println("Now continuing 11");
			doPost(request,response);
		}
		}	
			
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("The control comes to doPost para again");
		if((request.getParameter("subLogin") != null) && request.getAttribute("continue") == null)
		{
		String req = request.getParameter("subLogin");
		if(req != null && req.equals("Login"))
		{
			this.loginRequest(request, response);		
		}
		else
			
					System.out.println("Now continuing 222 ");				
		}
		
		if (request.getParameter("continue") != null)
		{
			System.out.println("Now calling continueRequest function");
			this.continueRequest(request, response);
		}
		
	}

	public void loginRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("This is login request");
		
		String userName = request.getParameter("txtUserName");
		String password = request.getParameter("txtPassword");
				
		
		demo.setUserName(userName);
		demo.setPassword(password);
		
		System.out.println("Username from text box is " + userName + " and password is " + password);
		
		try 
		{
			if (userName!= null & password!= null)
			{
			System.out.println("validating the usr");
			this.demo.validateUser(demo);
			}
			else
			{
				System.out.println("Invalid username and password");
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("ERROR: " + e.getMessage());
			e.printStackTrace();
		}
				
		try {
			if (this.demo.validateUser(demo))
			{
				System.out.println("The control comes here");
				
				String name = request.getParameter("txtUserName");
				HttpSession session = request.getSession();
				session.setAttribute("chkuser",demo.chkuser);
				System.out.println("chkuser = " + demo.chkuser);
				session.setAttribute("person_id", demo.person_id);

				if (this.demo.isRole(demo))
				{
				session.setAttribute("role", "User");
				System.out.println("the user name in login servlet is :" + name);
				RequestDispatcher rd = request.getRequestDispatcher("Successful_Login.jsp?user_name=" + name);
				rd.forward(request, response);
				}
				else
				{
					session.setAttribute("role", "Admin");
					System.out.println("count now is: " + admin.count);
					System.out.println("Now calling the Admin_Home");
					RequestDispatcher rd = request.getRequestDispatcher("Admin_Home.jsp?user_name=" + name );
					admin.displayRequests();
					//System.out.println("count is " + admin.count);
					request.setAttribute("count",admin.count);
					System.out.println("count is " + admin.count);
					
					for (int i=0; i<admin.first_name.length;i++)
					{
						if(admin.first_name[i] != null)
						{	request.setAttribute("first_name",admin.first_name);
							System.out.println("first_name " + admin.first_name[i]);
						}	
					}
					
					
					for (int i=0; i<admin.group_id.length;i++)
					{
						if(admin.group_id[i] != null)
						{
							request.setAttribute("group_id",admin.group_id);
							System.out.println("group_id " + admin.group_id[i]);
						}
						
					}
					
					for (int i=0; i<admin.person_id.length;i++)
					{
						if(admin.person_id[i] != null)
						{
							System.out.println("person_id " + admin.person_id[i]);
							request.setAttribute("person_id",admin.person_id);
						}
					}
					for (int i=0; i<admin.group_name.length;i++)
					{
						if (admin.group_name[i] != null && !admin.group_name[i].isEmpty())
						{
							System.out.println("group_name in loginservlet is: " + admin.group_name[i]);
							request.setAttribute("group_name",admin.group_name);
						}
						
					}

					
					rd.forward(request, response);
				}
			}
			else
			{
				System.out.println("Calling view_login.jsp request = " + request + " response = " + response);
				HttpSession session = request.getSession();
				session.setAttribute("chkuser",demo.chkuser);
				System.out.println("chkuser = " + demo.chkuser);
				System.out.println("session.getAttribute('chkuser') = "+ session.getAttribute("chkuser"));
				RequestDispatcher rd = request.getRequestDispatcher("View_Login.jsp?chkuser=" + session.getAttribute("chkuser"));
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//////////////////
	public void continueRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	System.out.println("The control comes here");
	String name = request.getParameter("continue");
	HttpSession session = request.getSession();
	session.setAttribute("chkuser",demo.chkuser);
	System.out.println("chkuser = " + demo.chkuser);
	session.setAttribute("person_id", demo.person_id);
	System.out.println("count now is: " + admin.count);
	System.out.println("Now calling the Admin_Home");
	RequestDispatcher rd = request.getRequestDispatcher("Admin_Home.jsp?user_name=" + name );
	admin.displayRequests();
	request.setAttribute("count",admin.count);
	System.out.println("count is " + admin.count);	
		for (int i=0; i<admin.first_name.length;i++)
		{
			if(admin.first_name[i] != null)
			{	request.setAttribute("first_name",admin.first_name);
				System.out.println("first_name " + admin.first_name[i]);
			}	
		}
		
		
		for (int i=0; i<admin.group_id.length;i++)
		{
			if(admin.group_id[i] != null)
			{
				request.setAttribute("group_id",admin.group_id);
				System.out.println("group_id " + admin.group_id[i]);
			}
			
		}
		
		for (int i=0; i<admin.person_id.length;i++)
		{
			if(admin.person_id[i] != null)
			{
				System.out.println("person_id " + admin.person_id[i]);
				request.setAttribute("person_id",admin.person_id);
			}
		}
		for (int i=0; i<admin.group_name.length;i++)
		{
			if (admin.group_name[i] != null && !admin.group_name[i].isEmpty())
			{
				System.out.println("group_name in loginservlet is: " + admin.group_name[i]);
				request.setAttribute("group_name",admin.group_name);
			}
			
		}
		rd.forward(request, response);
	}
/////////////////////
	
	public void add()
		{
		
		
		}
}
