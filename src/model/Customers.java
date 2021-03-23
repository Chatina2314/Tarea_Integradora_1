package model;
public class Customers {
	//Attributes
	private String name = "";
	private String lastName = "";
	private String id = "";
	private String direction = "";
	private String phone = "";
	private String observations = "";
	//Methods
	public Customers(String pName, String pLastName, String pId, String pDirection, String pPhone, String pObservations) {
		name = pName;
		lastName = pLastName;
		id = pId;
		direction = pDirection;
		phone = pPhone;
		observations = pObservations;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getObservations() {
		return observations;
	}
}
