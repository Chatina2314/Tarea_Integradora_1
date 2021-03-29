package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import model.Client;
import model.Order;
import model.OrderSystem;
import model.Product;

enum DialogMode {
	ADD, UPDATE
}

public class Controller {

	private OrderSystem model;

	public Controller() {
		// TODO Auto-generated constructor stub
		model = new OrderSystem();
	}

	@FXML
	private Button importClients;
	@FXML
	private Button importProducts;
	@FXML
	private Button btnSearchClient;
	@FXML
	private Button btnExportClients;
	@FXML
	private Button btnExportOrders;
	@FXML
	private Button btnExportProducts;
	@FXML
	private Button btnShowProducts;
	@FXML
	private Button btnShowClients;
	@FXML
	private Button btnAdd;
	@FXML
	private Button btnEdit;
	@FXML
	private Button btnDelete;
	@FXML
	private TableView myTable;

	ObservableList<Client> clients;

	ObservableList<Product> products;

	public void initialize() {

		btnDelete.disableProperty().bind(Bindings.isNull(myTable.getSelectionModel().selectedItemProperty()));

		btnEdit.disableProperty().bind(Bindings.isNull(myTable.getSelectionModel().selectedItemProperty()));

		// Bind message label to the index of the selected table row
		//messageLabel.textProperty().bind(studentsTable.getSelectionModel().selectedIndexProperty().asString());
	}

	@FXML
	void handleDelete(ActionEvent event) {

		Optional<ButtonType> isConfirmed = showConfirmationDialog("Confim Delete", "Delete Confirmation",
				"Are you sure you would like to delete the selected Client?");
		if (isConfirmed.get() == ButtonType.OK) {
			int selectedIdx = myTable.getSelectionModel().getSelectedIndex();
			clients.remove(selectedIdx);
		}
	}

