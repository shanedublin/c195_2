package c195_2.main.appointment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import c195_2.main.Main;
import c195_2.main.login.User;
import c195_2.main.login.UserDAO;
import c195_2.main.login.UserDAOImpl;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class AppointmentReportScene {

	AppointmentDAO dao = new AppointmentDAOImpl();
	UserDAO userDao = new UserDAOImpl();

	Appointment appointment = new Appointment();

	GridPane pane = new GridPane();

	Label title = new Label("Number of Appointments by type");
	Button cancelButton = new Button("Home");

	ScrollPane sp = new ScrollPane();
	VBox paneBox = new VBox(10);
	public Scene s = new Scene(pane, 480, 480);
	private Main main;

	{

		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setVgap(5);
		pane.setHgap(5);

		pane.add(title, 0, 0);
		pane.add(cancelButton, 1, 0);
		sp.setContent(paneBox);
		pane.add(sp, 0, 1, 2, 1);

		cancelButton.setOnAction((event) -> main.switchScene("home"));
	}

	public AppointmentReportScene(Main main) {
		this.main = main;
	}

	public void loadReport() {
		List<Appointment> list = new ArrayList<Appointment>();
		list = dao.getAllAppointments();
		Map<Integer, List<Appointment>> map = new HashMap<Integer, List<Appointment>>();

		paneBox.getChildren().clear();
		list.stream().sorted((a, b) -> a.startTime.compareTo(b.startTime)).forEach(item -> {
			List<Appointment> alist = map.getOrDefault(item.userId, new ArrayList<Appointment>());
			alist.add(item);
			map.put(item.userId, alist);
		});

		for (List<Appointment> values : map.values()) {
			VBox userBox = new VBox(10);
			User u = userDao.find(values.get(0).userId);
			Label userLabel = new Label(u.userName);
			Label num = new Label("Num Appt: " + values.size());
			userBox.getChildren().add(userLabel);
			userBox.getChildren().add(num);
			userBox.setPadding(new Insets(4));
			userBox.setStyle("-fx-border-color: black;");

			values.forEach(item -> {
				VBox box = new VBox(4);
				Label title = new Label(item.title);
				Label startLabel = new Label("Start: " + AppointmentDAOImpl.sdf.format(item.startTime));
				Label endLabel = new Label("End: " + AppointmentDAOImpl.sdf.format(item.endTime));
				box.getChildren().add(title);
				box.getChildren().add(startLabel);
				box.getChildren().add(endLabel);
				box.setStyle("-fx-border-color: grey;");
				userBox.getChildren().add(box);
			});
			paneBox.getChildren().add(userBox);
		}

	}

}
