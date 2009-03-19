package repository;

import java.io.Serializable;

public class PatientInfo implements Serializable {
	private static final long serialVersionUID = -7447201063061791035L;
	
	private GeneralInfo gen_info;
	private MedicalHistory med_history;
	private SurgicalHistory surgical_history;
	private SocialHistory soc_history;
	private TestResults test_results;
	
	public PatientInfo(){ }
	
	public PatientInfo(PatientInfo patient_info){
		UpdatePatientInfo(patient_info.clone());
	}
	
	public PatientInfo(GeneralInfo gen_info, MedicalHistory med_history,
			SurgicalHistory surgical_history, SocialHistory soc_history,
			TestResults test_results){
		UpdatePatientInfo(gen_info.clone(), med_history.clone(),
				surgical_history.clone(), soc_history.clone(),
				test_results.clone());
	}
	
	public GeneralInfo ReadGenInfo(){
		return gen_info;
	}
	
	public MedicalHistory ReadMedHistory(){
		return med_history;
	}

	public SurgicalHistory ReadSurgicalHistory(){
		return surgical_history;
	}
	
	public SocialHistory ReadSocHistory(){
		return soc_history;
	}
	
	public TestResults ReadTestResults(){
		return test_results;
	}
	
	public void UpdatePatientInfo(PatientInfo patient_info){
		UpdatePatientInfo(patient_info.gen_info, patient_info.med_history,
				patient_info.surgical_history, patient_info.soc_history,
				patient_info.test_results);
	}
	
	public void UpdatePatientInfo(GeneralInfo gen_info, MedicalHistory med_history,
			SurgicalHistory surgical_history, SocialHistory soc_history,
			TestResults test_results){
		UpdateGenInfo(gen_info);
		UpdateMedHistory(med_history);
		UpdateSurgicalHistory(surgical_history);
		UpdateSocHistory(soc_history);
		UpdateTestResults(test_results);
	}
	
	public void UpdateGenInfo(GeneralInfo gen_info){
		this.gen_info = gen_info;
	}
	
	public void UpdateMedHistory(MedicalHistory med_history){
		this.med_history = med_history;
	}
	
	public void UpdateSurgicalHistory(SurgicalHistory surgical_history){
		this.surgical_history = surgical_history;
	}
	
	public void UpdateSocHistory(SocialHistory soc_history){
		this.soc_history = soc_history;
	}
	
	public void UpdateTestResults(TestResults test_results){
		this.test_results = test_results;
	}
	
	/**
	 * toString is undefined for this class.
	 */
	public String toString(){
		return null;
	}

	public PatientInfo clone(){
		return new PatientInfo(gen_info.clone(), med_history.clone(),
				surgical_history.clone(), soc_history.clone(),
				test_results.clone());
	}
}
