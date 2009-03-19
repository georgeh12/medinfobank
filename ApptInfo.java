package repository;

import java.io.Serializable;
import java.util.*;

public class ApptInfo implements Serializable {
	private static final long serialVersionUID = -3478706016214965210L;

	public class Appt {
		private Date date;
		private Time time;
		private Doctor doctor;
		private Note note;
		
		public Appt(){ }
		
		public Appt(Appt appt){
			UpdateAppt(appt.clone());
		}
		
		public Appt(Date date, Time time, Doctor doctor, Note note){
			UpdateAppt(date.clone(), time.clone(), doctor.clone(), note.clone());
		}
		
		public Date ReadDate(){
			return date;
		}
		
		public Time ReadTime(){
			return time;
		}
		
		public Doctor ReadDoctor(){
			return doctor;
		}
		
		public Note ReadNote(){
			return note;
		}
		
		public void UpdateAppt(Appt appt){
			UpdateAppt(appt.date, appt.time, appt.doctor, appt.note);
		}
		
		public void UpdateAppt(Date date, Time time, Doctor doctor, Note note){
			UpdateDate(date);
			UpdateTime(time);
			UpdateDoctor(doctor);
			UpdateNote(note);
		}
		
		public void UpdateDate(Date date){
			this.date = date;
		}
		
		public void UpdateTime(Time time){
			this.time = time;
		}
		
		public void UpdateDoctor(Doctor doctor){
			this.doctor = doctor;
		}
		
		public void UpdateNote(Note note){
			this.note = note;
		}
		
		public String toString(){
			return "Date: " + date + "\nTime: " + time + "\nDoctor: " + doctor +
			"\nNote: " + note;
		}
		
		public Appt clone(){
			return new Appt(date.clone(), time.clone(), doctor.clone(),
					note.clone());
		}
	}
	
	private Vector<Appt> appts = new Vector<Appt>();

	public void CreateAppt(Appt appt){
		appts.add(appt);
	}

	public void CreateAppt(Date date, Time time, Note note, Doctor doctor){
		appts.add(new Appt(date, time, doctor, note));
	}
	
	public Appt ReadAppt(int index){
		if(IndexIsValid(index)){
			return appts.get(index);
		}
		else{
			return null;
		}
	}
	
	public boolean UpdateAppt(Appt old_appt, Appt new_appt){
		return UpdateAppt(appts.indexOf(old_appt), new_appt);
	}
	
	public boolean UpdateAppt(int index, Appt appt){
		if(IndexIsValid(index)){
			appts.set(index, appt);
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean DeleteAppt(Appt appt){
		return appts.remove(appt);
	}
	
	public boolean DeleteAppt(int index){
		if(IndexIsValid(index)){
			appts.remove(index);
			return true;
		}
		else{
			return false;
		}
	}
	
	public int size(){
		return appts.size();
	}
	
	private boolean IndexIsValid(int index){
		return index >= 0 && index < size();
	}
	
	public ApptInfo(){ }
	
	public ApptInfo(ApptInfo appt_info){
		UpdateApptInfo(appt_info.clone());
	}

	private ApptInfo(Vector<Appt> appts){
		this.appts = CloneAppts(appts);
	}

	public Vector<Appt> ReadAppts(){
		return CloneAppts(appts);
	}
	
	@SuppressWarnings("unchecked")
	private Vector<Appt> CloneAppts(Vector<Appt> appts){
		return (Vector<Appt>) appts.clone();
	}
	
	public void UpdateApptInfo(ApptInfo appt_info){
		this.appts = appt_info.appts;
	}
	
	public String toString(){
		StringBuffer appt_info_string = new StringBuffer("");
		for(int i = 0; i < size(); i ++){
			appt_info_string.append((i == 0 ? "" : "\n\n") +
					Integer.toString(i + 1) + ". " + appts.get(i));
		}
		
		return appt_info_string.toString();
	}
	
	public ApptInfo clone(){
		return new ApptInfo(appts);
	}
}
