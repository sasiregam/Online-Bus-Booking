package Bus_Booking;
import java.util.*;
class Login{
	public void run()throws Exception{
		System.out.println("\n*************************************************************************");
		Passenger_details details = new Passenger_details();
		details.Passenger_Details() ;
		}
}
public class Main extends Passenger_details {
	static ArrayList<String> confirmed;
	static {
		confirmed= new ArrayList<>();
	Ac_sleeper booking_acsl = new Ac_sleeper();
	Ac_seater booking_acs = new Ac_seater();
	NonAc_sleeper booking_nacsl = new NonAc_sleeper();
	NonAc_seater booking_nacs = new NonAc_seater();
	booking_acs.add();
	booking_nacsl.add();
	booking_nacs.add();
	booking_acsl.add();
	}
	
	public static void main(String[] args) throws Exception{
		
		Admin obj = new Admin();
		String pass = "123456789";
		Scanner scanner = new Scanner(System.in);
		System.out.println("...................WELCOME TO ZOBUS...................");
		System.out.println("                (Chennai to Banaglore)");
		System.out.println("1.User"+"\n2.Admin\n3.Exit");
		System.out.print("Please enter your choice: ");
		boolean flag=false;
		String choice = scanner.next();
		if(!(choice.equals("1")||choice.equals("2")||choice.equals("3")))
		{
			System.out.println("Invalid Input");
			Main.main(null);
		}
		else {
		switch(choice)
		{
		case "1":
		   Login Existing_user = new Login();
		   Existing_user.run();
		   break;
		case "2":
			System.out.println("Enter your password");
			String in= scanner.next();
			while(flag!=true)
			if(in.equals(pass))
				flag = true;
			else
			{
			 System.out.println("Enter correct password");
			 in= scanner.next();
			 flag = false;
			}
			if(flag=true)
				obj.bus_details();
			break;
		case "3":
			System.out.println("Thank you for choosing ZOBUS");
			break;
		default:
			System.out.println("Please enter correct input");
			Main.main(null);
		}
		}
		
	
	}
}
/* */