package repository;
import java.io.Serializable;
import java.util.*;

public class Date implements Serializable {
	private static final long serialVersionUID = -1197080243283088199L;
	
	private int day = Calendar.DATE;
	private int month = Calendar.MONTH;
	private int year = Calendar.YEAR;

	public Date(){ }
	
	public Date(Date date){
		UpdateDate(date.clone());
	}
	
	public Date(int day, int month, int year){
		UpdateDate(day, month, year);
	}
	
	public int ReadDay(){
		return day;
	}
	
	public int ReadMonth(){
		return month;
	}
	
	public int ReadYear(){
		return year;
	}
	
	public void UpdateDate(Date date){
		UpdateDate(date.day, date.month, date.year);
	}
	
	public void UpdateDate(int day, int month, int year){
		UpdateDay(day);
		UpdateMonth(month);
		UpdateYear(year);
	}
	
	public void UpdateDay(int day){
		this.day = day;
	}
	
	public void UpdateMonth(int month){
		this.month = month;
	}
	
	public void UpdateYear(int year){
		this.year = year;
	}
	
	public String toString(){
		return month + "/" + day + "/" + year;
	}
	
	public Date clone(){
		return new Date(day, month, year);
	}
}
