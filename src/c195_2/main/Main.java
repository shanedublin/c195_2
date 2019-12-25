package c195_2.main;

import c195_2.main.appointment.AppointmentScene;
import c195_2.main.calandar.Calandar;
import c195_2.main.customer.CustomerScene;
import c195_2.main.home.Home;
import c195_2.main.login.Login;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	
	Login login = new Login(this);
	Home home = new Home(this);
	AppointmentScene appointment = new AppointmentScene(this);
	CustomerScene customer = new CustomerScene(this);
	Calandar calandar = new Calandar(this);
	
	Stage stage;
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.stage = primaryStage;
		primaryStage.setTitle("C195");
		 
		Group root = new Group();
		Scene s = new Scene(root, 480,480);
		primaryStage.setTitle("App");
		s.setOnKeyPressed((event) -> {
			if(event.getCode() == KeyCode.ESCAPE) {
				primaryStage.close();
			}
		});
		root.getChildren();
		primaryStage.setScene(login.s);
		primaryStage.show();

	}

	public static void main(String args[]) {
		launch(args);
	}
	
	public void switchScene(String scene) {
		scene = scene.toLowerCase();
		switch (scene) {
		case "home":
			stage.setTitle("home");
			stage.setScene(home.s);
			break;
		case "customer":
			stage.setTitle("customer");
			stage.setScene(customer.s);
			break;
		case "appointment":
			stage.setTitle("appointment");
			stage.setScene(appointment.s);
			break;
		case "calandar":
			stage.setTitle("calandar");
			stage.setScene(calandar.s);
			break;

		default:
			break;
		}
	}

}
