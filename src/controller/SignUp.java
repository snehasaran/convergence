
package controller;
import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import model.SignUpManager;


public class SignUp extends HttpServlet {
	
private static final long serialVersionUID = 1L;

	SignUpManager sinMgr = new SignUpManager();
	public SignUp() {
		super();
		System.out.println("testing");
	}

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		System.out.println("testing");
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("testing");
		String req = request.getParameter("subAddUser");
		if(req != null && req.equals("Add User")){
			this.addUserRequest(request, response);
			System.out.println("testing");
		}
		else{
			System.out.println("something wrong with add");
		}
		
	}
	
	public void addUserRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("This is add User request");
		System.out.println("testing");
		String userName = request.getParameter("txtUsrName");
		String userFirstName = request.getParameter("txtFirstName");
		String userLastName = request.getParameter("txtLastName");
		String phone = request.getParameter("txtPhoneNo");
		String phone_type = request.getParameter("phone_type");
		String city = request.getParameter("txtCity");
		String gender = request.getParameter("rdGender");
		String age = request.getParameter("txtAge");
		String state = request.getParameter("txtState");
		String email = request.getParameter("txtemail");
		System.out.println("testing");
		User u = new User();
		u.setUserName(userName);
		u.setUserFirstName(userFirstName);
		u.setUserLastName(userLastName);
		u.setPhoneType(Integer.parseInt(phone_type));
		u.setCity(city);
		u.setPhoneNo(phone);
		u.setGender(gender);
		u.setState(state);
		u.seteMail(email);
		u.setAge(Integer.parseInt(age));
		
		System.out.println("testing");
		RequestDispatcher rd = request.getRequestDispatcher("/social/WebContent/WEB-INF/UserCreated.html");
		rd.forward(request, response);
	}}


