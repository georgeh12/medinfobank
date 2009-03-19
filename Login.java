package repository;

import java.io.Serializable;

public class Login implements Serializable {
	private static final long serialVersionUID = -3343275566825379641L;
	
	private String username = "";
	private String password = "";
	private boolean logged_in = false;
	
	public boolean Authenticate(String username, String password){
		if(this.username == username && this.password == password){
			logged_in = true;
		}
		return logged_in;
	}
	
	public Login(){ }
	
	public Login(String username, String password){
		this(username, password, true);
	}
	
	public Login(String username, String password,
			boolean logged_in){
		UpdateLogin(username, password, logged_in);
	}
	
	public String ReadUsername(){
		return username;
	}
	
	public String ReadPassword(){
		return password;
	}
	
	public boolean ReadLoggedIn(){
		return logged_in;
	}
	
	private void UpdateLogin(String username, String password,
			boolean logged_in){
		UpdateUsername(username);
		UpdatePassword(password);
		UpdateLoggedIn(logged_in);
	}
	
	private void UpdateUsername(String username){
		this.username = username;
	}
	
	private void UpdatePassword(String password){
		this.password = password;
	}
	
	private void UpdateLoggedIn(boolean logged_in){
		this.logged_in = logged_in;
	}
	
	public String toString(){
		return "Username: " + username + "\nPassword: " +
		(logged_in ? "" : password);
	}
	
	public Login clone(){
		return new Login(username, password, logged_in);
	}
}
