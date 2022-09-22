package Bus_Booking;
import java.util.*;
public class Ac_seater extends Passenger_details {
	static Passenger_details pd= new Passenger_details();
	static Scanner scanner = new Scanner(System.in);
	public void add()
	{
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<3;j++)
			{
				seat[i][j]= new Passenger();
			}
		}
	}
	public void Display_seats(){
	System.out.println(".............AC Seater................\n");
		for(int i=0;i<4;i++){
			int k=1;
			for(int j=0;j<3;j++,k++){
				if(seat[i][j].getPassenger_sex().equals("neutral"))
				{
					System.out.print("|"+(i+1)+""+k+".Available | ");
				}
				    
				else {
					
					String name= seat[i][j].Passenger_gender;
					System.out.print("|   "+name+"   | ");
					
				}
			}
			if(i==1)
				System.out.print("\n");
			System.out.println();
		}
		System.out.println("............................................\n");
	}
	public void details ()throws Exception{
		System.out.println("Total No of passengers");
		String no_pas="0";
		int count=0;
		 boolean flag=true;
		 while(flag) 
		 {
			 no_pas=scanner.next();
		     flag=pd.check(no_pas);
	     }	
		 int no_pass = Integer.parseInt(no_pas);
		while(no_pass>=map.get("2.AC seater"))
		{
			System.out.println("The seats availability is low");
			no_pass = scanner.nextInt();
		}
		while(count!=no_pass){
			System.out.print("Enter your seat no:");
			String seat_n="0";
			  flag=true;
			 while(flag) 
			 {
				 seat_n=scanner.next();
				 flag=pd.check(seat_n);
		     }
			 int seat_c = Integer.parseInt(seat_n);
			 int row_no = seat_c/10;
			 int col_no = seat_c%10;

		if(!(seat[row_no-1][col_no-1].getPassenger_sex().equals("neutral")))
		{
			System.out.println("The seat is already booked, Kindly choose another seat");
			continue;
		}
		if(seat[row_no-1][col_no-1].getPassenger_sex().equals("neutral")){
			seat[row_no-1][col_no-1].setPassengerID(user_id);
			System.out.println("Enter your gender:(Male\\Female)");
			String gender = scanner.next();
			if(row_no-1==0||row_no-1==2){
				if(seat[row_no][col_no-1].getPassenger_sex().equals("neutral")||seat[row_no][col_no-1].getPassenger_sex().equals(gender)||seat[row_no][col_no-1].getPassengerID().equals(user_id))
				{
					 seat[row_no-1][col_no-1].setPassenger_gender(gender);
					 System.out.println("Enter the Name of the passenger");
					 String Name = scanner.next();
					 seat[row_no-1][col_no-1].setPassenger_Name(Name);
					 name.add(Name);
					 pass_name.put(user_id, name);
					 System.out.println("Enter the age of the passenger");
					 String age="0";
					 flag=true;
					 while(flag) 
					 {
						 age=scanner.next();
					     flag=pd.check(age);
				     }					
					 seat[row_no-1][col_no-1].setPassenger_Age(age);
					 seat[row_no-1][col_no-1].setticket_amt(550);
					 count++;
					 continue;
				}
				 else{
					 System.out.println("gender not matched please change seat no");
					 continue;
				 }
			}
			if(row_no-1==1||row_no-1==3){
				 if(seat[row_no-2][col_no-1].getPassenger_sex().equals("neutral")||seat[row_no-2][col_no-1].getPassenger_sex().equals(gender)||seat[row_no-2][col_no-1].getPassengerID().equals(user_id))
				 {
					 seat[row_no-1][col_no-1].setPassenger_gender(gender);
					 System.out.println("Enter the Name of the passenger");
					 String Name = scanner.next();
					 seat[row_no-1][col_no-1].setPassenger_Name(Name);
					 name.add(Name);
					 pass_name.put(user_id, name);
					 System.out.println("Enter the age of the passenger");
					 String age="0";
					  flag=true;
					 while(flag) 
					 {
						 age=scanner.next();
					     flag=pd.check(age);
				     }					 
					 seat[row_no-1][col_no-1].setPassenger_Age(age);
					 seat[row_no-1][col_no-1].setticket_amt(550);
					 count++;
					 continue;
				 }
				 else {
					 System.out.println("gender not matched please change seat no");
					 continue;
				 }
			  }
		   }
		}
		System.out.println("The total fare for passengers "+no_pass+" is:"+no_pass*550);
		System.out.print("Please enter yes to confirm or no to exit: ");
		while(true)
		{
		String choice = scanner.next();
		switch(choice)
		{
		case "Yes":
			System.out.println("Your booking is confirmed");
			Main.confirmed.add(user_id);
			counting_cancel.put(user_id, count);
			pd.Passenger_Details();
			break;
		case "yes":
			System.out.println("Your booking is confirmed");
			Main.confirmed.add(user_id);
			counting_cancel.put(user_id, count);
			pd.Passenger_Details();
			break;
		case "No":
			pd.cancelAll(user_id);
			Main.confirmed.remove(user_id);
			pd.ticket_decision();
			break;
		case "no":
			pd.cancelAll(user_id);
			Main.confirmed.remove(user_id);
			pd.ticket_decision();
			break;	
		default:
			System.out.println("Invalid input");
			System.out.println("Enter again");
			
			continue;
		}
		}
	}
}
	
