package model;
import java.util.ArrayList;
public class Restaurant {
	//Attributes
	private String name = "";
	private int orderCode = 1;
	//Relations
	private ArrayList<Users> user;
	private ArrayList<Customers> customers;
	private ArrayList<Products> products;
	private ArrayList<Ingredients> ingredient;
	private ArrayList<Order> order;
	//Methods
    public Restaurant(String pName) {
    	name = pName;
    	user = new ArrayList<Users>();
    	customers = new ArrayList<Customers>();
    	products = new ArrayList<Products>();
    	ingredient = new ArrayList<Ingredients>();
    	order = new ArrayList<Order>();
    }
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Users searchUser(String id){
		Users searchUser = null;
	    boolean find = false;
	    for (int i=0;i<user.size()&&!find==false;i++){
			Users users = user.get(i);
			if (users.getId().equals(id)){
				searchUser = user.get(i);
				find = true;
			}
		}
			return searchUser;
	}
	public String addUser(String name, String lastName, String id, String userName, String password){
		String message = "";
		Users users = searchUser(id);
		if(users!=null){
			message = "The user already exists.";
		}
		else{	
			users = new Users (name, lastName, id, userName, password);
			user.add(users);
			message = "The new user was successfully registered.";
		}
		return message;
	}
	public String removeUser(String id){
		String message = "";
		boolean remove = false;
		for(int i=0;i<user.size()&&!remove;i++){
			if (user.get(i).getId().equals(id)){
				user.remove(i);
				remove = true;
				message = "The user has been removed.";
			}
		}
		return message;
	}
	public Customers searchCustomer(String id) {
		Customers searchCustomer = null;
		boolean find = false;
	    for (int i=0;i<customers.size()&&!find==false;i++){
			Customers customer = customers.get(i);
			if (customer.getId().equals(id)){
				searchCustomer = customers.get(i);
				find = true;
			}
		}
	    return searchCustomer;
	}
	public String addCustomer(String name, String lastName, String id, String direction, String phone, String observations){
		String message = "";
		Customers customer = searchCustomer(id);
		if(customer!=null){
			message = "The customer already exists.";
		}
		else{	
			customer = new Customers (name, lastName, id, direction, phone, observations);
			customers.add(customer);
			message = "The new customer was successfully registered.";
		}
		return message;
	}
	public String removeCustomer(String id){
		String message = "";
		boolean remove = false;
		for(int i=0;i<customers.size()&&!remove;i++){
			if (customers.get(i).getId().equals(id)){
				customers.remove(i);
				remove = true;
				message = "The customer has been removed.";
			}
		}
		return message;
	}
	public void addOrder(String products, int quantity, String customer, String employeeCharge, String date, String hour, String observations, int conditions) {
		Order orders = new Order(orderCode, products, quantity, customer, employeeCharge, date, hour, observations, conditions);
		order.add(orders);
		orderCode++;
	}
	public String removeIngredients(String name){
		String message = "";
		boolean remove = false;
		Ingredients ingredients = null;
		for(int i=0;i<products.size()&&ingredients!=null;i++) {
			ingredients = products.get(i).searchIngredients(name);
		}
		if(ingredients!=null) {
			for(int i=0;i<ingredient.size()&&!remove;i++){
				if (ingredient.get(i).getName().equals(name)){
					ingredient.remove(i);
					remove = true;
					message = "The ingredient has been removed.";
				}
			}
		}
		return message;
	}
}
