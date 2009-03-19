package repository;

import java.io.Serializable;
import java.util.*;

public class SurgicalHistory implements Serializable {
	private static final long serialVersionUID = -3342511976740018193L;

	public class Operation implements Serializable {
		private static final long serialVersionUID = -7858194187336291399L;
		
		private String name;
		private Date date;
		
		public Operation(){ }
		
		public Operation(Operation operation){
			UpdateOperation(operation.clone());
		}
		
		public Operation(String name, Date date){
			UpdateOperation(name, date.clone());
		}
		
		public void UpdateOperation(Operation operation){
			UpdateOperation(operation.name, operation.date);
		}
		
		public void UpdateOperation(String name, Date date){
			UpdateMedicine(name);
			UpdateDate(date);
		}
		
		public void UpdateMedicine(String name){
			this.name = name; 
		}
		
		public void UpdateDate(Date date){
			this.date = date;
		}
		
		public String toString(){
			return name + ":  " + date;
		}
		
		public Operation clone(){
			return new Operation(name, date.clone());
		}
	}
	
	private Vector<Operation> operations = new Vector<Operation>();
	private Date tetanus_shot;
	
	public void CreateOperation(String name, Date date){
		operations.add(new Operation(name, date));
	}
	
	public void CreateOperation(Operation operation){
		operations.add(operation);
	}
	
	public Operation ReadOperation(int index){
		if(IndexIsValid(index)){
			return operations.get(index);
		}
		else{
			return null;
		}
	}
	
	public boolean UpdateOperation(Operation old_operation,
			Operation new_operation){
		return UpdateOperation(operations.indexOf(old_operation),
				new_operation);
	}
	
	public boolean UpdateOperation(int index, Operation operation){
		if(IndexIsValid(index)){
			operations.set(index, operation);
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean DeleteOperation(Operation operation){
		return operations.remove(operation);
	}
	
	public boolean DeleteOperation(int index){
		if(IndexIsValid(index)){
			operations.remove(index);
			return true;
		}
		else{
			return false;
		}
	}
	
	public int size(){
		return operations.size();
	}
	
	private boolean IndexIsValid(int index){
		return index >= 0 && index < size();
	}
	
	public SurgicalHistory(){ }
	
	public SurgicalHistory(SurgicalHistory surgical_history){
		UpdateSurgicalHistory(surgical_history.clone());
	}

	private SurgicalHistory(Vector<Operation> operations){
		this.operations = CloneOperations(operations);
	}

	public Vector<Operation> ReadMedications(){
		return CloneOperations(operations);
	}
	
	@SuppressWarnings("unchecked")
	private Vector<Operation> CloneOperations(Vector<Operation> operations){
		return (Vector<Operation>) operations.clone();
	}
	
	public Date ReadTetanusShot(){
		return tetanus_shot;
	}
	
	public void UpdateSurgicalHistory(SurgicalHistory surgical_history){
		this.operations = surgical_history.operations;
	}
	
	public void UpdateTetanusShot(Date tetanus_shot){
		this.tetanus_shot = tetanus_shot;
	}
	
	public String toString(){
		StringBuffer surgical_history_string = new StringBuffer("");
		
		for(int i = 0; i < size(); i ++){
			surgical_history_string.append((i == 0 ? "" : "\n") +
					operations.get(i));
		}
		
		return surgical_history_string.toString();
	}
	
	public SurgicalHistory clone(){
		return new SurgicalHistory(operations);
	}
}
