package c195_2.main.appointment;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import c195_2.main.Main;
import c195_2.main.customer.Customer;
import c195_2.main.customer.CustomerDAO;
import c195_2.main.customer.CustomerDAOImpl;
import c195_2.main.login.User;
import c195_2.main.login.UserDAO;
import c195_2.main.login.UserDAOImpl;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;

public class AppointmentScene {

	private static final String APPOINTMENTS_CAN_NOT_OVERLAP = "Appointments can not overlap.";
	private static final String TIME_NOT_IN_BUISNESS_HOURS = "Time not in buisness hours (9am-5pm)";
	private static final String ALL_FIELDS_REQUIRED = "All fields are required.";

	AppointmentDAO dao = new AppointmentDAOImpl();

	Appointment appointment = new Appointment();

	GridPane pane = new GridPane();

	Label titleLabel = new Label("Title");
	TextField title = new TextField();

	Label customerLabel = new Label("Customer");
	TextField customer = new TextField();
	ComboBox<Customer> customerComboBox = new ComboBox<Customer>();

	Label userLabel = new Label("User");
	TextField user = new TextField();
	ComboBox<User> userComboBox = new ComboBox<User>();

	Label descriptionLabel = new Label("Description");
	TextField description = new TextField();

	Label locationLabel = new Label("Location");
	TextField location = new TextField();

	Label contactLabel = new Label("Contact");
	TextField contact = new TextField();

	Label typeLabel = new Label("Type");
	TextField type = new TextField();

	Label urlLabel = new Label("Url");
	TextField url = new TextField();

	Label startLabel = new Label("Start Time");
	TextField start = new TextField();
	DatePicker startDate = new DatePicker();
	TextField startTime = new TextField();
	ComboBox<String> startMeridiem = new ComboBox<String>();

	Label endLabel = new Label("End Time");
	TextField end = new TextField();
	DatePicker endDate = new DatePicker();
	TextField endTime = new TextField();
	ComboBox<String> endMeridiem = new ComboBox<String>();

	Label errorLabel = new Label(TIME_NOT_IN_BUISNESS_HOURS);

	Button saveButton = new Button("Save");
	Button cancelButton = new Button("Home");
	Button deleteButton = new Button("Delete");

	public Scene s = new Scene(pane, 480, 480);
	private Main main;

	UserDAO userDAO = new UserDAOImpl();
	List<User> users = new ArrayList<User>();

	CustomerDAO customerDAO = new CustomerDAOImpl();
	List<Customer> customers = new ArrayList<Customer>();

	Callback<ListView<User>, ListCell<User>> factoryUser = lv -> new ListCell<User>() {

		@Override
		protected void updateItem(User item, boolean empty) {
			super.updateItem(item, empty);
			setText(empty ? "" : item.userName);
		}

	};

	Callback<ListView<Customer>, ListCell<Customer>> factoryCustomer = lv -> new ListCell<Customer>() {

		@Override
		protected void updateItem(Customer item, boolean empty) {
			super.updateItem(item, empty);
			setText(empty ? "" : item.customerName);
		}

	};

	{
		pane.setPadding(new Insets(10, 10, 10, 10));

		pane.setVgap(5);
		pane.setHgap(5);

		pane.add(titleLabel, 0, 0);
		pane.add(title, 1, 0);

		pane.add(customerLabel, 0, 1);
//		pane.add(customer, 1,1);
		pane.add(customerComboBox, 1, 1);

		pane.add(userLabel, 0, 2);
//		pane.add(user, 1, 2);
		pane.add(userComboBox, 1, 2);

		pane.add(descriptionLabel, 0, 3);
		pane.add(description, 1, 3);

		pane.add(locationLabel, 0, 4);
		pane.add(location, 1, 4);

		pane.add(contactLabel, 0, 5);
		pane.add(contact, 1, 5);

		pane.add(typeLabel, 0, 6);
		pane.add(type, 1, 6);

		pane.add(urlLabel, 0, 7);
		pane.add(url, 1, 7);

		pane.add(startLabel, 0, 8);
		pane.add(startDate, 1, 8);
		pane.add(startTime, 2, 8);
		pane.add(startMeridiem, 3, 8);

		pane.add(endLabel, 0, 9);
		pane.add(endDate, 1, 9);
		pane.add(endTime, 2, 9);
		pane.add(endMeridiem, 3, 9);

		pane.add(errorLabel, 0, 10, 4, 1);
		errorLabel.setVisible(false);

		pane.add(saveButton, 0, 11);
		pane.add(cancelButton, 1, 11);
//		pane.add(deleteButton, 2, 10);

		cancelButton.setOnAction((event) -> main.switchScene("home"));
		// loading all users
		users = userDAO.getUsers();

		userComboBox.setPromptText("Select...");
		userComboBox.getItems().addAll(users);
		userComboBox.setCellFactory(factoryUser);

		// loading all customers
		customers = customerDAO.getCustomers();

		customerComboBox.setPromptText("Select...");
		customerComboBox.setCellFactory(factoryCustomer);
		customerComboBox.getItems().addAll(customers);

		startMeridiem.getItems().addAll("AM", "PM");
		startMeridiem.setPromptText("Select...");
		startTime.setPromptText("hh:mm");
		startTime.setMaxWidth(100);

		endMeridiem.getItems().addAll("AM", "PM");
		endMeridiem.setPromptText("Select...");
		endTime.setMaxWidth(100);

		endTime.setPromptText("hh:mm");

		saveButton.setOnAction((event) -> save());
		deleteButton.setOnAction((event) -> this.delete(event));

		errorLabel.setTextFill(Color.DARKRED);

	}

