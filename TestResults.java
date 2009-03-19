package repository;

import java.io.Serializable;
import java.util.*;

public class TestResults implements Serializable {
	private static final long serialVersionUID = -291682489120808835L;

	public class Test implements Serializable {
		private static final long serialVersionUID = -3515021340941860160L;
		
		private Date date;
		private String type;
		private boolean result = false;
		private Note description;
		
		public Test(){ }
		
		public Test(Test test){
			UpdateTests(test.clone());
		}
		
		public Test(Date date, String type, boolean result, Note description){
			UpdateTest(date, type, result, description);
		}
		
		public void UpdateTests(Test test){
			UpdateTest(test.date, test.type, test.result,
					test.description);
		}
		
		public void UpdateTest(Date date, String type, boolean result,
				Note description){
			UpdateDate(date);
			UpdateType(type);
			UpdateResult(result);
			UpdateDescription(description);
		}
		
		public void UpdateDate(Date date){
			this.date = date; 
		}
		
		public void UpdateType(String type){
			this.type = type;
		}
		
		public void UpdateResult(boolean result){
			this.result = result;
		}
		
		public void UpdateDescription(Note description){
			this.description = description;
		}
		
		public String toString(){
			return "Administered: " + date + "\nTest Type: " + type +
			"\nResults: " + (result ? "Positive" : "\nNegative") +
			"\nDescription: " + description;
		}

		public Test clone(){
			return new Test(date.clone(), type, result, description.clone());
		}
	}
	
	private Vector<Test> tests = new Vector<Test>();

	public void CreateTest(Date date, String type, boolean result,
			Note description){
		tests.add(new Test(date, type, result, description));
	}
	
	public void CreateTest(Test test){
		tests.add(test);
	}
	
	public Test ReadTest(int index){
		if(IndexIsValid(index)){
			return tests.get(index);
		}
		else{
			return null;
		}
	}
	
	public boolean UpdateTest(Test old_test,
			Test new_test){
		return UpdateTest(tests.indexOf(old_test),
				new_test);
	}
	
	public boolean UpdateTest(int index, Test test){
		if(IndexIsValid(index)){
			tests.set(index, test);
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean DeleteTest(Test test){
		return tests.remove(test);
	}
	
	public boolean DeleteTest(int index){
		if(IndexIsValid(index)){
			tests.remove(index);
			return true;
		}
		else{
			return false;
		}
	}
	
	public int size(){
		return tests.size();
	}
	
	private boolean IndexIsValid(int index){
		return index >= 0 && index < size();
	}
	
	public TestResults(){ }
	
	public TestResults(TestResults test_results){
		UpdateTestResults(test_results.clone());
	}

	private TestResults(Vector<Test> tests){
		this.tests = CloneTests(tests);
	}

	public Vector<Test> ReadTests(){
		return CloneTests(tests);
	}
	
	@SuppressWarnings("unchecked")
	private Vector<Test> CloneTests(Vector<Test> tests){
		return (Vector<Test>) tests.clone();
	}
	
	public void UpdateTestResults(TestResults test_results){
		this.tests = test_results.tests;
	}
	
	public String toString(){
		StringBuffer test_results_string = new StringBuffer("");
		
		for(int i = 0; i < size(); i ++){
			test_results_string.append((i == 0 ? "" : "\n") +
					tests.get(i));
		}
		
		return test_results_string.toString();
	}
	
	public TestResults clone(){
		return new TestResults(tests);
	}
}
