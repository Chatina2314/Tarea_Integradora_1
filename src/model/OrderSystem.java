package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;


public class OrderSystem {

	private ArrayList<Product> products;
	private ArrayList<Order> orders;
	private ArrayList<Client> clients;
	private ArrayList<Employee> employees;
	private ArrayList<UserSystem> userSystems;
	
	
	
	
	public OrderSystem() {
		super();
		this.products = new ArrayList<Product>();
		this.clients = new ArrayList<Client>();
		this.orders = new ArrayList<Order>();
	}



	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}

	public ArrayList<UserSystem> getUserSystems() {
		return userSystems;
	}

	public void setUserSystems(ArrayList<UserSystem> userSystems) {
		this.userSystems = userSystems;
	}


	public void addProduct(Product product) {
		if (product != null) {
			products.add(product);
		}
	}

	public void addClient(Client client) {
		clients.add(client);

	}

	public void addOrder(Order order) {
		if (order != null) {
			orders.add(order);
		}
	}
	
	public void addEmployee(Employee employee) {
		if (employee != null) {
			employees.add(employee);
		}
	}

	public void addUserSystem(UserSystem userSystem) {
		if (userSystem != null) {
			userSystems.add(userSystem);
		}

	}


	public void updateProduct( String name, String type, String ingredients, String size, int price) {
		if (name != null && name != " ") {
			for (int i = 0; i < products.size(); i++) {
				Product prod = products.get(i);
				if (name.equals(prod.getName())) {
					prod.setingredients(ingredients);
					prod.setName(name);
					prod.setPrice(price);
					prod.setsize(size);
					prod.settype(type);
				}
			}
		}
	}
	
	public void updateClient(String name, String lastName, String id, String phone, String adrress, String observations) {
		if (id != null && id != " ") {
			for (int i = 0; i < clients.size(); i++) {
				Client cli = clients.get(i);
				if (id.equals(cli.getId())) {
					cli.setName(name);
					cli.setLastName(lastName);
					cli.setAdrress(adrress);
					cli.setId(id);
					cli.setPhone(phone);
					cli.setobservations(observations);
				}
			}
		}
	}
	
	public void updateEmployee(String name, String lastName, String id) {
		if (id != null && id != " ") {
			for (int i = 0; i < employees.size(); i++) {
				Employee emp = employees.get(i);
				if (id.equals(emp.getId())) {
					emp.setName(name);
					emp.setLastName(lastName);
					emp.setId(id);

				}
			}
		}
	}
	
	public void updateUserSystem(String name, String lastName, String id, String nickName, String password) {
		if (id != null && id != " ") {
			for (int i = 0; i < userSystems.size(); i++) {
				UserSystem us = userSystems.get(i);
				if (id.equals(us.getId())) {
					us.setName(name);
					us.setLastName(lastName);
					us.setId(id);
					us.setNickName(nickName);
					us.setPassword(password);
				}
			}
		}
	}
	
	
	public void updateOrder(String code, String state, ArrayList<Product> products, Client cli, Employee employee, Date date, String obs) {
		if (code != null && code != " ") {
			for (int i = 0; i < orders.size(); i++) {
				Order order = orders.get(i);
				if (code.equals(order.getCode())) {
					order.setClient(cli);
					
				}
			}
		}
	}
	
	
	public String changeOrderState(Order order, int newState) {
		String state = "";
		if ((order.getState() != 0) && (newState != 0)) {
			if (newState > order.getState()) {
				order.setState(newState);
				state = order.orderState(newState);
			} else {
				state = "Ups!, hay un error en tu orden";
			}
		}
		return state;
	}

	
	public Client searchClient(String name) {
		long startTime = System.currentTimeMillis();
		Client cli = null;
		String str = "";
		Collections.sort(clients, new ClientNameSort());
		boolean encontre = false;
		int inicio = 0;
		int fin = clients.size();
		while (inicio <= fin && !encontre) {
			int medio = (int) Math.floor((inicio + fin) / 2);
			if (medio != clients.size()) {
				String elementoDelMedio = clients.get(medio).getName();
				int resultadoDeComparancion = name.compareToIgnoreCase(elementoDelMedio);
				if (resultadoDeComparancion == 0) {
					encontre = true;
					cli = clients.get(medio);
					str = "Nombre: " + cli.getName() + "\n" + "Apellido: " + cli.getLastName() + "\n" + "Num ID: " + cli.getId() + "\n" + "Numero Telefonico: "
							+ cli.getPhone() + "\n" + "Dirección: " + cli.getAdrress() + "\n" + "Observaciones: " + cli.getobservations();
				} else if (resultadoDeComparancion < 0) {
					fin = medio - 1;
				} else if (resultadoDeComparancion > 0) {
					inicio = medio + 1;
				}
			}
		}
		
		System.out.println(str);
		if (encontre == false) {
			System.out.println("no existe el cliente "+name);
			
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Duracion de busquedad: " + (endTime - startTime) / 1e6 + " ms");
		str += "Duracion de busquedad: " + (endTime - startTime) / 1e6 + " ms";
		return cli;
	}
/*	
	public void insercionPhoneNumbers() {
		int x = clients.size();
		Client[] vector = new Client[x];
		for (int i = 0; i < vector.length; i++) {
			vector[i] = clients.get(i);
		}
		for (int i = 1; i < vector.length; i++) {
			Client aux = vector[i];
			int j;
			for (j = i - 1; j >= 0 && vector[j].getPhone() < aux.getPhone(); j--) {
				vector[j + 1] = vector[j];
			}
			vector[j + 1] = aux;
		}
		System.out.println("InsercionPhoneNumbers");
		for(Client e : vector ) {
			System.out.println(e.toString());
		}
	} 
*/	
	public void bubbleSortRestaurants() {
		if (this.getClients() != null) {
			int x = this.getClients().size();
			Client[] matrix = new Client[x];
			for (int i = 0; i < x; i++) {
				matrix[i] = this.getClients().get(i);
			}
			Client temp;
			for (int i = 1; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length - 1; j++) {
					if (matrix[j].getName().charAt(0) > matrix[j + 1].getName().charAt(0)) {
						temp = matrix[j];
						matrix[j] = matrix[j + 1];
						matrix[j + 1] = temp;
					}
				}
			}
			for (int i = 0; i < x; i++) {
				System.out.println(matrix[i].toString());
			}
		}
	}
}
