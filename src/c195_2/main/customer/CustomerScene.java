package c195_2.main.customer;

import c195_2.main.Main;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CustomerScene {
	
	
	
	Label nameLabel = new Label("Name");
	TextField name = new TextField();
	HBox nameBox = new HBox(10, nameLabel, name);
	
	Label addressLabel = new Label("address");
	TextField addressText = new TextField();
	HBox addressBox = new HBox(10, addressLabel, addressText);
	
	Label address2Label = new Label("address");
	TextField address2Text = new TextField();
	HBox address2Box = new HBox(10, address2Label, address2Text);
	
	Label cityLabel = new Label("City");
	TextField cityText = new TextField();
	HBox cityBox = new HBox(10, cityLabel, cityText);
	
	Label countryLabel = new Label("Country");
	TextField countryText = new TextField();
	HBox countryBox = new HBox(10, countryLabel, countryText);
	
	Label postalLabel = new Label("Postal Code");
	TextField postalText = new TextField();
	HBox postalBox = new HBox(10, postalLabel, postalText);
	
	Label phoneLabel = new Label("Phone");
	TextField phonetext = new TextField();
	HBox phoneBox = new HBox(10, phoneLabel, phonetext);
	
	Button saveButton = new Button("Save");
	Button cancelButton = new Button("Cancel");
	HBox saveBox = new HBox(10, saveButton, cancelButton);
	
	
	
	VBox box = new VBox(10, 
			nameBox,
			addressBox,
			address2Box,
			cityBox,
			countryBox,
			postalBox,
			phoneBox,
			saveBox);
	

	public Scene s = new Scene(box,480,480);
	private Main main;
	
	{
		cancelButton.setOnAction((event) -> main.switchScene("home"));
		saveButton.setOnAction((event)->this.save(event));
	}
	
	public void save(ActionEvent event) {
		Customer customer = new Customer();
		Address address = new Address();
		City city = new City();
		Country country = new Country();
		
		customer.customerName = name.getText();
		address.address = addressText.getText();
		address.address2  = address2Text.getText();
		address.postalCode = postalText.getText();
		address.phone = phonetext.getText();
		city.city = cityText.getText();
		country.country = countryText.getText(); 
		
		
	}
	
	public CustomerScene(Main main) {
		this.main = main;
	}

}
