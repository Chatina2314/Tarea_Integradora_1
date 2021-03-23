package model;
public class Order {
	//Attributes
	private int code = 0;
	private String products = "";
	private int quantity = 0;
	private String customer = "";
	private String employeeCharge = "";
	private String date = "";
	private String hour = "";
	private String observations = "";
	//Relations
	private Condition conditions;
	//Methods
    public Order(int pCode, String pProducts, int pQuantity, String pCustomer, String pEmployeeCharge, String pDate, String pHour, String pObservations, int pConditions) {
    	code = pCode;
    	products = pProducts;
    	quantity = pQuantity;
    	customer = pCustomer;
    	employeeCharge = pEmployeeCharge;
    	date = pDate;
    	hour = pHour;
    	observations = pObservations;
    }
    public Condition getConditions() {
		return conditions;
	}
	public void setConditions(int pConditions) {
		if(pConditions==1) {
    		conditions = Condition.REQUESTED;
    	}
    	else if(pConditions==2) {
    		conditions = Condition.IN_PROCES;
    	}
    	else if(pConditions==3) {
    		conditions = Condition.SENT;
    	}
    	else if(pConditions==4) {
    		conditions = Condition.DELIVERED;
    	}
    	else if(pConditions==5) {
    		conditions = Condition.CANCELED;
    	}
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getProducts() {
		return products;
	}
	public void setProducts(String products) {
		this.products = products;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getEmployeeCharge() {
		return employeeCharge;
	}
	public void setEmployeeCharge(String employeeCharge) {
		this.employeeCharge = employeeCharge;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}
}
