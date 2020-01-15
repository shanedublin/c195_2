package c195_2.main;

import c195_2.main.appointment.Appointment;
import c195_2.main.appointment.AppointmentScene;
import c195_2.main.calandar.CalandarScene;
import c195_2.main.customer.CustomerScene;
import c195_2.main.customer.CustomerTable;
import c195_2.main.customer.CustomerView;
import c195_2.main.database.DBUtil;
import c195_2.main.home.Home;
import c195_2.main.login.Login;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;

public class Main extends Application {
	
	Login login = new Login(this);
	Home home = new Home(this);
	AppointmentScene appointment = new AppointmentScene(this);
	CustomerScene customer = new CustomerScene(this);
	CustomerTable customerTable = new CustomerTable(this);
	CalandarScene calandar = new CalandarScene(this);
	
	public Stage stage;
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.stage = primaryStage;
		primaryStage.setTitle("C195");
		 
		Group root = new Group();
		//Scene s = new DefaultScene(root, 480,480, primaryStage);
		primaryStage.setTitle("App");
		
		root.getChildren();
//		primaryStage.setScene(home.s);
//		primaryStage.setScene(calandar.s);
		primaryStage.setScene(login.s);
		primaryStage.show();
		primaryStage.setOnCloseRequest(e -> exit());

	}
	
	public void exit() {
		DBUtil.closeConnection();
	}

	public static void main(String args[]) {
		launch(args);
	}
	
	public void switchScene(String scene, Object o) {
		scene = scene.toLowerCase();
		switch (scene) {
		case "home":
			stage.setTitle("home");
			stage.setScene(home.s);
			break;
		case "customer":
			stage.setTitle("customer");
			customer = new CustomerScene(this);
			customer.setCustomer((CustomerView) o);
			stage.setScene(customer.s);
			break;
		case "customer_list":
			stage.setTitle("customer list");
			customerTable = new CustomerTable(this);
			stage.setScene(customerTable.s);
			customerTable.init();
			break;
		case "appointment":
			stage.setTitle("appointment");
			appointment = new AppointmentScene(this);
			appointment.setAppointment((Appointment) o);
			stage.setScene(appointment.s);
			break;
		case "calandar":
			calandar = new CalandarScene(this);
			stage.setTitle("calandar");
			stage.setScene(calandar.s);
			break;
			
		default:
			break;
		}
		
	}
	
	
	public void switchScene(String scene) {
		switchScene(scene, null);
	}

}
