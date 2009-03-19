package repository;

import java.io.Serializable;

public class PhoneNumber implements Serializable {
	private static final long serialVersionUID = -9017219923385125604L;
	
	private String phone_number = "";
	
	public PhoneNumber(){}
	
	public PhoneNumber(PhoneNumber phone_number){
		UpdatePhoneNumber(phone_number.clone());
	}
	
	public PhoneNumber(String phone_number){
		UpdatePhoneNumber(phone_number);
	}
	
	public void UpdatePhoneNumber(PhoneNumber phone_number){
		UpdatePhoneNumber(phone_number.phone_number);
	}
	
	public void UpdatePhoneNumber(String phone_number){
		this.phone_number = phone_number;
	}
	
	public String toString(){
		return phone_number;
	}
	
	public PhoneNumber clone(){
		return new PhoneNumber(phone_number);
	}
}
