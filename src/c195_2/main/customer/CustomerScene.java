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


	public Scene s = new Scene(pane, 480, 480);
	private Main main;
	CustomerBO customerBO = new CustomerBO();

	{
		cancelButton.setOnAction((event) -> main.switchScene("home"));
		saveButton.setOnAction((event) -> this.save(event));

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
		Customer customer = new Customer();
		Address address = new Address();
		City city = new City();
		Country country = new Country();

		customer.customerName = name.getText();
		address.address = addressText.getText();
		address.address2 = address2Text.getText();
		address.postalCode = postalText.getText();
		address.phone = phoneText.getText();
		city.city = cityText.getText();
		country.country = countryText.getText();

		customerBO.saveCustomer(customer, country, city, address);

	}

	public CustomerScene(Main main) {
		this.main = main;
	}

}
