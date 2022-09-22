package Bus_Booking;
import java.util.*;
public class Admin extends Passenger_details {
   static	Admin object = new Admin();
	static Scanner scanner = new Scanner(System.in);
	Passenger_details pd = new Passenger_details();
	public void bus_details() throws Exception
	{
		System.out.println("...........Admin..........");
		System.out.println("Enter the bus to overview\n1.AC Sleeper  2.AC Seater  3.Non AC Sleeper  4.Non Ac Seater  5.All  6.Exit");
		boolean flag=true;
		String choice=null;
		while(flag) {
			 choice=scanner.next();
		flag=pd.check(choice);
	}
		switch(choice)
		{
		case "1":
			System.out.println(".....AC Sleeper overview.....");
			int count = object.Acsleeper_details();
			System.out.println(can_acsl);
			if(can_acsl!=0)
			System.out.println("Total fare collected is: "+(count*700+can_acsl*350)+"("+count+" Booking + "+can_acsl+" Cancellation"+")");
			else
				System.out.println("Total fare collected is:"+count*700);
			object.bus_details();
			break;
		case "2":
			System.out.println(".....AC Seater overview.....");
			count= object.Acseater_details();
			if(can_acse!=0)
			System.out.println("Total fare collected is: "+(count*550+can_acse*275)+"("+count+" Booking + "+can_acse+" Cancellation"+")");
			else
				System.out.println("The total fare collected is:"+count*550);
			object.bus_details();
			break;
		case "3":
			System.out.println(".....Non AC Sleeper overview.....");
			count = object.Nacsleeper_details();
			if(can_nacsl!=0)
			System.out.println("Total fare collected is: "+(count*600+can_nacsl*150)+"("+count+" Booking +  "+can_nacsl+" Cancellation"+")");
			else
				System.out.println("Total fare collected is:"+count*600);
			object.bus_details();
			break;
		case "4":
			System.out.println(".....Non AC Seater overview.....");
			count = object.Nacsleeper_details();
			if(can_nacse!=0)
			System.out.println("Total fare collected is: "+(count*450+can_nacse*112.5)+"("+count+" Booking + "+can_nacse+" Cancellation"+")");
			else
				System.out.println("Total fare collected is:"+count*450);
			object.bus_details();
			break;
		case "5":
			System.out.println(".....AC Sleeper overview.....");
			count = object.Acsleeper_details();
			System.out.println(can_acsl);
			if(can_acsl!=0)
			System.out.println("Total fare collected is: "+(count*700+can_acsl*350)+"("+count+" Booking"+can_acsl+" + Cancellation"+")");
			else
				System.out.println("Total fare collected is:"+count*700);
			System.out.println(".....AC Seater overview.....");
			count= object.Acseater_details();
			if(can_acse!=0)
			System.out.println("Total fare collected is: "+(count*550+can_acse*275)+"("+count+"Booking + "+can_acse+" Cancellation"+")");
			else
				System.out.println("The total fare collected is:"+count*550);
			System.out.println(".....Non AC Sleeper overview.....");
			count = object.Nacsleeper_details();
			if(can_nacsl!=0)
			System.out.println("Total fare collected is: "+(count*600+can_nacsl*150)+"("+count+"Booking + "+can_nacsl+" Cancellation"+")");
			else
				System.out.println("Total fare collected is:"+count*600);
			System.out.println(".....Non AC Seater overview.....");
			count = object.Nacsleeper_details();
			if(can_nacse!=0)
			System.out.println("Total fare collected is: "+(count*450+can_nacse*112.5)+"("+count+"Booking + "+can_nacse+" Cancellation"+")");
			else
				System.out.println("Total fare collected is:"+count*450);
			object.bus_details();
		case "6":
			System.out.println("......................................................");
			Main.main(null);
			break;
			default:
				System.out.println("Please enter correct input");
				object.bus_details();
		}
		
	}
	public static int Acsleeper_details()
	{
		int count=0,amount=0;
		boolean flag = false;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<2;j++)
			{
				if(!((upper[i][j]).getPassenger_sex().equals("neutral")))
				{
						System.out.println("Seat no is upper"+(i+1)+(j+1));
						amount=amount+(upper[i][j].ticket_amt);
						count++;
					
				}
				if(!(lower[i][j].getPassenger_sex().equals("neutral")))
				{
						System.out.println("Seat no is lower"+(i+1)+(j+1));
						amount=amount+(upper[i][j].ticket_amt);
						count++;
				}
			}
		}
		System.out.println("Total no of seats filled is:" + count);
		return count;
	}
	public static int Nacsleeper_details()
	{
		int count=0;
		boolean flag = false;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<2;j++)
			{
				if(!((upper_nac[i][j]).getPassenger_sex().equals("neutral")))
				{
						System.out.println("Seat no is upper"+(i+1)+(j+1));
						count++;
					
				}
				if(!(lower_nac[i][j].getPassenger_sex().equals("neutral")))
				{
						System.out.println("Seat no is lower"+(i+1)+(j+1));
						count++;
				}
			}
		}
		System.out.println("Total no of seats filled is:" + count);
		return count;
	}
	public static int Nacseater_details()
	{
		int count=0;
		boolean flag = false;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<2;j++)
			{
				if(!((seat_Non[i][j]).getPassenger_sex().equals("neutral")))
				{
						System.out.println("Seat no is: "+(i+1)+(j+1));
						count++;
				}
			}
		}
		System.out.println("Total no of seats filled is:" + count);
		return count;
	}
	public static int Acseater_details()
	{
		int count=0;
		boolean flag = false;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<2;j++)
			{
				if(!((seat_Non[i][j]).getPassenger_sex().equals("neutral")))
				{
						System.out.println("Seat no is: "+(i+1)+(j+1));
						count++;
				}
			}
		}
		System.out.println("Total no of seats filled is:" + count);
		return count;
	}

	
}
