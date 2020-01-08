package c195_2.main.home;

import c195_2.main.Main;
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
	Button customerTableButton = new Button("Customer Table");
	Button customerButton = new Button("Customers");
	Button appointmentButton = new Button("Appointments");
	Button calandarButton = new Button ("Calandar");
	
	VBox vBox = new  VBox(10, homeLabel, customerTableButton, customerButton, appointmentButton, calandarButton);
	public Scene s = new Scene(vBox, 480, 480);
	
	{
		
		customerTableButton.setOnAction((event) -> main.switchScene("customer_list"));
		customerButton.setOnAction((event) -> main.switchScene("customer"));
		appointmentButton.setOnAction((event) -> main.switchScene("appointment"));
		calandarButton.setOnAction((event) -> main.switchScene("calandar"));
	}
	

}
