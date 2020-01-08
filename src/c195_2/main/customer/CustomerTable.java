package c195_2.main.customer;


import java.util.Timer;
import java.util.TimerTask;

import c195_2.main.DefaultScene;
import c195_2.main.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class CustomerTable {

	private Main main;
	
	TableView tv = new TableView();

	ObservableList<Customer> data = FXCollections.observableArrayList();
	
	
	{
		
		data.add(new Customer());
		tv.setItems(data);
		TableColumn firstNameCol = new TableColumn("Customer Name");
		
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("customerProp"));
        TableColumn editCol = new TableColumn("Edit");
        TableColumn delCol = new TableColumn("Delete");
        tv.getColumns().addAll(firstNameCol,editCol,delCol);
	}
	
	public Scene s;
	
	public CustomerTable(Main main) {
		this.main = main;
		this.s = new DefaultScene(tv, 480, 480,main.stage);
	}
	
	public void init() {
		data.clear();
		Timer t = new Timer();
		TimerTask tt = new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("run");
				Customer customer = new Customer();
				customer.customerProp.set("Testing");
				data.add(customer);
				
			}
		};
		t.schedule(tt, 1000);
		
	}

}
