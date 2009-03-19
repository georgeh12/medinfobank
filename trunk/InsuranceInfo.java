package repository;

import java.io.Serializable;

public class InsuranceInfo implements Serializable {
	private static final long serialVersionUID = -160491412428495081L;
	
	private String name = "";
	private String group_number = "";
	private String subscriber_number = "";
	private PhoneNumber telephone;
	private boolean copay = false;
	private double copay_amount = 0.0;
	private String web_address = "";

	public InsuranceInfo(){ }
	
	public InsuranceInfo(InsuranceInfo insurance_info){
		UpdateInsuranceInfo(insurance_info.clone());
	}
	
	public InsuranceInfo(String name, String group_number,
			String subscriber_number, PhoneNumber telephone, boolean copay,
			double copay_amount, String web_address){
		UpdateInsuranceInfo(name, group_number, subscriber_number,
				telephone.clone(), copay, copay_amount, web_address);
	}
	
	public String ReadName(){
		return name;
	}

	public String ReadGroupNumber(){
		return group_number;
	}

	public String ReadSubscriberNumber(){
		return subscriber_number;
	}

	public PhoneNumber ReadTelephone(){
		return telephone;
	}

	public boolean ReadCopay(){
		return copay;
	}

	public double ReadCopayAmount(){
		return copay_amount;
	}

	public String ReadWebAddress(){
		return web_address;
	}
	
	public void UpdateInsuranceInfo(InsuranceInfo insurance_info){
		UpdateInsuranceInfo(insurance_info.name,
				insurance_info.group_number, insurance_info.subscriber_number,
				insurance_info.telephone, insurance_info.copay,
				insurance_info.copay_amount, insurance_info.web_address);
	}
	
	public void UpdateInsuranceInfo(String name, String group_number,
			String subscriber_number, PhoneNumber telephone,
			boolean copay, double copay_amount, String web_address){
		UpdateCompanyName(name);
		UpdateGroupNumber(group_number);
		UpdateSubscriberNumber(subscriber_number);
		UpdateTelephone(telephone);
		UpdateCopay(copay);
		UpdateCopayAmount(copay_amount);
		UpdateWebAddress(web_address);
	}
	
	public void UpdateCompanyName(String name){
		this.name = name;
	}
	
	public void UpdateGroupNumber(String group_number){
		this.group_number = group_number;
	}
	
	public void UpdateSubscriberNumber(String subscriber_number){
		this.subscriber_number = subscriber_number;
	}
	
	public void UpdateTelephone(PhoneNumber telephone){
		this.telephone = telephone;
	}
	
	public void CheckCopay(){
		UpdateCopay(true);
	}
	
	public void UncheckCopay(){
		UpdateCopay(false);
	}
	
	private void UpdateCopay(boolean copay){
		this.copay = copay;
	}
	
	public void UpdateCopayAmount(double copay_amount){
		this.copay_amount = copay_amount;
	}
	
	public void UpdateWebAddress(String web_address){
		this.web_address = web_address;
	}
	
	public String toString(){
		return "Company Name: " + name + "\nGroupNumber: " +
		group_number + "\nSubscriber Number: " + subscriber_number +
		"\nPhone Number: " + telephone + "\n" +
		(copay ? "+" : "-") + "Is copay required?  Amount: " + copay_amount +
		"\nWeb Address: " + web_address;
	}

	public InsuranceInfo clone(){
		return new InsuranceInfo(name, group_number, subscriber_number,
				telephone.clone(), copay, copay_amount, web_address);
	}
}
