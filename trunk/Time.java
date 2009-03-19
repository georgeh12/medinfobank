package repository;

import java.io.Serializable;
import java.util.*;

public class Time implements Serializable {
	private static final long serialVersionUID = -2308028308340828156L;
	
	private int hour = Calendar.HOUR;
	private int minute = Calendar.MINUTE;

	public Time(){ }
	
	public Time(Time time){
		UpdateTime(time.clone());
	}
	
	public Time(int hour, int minute){
		UpdateTime(hour, minute);
	}
	
	public int ReadHour(){
		return hour;
	}
	
	public int ReadMinute(){
		return minute;
	}
	
	public void UpdateTime(Time time){
		UpdateTime(time.hour, time.minute);
	}
	
	public void UpdateTime(int hour, int minute){
		UpdateHour(hour);
		UpdateMinute(minute);
	}
	
	public void UpdateHour(int hour){
		this.hour = hour;
	}
	
	public void UpdateMinute(int minute){
		this.minute = minute;
	}
	
	public String toString(){
		return hour + ":" + minute;
	}
	
	public Time clone(){
		return new Time(hour, minute);
	}
}
