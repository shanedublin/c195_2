package c195_2.main.appointment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import c195_2.main.Main;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class UserReportScene {

	AppointmentDAO dao = new AppointmentDAOImpl();

	Appointment appointment = new Appointment();

	GridPane pane = new GridPane();

	Label title = new Label("Number of Appointments by type");
	Button cancelButton = new Button("Home");

	VBox box = new VBox(10);
	public Scene s = new Scene(pane, 480, 480);
	private Main main;

	{

		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setVgap(5);
		pane.setHgap(5);

		pane.add(title, 0, 0);
		pane.add(cancelButton, 1, 0);
		pane.add(box, 0, 1, 2, 1);

		cancelButton.setOnAction((event) -> main.switchScene("home"));
	}

	public UserReportScene(Main main) {
		this.main = main;
	}

	public void loadReport() {
		List<AppointmentReport> list = new ArrayList<AppointmentReport>();
		try {
			list = dao.getAppoinmentReport();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		box.getChildren().clear();
		list.stream()
			.sorted((a, b) -> a.type.compareTo(b.type))
			.forEach(item -> {
				String s = item.toString();
				Label l = new Label(s);
				box.getChildren().add(l);
			});
	}

}
