package c195_2.main.customer;

import c195_2.main.Entity;

public class Country extends Entity {
	
	public Integer countryId;
	public String country;
	
	@Override
	public String toString() {
		return "Country ID: " + countryId +  " Name: " + country;
	}

}
