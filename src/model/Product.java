package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Product {

	public final static String PLATO_PRINCIPAL = "Plato principal";
	public final static String ADICIONAL = "Adicional";
	public final static String BEBIDA = "Bebida";
	
	private String name;
	private StringProperty type;
	private StringProperty ingredients;
	private StringProperty size;
	private double price;
	
	//private final StringProperty observa;
	
	public Product( String name,String type, String ingredients, String size, double price) {
		super();
		this.name = name;
		this.type = new SimpleStringProperty(type);
		this.ingredients = new SimpleStringProperty(ingredients);
		this.size = new SimpleStringProperty(size);
		this.price = price;
	}
	
	public StringProperty typeProperty() { return type; }
	public StringProperty ingredientsProperty() { return ingredients; }
	public StringProperty sizeProperty() { return size; }

	public String gettype() {
		return type.get();
	}

	public void settype(String typee) {
		this.type.set(typee);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getingredients() {
		return ingredients.get();
	}

	public void setingredients(String ingredients) {
		this.ingredients.set(ingredients);
	}

	public String getsize() {
		return size.get();
	}

	public void setsize(String size) {
		this.size.set(size);
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Nombre "+ name +" ;tipo " + type + " ;ingredientes "+ ingredients + " ;Precio "+price+ " ;tamaño "+size;
	}
	
	
	
	
}
