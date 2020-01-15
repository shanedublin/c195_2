package c195_2.main.login;


import c195_2.main.Main;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Login {
	
	
public static User loggedInUser = new User();
	
	{
		loggedInUser.userId = 1;
	}


	private Main main;


	Label usernameLabel = new Label("Username");
	TextField userName = new TextField();
	HBox usernameBox = new HBox(10, usernameLabel, userName);
	
	Label passwordLabel = new Label("Password");
	PasswordField password = new PasswordField();
	HBox passwordBox = new HBox(10, passwordLabel, password);
	
	Button loginButton = new Button("Login");
	HBox loginBox = new HBox(10, loginButton);
	
	VBox box = new VBox(10, usernameBox, passwordBox, loginBox);
	
	public Scene s = new Scene(box,480,480);
	
	public Login(Main main) {
		this.main = main;
		
		loginButton.setOnAction((event) -> {
			main.switchScene("home");
		});
	}


}
