package c195_2.main.appointment;

import c195_2.main.Main;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AppointmentScene {

	GridPane pane = new GridPane();

	Label titleLabel = new Label("Title");
	TextField title = new TextField();

	Label customerLabel = new Label("Customer");
	TextField cutomer = new TextField();

	Label userLabel = new Label("User");
	TextField user = new TextField();

	Label descriptionLabel = new Label("Description");
	TextField description = new TextField();

	Label locationLabel = new Label("Location");
	TextField location = new TextField();

	Label contactLabel = new Label("Contact");
	TextField contact = new TextField();

	Label typeLabel = new Label("Type");
	TextField type = new TextField();

	Label urlLabel = new Label("Url");
	TextField url = new TextField();
	Button saveButton = new Button("Save");
	Button cancelButton = new Button("Cancel");

	public Scene s = new Scene(pane, 480, 480);
	private Main main;

	{
		pane.setPadding(new Insets(10, 10, 10, 10));

		pane.setVgap(5);
		pane.setHgap(5);

		pane.add(titleLabel, 0, 0);
		pane.add(title, 1, 0);

		pane.add(customerLabel, 0, 1);
		pane.add(cutomer, 1,1);

		pane.add(userLabel, 0, 2);
		pane.add(user, 1, 2);

		pane.add(descriptionLabel, 0, 3);
		pane.add(description, 1, 3);

		pane.add(locationLabel, 0, 4);
		pane.add(location, 1, 4);

		pane.add(contactLabel, 0, 5);
		pane.add(contact, 1, 5);

		pane.add(typeLabel, 0, 6);
		pane.add(type, 1, 6);

		pane.add(urlLabel, 0, 7);
		pane.add(url, 1, 7);

		pane.add(saveButton, 0, 8);
		pane.add(cancelButton, 1, 8);

		cancelButton.setOnAction((event) -> main.switchScene("home"));
	}

	public AppointmentScene(Main main) {
		this.main = main;
		// TODO Auto-generated constructor stub
	}

}
