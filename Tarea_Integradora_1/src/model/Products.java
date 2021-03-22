package model;
import java.util.ArrayList;
public class Products {
	//Attributes
	private String name = "";
	private String size = "";
	private double price = 0;
	//Relations
	private TypeProduct type;
	private ArrayList<Ingredients> ingredient;
	//Methods
	public Products(String pName, String pSize, double pPrice, int pType, ArrayList<Ingredients> pIngredient) {
		name = pName;
		size = pSize;
		price = pPrice;
		ingredient = pIngredient;
	}
	public String getName() {
    	return name;
	}
    public void setName(String name) {
    	this.name = name;
	}
    public String getSize() {
    	return size;
    }
    public void setSize(String size) {
    	this.size = size;
    }
    public double getPrice() {
    	return price;
    }
    public void setPrice(double price) {
    	this.price = price;
    }
    public TypeProduct getType() {
		return type;
	}
	public void setType(int pType) {
		if(pType==1) {
    		type = TypeProduct.MAIN_COURSE;
    	}
    	else if(pType==2) {
    		type = TypeProduct.ADDITIONAL;
    	}
    	else if(pType==3) {
    		type = TypeProduct.DRINK;
    	}
	}
	public ArrayList<Ingredients> getIngredient() {
		return ingredient;
	}
	public void setIngredient(ArrayList<Ingredients> ingredient) {
		this.ingredient = ingredient;
	}
	public Ingredients searchIngredients(String name){
		Ingredients searchIngredients = null;
	    boolean find = false;
	    for (int i=0;i<ingredient.size()&&!find==false;i++){
	    	Ingredients ingredients = ingredient.get(i);
			if (ingredients.getName().equals(name)){
				searchIngredients = ingredient.get(i);
				find = true;
			}
		}
			return searchIngredients;
	}
}
