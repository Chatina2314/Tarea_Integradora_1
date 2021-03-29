package model;

import java.util.ArrayList;
import java.util.Date;

public class Order {

	public final static String SOLICITADO = "Solicitado";
	public final static String EN_PROCESO = "En Proceso";
	public final static String ENVIADO = "Enviado";
	public final static String ENTREGADO = "Entregado";
	
	private int code;
	private int state;
	private ArrayList<Product> products;
	private int productsQuantity;
	private Client client;
	private Employee  employee;
	private Date dateRequest;
	private String observations;
	


	public Order(int code, int state, ArrayList<Product> products, int productsQuantity, Client client,
			Employee employee, Date dateRequest, String observations) {

		this.code = code;
		this.state = state;
		this.products = products;
		this.productsQuantity = productsQuantity;
		this.client = client;
		this.employee = employee;
		this.dateRequest = dateRequest;
		this.observations = observations;
	}

	
	public int getProductsQuantity() {
		return productsQuantity;
	}


	public void setProductsQuantity(int productsQuantity) {
		this.productsQuantity = productsQuantity;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public Date getDateRequest() {
		return dateRequest;
	}


	public void setDateRequest(Date dateRequest) {
		this.dateRequest = dateRequest;
	}


	public String getObservations() {
		return observations;
	}


	public void setObservations(String observations) {
		this.observations = observations;
	}


	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Date getDate() {
		return dateRequest;
	}

	public void setDate(Date dateRequest) {
		this.dateRequest = dateRequest;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getNitRestaurant() {
		return observations;
	}

	public void setNitRestaurant(String restaurant) {
		this.observations = restaurant;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
	public String orderState(int state) {
		String stateReturn="";
		
		switch (state) {
		case 1:
			stateReturn = SOLICITADO; 
			break;
			
		case 2:
			stateReturn = EN_PROCESO; 
			break;
		case 3:
			stateReturn = ENVIADO; 
			break;
		case 4:
			stateReturn = ENTREGADO; 
			break;
		}
		
		
		return stateReturn;
	}
	public String nameState() {
		String stateReturn="";
		
		switch (this.state) {
		case 1:
			stateReturn = SOLICITADO; 
			break;
			
		case 2:
			stateReturn = EN_PROCESO; 
			break;
		case 3:
			stateReturn = ENVIADO; 
			break;
		case 4:
			stateReturn = ENTREGADO; 
			break;
		}
		
		
		return stateReturn;
	}
	
	public String showProducts() {
		String str = "";
		for(Product e: getProducts()) {
			str+=e.toString()+"\n";
		}
		return str;
	}
	
	@Override
	public String toString() {
		String str = "";
		for(Product e: products) {
			str += e.getName()+" -- ";
		}
		return "Codigo "+code+" ;estado "+nameState()+" ;Fecha "+dateRequest + " ;productos "+str;
	}
	
	
}
