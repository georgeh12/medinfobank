package repository;

import java.io.Serializable;

public class Name implements Serializable {
	private static final long serialVersionUID = 8256782815312714549L;
	
	private String first = "";
	private String MI = "";
	private String last = "";
	
	public Name(){}
	
	public Name(Name name){
		UpdateName(name.clone());
	}
	
	public Name(String first, String MI, String last){
		UpdateName(first, MI, last);
	}
	
	public String ReadFirst(){
		return first;
	}
	
	public String ReadMI(){
		return MI;
	}
	
	public String ReadLast(){
		return last;
	}
	
	public void UpdateName(Name name){
		UpdateName(name.first, name.MI, name.last);
	}
	
	public void UpdateName(String first, String MI, String last){
		UpdateFirst(first);
		UpdateMI(MI);
		UpdateLast(last);
	}
	
	public void UpdateFirst(String first){
		this.first = first;
	}
	
	public void UpdateMI(String MI){
		this.MI = MI;
	}
	
	public void UpdateLast(String last){
		this.last = last;
	}
	
	public String toString(){
		return first + " " + MI + " " + last;
	}
	
	public Name clone(){
		return new Name(first, MI, last);
	}
	
	public boolean equals(Name name){
		return this.first == name.first && this.MI == name.MI &&
		this.last == name.last;
	}
}
