package c195_2.main.appointment;

import c195_2.main.Main;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AppointmentScene {

	
	Label titleLabel = new Label("Title");
	TextField title = new TextField();
	HBox titleBox = new HBox(10, titleLabel, title);
	
	Label descriptionLabel = new Label("Description");
	TextField description = new TextField();
	HBox descriptionBox = new HBox(10, descriptionLabel, description);
	
	Label locationLabel = new Label("Location");
	TextField location = new TextField();
	HBox locationBox = new HBox(10, locationLabel, location);
	
	Label contactLabel = new Label("Contact");
	TextField contact = new TextField();
	HBox contactBox = new HBox(10, contactLabel, contact);
	
	Label typeLabel = new Label("Type");
	TextField type = new TextField();
	HBox typeBox = new HBox(10, typeLabel, type);
	
	Label urlLabel = new Label("Url");
	TextField url = new TextField();
	HBox urlBox = new HBox(10, urlLabel, url);
	Button saveButton = new Button("Save");
	Button cancelButton = new Button("Cancel");
	HBox saveBox = new HBox(10, saveButton, cancelButton);
	
	VBox box = new VBox(10, 
				titleBox,
				descriptionBox,
				locationBox,
				contactBox,
				typeBox,
				urlBox,
				saveBox);
	
	public Scene s = new Scene(box,480,480);
	private Main main;

	{
		cancelButton.setOnAction((event) -> main.switchScene("home"));
	}
	
	public AppointmentScene(Main main) {
		this.main = main;
		// TODO Auto-generated constructor stub
	}

}
