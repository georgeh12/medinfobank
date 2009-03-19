package repository;

import java.io.Serializable;
import java.util.*;

public class CurrentMedications implements Serializable {
	private static final long serialVersionUID = 4412023950251482471L;

	public class Medication implements Serializable {
		private static final long serialVersionUID = 234900943974552044L;
		
		private String name;
		private Doctor doctor;
		
		public Medication(){ }
		
		public Medication(Medication medication){
			UpdateMedication(medication.clone());
		}
		
		public Medication(String name, Doctor doctor){
			UpdateMedication(name, doctor.clone());
		}
		
		public void UpdateMedication(Medication medication){
			UpdateMedication(medication.name, medication.doctor);
		}
		
		public void UpdateMedication(String name, Doctor doctor){
			UpdateMedicine(name);
			UpdateDoctor(doctor);
		}
		
		public void UpdateMedicine(String name){
			this.name = name; 
		}
		
		public void UpdateDoctor(Doctor doctor){
			this.doctor = doctor;
		}
		
		public String toString(){
			return name + "  Prescribing Doctor: " + doctor;
		}
		
		public Medication clone(){
			return new Medication(name, doctor.clone());
		}
	}

	private Vector<Medication> medications = new Vector<Medication>();
	private Note allergies;
	
	public void CreateMedication(Medication medication){
		medications.add(medication);
	}
	
	public void CreateMedication(String name, Doctor doctor){
		medications.add(new Medication(name, doctor));
	}
	
	public Medication ReadMedication(int index){
		if(IndexIsValid(index)){
			return medications.get(index);
		}
		else{
			return null;
		}
	}
	
	public boolean UpdateMedication(Medication old_medication,
			Medication new_medication){
		return UpdateMedication(medications.indexOf(old_medication),
				new_medication);
	}
	
	public boolean UpdateMedication(int index, Medication medication){
		if(IndexIsValid(index)){
			medications.set(index, medication);
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean DeleteMedication(Medication medication){
		return medications.remove(medication);
	}
	
	public boolean DeleteMedication(int index){
		if(IndexIsValid(index)){
			medications.remove(index);
			return true;
		}
		else{
			return false;
		}
	}
	
	public int size(){
		return medications.size();
	}
	
	private boolean IndexIsValid(int index){
		return index >= 0 && index < size();
	}
	
	public CurrentMedications(){ }
	
	public CurrentMedications(CurrentMedications current_medications){
		UpdateCurrentMedications(current_medications);
	}

	private CurrentMedications(Vector<Medication> medications){
		this.medications = CloneMedications(medications);
	}

	public Vector<Medication> ReadMedications(){
		return CloneMedications(medications);
	}
	
	@SuppressWarnings("unchecked")
	private Vector<Medication> CloneMedications(Vector<Medication> medications){
		return (Vector<Medication>) medications.clone();
	}
	
	public Note ReadAllergies(){
		return allergies;
	}
	
	public void UpdateCurrentMedications(CurrentMedications current_medications){
		this.medications = current_medications.medications;
	}
	
	public void UpdateAllergies(Note allergies){
		this.allergies = allergies;
	}
	
	public String toString(){
		StringBuffer current_meds_string = new StringBuffer("");
		current_meds_string.append("Current Medications:");
		
		for(int i = 0; i < size(); i ++){
			current_meds_string.append("\n" + Integer.toString(i + 1) +
					". " + medications.get(i));
		}
		
		current_meds_string.append("\n\nAllergies: " + allergies);
		
		return current_meds_string.toString();
	}
	
	public CurrentMedications clone(){
		return new CurrentMedications(medications);
	}
}
