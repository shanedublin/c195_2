package c195_2.main.calandar;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import c195_2.main.Main;
import c195_2.main.appointment.Appointment;
import c195_2.main.appointment.AppointmentDAO;
import c195_2.main.appointment.AppointmentDAOImpl;
import c195_2.main.login.Login;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CalandarScene {

	
	
	
	GridPane pane = new GridPane();
	
	DatePicker datePicker = new DatePicker();
	ScrollPane sp = new ScrollPane();
	VBox calanderBox = new VBox(4);
	
	Button weekButton = new Button("Week");
	Button monthButton = new Button("Month");
	Button saveButton = new Button("Save");
	Button cancelButton = new Button("Back");
//	HBox saveBox = new HBox(10, saveButton, cancelButton);
	HBox dateBox = new HBox(10, datePicker,weekButton,monthButton, cancelButton);
//	VBox box = new VBox(10, dateBox,saveBox);
	
	AppointmentDAO dao = new AppointmentDAOImpl();
	
	public Scene s = new Scene(pane, 480,640);
	private Main main;
	
	{
		sp.setContent(calanderBox);
		sp.setFitToHeight(true);
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setVgap(5);
		pane.setHgap(5);
		datePicker.setValue(LocalDate.now());
		pane.add(dateBox, 0, 0);
//		getWeek();
//		pane.add(getDay("1", null), 0, 1);
		pane.add(sp, 0, 1);
		cancelButton.setOnAction((event) -> main.switchScene("home"));
		datePicker.setPromptText("Select calandar date");
		
		weekButton.setOnAction((event) -> getWeek());
		monthButton.setOnAction((event) -> getMonth());
		
//		s.getStylesheets().add("style.css");
	}
	
	public CalandarScene(Main main) {
		this.main = main;
		// TODO Auto-generated constructor stub
	}
	
	
	
	public LocalDate getDate() {
		LocalDate date = datePicker.getValue();
		return date;
	}
	
	public void getWeek() {
		LocalDate startDate = getDate();
		
		calanderBox.getChildren().clear();
		int day = 0;
		for(int i = startDate.getDayOfMonth(); i < startDate.getDayOfMonth()+7; i ++) {
			LocalDate plusDays = startDate.plusDays(day);
			List<Appointment> apps = dao.findByUserAndDay(Login.loggedInUser.userId, Date.valueOf(plusDays));
			GridPane gp = getDay(sdf.format(Date.valueOf(plusDays)), apps);
			calanderBox.getChildren().add(gp);
			day++;
		}
	}
	
	public void getMonth() {
		
		LocalDate localDate  = getDate();
		LocalDate of = LocalDate.of(localDate.getYear(), localDate.getMonth(), 1);
		int numDays = of.getMonth().length(localDate.isLeapYear());
		calanderBox.getChildren().clear();
		
		for(int i = 0; i < numDays; i ++) {
			LocalDate plusDays = of.plusDays(i);
			List<Appointment> apps = dao.findByUserAndDay(Login.loggedInUser.userId, Date.valueOf(plusDays));
			GridPane day = getDay(sdf.format(Date.valueOf(plusDays)), apps);
			calanderBox.getChildren().add(day);
		}
	}
	
	SimpleDateFormat sdf = new SimpleDateFormat("EEE-d");
	SimpleDateFormat time = new SimpleDateFormat("h:mm a");
	public GridPane getDay(String day, List<Appointment> list) {
		Label l = new Label(day);
		GridPane p = new GridPane();
		p.add(l, 0, 0);
		for (int i = 0; i < list.size(); i++) {
			Appointment app = list.get(i);
			Label title = new Label(app.title);
			Label startTime = new Label("Start: " +time.format(app.startTime));
			Label endTime = new Label("End: " + time.format(app.endTime));
			VBox box = new VBox(2,title,startTime,endTime);
			p.add(box, 0, i +1);
			Button button = new Button("View");
			button.setPadding(new Insets(4));
			button.setOnAction((event) -> {
				main.switchScene("appointment", app);
			});
			
			p.add(button, 1, i + 1);
			box.setPadding(new Insets(4));
		}
		p.setStyle("-fx-border-color: black;");
//		box.setStyle(value);
		return p;
		
	}

}
