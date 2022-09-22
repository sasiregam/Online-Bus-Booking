package Bus_Booking;
import java.util.*;
import java.io.*;
public class Passenger {
	
	public  String Passenger_id="not";
	public  String Passenger_name;
	public  String Passenger_age;
	public  String Passenger_gender="neutral";
	public  int ticket_amt =0;
	
    public void setPassengerID(String ID){
    	Passenger_id =ID;
    }
    public void setPassenger_Name(String Name){
    	Passenger_name = Name;
    }
    public void setPassenger_Age(String Age){
    	Passenger_age = Age;
    }
    public void setPassenger_gender(String gender){
    	Passenger_gender = gender;
    }
    public void setticket_amt(int ticket_no) {
    	ticket_amt=ticket_amt;
    }
    public String getPassengerID(){
    	return Passenger_id;
    }
    public String getPassenger_Name(){
    	return Passenger_name;
    }
    public String getPassenger_Age(){
    	return Passenger_age ;
    }
    public String getPassenger_sex(){
    	return Passenger_gender;
    }
    public int getticket_amt() {
    	return ticket_amt;
    }
}



