package c195_2.main.customer;

import c195_2.main.Main;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CustomerScene {

	GridPane pane = new GridPane();

	Label nameLabel = new Label("Name");
	TextField name = new TextField();

	Label addressLabel = new Label("address");
	TextField addressText = new TextField();

	Label address2Label = new Label("address");
	TextField address2Text = new TextField();

	Label cityLabel = new Label("City");
	TextField cityText = new TextField();

	Label countryLabel = new Label("Country");
	TextField countryText = new TextField();

	Label postalLabel = new Label("Postal Code");
	TextField postalText = new TextField();

	Label phoneLabel = new Label("Phone");
	TextField phoneText = new TextField();

	Button saveButton = new Button("Save");
	Button cancelButton = new Button("Cancel");
	Button deleteButton = new Button("Delete");

	public Scene s = new Scene(pane, 480, 480);
	private Main main;
	CustomerView cv = new CustomerView();
	CustomerBO customerBO = new CustomerBO();
	CustomerDAO dao = new CustomerDAOImpl();

	{
		cancelButton.setOnAction((event) -> main.switchScene("home"));
		saveButton.setOnAction((event) -> this.save(event));
		deleteButton.setOnAction((event) -> this.delete(event));

		pane.setPadding(new Insets(10, 10, 10, 10));

		pane.setVgap(5);
		pane.setHgap(5);
		pane.add(nameLabel, 0, 0);
		pane.add(name, 1, 0);
		pane.add(addressLabel, 0, 1);
		pane.add(addressText, 1, 1);
		pane.add(address2Label, 0, 2);
		pane.add(address2Text, 1, 2);
		pane.add(cityLabel, 0, 3);
		pane.add(cityText, 1, 3);
		pane.add(countryLabel, 0, 4);
		pane.add(countryText, 1, 4);
		pane.add(postalLabel, 0, 5);
		pane.add(postalText, 1, 5);
		pane.add(phoneLabel, 0, 6);
		pane.add(phoneText, 1, 6);
		pane.add(saveButton, 0, 7);
		pane.add(cancelButton, 1, 7);
		
	}

	public void save(ActionEvent event) {

		cv.customer.setCustomerName(name.getText());
		cv.address.address = addressText.getText();
		cv.address.address2 = address2Text.getText();
		cv.address.postalCode = postalText.getText();
		cv.address.phone = phoneText.getText();
		cv.city.city = cityText.getText();
		cv.country.country = countryText.getText();

		customerBO.saveCustomer(cv);

	}

	private void delete(ActionEvent event) {
		dao.delete(cv.customer.customerId);
		main.switchScene("home");
		
	}

	public CustomerScene(Main main) {
		this.main = main;
	}

	public void setCustomer(CustomerView c) {
		if (c == null) {
			pane.getChildren().remove(deleteButton);
			return;
		}
		pane.add(deleteButton, 2, 7);
		cv = c;
		//cv = customerBO.loadCustomer(c.customerId);
		name.setText(cv.customer.customerName);
		addressText.setText(cv.address.address);
		address2Text.setText(cv.address.address2);
		postalText.setText(cv.address.postalCode);
		phoneText.setText(cv.address.phone);
		cityText.setText(cv.city.city);
		countryText.setText(cv.country.country);

	}

}
