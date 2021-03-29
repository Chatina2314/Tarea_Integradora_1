package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Client extends Person{
	

	private final StringProperty adrress;
	private final StringProperty phone;
	//private String observations;
	//private final StringProperty observations;
	private final StringProperty observa;
	

	public Client() {
		this("","","","","", "");
	}
	public Client(String name, String lastName, String id, String adrress, String phone, String observations) {
		super(name, lastName, id);
		this.adrress = new SimpleStringProperty(adrress);
		this.phone = new SimpleStringProperty(phone);
		//this.observations = observations;
		this.observa = new SimpleStringProperty(observations);
	}

	public StringProperty nameProperty() {return name;}
	public StringProperty lastNameProperty() {return lastName;}
	public StringProperty idProperty() {return id;}
	public StringProperty adrressProperty() {return adrress;}
	public StringProperty phoneProperty() {return phone;}
	
	public StringProperty observaProperty() {return observa;}
	

	public String getobservations() {
		//return this.observations.get();
		return this.observa.get();
	}


	public void setobservations(String observations) {
		//this.observations = observations;
		this.observa.set(observations);
	}

	public String getPhone() {
		return phone.get();
	}


	public void setPhone(String phone) {
		this.phone.set(phone);
	}


	public String getAdrress() {
		return adrress.get();
	}


	public void setAdrress(String adrress) {
		this.adrress.set(adrress);
	}
	
	@Override
	public String toString() {
		return "Nombre Completo " + name + " " +lastName + "; observaciones: " + observa + " ;num de ID "+ id + " ;telefono " + phone + " ;dirección "+adrress;
	}



	
	
	
	

}
