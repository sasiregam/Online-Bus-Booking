package Bus_Booking;

import java.util.*;

public class NonAc_sleeper extends Passenger_details {
	Passenger_details pd = new Passenger_details();
	Scanner scanner = new Scanner(System.in);
	public void add(){
		for(int i=0;i<3;i++){
			for(int j=0;j<2;j++){
				upper_nac[i][j]=new Passenger();
				lower_nac[i][j]= new Passenger();
			}
		}
	}
	public void display(){
		System.out.println("..............Non AC Sleeper................");
		System.out.println("..........Upper............");
		for(int i=0;i<3;i++){
			int k=1;
			for(int j=0;j<2;j++){
				if(upper_nac[i][j].getPassenger_sex().equals("neutral"))
				{
					System.out.print("|"+(i+1)+""+k+".Available | ");
				}
					
				else
				{
					String name= seat[i][j].Passenger_gender;
					System.out.print("|   "+name+"   | ");		}
					
			}
			System.out.println();
			if(i==1)
				System.out.println();
		}
		System.out.println("..................Lower.................");
		for(int i=0;i<3;i++){
			int k=1;
			for(int j=0;j<2;j++,k++){
				if(lower_nac[i][j].getPassenger_sex().equals("neutral"))
				{
					System.out.print("|"+(i+1)+""+k+".Available | ");
				}
					
				else {
					String name= seat[i][j].Passenger_gender;
					System.out.print("|   "+name+"   | ");
				
			}
		}
			System.out.println();
			if(i==1)
				System.out.println();
		
	}
		System.out.println("........................................\n");
	}
	public void details() throws Exception
	{
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
		while(no_pass>=map.get("3.non AC Sleeper"))
		{
			System.out.println("The seats availability is low");
			no_pass = scanner.nextInt();
		}
		while(count!=no_pass){
			System.out.println("please enter \n1.upper\n2. lower");
			String choice = scanner.next();
			switch (choice)
			{
			case "1":
				System.out.print("Enter your seat no:");
				String seat="0";
				  flag=true;
				 while(flag) 
				 {
					 seat=scanner.next();
					 flag=pd.check(seat);
			     }
				 int seat_c = Integer.parseInt(seat);
				 while(true)
				 {
					 if(seat_c ==11||seat_c==12||seat_c==13||seat_c==21||seat_c==22||seat_c==23)
					 {
						 break;
					 }
					 else
					 {
						 System.out.println("Enter correct seat number:");
						 continue;
					 }
				 }
				 int row_no = seat_c/10;
				 int col_no = seat_c%10;
				if(!(upper_nac[row_no-1][col_no-1].getPassenger_sex().equals("neutral")))
				{
					System.out.println("The seat is already booked, Kindly choose another seat");
					continue;
				}
				if(upper_nac[row_no-1][col_no-1].getPassenger_sex().equals("neutral")){
					upper_nac[row_no-1][col_no-1].setPassengerID(user_id);
					System.out.println("Enter your gender:(Male\\Female)");
					String gender = scanner.next();
					if(row_no-1==1)
					{
						if(upper_nac[row_no-2][col_no-1].getPassenger_sex().equals(gender)||upper_nac[row_no-2][col_no-1].getPassenger_sex().equals("neutral")||upper_nac[row_no-2][col_no-1].getPassengerID().equals(user_id))
						{
							upper_nac[row_no-1][col_no-1].setPassenger_gender(gender);
							 System.out.println("Enter the Name of the passenger");
							 String Name = scanner.next();
							 upper_nac[row_no-1][col_no-1].setPassenger_Name(Name);
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
							 upper_nac[row_no-1][col_no-1].setPassenger_Age(age);
							 upper_nac[row_no-1][col_no-1].setticket_amt(550);
							 count++;
							 continue;
						}
						 else{
							 System.out.println("Gender not matched please change seat no");
							 continue;
						 }
					}
					if(row_no-1==0)
					{
						if(upper_nac[row_no][col_no-1].getPassenger_sex().equals(gender)||upper_nac[row_no][col_no-1].getPassenger_sex().equals("neutral")||upper_nac[row_no][col_no-1].getPassengerID().equals(user_id))
						{
							upper_nac[row_no-1][col_no-1].setPassenger_gender(gender);
							 System.out.println("Enter the Name of the passenger");
							 String Name = scanner.next();
							 upper_nac[row_no-1][col_no-1].setPassenger_Name(Name);
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
							 upper_nac[row_no-1][col_no-1].setPassenger_Age(age);
							 upper_nac[row_no-1][col_no-1].setticket_amt(550);
							 count++;
							 continue;
						}
						 else{
							 System.out.println("gender not matched please change seat no");
							 continue;
						 }
					}
				}
			case "2":
				System.out.print("Enter your seat no:");
				 seat="0";
				  flag=true;
				 while(flag) 
				 {
					 seat=scanner.next();
					 flag=pd.check(seat);
			     }
				seat_c = Integer.parseInt(seat);
				while(true)
				{
				    break;
				}
				row_no = seat_c/10;
				col_no = seat_c%10;
				if(!(lower_nac[row_no-1][col_no-1].getPassenger_sex().equals("neutral")))
					System.out.println("The seat is already booked, Kindly choose another seat");
				if(lower_nac[row_no-1][col_no-1].getPassenger_sex().equals("neutral")){
					lower_nac[row_no-1][col_no-1].setPassengerID(user_id);
					System.out.println("Enter your gender:(Male\\Female)");
					String gender = scanner.next();
					if(row_no-1==1)
					{
						if(lower_nac[row_no-2][col_no-1].getPassenger_sex().equals(gender)||lower_nac[row_no-2][col_no-1].getPassenger_sex().equals("neutral")||lower_nac[row_no-2][col_no-1].getPassengerID().equals(user_id))
						{
							lower_nac[row_no-1][col_no-1].setPassenger_gender(gender);
							 System.out.println("Enter the Name of the passenger");
							 String Name = scanner.next();
							 lower_nac[row_no-1][col_no-1].setPassenger_Name(Name);
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
							 lower_nac[row_no-1][col_no-1].setPassenger_Age(age);
							 lower_nac[row_no-1][col_no-1].setticket_amt(550);
							 count++;
							 continue;
						}
						 else{
							 System.out.println("gender not matched please change seat no");
							 continue;
						 }
					}
					if(row_no-1==0)
					{
						if(lower_nac[row_no][col_no-1].getPassenger_sex().equals(gender)||lower_nac[row_no][col_no-1].getPassenger_sex().equals("neutral")||lower_nac[row_no][col_no-1].getPassengerID().equals(user_id))
						{
							lower_nac[row_no-1][col_no-1].setPassenger_gender(gender);
							 System.out.println("Enter the Name of the passenger");
							 String Name = scanner.next();
							 lower_nac[row_no-1][col_no-1].setPassenger_Name(Name);
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
							 lower_nac[row_no-1][col_no-1].setPassenger_Age(age);
							 lower_nac[row_no-1][col_no-1].setticket_amt(550);
							 count++;
							 continue;
						}
						 else{
							 System.out.println("gender not matched please change seat no");
							 continue;
						 }
					}
				
			   }
			}
		}
		System.out.println("The total fare for passengers "+no_pass+" is: "+no_pass*600);
		System.out.print("Please enter yes to confirm or no to exit: ");
		 flag = true;
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