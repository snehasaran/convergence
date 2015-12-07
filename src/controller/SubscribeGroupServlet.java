package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.GroupPerson;
import model.SubscribeGroupModel;

@WebServlet("/subscribe")
public class SubscribeGroupServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private SubscribeGroupModel model;
	private static String STATUS = "Pending";

	public SubscribeGroupServlet() throws SQLException
	{
		super();
		model = new SubscribeGroupModel();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String groupId = request.getParameter("groupId");
		int personId = (int) session.getAttribute("person_id");
		String isSubscribed = request.getParameter("subscribe");
		String userName = session.getAttribute("user_name").toString();
		if(groupId != null)
		{
			System.out.println("Insert new records for subscribing to group " + groupId);
			GroupPerson groupPerson = new GroupPerson();
			groupPerson.setGroupId(groupId);
			groupPerson.setPersonId(personId);
			groupPerson.setStatus(STATUS);	
			model.setGroupPerson(groupPerson);
			if(isSubscribed.equals("true"))
				model.addGroupSubscription();
			else 
				model.deleteGroupSubscription();
			RequestDispatcher rd = request.getRequestDispatcher("Successful_Login.jsp?user_name=" + userName);			
		    rd.forward(request, response);
		}
		else
		{
			System.out.println("No data to insert");
		}	
	}
}


