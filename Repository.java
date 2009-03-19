package repository;

import java.util.*;
import java.io.*;

public class Repository implements Serializable{
	private static final long serialVersionUID = -7402912552795293658L;
	
	private Login master_login;
	private boolean login_set = false; //If login not set, prompt for user/pass
	private Vector<Patient> patients = new Vector<Patient>();
	
	public Repository(){ }
	
	private Repository(Login master_login, boolean login_set,
			Vector<Patient> patients){
		this.master_login = master_login;
		this.login_set = login_set;
		this.patients = ClonePatients(patients);
	}

	public Vector<Patient> ReadPatients(){
		return ClonePatients(patients);
	}
	
	@SuppressWarnings("unchecked")
	private Vector<Patient> ClonePatients(Vector<Patient> patients){
		return (Vector<Patient>) patients.clone();
	}
	
	public boolean AuthenticatePatient(String username, String password){
		return master_login.Authenticate(username, password);
	}
	
	public Patient Authenticate(String username, String password){
		if(login_set){
			if(!master_login.Authenticate(username, password)){
				for(int i = 0; i < size(); i ++){
					if(patients.get(i).Authenticate(username, password)){
						return patients.get(i);
					}
				}
			}
		}
		
		return null;
	}
	
	public Vector<Patient> Search(Name name){
		Vector<Patient> patients = new Vector<Patient>();
		
		for(int i = 0; i < size(); i++){
			if(patients.get(i).ReadPatientInfo().ReadGenInfo().ReadName().equals(name)){
				patients.add(patients.get(i));
			}
		}
		
		return patients;
	}
	
	public Patient Search(Name name, Date birthdate){
		Vector<Patient> patients = new Vector<Patient>();
		
		for(int i = 0; i < size(); i++){
			if(patients.get(i).ReadPatientInfo().ReadGenInfo().ReadName().equals(name) &&
					patients.get(i).ReadPatientInfo().ReadGenInfo().ReadBirthdate().equals(birthdate)){
				return patients.get(i);
			}
		}
		
		return null;
	}
	
	public void CreatePatient(Patient patient){
		patients.add(patient);
	}
	
	public void DeletePatient(Patient patient){
		patients.remove(patient);
	}
	
	public int size(){
		return patients.size();
	}
	
	public void UpdateMasterLogin(Login login){
		this.master_login = login;
	}
	
	public void UpdateMasterLogin(String username, String password){
		UpdateMasterLogin(new Login(username, password));
		this.login_set = true;
	}
	
	public boolean isLoggedIn(){
		return master_login.ReadLoggedIn();
	}

	/**
	 * toString is undefined for this class.
	 */
	public String toString(){
		return "Welcome to the Medical Info Bank!";
	}
	
	public Repository clone(){
		return new Repository(master_login.clone(), login_set, patients);
	}
}
