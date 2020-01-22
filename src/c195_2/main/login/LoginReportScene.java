package c195_2.main.login;


import static c195_2.main.appointment.AppointmentDAOImpl.sdf;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

import c195_2.main.Main;
import c195_2.main.appointment.AppointmentScene;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LoginReportScene {
	

	private Main main;

	

	Label reportLabel = new Label("Login Report");
	Label reportText = new Label("");

	
	Button homeButton = new Button("Home");
	
	GridPane box = new GridPane();
	
	public Scene s = new Scene(box,480,480);
	{
		
		
		box.add(reportLabel, 0, 0);
		box.add(reportText, 0, 1);
		
		box.add(homeButton, 0, 2);
		
		box.setHgap(5);
		box.setVgap(5);
		
		box.setPadding(new Insets(10));
		homeButton.setOnAction((event) -> main.switchScene("home"));
		
	}
	public LoginReportScene(Main main) {
		
		this.main = main;
		try {
			updateLoginFile();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		
	}

	public void updateLoginFile() throws IOException, ParseException {
		
		List<String> readAllLines = Files.readAllLines(Paths.get("./login.txt"));
		String info  = "Total previous number of logins: " + readAllLines.size();
		info += System.lineSeparator();
		String lastLogin = readAllLines.get(readAllLines.size()-1);
		String[] split = lastLogin.split("=");
		info += "Last Login: " + sdf.parse(split[1]);
		reportText.setText(info);
	}

}
