package repository;

import java.io.Serializable;

public class Doctor implements Serializable {
	private static final long serialVersionUID = 7782972055476163437L;
	
	private Name name;
	private String spec = "";
	private PhoneNumber telephone;
	private PhoneNumber fax;
	private Address address;

	public Doctor(){ }
	
	public Doctor(Doctor doctor){
		UpdateDoctor(doctor.clone());
	}
	
	public Doctor(Name name, String spec, PhoneNumber telephone,
			PhoneNumber fax, Address address){
		UpdateDoctor(name.clone(), spec, telephone.clone(), fax.clone(),
				address.clone());
	}
	
	public Name ReadName(){
		return name;
	}

	public String ReadSpec(){
		return spec;
	}

	public PhoneNumber ReadTelephone(){
		return telephone;
	}

	public PhoneNumber ReadFax(){
		return fax;
	}

	public Address ReadAddress(){
		return address;
	}
	
	public void UpdateDoctor(Doctor doctor){
		UpdateDoctor(doctor.name, doctor.spec, doctor.telephone,
				doctor.fax, doctor.address);
	}
	
	public void UpdateDoctor(Name name, String spec, PhoneNumber telephone,
			PhoneNumber fax, Address address){
		UpdateName(name);
		UpdateSpec(spec);
		UpdateTelephone(telephone);
		UpdateFax(fax);
		UpdateAddress(address);
	}
	
	public void UpdateName(Name name){
		this.name = name;
	}
	
	public void UpdateSpec(String spec){
		this.spec = spec;
	}
	
	public void UpdateTelephone(PhoneNumber telephone){
		this.telephone = telephone;
	}
	
	public void UpdateFax(PhoneNumber fax){
		this.fax = fax;
	}
	
	public void UpdateAddress(Address address){
		this.address = address;
	}
	
	public String toString(){
		return "Doctor Name: " + name + "\nType of Doctor: " + spec +
		"\nPhone Number: " + telephone + "\nFax Number: " + fax +
		"\nPractitioner's Office\n" + address;
	}
	
	public Doctor clone(){
		return new Doctor(name.clone(), spec, telephone.clone(), fax.clone(),
				address.clone());
	}
}
