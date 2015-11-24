package beans;

import java.util.List;
import java.util.ArrayList;


public class User {

	
	private String userName;
	private String userFirstName;
	private String userLastName;
	private String city;
	private String state;
	private String gender;
	private int age;
	private int phone_type;
	private String phoneNo;
	private String email;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String txtFirstName) {
		this.userFirstName = userFirstName;
	}
	
	
	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String txtLastName) {
		this.userLastName = userFirstName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getPhoneType() {
		return phone_type;
	}

	public void setPhoneType(int phone_type) {
		this.phone_type = phone_type;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String geteMail() {
		return email;
	}

	public void seteMail(String email) {
		this.email = email;
	}
	
}
