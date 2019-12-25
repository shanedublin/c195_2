package c195_2.main.calandar;

import c195_2.main.Main;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Calandar {

	
	
	Button saveButton = new Button("Save");
	Button cancelButton = new Button("Cancel");
	HBox saveBox = new HBox(10, saveButton, cancelButton);
	
	VBox box = new VBox(10, saveBox);
	public Scene s = new Scene(box, 480,480);
	private Main main;
	
	{
		cancelButton.setOnAction((event) -> main.switchScene("home"));
	}
	
	public Calandar(Main main) {
		this.main = main;
		// TODO Auto-generated constructor stub
	}

}
