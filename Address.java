package repository;

import java.io.Serializable;

public class Address implements Serializable {
	private static final long serialVersionUID = 1921743373816445537L;
	
	private String street = "";
	private String city = "";
	private String state = "";
	private String zip = "";
	
	public Address(){ }
	
	public Address(Address address){
		UpdateAddress(address.clone());
	}
	
	public Address(String street, String city, String state,
			String zip){
		UpdateAddress(street, city, state, zip);
	}
	
	public String ReadStreet(){
		return street;
	}
	
	public String ReadCity(){
		return city;
	}
	
	public String ReadState(){
		return state;
	}
	
	public String ReadZip(String zip){
		return zip;
	}
	
	public void UpdateAddress(Address address){
		UpdateAddress(address.street, address.city, address.state,
				address.zip);
	}
	
	public void UpdateAddress(String street, String city, String state,
			String zip){
		UpdateStreet(street);
		UpdateCity(city);
		UpdateStreet(state);
		UpdateZip(zip);
	}
	
	public void UpdateStreet(String street){
		this.street = street;
	}
	
	public void UpdateCity(String city){
		this.city = city;
	}
	
	public void UpdateState(String state){
		this.state = state;
	}
	
	public void UpdateZip(String zip){
		this.zip = zip;
	}

	public String toString(){
		return "Street Address: " + street +
		"\nCity: " + city + "  State: " + state + "  Zip Code: " + zip;
	}
	
	public Address clone(){
		return new Address(street, city, state, zip);
	}
}
