package repository;

import java.io.Serializable;

public class SocialHistory implements Serializable {
	private static final long serialVersionUID = 2775305470238548967L;
	
	private final static int history_size = 4;
	private final String[] history_questions = {"Do you excercise regularly?", 
			"Do you drink alcohol?", "Do you use recreational drugs?",
			"Are you sexually active?"};
	private boolean[] history = new boolean[size()];
	private Note countries_visited;
	
	public SocialHistory(){ }
	
	public SocialHistory(SocialHistory social_history){
		UpdateSocHistory(social_history.clone());
	}
	
	public SocialHistory(boolean[] history, Note countries_visited){
		UpdateSocHistory(history.clone(), countries_visited.clone());
	}
	
	public void UpdateSocHistory(SocialHistory social_history){
		UpdateSocHistory(social_history.history,
				social_history.countries_visited);
	}
	
	public boolean[] ReadHistory(){
		return history;
	}
	
	public boolean ReadHistory(int index){
		if(IndexIsValid(index)){
			return history[index];
		}
		else{
			return false;
		}
	}
	
	public Note ReadCountriesVisited(){
		return countries_visited;
	}
	
	public void UpdateSocHistory(boolean[] history, Note countries_visited){
		UpdateHistory(history);
		UpdateCountriesVisited(countries_visited);
	}
	
	public void UpdateHistory(boolean[] history){
		this.history = history;
	}
	
	public void UpdateCountriesVisited(Note countries_visited){
		this.countries_visited = countries_visited;
	}
	
	public int size(){
		return history_size;
	}
	
	private boolean IndexIsValid(int index){
		return index >= 0 && index < size();
	}
	
	public String toString(){
		String social_history_string = "";
		for(int i = 0; i < size(); i ++){
			social_history_string += (history[i] ? "+" : "-") +
			history_questions[i] + "\n";
		}
		
		return social_history_string +
		"List any foreign countries or places you've visited:\n" +
		countries_visited;
	}
	
	public SocialHistory clone(){
		return new SocialHistory(history.clone(), countries_visited.clone());
	}
}
