package model;
public class Users extends Employee{
	//Attributes
	private String userName = "";
	private String password = "";
	//Methods
	public Users(String pUserName, String pPassword, String name, String lastName, String id) {
		super(name, lastName, id);
		userName = pUserName;
	    password = pPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