	@FXML
	public void searchClient(ActionEvent event) {
		System.out.println("Buscar Cliente");

		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Buscar Cliente");
		dialog.setHeaderText("Ingrese el nombre del cliente");
		String name = dialog.showAndWait().get();
		// System.out.println("Buscar cliente: "+name);
		Client cli = model.searchClient(name);

		if (!dialog.getDialogPane().lookupButton(ButtonType.OK).isPressed()) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Cliente");
			if (cli != null) {
				alert.setContentText("Nombre Completo: " + cli.getName() + " " + cli.getLastName() + "\n" + "ID: "
						+ cli.getId() + "\n" + "Dirección: " + cli.getAdrress() + "\n" + "Telefono: " + cli.getPhone()
						+ "\n" + "Observaciones: " + cli.getobservations() + "\n");

			} else {
				alert.setContentText("No existe un cliente con el nombre: " + name);
			}
			alert.showAndWait();
		}
	}

	@FXML
	void handleAdd(ActionEvent event) {
		showClients();
		handleUpdate(event);
	}

	@FXML
	public void handleUpdate(ActionEvent event) {
		String dialogTitle = "";
		DialogMode mode;

		Client cli = null;
		// System.out.println("btnShowClients");

		if (event.getSource().equals(btnAdd)) {
			mode = DialogMode.ADD;
			dialogTitle = "Add Client";
			cli = new Client();
			System.out.println("btnAdd");
		} else if (event.getSource().equals(btnEdit)) {
			System.out.println("btnEdit");
			mode = DialogMode.UPDATE;
			dialogTitle = "Update Client";
			cli = (Client) myTable.getSelectionModel().getSelectedItem();
		} else {
			return;
		}

		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("Client.fxml"));
			DialogPane clientDialogPane = fxmlLoader.load();

			ClientController clientController = fxmlLoader.getController();
			clientController.setClient(cli);

			Dialog<ButtonType> dialog = new Dialog<>();
			dialog.setDialogPane(clientDialogPane);
			dialog.setTitle(dialogTitle);

			Optional<ButtonType> clickedButton = dialog.showAndWait();

			if (clickedButton.get() == ButtonType.OK) {
				System.out.println("User selected ok");
				if (mode == DialogMode.ADD) {
					clients.add(cli);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void showClients() {

		myTable.getColumns().clear();
		TableColumn tcName = new TableColumn("Nombre");
		TableColumn tcLastName = new TableColumn("Apellido");
		TableColumn tcId = new TableColumn("ID");
		TableColumn tcAddress = new TableColumn("Dirección");
		TableColumn tcPhone = new TableColumn("Telefono");
		TableColumn<Client, String> tcObservations = new TableColumn<Client, String>("Observaciones");
		myTable.getColumns().addAll(tcName, tcLastName, tcId, tcAddress, tcPhone, tcObservations);

		clients = FXCollections.observableArrayList(model.getClients());

		tcName.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
		tcLastName.setCellValueFactory(new PropertyValueFactory<Client, String>("lastName"));
		tcId.setCellValueFactory(new PropertyValueFactory<Client, String>("id"));
		tcAddress.setCellValueFactory(new PropertyValueFactory<Client, String>("adrress"));
		tcPhone.setCellValueFactory(new PropertyValueFactory<Client, String>("phone"));
		tcObservations.setCellValueFactory(new PropertyValueFactory<Client, String>("observa"));
		myTable.setItems(clients);

	}

	public void showProducts() {
		myTable.getColumns().clear();
		TableColumn tcName = new TableColumn("Nombre");
		TableColumn tcType = new TableColumn("Tipo");
		TableColumn tcIngredients = new TableColumn("Ingredientes");
		TableColumn tcSize = new TableColumn("Tamaño");
		TableColumn tcPrice = new TableColumn("Precio");
		myTable.getColumns().addAll(tcName, tcType, tcIngredients, tcSize, tcPrice);

		products = FXCollections.observableArrayList(model.getProducts());

		tcName.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
		tcType.setCellValueFactory(new PropertyValueFactory<Client, String>("type"));
		tcIngredients.setCellValueFactory(new PropertyValueFactory<Client, String>("ingredients"));
		tcSize.setCellValueFactory(new PropertyValueFactory<Client, String>("size"));
		tcPrice.setCellValueFactory(new PropertyValueFactory<Client, Double>("price"));
		myTable.setItems(products);

	}

	public String showOrders() {
		String str = "";
		ArrayList<Order> data = this.model.getOrders();
		if (data != null) {
			for (Order e : data) {
				str += e.toString();
			}
		}
		System.out.println("--------------------- ORDENES---------------------");
		System.out.println(str);
		return str;
	}

	@SuppressWarnings("unchecked")
	@FXML
	public void readClientsCSV(ActionEvent event) {
		try {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Importar Clientes");

			fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV", "*.csv"));

			File file = fileChooser.showOpenDialog(null);
			System.out.println(file.getName());

			Path filePath = Paths.get(file + "");
			BufferedReader br = Files.newBufferedReader(filePath);
			String linea;
			int contador = 0;
			while ((linea = br.readLine()) != null) {
				if (contador != 0) {
					String[] datosLinea = linea.split(",");
					String name = datosLinea[0];
					String lastName = datosLinea[1];
					String idNumber = datosLinea[2];
					String address = datosLinea[3];
					String phone = datosLinea[4];
					String observations = datosLinea[5];
					Client newClient = new Client(name, lastName, idNumber, address, phone, observations);
					model.addClient(newClient);
				}

				contador++;
			}

		} catch (Exception e) {
			e.getMessage();
		}
		showClients();
	}

	@FXML
	public void readProductsCSV(ActionEvent event) {
		try {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Importar Productos");

			fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV", "*.csv"));

			File file = fileChooser.showOpenDialog(null);
			System.out.println(file.getName());

			Path filePath = Paths.get(file + "");
			BufferedReader br = Files.newBufferedReader(filePath);
			String linea;
			int contador = 0;
			while ((linea = br.readLine()) != null) {
				if (contador != 0) {
					// System.out.println("linea: " + linea);
					String[] datosLinea = linea.split(",");
					String name = datosLinea[0];
					String type = datosLinea[1];
					String Ingredientes = datosLinea[2];
					String size = datosLinea[3];
					double price = Double.parseDouble(datosLinea[4].trim());

					Product newProduct = new Product(name, type, Ingredientes, size, price);
					model.addProduct(newProduct);
					System.out.println("new: " + newProduct.toString());
				}
				contador++;
			}
			showProducts();

		} catch (Exception e) {
			e.getMessage();
		}
	}

	private Optional<ButtonType> showConfirmationDialog(String title, String headerText, String contentText) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);

		return alert.showAndWait();
	}
	@SuppressWarnings("resource")
	@FXML
    private void exportClientSet(ActionEvent event) {
    	
    	try {
    		FileWriter writer = new FileWriter("Clientes.csv");
        	String header = "Name LastName ID Address Phone Observation";
			writer.write(header);
			writer.write(clients.toString());
			writer.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    }

    @FXML
    private void exportOrderSet(ActionEvent event) {

       	
    	try {
    		FileWriter writer = new FileWriter("Ordenes.csv");
        	String header = "";
			writer.write(header);
			writer.write(clients.toString());
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    }

    @FXML
    private void exportProductSet(ActionEvent event) {
       	
    	try {
    		FileWriter writer = new FileWriter("Productos.csv");
        	String header = "";
			writer.write(header);
			writer.write(clients.toString());
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    }
}
