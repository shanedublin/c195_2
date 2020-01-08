package c195_2.main.customer;


import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import c195_2.main.DefaultScene;
import c195_2.main.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

public class CustomerTable {

	private Main main;
	CustomerBO customerBO = new CustomerBO();
	
	//TableView<Customer> tv = new TableView<Customer>();

	//ObservableList<Customer> data = FXCollections.observableArrayList();
	GridPane pane = new GridPane();
	Label nameLabel = new Label("Name");
	Label editLabel = new Label("Edit");
	Label deleteLabel = new Label("Delete");
	
	
	{
		
		pane.add(nameLabel, 0, 0);
		pane.add(editLabel, 1, 0);
		pane.setPadding(new Insets(10, 10, 10, 10));

		pane.setVgap(5);
		pane.setHgap(5);
		
	}
	
	public Scene s;
	
	public CustomerTable(Main main) {
		this.main = main;
		this.s = new DefaultScene(pane, 480, 480,main.stage);
		init();
	}
	
	public void init() {
		System.out.println("init");
		List<CustomerView> list = customerBO.loadCustomers();
		fillPane(list);
//		data.clear();
//		Timer t = new Timer();
//		TimerTask tt = new TimerTask() {
//			
//			@Override
//			public void run() {
//				System.out.println("run");
//				Customer customer = new Customer();
//				customer.customerProp.set("Testing");
//				data.add(customer);
//				
//			}
//		};
//		t.schedule(tt, 1000);
		
	}
	
	public void fillPane(List<CustomerView> list) {
		for (int i = 0; i < list.size(); i++) {
			CustomerView c = list.get(i);
			Label l = new Label(c.customer.customerName);
			pane.add(l, 0, i+1);
			Button button = new Button("Edit");
			button.setOnAction(event -> {
				main.switchScene("customer", c);
			});
			pane.add(button, 1, i+1);
			
		}
		
	}

}
