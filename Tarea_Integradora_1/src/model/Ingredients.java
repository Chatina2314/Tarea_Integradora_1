package model;
public class Ingredients {
	//Attributes
	private String name = "";
	//Methods
	public Ingredients(String pName) {
		name = pName;
	}
	public String getName() {
    	return name;
	}
    public void setName(String name) {
    	this.name = name;
	}
}