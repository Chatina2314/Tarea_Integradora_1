package model;
import java.util.ArrayList;
public class Restaurant {
	//Attributes
	private String name = "";
	private int orderCode = 1;
	//Relations
	private ArrayList<Employee> employees;
	private ArrayList<Customers> customers;
	private ArrayList<Products> products;
	private ArrayList<Ingredients> ingredient;
	private ArrayList<Order> order;
	//Methods
    public Restaurant(String pName) {
    	name = pName;
    	employees = new ArrayList<Employee>();
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
	public Employee searchEmployee(String id){
		Employee searchEmployee = null;
	    boolean find = false;
	    for (int i=0;i<employees.size()&&!find==false;i++){
			Employee employee = employees.get(i);
			if (employee.getId().equals(id)){
				searchEmployee = employees.get(i);
				find = true;
			}
		}
			return searchEmployee;
	}
	public String addEmployee(String name, String lastName, String id){
		String message = "";
		Employee employee = searchEmployee(id);
		if(employee!=null){
			message = "The employee already exists.";
		}
		else{	
			employee = new Employee (name, lastName, id);
			employees.add(employee);
			message = "The new employee was successfully registered.";
		}
		return message;
	}
	public String removeEmployee(String id){
		String message = "";
		boolean remove = false;
		for(int i=0;i<employees.size()&&!remove;i++){
			if (employees.get(i).getId().equals(id)){
				employees.remove(i);
				remove = true;
				message = "The employee has been removed.";
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
