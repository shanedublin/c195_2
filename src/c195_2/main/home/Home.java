package c195_2.main.home;

import c195_2.main.Main;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Home {
	

	
	private Main main;
	public Home(Main main) {
		this.main = main;
	}
	Label homeLabel = new Label("Home");
	Button customerTableButton = new Button("View Customers");
	Button customerButton = new Button("Create Customer");
	Button appointmentButton = new Button("Create Appointment");
	Button calandarButton = new Button ("View Calandar");
	
	VBox vBox = new  VBox(10, homeLabel, customerTableButton, customerButton, appointmentButton, calandarButton);
	public Scene s = new Scene(vBox, 480, 480);
	
	{
		vBox.setPadding(new Insets(10));
		customerTableButton.setOnAction((event) -> main.switchScene("customer_list"));
		
		customerButton.setOnAction((event) -> main.switchScene("customer"));
		appointmentButton.setOnAction((event) -> main.switchScene("appointment"));
		calandarButton.setOnAction((event) -> main.switchScene("calandar"));
	}
	

}
