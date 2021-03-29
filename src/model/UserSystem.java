package model;

public class UserSystem extends Employee {

	
	String nickName;
	String password;
	
	
	public UserSystem(String name, String lastName, String id, String nickName, String password) {
		super(name, lastName, id);
		this.nickName = nickName;
		this.password = password;
	}


	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nickname: "+nickName+", password: "+password;
	}
}
