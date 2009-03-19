package repository;

import java.io.Serializable;

public class MedicalHistory implements Serializable {
	private static final long serialVersionUID = 499227852772127699L;
	
	private Note health_concerns;
	private DiseaseHistory self;
	private Note other_problems;
	private DiseaseHistory family;
	private Note other_fam_history;
	
	public MedicalHistory(){ }
	
	public MedicalHistory(MedicalHistory fam_history){
		UpdateMedHistory(fam_history.clone());
	}
	
	public MedicalHistory(Note health_concerns, DiseaseHistory self,
			Note other_problems, DiseaseHistory family, Note other_fam_history){
		UpdateMedHistory(health_concerns.clone(), self.clone(),
				other_problems.clone(), family.clone(),
				other_fam_history.clone());
	}
	
	public Note ReadHealthConcerns(){
		return health_concerns;
	}
	
	public DiseaseHistory ReadSelf(){
		return self;
	}
	
	public Note ReadOtherProblems(){
		return other_problems;
	}
	
	public DiseaseHistory ReadFamily(){
		return family;
	}
	
	public Note ReadOtherFamHistory(){
		return other_fam_history;
	}
	
	public void UpdateMedHistory(MedicalHistory medical_history){
		UpdateMedHistory(medical_history.health_concerns, medical_history.self,
				medical_history.other_problems,  medical_history.family,
				medical_history.other_fam_history);
	}
	
	public void UpdateMedHistory(Note health_concerns, DiseaseHistory self,
			Note other_problems, DiseaseHistory family, Note other_fam_history){
		UpdateHealthConcerns(health_concerns);
		UpdateSelf(self);
		UpdateOtherProblems(other_problems);
		UpdateFamily(family);
		UpdateOtherFamHistory(other_fam_history);
	}
	
	public void UpdateHealthConcerns(Note health_concerns){
		this.health_concerns = health_concerns;
	}
	
	public void UpdateSelf(DiseaseHistory self){
		this.self = self;
	}
	
	public void UpdateOtherProblems(Note other_problems){
		this.other_problems = other_problems;
	}
	
	public void UpdateFamily(DiseaseHistory family){
		this.family = family;
	}
	
	public void UpdateOtherFamHistory(Note other_fam_history){
		this.other_fam_history = other_fam_history;
	}
	
	/**
	 * toString is undefined for this class.
	 */
	public String toString(){
		return "Present Health Concerns: " + health_concerns + "\n\n" + 
		self + "\n" + "Other Problems: " + other_problems + "\n\n" +
		family + "\n" + "Other family medical history: " + other_fam_history;
	}

	public MedicalHistory clone(){
		return new MedicalHistory(health_concerns.clone(), self.clone(),
				other_problems.clone(), family.clone(),
				other_fam_history.clone());
	}
}