	public AppointmentScene(Main main) {
		this.main = main;
	}

	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-d-h:m-a");

	public void save() {

		try {
			appointment.customerId = customerComboBox.getSelectionModel().getSelectedItem().customerId;
			appointment.userId = userComboBox.getSelectionModel().getSelectedItem().userId;
			appointment.title = title.getText();
			appointment.description = description.getText();
			appointment.location = location.getText();
			appointment.contact = contact.getText();
			appointment.type = type.getText();
			appointment.url = url.getText();

		} catch (Exception e) {
			errorLabel.setText(ALL_FIELDS_REQUIRED);
			errorLabel.setVisible(true);
			e.printStackTrace();
			return;
		}

		System.out.println(startMeridiem.getValue());
		LocalDate startValue = startDate.getValue();
		String startString = startValue.getYear() + "-" + startValue.getMonthValue() + "-" + startValue.getDayOfMonth()
				+ "-" + startTime.getText() + "-" + startMeridiem.getValue();
		LocalDate endValue = endDate.getValue();
		String endString = endValue.getYear() + "-" + endValue.getMonthValue() + "-" + endValue.getDayOfMonth() + "-"
				+ endTime.getText() + "-" + endMeridiem.getValue();

		try {
			System.out.println(startString);
			System.out.println(endString);
			appointment.startTime = new Timestamp(dateFormat.parse(startString).getTime());
//			appointment.startTime = appointment.startTime.u
			appointment.endTime = new Timestamp(dateFormat.parse(endString).getTime());

		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (overlappingAppoinments()) {
			errorLabel.setText(APPOINTMENTS_CAN_NOT_OVERLAP);
			errorLabel.setVisible(true);
			return;
		}

		if (buisnessTime(appointment.startTime, appointment.endTime)) {
			dao.addOrUpdate(appointment);
			errorLabel.setVisible(false);
		} else {
			errorLabel.setText(TIME_NOT_IN_BUISNESS_HOURS);
			errorLabel.setVisible(true);
		}

	}

	private boolean overlappingAppoinments() {
		return dao.appoinmentOverlaps(appointment);
	}

	private void delete(ActionEvent event) {
		dao.delete(appointment.appointmentId);
		main.switchScene("home");

	}

	SimpleDateFormat sdf = new SimpleDateFormat("h:mm");
	SimpleDateFormat merediem = new SimpleDateFormat("a");

	public void setAppointment(Appointment a) {
		if (a == null) {
			pane.getChildren().remove(deleteButton);
			return;
		}
		System.out.println(a.appointmentId);
		appointment = a;

		pane.add(deleteButton, 2, 11);

		// used to filter customers. used a lamda to simplify code and make searching
		// faster
		Optional<Customer> customerOptional = customers.stream().filter(cus -> a.customerId == cus.customerId)
				.findAny();

		// used to filter users. used a lamda to simplify code and make searching faster
		Optional<User> userOptional = users.stream().filter(cus -> a.userId == cus.userId).findAny();

		if (customerOptional.isPresent()) {
			customerComboBox.getSelectionModel().select(customerOptional.get());
		}
		if (userOptional.isPresent()) {
			userComboBox.getSelectionModel().select(userOptional.get());
		}

		title.setText(a.title);
		description.setText(a.description);
		location.setText(a.location);
		contact.setText(a.contact);
		type.setText(a.type);
		url.setText(a.url);

		startDate.setValue(a.startTime.toLocalDateTime().toLocalDate());
		startTime.setText(sdf.format(a.startTime));
		startMeridiem.setValue(merediem.format(a.startTime));

		endDate.setValue(a.endTime.toLocalDateTime().toLocalDate());
		endTime.setText(sdf.format(a.endTime));
		endMeridiem.setValue(merediem.format(a.endTime));

	}

	/**
	 * Open 7 days a week from 9am-5pm
	 * 
	 * @param startTime
	 * @param startMer
	 * @param endTime
	 * @param endMer
	 * @return
	 */
	public static boolean buisnessTime(Timestamp startTime, Timestamp endTime) {
		return inHours(startTime) && inHours(endTime);
	}

	public static boolean inHours(Timestamp ts) {
		Calendar open = Calendar.getInstance();
		open.setTime(ts);
		open.set(Calendar.HOUR_OF_DAY, 8);
		open.set(Calendar.MINUTE, 59);

		Calendar close = Calendar.getInstance();
		close.setTime(ts);
		close.set(Calendar.HOUR_OF_DAY, 17);
		close.set(Calendar.MINUTE, 1);

		Calendar c = Calendar.getInstance();
		c.setTime(ts);
		return c.after(open) && c.before(close);

	}

}
