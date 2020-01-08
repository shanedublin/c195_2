package c195_2.main.customer;

import javafx.beans.property.SimpleStringProperty;

public class Customer {
	
	public final SimpleStringProperty customerProp = new SimpleStringProperty("");

	public Integer customerId;
	public String customerName;
	public Integer addressId;
	public Boolean active = true;
}
