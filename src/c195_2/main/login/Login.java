package c195_2.main.login;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Locale;

import c195_2.main.Main;
import c195_2.main.appointment.AppointmentDAOImpl;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Login {
	
	
public static User loggedInUser = new User();
	
	{
		loggedInUser.userId = 1;
	}


	private Main main;

	
	UserDAO dao = new UserDAOImpl();

	Label usernameLabel = new Label("Username");
	TextField userName = new TextField();
	
	Label passwordLabel = new Label("Password");
	PasswordField password = new PasswordField();
	
	Label errorLabel = new Label("Invalid username or password");
	
	Button loginButton = new Button("Login");
	
	GridPane box = new GridPane();
	
	public Scene s = new Scene(box,480,480);
	String language = Locale.getDefault().getLanguage();
	{
		
		
		box.add(usernameLabel, 0, 0);
		box.add(userName, 1, 0);
		
		box.add(passwordLabel, 0, 1);
		box.add(password, 1, 1);
		
		box.add(errorLabel, 0, 2, 2, 1);
		
		box.add(loginButton, 0, 3);
		
		box.setHgap(5);
		box.setVgap(5);
		
		box.setPadding(new Insets(10));
		loginButton.setOnAction((event) -> loginAction());
		errorLabel.setVisible(false);
		System.out.println(language);
		if("fr".equalsIgnoreCase(language)) {
			usernameLabel.setText("nom d'utilisateur");
			passwordLabel.setText("mot de passe");
			loginButton.setText("connectez-vous");
			errorLabel.setText("nom d'utilisateur ou mot de passe invalide");
		}
		
	}
	public Login(Main main) {
		
		this.main = main;
		
	}

	public void loginAction() {
		User u = new User();
		u.userName = userName.getText();
		u.password = password.getText();
		u = dao.validateUser(u);
		if(u.userId != null) {
			loggedInUser = u;
			main.switchScene("home");
			updateLoginFile();
		} else {
			errorLabel.setVisible(true);
		}
	}
	
	public void updateLoginFile() {
		LocalDateTime now = LocalDateTime.now();
		Timestamp ts = Timestamp.valueOf(now);
		String msg = loggedInUser.userName +" = " + AppointmentDAOImpl.sdf.format(ts) + System.lineSeparator();
		try {
			Files.write(Paths.get("./login.txt"), msg.getBytes(), StandardOpenOption.APPEND );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
