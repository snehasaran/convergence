package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AdminHome;
import model.DBDemo;
import model.GroupAdminHome;

/**
 * Servlet implementation class TestLoginServlet
 */
//@WebServlet("/TestLoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DBDemo demo = new DBDemo();
	AdminHome admin = new AdminHome();
	GroupAdminHome groupAdmin = new GroupAdminHome();

	public LoginServlet() 
	{
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String req1 = request.getParameter("subAdd");
		String req2 = request.getParameter("subReject");
		int j = 0;

		Map<Integer, String> chkbox = new HashMap<Integer, String>();
		String[] checkboxes = new String[1000];
		System.out.println("Inside login servlet");
		checkboxes = request.getParameterValues("requests");
		for (String c : checkboxes)
		{
			chkbox.put(j,c);
			j++;
			System.out.println("c = " + c + "::::" + "j =" + j);
		}
		
		

		if(req1 != null && req1.equals("Add"))
		{
			System.out.println("Calling add method....");
			try{
				if(this.demo.getRole(demo).equals("groupadmin")){
					groupAdmin.addUpdate(chkbox);
					System.out.println("Calling group admin add method....");
				}

				else{
					admin.addUpdate(chkbox);
					System.out.println("Calling admin add method....");
				}

			}
			catch(Exception ex){
				System.out.println("Unable call Add method");
			}

		}
		else
		{
			if(req2 != null && req2.equals("Reject"))
			{
				System.out.println("Calling reject method....");
				try{
					if(this.demo.getRole(demo).equals("groupadmin")){
						groupAdmin.rejectUpdate(chkbox);
						System.out.println("Calling group admin reject method....");
					}
					else{
						groupAdmin.rejectUpdate(chkbox);
						System.out.println("Calling admin reject method....");
					}
				}
				catch(Exception e){
					System.out.println("Unable to call reject method");
				}

			}
			else
			{
				System.out.println("Cannot do any operation");
			}
		}
		System.out.println("Out of if loop...");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		

		String req = request.getParameter("subLogin");
		
		//String findGrpToDeactivate = request.getParameter("deactivateGroup");
		if(req != null)
		{
			if(req.equals("Login")){
				this.loginRequest(request, response);
			}
			else if(req.equals("Create")){
				String groupName = request.getParameter("txtGroupName");
				String groupDescr = request.getParameter("txtGroupDescr");
				admin.createGroup(groupName,groupDescr);
			}
			else if(req.equals("Deactivate")){
				int j = 0;

				Map<Integer, String> chkbox = new HashMap<Integer, String>();
				String[] checkboxes = new String[1000];
				System.out.println("Inside doPost Method of loginServlet");
				checkboxes = request.getParameterValues("requests");
				for (String c : checkboxes)
				{
					chkbox.put(j,c);
					j++;
					System.out.println("c = " + c + "::::" + "j =" + j);
				}
				
				//String groupToDeactivate = request.getParameter("requests");
				admin.deactivateGroup(chkbox);
			}

		}
		else
		{
			System.out.println("Cannot login");
		}


	}

	public void loginRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();

		}
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
				session = request.getSession();
				session.setAttribute("chkuser",demo.chkuser);
				System.out.println("chkuser = " + demo.chkuser);
				session.setAttribute("person_id", demo.person_id);
				session.setAttribute("user_name",name);

				if (this.demo.getRole(demo).equals("user"))
				{
					request.setAttribute("role", "User");
					RequestDispatcher rd = request.getRequestDispatcher("Successful_Login.jsp?user_name=" + name);
					rd.forward(request, response);
				}
				else if(this.demo.getRole(demo).equals("groupadmin"))
				{
					request.setAttribute("role", "Group Admin");
					RequestDispatcher rd = request.getRequestDispatcher("Group_Admin_Home.jsp?user_name=" + name);
					groupAdmin.displayRequests(demo.person_id);
					System.out.println("count is " + groupAdmin.count);
					request.setAttribute("count",groupAdmin.count);
					for (int i=0; i<groupAdmin.first_name.length;i++)
					{
						if(groupAdmin.first_name[i] != null)
						{	request.setAttribute("first_name",groupAdmin.first_name);
						System.out.println("first_name " + groupAdmin.first_name[i]);
						}	
					}


					for (int i=0; i<groupAdmin.group_name.length;i++)
					{
						if (groupAdmin.group_name[i] != null && !groupAdmin.group_name[i].isEmpty())
						{
							System.out.println("group_name in loginservlet is for group_admin: " + groupAdmin.group_name[i]);
							request.setAttribute("group_name",groupAdmin.group_name);
						}

					}
					rd.forward(request, response);
				}
				else if(this.demo.getRole(demo).equals("admin"))
				{
					request.setAttribute("role", "Admin");

					RequestDispatcher rd = request.getRequestDispatcher("Admin_Home.jsp?user_name=" + name);
					admin.displayRequests();
					System.out.println("count is " + admin.count);
					request.setAttribute("count",admin.count);
					for (int i=0; i<admin.first_name.length;i++)
					{
						if(admin.first_name[i] != null)
						{	request.setAttribute("first_name",admin.first_name);
						System.out.println("first_name " + admin.first_name[i]);
						}	
					}


					for (int i=0; i<admin.group_name.length;i++)
					{
						if (admin.group_name[i] != null && !admin.group_name[i].isEmpty())
						{
							System.out.println("group_name in loginservlet is for admin: " + admin.group_name[i]);
							request.setAttribute("group_name",admin.group_name);
						}

					}

					rd.forward(request, response);
				}
			}
			else
			{
				System.out.println("Calling view_login.jsp request = " + request + " response = " + response);
				session = request.getSession();
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
