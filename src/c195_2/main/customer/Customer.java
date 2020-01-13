package c195_2.main.customer;

public class Customer {
	
	

	public Integer customerId;
	public String customerName;
	public Integer addressId;
	public Boolean active = true;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		
		this.customerName = customerName;
	}
	
	@Override
	public String toString() {
		return customerName; 
	}
	
	
}
