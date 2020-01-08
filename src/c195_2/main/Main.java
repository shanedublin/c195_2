package c195_2.main;

import c195_2.main.appointment.AppointmentScene;
import c195_2.main.calandar.Calandar;
import c195_2.main.customer.CustomerScene;
import c195_2.main.customer.CustomerTable;
import c195_2.main.database.DBUtil;
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
	CustomerTable customerTable = new CustomerTable(this);
	Calandar calandar = new Calandar(this);
	
	public Stage stage;
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.stage = primaryStage;
		primaryStage.setTitle("C195");
		 
		Group root = new Group();
		Scene s = new DefaultScene(root, 480,480, primaryStage);
		primaryStage.setTitle("App");
		
		root.getChildren();
		primaryStage.setScene(customerTable.s);
		primaryStage.show();
		primaryStage.setOnCloseRequest(e -> exit());

	}
	
	public void exit() {
		DBUtil.closeConnection();
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
		case "customer_list":
			stage.setTitle("customer list");
			stage.setScene(customerTable.s);
			customerTable.init();
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
