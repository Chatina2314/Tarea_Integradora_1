package model;
public class Employee {
	//Attributes
	private String name = "";
	private String lastName = "";
	private String id = "";
	//Methods
    public Employee(String pName, String pLastName, String pId) {
    	name = pName;
    	lastName = pLastName;
    	id = pId;
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
}
