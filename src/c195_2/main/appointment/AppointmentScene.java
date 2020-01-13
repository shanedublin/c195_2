package c195_2.main.appointment;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import c195_2.main.Main;
import c195_2.main.customer.Customer;
import c195_2.main.customer.CustomerDAO;
import c195_2.main.customer.CustomerDAOImpl;
import c195_2.main.login.User;
import c195_2.main.login.UserDAO;
import c195_2.main.login.UserDAOImpl;
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
import javafx.util.Callback;

public class AppointmentScene {
	
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
	
	Button saveButton = new Button("Save");
	Button cancelButton = new Button("Cancel");

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
		pane.add(customerComboBox, 1,1);

		pane.add(userLabel, 0, 2);
//		pane.add(user, 1, 2);
		pane.add(userComboBox, 1,2);

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
		
		pane.add(startLabel, 0,8);
		pane.add(startDate, 1, 8);
		pane.add(startTime, 2, 8);
		pane.add(startMeridiem, 3, 8);
		
		pane.add(endLabel, 0, 9);
		pane.add(endDate, 1, 9);
		pane.add(endTime, 2, 9);
		pane.add(endMeridiem, 3, 9);

		
		pane.add(saveButton, 0, 10);
		pane.add(cancelButton, 1, 10);

		cancelButton.setOnAction((event) -> main.switchScene("home"));
		// loading all users
		users = userDAO.getUsers();		
//		List<String> collect = users.stream()
//				.map(user -> user.userName)
//				.collect(Collectors.toList());
		
				
		userComboBox.setPromptText("Select...");
		userComboBox.getItems().addAll(users);
		userComboBox.setCellFactory(factoryUser);
		
		// loading all customers
		customers = customerDAO.getCustomers();
//		List<String> customersCollect = customers.stream()
//				.map(c -> c.customerName)
//				.collect(Collectors.toList());
		

		customerComboBox.setPromptText("Select...");
		customerComboBox.setCellFactory(factoryCustomer);
		customerComboBox.getItems().addAll(customers);
		
		startMeridiem.getItems().addAll("AM","PM");
		startMeridiem.setPromptText("Select...");
		startTime.setPromptText("hh:mm");
		startTime.setMaxWidth(100);
		
		endMeridiem.getItems().addAll("AM","PM");
		endMeridiem.setPromptText("Select...");
		endTime.setMaxWidth(100);
		
		endTime.setPromptText("hh:mm");
		
		
		saveButton.setOnAction((event) -> save());
	}

	
	
	
	public AppointmentScene(Main main) {
		this.main = main;
		
		// TODO Auto-generated constructor stub
	}

	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-d-h:m-a");
	
	public void save() {
		appointment.customerId = customerComboBox.getSelectionModel().getSelectedItem().customerId;
		appointment.userId = userComboBox.getSelectionModel().getSelectedItem().userId;
		appointment.title = title.getText();
		appointment.description = description.getText();
		appointment.location = location.getText();
		appointment.contact = contact.getText();
		appointment.type = type.getText();
		appointment.url = url.getText();
		
		
		LocalDate startValue = startDate.getValue();
		String startString = startValue.getYear() + "-" +
				startValue.getMonthValue() + "-" + 
				startValue.getDayOfMonth() + "-" +
				startTime.getText() + "-" +
				startMeridiem.getValue();
		
		LocalDate endValue = endDate.getValue();
		String endString = endValue.getYear() + "-" +
				endValue.getMonthValue() + "-" + 
				endValue.getDayOfMonth() + "-" +
				endTime.getText() + "-" +
				endMeridiem.getValue();
		
		try {
			appointment.startTime =  new Date( dateFormat.parse(startString).getTime());
			appointment.endTime =  new Date( dateFormat.parse(endString).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		dao.addOrUpdate(appointment);
		
		

	}

}
