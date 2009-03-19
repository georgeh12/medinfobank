package repository;
import java.io.Serializable;
import java.util.*;

public class DoctorInfo implements Serializable {
	private static final long serialVersionUID = 1164723231119658915L;
	
	private Vector<Doctor> doctors = new Vector<Doctor>();
	
	public void CreateDoctor(Doctor doctor){
		doctors.add(doctor);
	}
	
	public Doctor ReadDoctor(int index){
		if(IndexIsValid(index)){
			return doctors.get(index);
		}
		else{
			return null;
		}
	}
	
	public boolean UpdateDoctor(Doctor old_doctor, Doctor new_doctor){
		return UpdateDoctor(doctors.indexOf(old_doctor), new_doctor);
	}
	
	public boolean UpdateDoctor(int index, Doctor doctor){
		if(IndexIsValid(index)){
			doctors.set(index, doctor);
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean DeleteDoctor(Doctor doctor){
		return doctors.remove(doctor);
	}
	
	public boolean DeleteDoctor(int index){
		if(IndexIsValid(index)){
			doctors.remove(index);
			return true;
		}
		else{
			return false;
		}
	}
	
	public int size(){
		return doctors.size();
	}
	
	private boolean IndexIsValid(int index){
		return index >= 0 && index < size();
	}
	
	public DoctorInfo(){ }
	
	public DoctorInfo(DoctorInfo doctor_info){
		UpdateDoctorInfo(doctor_info.clone());
	}
	
	private DoctorInfo(Vector<Doctor> doctors){
		this.doctors = CloneDoctors(doctors);
	}

	public Vector<Doctor> ReadDoctors(){
		return CloneDoctors(doctors);
	}
	
	@SuppressWarnings("unchecked")
	private Vector<Doctor> CloneDoctors(Vector<Doctor> doctor_info){
		return (Vector<Doctor>) doctor_info.clone();
	}
	
	public void UpdateDoctorInfo(DoctorInfo doctor_info){
		this.doctors = doctor_info.doctors;
	}
	
	/**
	 * toString is undefined for this class.
	 */
	public String toString(){
		StringBuffer doctor_info_string = new StringBuffer("");
		for(int i = 0; i < size(); i ++){
			doctor_info_string.append((i == 0 ? "" : "\n\n") +
					Integer.toString(i + 1) + ". " + doctors.get(i));
		}
		
		return doctor_info_string.toString();
	}
	
	public DoctorInfo clone(){
		return new DoctorInfo(doctors);
	}
}
