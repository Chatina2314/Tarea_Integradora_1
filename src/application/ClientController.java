package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import model.Client;

public class ClientController {

	@FXML
	private DialogPane dialogPane;

	@FXML
	private TextField idField;

	@FXML
	private TextField nameField;

	@FXML
	private TextField lastNameField;

	@FXML
	private TextField addressField;
	@FXML
	private TextField phoneField;
	@FXML
	private TextField observationField;


	public void setClient(Client cli) {

		idField.textProperty().bindBidirectional(cli.idProperty());
		nameField.textProperty().bindBidirectional(cli.nameProperty());
		lastNameField.textProperty().bindBidirectional(cli.lastNameProperty());
		addressField.textProperty().bindBidirectional(cli.adrressProperty());
		phoneField.textProperty().bindBidirectional(cli.phoneProperty());
		observationField.textProperty().bindBidirectional(cli.observaProperty());

		Button okButton = (Button) dialogPane.lookupButton(ButtonType.OK);
		okButton.addEventFilter(ActionEvent.ACTION, event -> {
			if (!validateFormData()) {
				event.consume();
			}
		});
	}

	private boolean validateFormData() {
		if (idField.getText().isEmpty()) {
			showAlert(AlertType.ERROR, "Form Error!", "Please enter the client Id");
			idField.requestFocus();
			return false;
		}

		if (nameField.getText().isEmpty()) {
			showAlert(AlertType.ERROR, "Form Error!", "Please enter the client first name");
			nameField.requestFocus();
			return false;
		}

		if (lastNameField.getText().isEmpty()) {
			showAlert(AlertType.ERROR, "Form Error!", "Please enter the client last name");
			lastNameField.requestFocus();
			return false;
		}

		if (addressField.getText().isEmpty()) {
			showAlert(AlertType.ERROR, "Form Error!", "Please enter the client address");
			addressField.requestFocus();
			return false;
		}
		if (phoneField.getText().isEmpty()) {
			showAlert(AlertType.ERROR, "Form Error!", "Please enter the client phone");
			addressField.requestFocus();
			return false;
		}


		return true;
	}

	private void showAlert(AlertType alertType, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.show();
	}
}
