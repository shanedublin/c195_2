package c195_2.main.home;

import c195_2.main.Main;
import c195_2.main.appointment.Appointment;
import c195_2.main.appointment.AppointmentDAO;
import c195_2.main.appointment.AppointmentDAOImpl;
import c195_2.main.login.Login;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Home {
	

	AppointmentDAO dao = new AppointmentDAOImpl();
	
	private Main main;
	public Home(Main main) {
		this.main = main;
	}
	Label homeLabel = new Label("Home");
	Label appointmentWarning = new Label("You have an appointment in less than 15 minutes!");
	Button customerTableButton = new Button("View Customers");
	
	Button customerButton = new Button("Create Customer");
	Button appointmentButton = new Button("Create Appointment");
	Button calandarButton = new Button ("View Calandar");
	Button numberOfAppointments = new Button("Appointment Report");
	Button userReport = new Button("User Report");
	Button customReport = new Button("Login Report");
	
	
	VBox vBox = new  VBox(10, homeLabel,appointmentWarning , customerTableButton,
			customerButton, appointmentButton, calandarButton,
			numberOfAppointments, userReport, customReport);
	public Scene s = new Scene(vBox, 480, 480);
	
	{
		vBox.setPadding(new Insets(10));
		customerTableButton.setOnAction((event) -> main.switchScene("customer_list"));
		appointmentWarning.setVisible(false);
		customerButton.setOnAction((event) -> main.switchScene("customer"));
		appointmentButton.setOnAction((event) -> main.switchScene("appointment"));
		calandarButton.setOnAction((event) -> main.switchScene("calandar"));
		numberOfAppointments.setOnAction((even) -> main.switchScene("appointmentReport"));
		customReport.setOnAction((even) -> main.switchScene("loginreport"));
		appointmentWarning.setTextFill(Color.DARKRED);
	}

	
	public void checkAppoinments() {
		Appointment a = dao.in15Mins(Login.loggedInUser.userId);
		if(a != null) {
		 	appointmentWarning.setVisible(true);
		}else {
			appointmentWarning.setVisible(false);
		}
	}

}
