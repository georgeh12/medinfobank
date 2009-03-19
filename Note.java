package repository;

import java.io.Serializable;

public class Note implements Serializable {
	private static final long serialVersionUID = 8426200780184595652L;
	
	private String note_string = "";
	private String note = "";
	
	public Note(){}
	
	public Note(Note note){
		UpdateNote(note.clone());
	}
	
	public Note(String note){
		UpdateNote(note);
	}
	
	public Note(String note_string, String note){
		UpdateNote(note_string, note);
	}
	
	public String ReadNoteString(){
		return note_string;
	}
	
	public String ReadNote(){
		return note;
	}
	
	public void UpdateNote(Note note){
		UpdateNote(note);
	}
	
	public void UpdateNote(String note){
		this.note = note;
	}
	
	public void UpdateNote(String note_string, String note){
		this.note_string = note_string;
		this.note = note;
	}
	
	public String toString(){
		return note_string + note;
	}
	
	public Note clone(){
		return new Note(note_string, note);
	}
}
