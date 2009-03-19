package repository;
import java.io.Serializable;
import java.util.Calendar;

public class Patient implements Serializable {
	private static final long serialVersionUID = 8666812175307853057L;
	
	private PatientInfo patient_info;
	private DoctorInfo doctor_info;
	private InsuranceInfo insurance_info;
	private EmergencyContacts emergency_contacts;
	private Calendar calendar;	//Place-holder for Sean's calendar class.
	private Login login;
	private boolean login_set = false; //If login not set, prompt for user/pass
	
	public boolean Authenticate(String username, String password){
		if(login_set){
			return login.Authenticate(username, password);
		}
		
		return false;
	}
	
	public Patient(){ }
	
	public Patient(Patient patient){
		UpdatePatient(patient.clone());
	}
	
	/**
	 * Calendar is just a place-holder for Sean's calendar Class.
	 * It should be able to use "clone()".
	 * @param patient_info
	 * @param doctor_info
	 * @param insurance_info
	 * @param emergency_contacts
	 * @param calendar
	 * @param login
	 */
	public Patient(PatientInfo patient_info, DoctorInfo doctor_info,
			InsuranceInfo insurance_info, EmergencyContacts emergency_contacts,
			Calendar calendar, Login login){
		UpdatePatient(patient_info.clone(), doctor_info.clone(),
				insurance_info.clone(), emergency_contacts.clone(),
				calendar, login.clone());
	}
	
	private Patient(PatientInfo patient_info, DoctorInfo doctor_info,
			InsuranceInfo insurance_info, EmergencyContacts emergency_contacts,
			Calendar calendar, Login login, boolean login_set){
		UpdatePatient(patient_info.clone(), doctor_info.clone(),
				insurance_info.clone(), emergency_contacts.clone(),
				calendar, login.clone());
		this.login_set = login_set;
	}
	
	public PatientInfo ReadPatientInfo(){
		return patient_info;
	}
	
	public DoctorInfo ReadDoctorInfo(){
		return doctor_info;
	}
	
	public InsuranceInfo ReadInsuranceInfo(){
		return insurance_info;
	}
	
	public EmergencyContacts ReadEmergencyContacts(){
		return emergency_contacts;
	}
	
	public Calendar ReadCalendar(){
		return calendar;
	}
	
	public Login ReadLogin(){
		return login;
	}
	
	public void UpdatePatient(Patient patient){
		UpdatePatient(patient.patient_info, patient.doctor_info,
				patient.insurance_info, patient.emergency_contacts,
				patient.calendar, patient.login);
	}
	
	public void UpdatePatient(PatientInfo patient_info,
			DoctorInfo doctor_info, InsuranceInfo insurance_info,
			EmergencyContacts emergency_contacts, Calendar calendar,
			Login login){
		UpdatePatientInfo(patient_info);
		UpdateDoctorInfo(doctor_info);
		UpdateInsuranceInfo(insurance_info);
		UpdateEmergencyContacts(emergency_contacts);
		UpdateCalendar(calendar);
		UpdateLogin(login);
	}
	
	public void UpdatePatientInfo(PatientInfo patient_info){
		this.patient_info = patient_info;
	}
	
	public void UpdateDoctorInfo(DoctorInfo doctor_info){
		this.doctor_info = doctor_info;
	}
	
	public void UpdateInsuranceInfo(InsuranceInfo insurance_info){
		this.insurance_info = insurance_info;
	}
	
	public void UpdateEmergencyContacts(EmergencyContacts emergency_contacts){
		this.emergency_contacts = emergency_contacts;
	}
	
	public void UpdateCalendar(Calendar calendar){
		this.calendar = calendar;
	}
	
	public void CreateLogin(String username, String password){
		UpdateLogin(new Login(username, password));
	}
	
	public void UpdateLogin(Login login){
		login_set = true;
		this.login = login;
	}
	
	public void UpdateLogin(String username, String password){
		UpdateLogin(new Login(username, password));
	}
	
	public boolean isLoggedIn(){
		return login.ReadLoggedIn();
	}
	
	/**
	 * toString is undefined for this class.
	 */
	public String toString(){
		return null;
	}

	public Patient clone(){
		return new Patient(patient_info.clone(), doctor_info.clone(),
				insurance_info.clone(), emergency_contacts.clone(),
				calendar, login.clone(), login_set);
	}
}
