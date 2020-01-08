package c195_2.main;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class DefaultScene extends Scene {

	public DefaultScene(Parent root, double width, double height, Stage primaryStage) {
		super(root, width, height);
		
		this.setOnKeyPressed((event) -> {
			if(event.getCode() == KeyCode.ESCAPE) {
				primaryStage.close();
				
			}
		});
		// TODO Auto-generated constructor stub
	}

}
