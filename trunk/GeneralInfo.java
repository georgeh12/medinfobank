package repository;

import java.io.Serializable;

public class GeneralInfo implements Serializable {
	private static final long serialVersionUID = -5608919249744874437L;

	//all enums implement Serializable by default
	public enum Sex {
		none(), Male('m'), Female('f');
		private char sex = ' ';
		
		private Sex(){ }
		
		private Sex(char sex){
			this.sex = sex;
		}
		
		public String toString(){
			if(sex == 'm'){
				return "Male";
			}
			else if(sex == 'f'){
				return "Female";
			}
			else{
				return "";
			}
		}
	}
	
	private Name name;
	private Date birthdate;
	private String social_security = "";
	private Sex sex = Sex.none;
	private int age = 0;			//yrs
	private double height = 0.0;	//in.
	private double weight = 0.0;	//lbs.
	
	public GeneralInfo() { }
	
	public GeneralInfo(GeneralInfo general_info){
		UpdateGeneralInfo(general_info.clone());
	}

	public GeneralInfo(Name name, Date birthdate, String social_security, Sex sex,
			int age, double height, double weight){
		UpdateGeneralInfo(name.clone(), birthdate.clone(), social_security,
				sex, age, height, weight);
	}
	
	public Name ReadName(){
		return name;
	}
	
	public Date ReadBirthdate(){
		return birthdate;
	}
	
	public String ReadSocialSecurity(){
		return social_security;
	}
	
	public Sex ReadSex(){
		return sex;
	}
	
	public int ReadAge(){
		return age;
	}
	
	public double ReadHeight(){
		return height;
	}
	
	public double ReadWeight(){
		return weight;
	}
	
	public void UpdateGeneralInfo(GeneralInfo general_info){
		UpdateGeneralInfo(general_info.name, general_info.birthdate,
				general_info.social_security, general_info.sex, general_info.age,
				general_info.height, general_info.weight);
	}
	
	public void UpdateGeneralInfo(Name name, Date birthdate,
			String social_security, Sex sex, int age, double height,
			double weight){
		UpdateName(name);
		UpdateBirthdate(birthdate);
		UpdateSocialSecurity(social_security);
		UpdateSex(sex);
		UpdateAge(age);
		UpdateHeight(height);
		UpdateWeight(weight);
	}
	
	public void UpdateName(Name name){
		this.name = name;
	}
	
	public void UpdateBirthdate(Date birthdate){
		this.birthdate = birthdate;
	}
	
	public void UpdateSocialSecurity(String social_security){
		this.social_security = social_security;
	}
	
	public void UpdateSex(Sex sex){
		this.sex = sex;
	}
	
	public void UpdateAge(int age){
		this.age = age;
	}
	
	public void UpdateHeight(double height){
		this.height = height;
	}
	
	public void UpdateWeight(double weight){
		this.weight = weight;
	}
	
	public String toString(){
		return "Patient Name: " + name + "\nBirthdate: " + birthdate +
		"\nSocial Security Number: " + social_security + "\nSex: " + sex +
		"\nAge: " + age + "\nHeight: " + height + " in." + "\nWeight: " +
		weight + " lbs.";
	}
	
	public GeneralInfo clone(){
		return new GeneralInfo(name.clone(), birthdate.clone(), social_security,
				sex, age, height, weight);
	}
}
