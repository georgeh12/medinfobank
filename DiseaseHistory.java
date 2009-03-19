package repository;
import java.util.*;
import java.io.*;

/**
 * All ailments/diseases/conditions should be stored in a text file
 * named diseases.txt, or one specified by the constructor. Each
 * category name should have a space before it, followed by all of
 * the diseases in that category.
 */
public class DiseaseHistory implements Serializable {
	private static final long serialVersionUID = -5769412209837530607L;

	public class DiseaseCategory implements Serializable {
		private static final long serialVersionUID = 3210161408587213144L;
		
		private String category;
		private Vector<String> diseases = new Vector<String>();
		private Vector<Boolean> checklist = new Vector<Boolean>();

		public DiseaseCategory(String category, Vector<String> diseases,
				Vector<Boolean> checklist){
			this.category = category;
			this.diseases = CloneDiseases(diseases);
			this.checklist = CloneChecklist(checklist);
		}

		public Vector<String> ReadDiseases(){
			return CloneDiseases(diseases);
		}
		
		@SuppressWarnings("unchecked")
		private Vector<String> CloneDiseases(Vector<String> diseases){
			return (Vector<String>) diseases.clone();
		}

		public Vector<Boolean> ReadChecklist(){
			return CloneChecklist(checklist);
		}
		
		@SuppressWarnings("unchecked")
		private Vector<Boolean> CloneChecklist(Vector<Boolean> checklist){
			return (Vector<Boolean>) checklist.clone();
		}
		
		public DiseaseCategory(String category){
			this.category = category;
		}
		
		public void add(String disease){
			diseases.add(disease);
			checklist.add(false);
		}
		
		public String ReadCategory(){
			return category;
		}
		
		public String ReadDisease(int index){
			if(IndexIsValid(index)){
				return diseases.get(index);
			}
			else{
				return null;
			}
		}
		
		public boolean ReadCheckmark(int index){
			if(IndexIsValid(index)){
				return checklist.get(index);
			}
			else{
				return false;
			}
		}
		
		public boolean CheckDisease(String disease){
			return CheckDisease(diseases.indexOf(disease));
		}
		
		public boolean CheckDisease(int index){
			return MarkDisease(index, true);
		}
		
		public boolean UncheckDisease(String disease){
			return UncheckDisease(disease.indexOf(disease));
		}
		
		public boolean UncheckDisease(int index){
			return MarkDisease(index, false);
		}
		
		private boolean MarkDisease(int index, boolean mark){
			if(IndexIsValid(index)){
				checklist.set(index, true);
				return true;
			}
			else{
				return false;
			}
		}
		
		public int size(){
			return diseases.size();
		}
		
		private boolean IndexIsValid(int index){
			return index >= 0 && index < size();
		}
		
		public String toString(){
			StringBuffer disease_string = new StringBuffer("");
			for(int i = 0; i < size(); i ++){
				disease_string.append("\n" + (checklist.get(i) ? "+" : "-") +
						diseases.get(i));
			}
			return ReadCategory() + ":" + disease_string;
		}
		
		public DiseaseCategory clone(){
			return new DiseaseCategory(category, diseases, checklist);
		}
	}
	
	private Vector<DiseaseCategory> diseases_list;
	
	public DiseaseCategory ReadDiseaseCategory(int index){
		return diseases_list.get(index);
	}
	
	public int size(){
		return diseases_list.size();
	}
	
	public DiseaseHistory(){
		this("diseases.txt");
	}
	
	public DiseaseHistory(String disease_file){
		UpdateDiseaseHistory(disease_file);
	}

	private DiseaseHistory(Vector<DiseaseCategory> diseases_list){
		this.diseases_list = CloneDiseasesList(diseases_list);
	}

	public Vector<DiseaseCategory> ReadDiseasesList(){
		return CloneDiseasesList(diseases_list);
	}
	
	@SuppressWarnings("unchecked")
	private Vector<DiseaseCategory> CloneDiseasesList(Vector<DiseaseCategory> diseases_list){
		return (Vector<DiseaseCategory>) diseases_list.clone();
	}
	
	public int UpdateDiseaseHistory(String disease_file){
		try{
			BufferedReader reader = 
				new BufferedReader(new InputStreamReader(new FileInputStream(disease_file)));

			diseases_list = new Vector<DiseaseCategory>();
			
			while (reader.ready()) {
				String category = reader.readLine();
				diseases_list.add(new DiseaseCategory(category));
			
				while (reader.ready()) {
					String disease = reader.readLine();
					if(disease.length() != 0){
						diseases_list.get(diseases_list.size()-1).add(disease);
					}
					else{
						break;
					}
				}
		}
		} catch(FileNotFoundException e){
			System.out.print(disease_file + " could not be found");
			return -1;
		} catch (IOException e) {
			System.out.print("IOException while reading " + disease_file);
			return -2;
		}
		
		return 0;
	}
	
	public String toString(){
		StringBuffer diseases_string = new StringBuffer("");
		for(int i = 0; i < size(); i ++){
			diseases_string.append((i == 0 ? "" : "\n\n") +
					diseases_list.get(i));
		}
		
		return diseases_string.toString();
	}
	
	public DiseaseHistory clone(){
		return new DiseaseHistory(diseases_list);
	}
}
