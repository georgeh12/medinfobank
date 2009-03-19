package repository;
import java.io.Serializable;
import java.util.*;

public class EmergencyContacts implements Serializable {
	private static final long serialVersionUID = -1049517380465507778L;

	public class ContactInfo implements Serializable {
		private static final long serialVersionUID = 8603614608620439923L;
		
		private Name name;
		private PhoneNumber house;
		private PhoneNumber cell;
		private Address address;
		private String relation = "";
		
		public ContactInfo(){ }
		
		public ContactInfo(ContactInfo contact_info){
			UpdateContactInfo(contact_info.clone());
		}
		
		public ContactInfo(Name name, PhoneNumber house, PhoneNumber cell,
				Address address, String relation){
			UpdateContactInfo(name.clone(), house.clone(), cell.clone(),
					address.clone(), relation);
		}
		
		public Name ReadName(){
			return name;
		}
		
		public PhoneNumber Readhouse(){
			return house;
		}
		
		public PhoneNumber ReadCell(){
			return cell;
		}
		
		public Address ReadAddress(){
			return address;
		}
		
		public String ReadRelation(){
			return relation;
		}
		
		public void UpdateContactInfo(ContactInfo contact_info){
			UpdateContactInfo(contact_info.name, contact_info.house,
					contact_info.cell, contact_info.address,
					contact_info.relation);
		}
		
		public void UpdateContactInfo(Name name, PhoneNumber house,
				PhoneNumber cell, Address address, String relation){
			UpdateName(name);
			Updatehouse(house);
			UpdateCell(cell);
			UpdateAddress(address);
			UpdateRelation(relation);
		}
		
		public void UpdateName(Name name){
			this.name = name;
		}
		
		public void Updatehouse(PhoneNumber house){
			this.house = house;
		}
		
		public void UpdateCell(PhoneNumber cell){
			this.cell = cell;
		}
		
		public void UpdateAddress(Address address){
			this.address = address;
		}
		
		public void UpdateRelation(String relation){
			this.relation = relation;
		}
		
		public String toString(){
			return "Name: " + name + "\nHouse: " + house + "  Cell: " + cell +
			"\n" + address + "\n" + "Relationship to Patient: " + relation;
		}
		
		public ContactInfo clone(){
			return new ContactInfo(name.clone(), house.clone(), cell.clone(),
					address.clone(), relation);
		}
	}
	
	private Vector<ContactInfo> contacts = new Vector<ContactInfo>();
	
	public void CreateContactInfo(ContactInfo contact){
		contacts.add(contact);
	}

	public void CreateContactInfo(Name name, PhoneNumber house,
			PhoneNumber cell, Address address, String relation){
		contacts.add(new ContactInfo(name, house, cell, address, relation));
	}
	
	public ContactInfo ReadContactInfo(int index){
		if(IndexIsValid(index)){
			return contacts.get(index);
		}
		else{
			return null;
		}
	}
	
	public boolean UpdateContactInfo(ContactInfo old_contact,
			ContactInfo new_contact){
		return UpdateContactInfo(contacts.indexOf(old_contact),
				new_contact);
	}
	
	public boolean UpdateContactInfo(int index, ContactInfo contact){
		if(IndexIsValid(index)){
			contacts.set(index, contact);
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean DeleteContactInfo(ContactInfo contact){
		return contacts.remove(contact);
	}
	
	public boolean DeleteContactInfo(int index){
		if(IndexIsValid(index)){
			contacts.remove(index);
			return true;
		}
		else{
			return false;
		}
	}
	
	public int size(){
		return contacts.size();
	}
	
	private boolean IndexIsValid(int index){
		return index >= 0 && index < size();
	}
	
	public EmergencyContacts(){ }
	
	@SuppressWarnings("unchecked")
	private EmergencyContacts(Vector<ContactInfo> contacts){
		this.contacts = (Vector<ContactInfo>) contacts.clone();
	}
	
	public EmergencyContacts(EmergencyContacts emergency_contacts){
		UpdateEmergencyContacts(emergency_contacts.clone());
	}
	
	public void UpdateEmergencyContacts(EmergencyContacts emergency_contacts){
		this.contacts = emergency_contacts.contacts;
	}

	public String toString(){
		StringBuffer emergency_contacts_string = new StringBuffer("");
		for(int i = 0; i < size(); i ++){
			emergency_contacts_string.append((i == 0 ? "" : "\n\n") +
					Integer.toString(i + 1) + ". " + contacts.get(i));
		}
		
		return emergency_contacts_string.toString();
	}
	
	public EmergencyContacts clone(){
		return new EmergencyContacts(contacts);
	}
}
