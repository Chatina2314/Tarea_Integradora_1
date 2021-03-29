package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
	
	final StringProperty name;
	final StringProperty lastName;
	final StringProperty id;
	
	public Person(String name, String lastName, String id) {
		this.name = new SimpleStringProperty(name);
		this.lastName = new SimpleStringProperty(lastName);
		this.id = new SimpleStringProperty(id);
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public String getLastName() {
		return lastName.get();
	}

	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}

	public String getId() {
		return id.get();
	}

	public void setId(String id) {
		this.id.set(id);
	}
	
	

}
