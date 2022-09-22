package Bus_Booking;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;
class Passenger_details  {
	public static Passenger[][] seat=new Passenger[4][3];
	public static Passenger[][] upper= new Passenger[3][2];
	public static Passenger[][] lower = new Passenger[3][2];
	public static Passenger[][] upper_nac= new Passenger[3][2];
	static Passenger[][] lower_nac = new Passenger[3][2];
	static Passenger[][] seat_Non=new Passenger[4][3];
	static NonAc_seater booking_nacse = new NonAc_seater();
	static NonAc_sleeper booking_nacsl = new NonAc_sleeper();
	static Ac_seater booking_acse = new Ac_seater();
   static  Ac_sleeper booking_acsl = new Ac_sleeper();
	public static  String user_id; 
	static Scanner scanner = new Scanner(System.in);
	static Passenger passenger = new Passenger();
	static Passenger [][] array;
	static Passenger_details passenger_details = new Passenger_details();
	public static int entring=0;
	public static int [][] order=new int[4][2];
	public static Map<String, Integer> map = new LinkedHashMap<>();
	public static Map<String, Integer>counting_cancel = new HashMap<>();
	public static ArrayList<Integer> counting =new ArrayList<>();
	public static int can_acsl=0;
	public static int can_nacsl=0;
	public static int can_acse=0;
	public static int can_nacse=0;
	public static int con_can=0;
	public static ArrayList<String> name = new ArrayList<>();
	public static Map<String, ArrayList<String>> pass_name = new HashMap<>();
	//here we get user input
     public void Passenger_Details() throws Exception{
    	 System.out.print("User Login\n"+"1.Login"+"\n2.SignUp"+"\n3.Exit");
    	 System.out.print("\n**************************************************************************"+"\nPlease enter your choice: ");
        String  choice = scanner.next();
        if(!(choice.equals("1")||choice.equals("2")||choice.equals("3")))
        {
        	System.out.println("Invalid Input");
        	passenger_details.Passenger_Details();
        }
        switch (choice){
         case "1": //login
            passenger_details.Login();
            ticket_decision();
            break;
         case "2"://sign up
        	 passenger_details.signUp();
        	 break;
         case "3": //exit to main
        	 Main.main(null);
        	 break;
         default:
 			System.out.println("Please enter correct input");
 			passenger_details.Passenger_Details();
         }
   }
     File login_sheet = new File("C:\\Users\\admin\\Desktop\\login_Sheet.txt");
     BufferedReader br;
     BufferedWriter buffer;
     public void Login() throws Exception {
    	 entring++;//how many are signing in
    	 scanner.nextLine();
    	 br=new BufferedReader(new FileReader(login_sheet));
    	 boolean log=false;
    	 System.out.print("Enter Username:");
    	 user_id = scanner.next(); 
    	 String line; br.readLine();
    	 while((line=br.readLine())!=null){
    		 String[] match=line.split(" ");
    		 if((match[0]).equals(user_id)) {
    			 System.out.print("Enter the password:"); //password section
    			 String password=scanner.next();
    			 while(!password.equals(match[1])) {
    				 System.out.println("Please enter the correct password");
    				 password=scanner.nextLine();
    			 }
    			 System.out.println("\n...............You have been loged in successfully...............");
    			 log=true;
    		 }
    	 }
     	 br.close();
    	 if(log==false) { //to sign in using the login method
    		 System.out.println("You didn't have an account so enter the password to create an account");
    		 System.out.println("Enter the password");
    		 String password=scanner.next();
    		 System.out.println("\n...............You have been loged in successfully...............");
      		 buffer=new BufferedWriter(new FileWriter(login_sheet,true));
    		 buffer.write("\n"+user_id+" "+password);
    		buffer.close();
    		 
    	 }
     }
     public void ticket_decision()throws Exception {
    	 System.out.print("\n1.Ticket booking   2.Ticket cancellation   3.Previous booking  4.Exit\nEnter your choice: ");
    	 boolean flag = false;
    	String  choice = scanner.next();
    	 if(!(choice.equals("1")||choice.equals("2")||choice.equals("3")||choice.equals("4")))
    	 {
         	System.out.println("Invalid Input");
         	passenger_details.ticket_decision();
    	 }
    	 switch(choice){
    	 case "1"://ticket booking
    		 Ticket_booking();
    		 break;
    	 case "2":
    		 if(!(Main.confirmed.contains(user_id))) {
        		 System.out.println("You do not have any booking");
        		 passenger_details.ticket_decision();
        		 return;
        	 }
    		  passenger_details.previous_booking(user_id);
    		  System.out.println("1.Partial\n2.All\n3.Exit");
    		  String choice1 = scanner.next();
    		  switch(choice1)
    		  {
    		  case "1":
    			  passenger_details.cancelPartial(user_id);
    			  break;
    		  case "2":
    			  con_can =1;
        		  passenger_details.cancelAll(user_id);
        		  break;
    		  case "3":
    			  passenger_details.ticket_decision();
    			  break;
    			  default:
    				  System.out.println("Enter the correct input");
    				  passenger_details.ticket_decision();
    		  }
    		  passenger_details.ticket_decision();
    	     break;
    	 case "3":
    		 if(!(Main.confirmed.contains(user_id))) {
        		 System.out.println("You do not have any booking");
        		 passenger_details.ticket_decision();
        		 return;
        	 }
    		  passenger_details.previous_booking(user_id);
    		  passenger_details.ticket_decision();
    		  break;
    	 case "4":
    		 passenger_details.Passenger_Details();
    		 break;
    	 default:
	 			System.out.println("Please enter correct input");
	 			passenger_details.ticket_decision();
    	 }
     }
     public void signUp() throws Exception{
    	 br = new BufferedReader(new FileReader(login_sheet));
    	 buffer = new BufferedWriter(new FileWriter(login_sheet,true));
    	 System.out.print("Enter your Username:");
    	 String user_id = scanner.next();
    	 System.out.print("Enter your Password:");
    	 String password = scanner.next();
    	 buffer.write("\n"+user_id+" "+password);
    	 buffer.close();
    	 br.close();
    	 System.out.println("You have been logged in successfully");
    	 ticket_decision();
     }
     public void Ticket_booking() throws Exception {
    	 passenger_details.order_filter();
//    	 map=passenger_details.sortBykey(map);sortByValue
    	 passenger_details.sortByValue(map);
    	 
//    	 for (Map.Entry<String, Integer> en : map.entrySet()) {
//             System.out.println( en.getKey()+" -" + en.getValue());
//    	 }
    	 System.out.println("5.All \n6.Exit");
    	 if(Main.confirmed.contains(user_id)) {
    		 System.out.println("You already booked"+"\n1.Please choose another option");
    		 passenger_details.ticket_decision();
    		 return;
    	 }
    	 
    	 System.out.println("\nAC + Sleeper - Rs.700 / seat\r\n"
    	 		+ "AC + Seater - Rs. 550 / seat\r\n"
    	 		+ "Non-AC + Sleeper - Rs. 600 / seat\r\n"
    	 		+ "Non-AC + Seater - Rs. 450 / seat"+"\nPlease enter your choice: ");
    	 String choice = scanner.next();
    	 if(!(choice.equals("1")||choice.equals("2")||choice.equals("3")||choice.equals("4")||choice.equals("5")||choice.equals("6")))
    	 {
    		 System.out.println("Invalid Input");
    		 passenger_details.Ticket_booking();
    	 }
    	 switch(choice) {
    	 case "1":
    		 booking_acsl.display();
    		 booking_acsl.details();
    		 break;
    	 case "2":
    		 booking_acse.Display_seats();
    		 booking_acse.details();
    		 break;
    	 case"3":
    		 booking_nacsl.display();
    		 booking_nacsl.details();
    		 break;
    	 case "4":
    		 booking_nacse.Display_seats();
    		 booking_nacse.details();
    		 break;
    	 case "5":
    		 booking_acsl.display();
    		 booking_acse.Display_seats();
    		 booking_nacsl.display();
    		 booking_nacse.Display_seats();
    		 passenger_details.Ticket_booking();
    		 
    	 case "6":
    		 passenger_details.ticket_decision();
    	 default:
	 			System.out.println(".....................Please enter correct input....................");
	 			passenger_details.Ticket_booking();
    	 }
     }
     public void cancelAll(String id) throws Exception
     { //ac seater
    	 map.replace(id, null);
    	 for(int i=0;i<4;i++)
 		{
 			for(int j=0;j<3;j++)
 			{
 				if(seat[i][j].getPassenger_sex().equals("neutral"))
 					continue;
 				else if(seat[i][j].getPassengerID().equals(id))
 				{
 					seat[i][j].setPassenger_gender("neutral");
 					seat[i][j].setPassengerID("not");
 					if(con_can==1)
 						can_acse++;
 				}
 			}
 		}
    	 //non ac seater
    	 for(int i=0;i<4;i++)
 		{
 			for(int j=0;j<3;j++)
 			{
 				if(seat_Non[i][j].getPassenger_sex().equals("neutral"))
 					continue;
 				else if(seat_Non[i][j].getPassengerID().equals(id))
 				{
 					seat_Non[i][j].setPassenger_gender("neutral");
 					seat_Non[i][j].setPassengerID("not");
 					if(con_can==1)
 						can_nacse++;
 				}
 			}
 		}
    	 //ac-sleeper
    	 for(int i=0;i<3;i++)
			{
				for(int j=0;j<2;j++)
				{
					if(upper[i][j].getPassenger_sex().equals("neutral"))
						continue;
					else if(upper[i][j].getPassengerID().equals(id))
					{
						upper[i][j].setPassenger_gender("neutral");
						upper[i][j].setPassengerID("not");
						if(con_can==1)
	 						can_acsl++;
					}
				}
			}
    	 for(int i=0;i<3;i++)
			{
				for(int j=0;j<2;j++)
				{
					if(lower[i][j].getPassenger_sex().equals("neutral"))
						continue;
					else if(lower[i][j].getPassengerID().equals(id))
					{
						lower[i][j].setPassenger_gender("neutral");
						lower[i][j].setPassengerID("not");
						if(con_can==1)
	 						can_acsl++;
					}
				}
			}
    	 //non ac sleeper
    	 for(int i=0;i<3;i++)
			{
				for(int j=0;j<2;j++)
				{if(upper_nac[i][j].getPassenger_sex().equals("neutral"))
					continue;
				else if(upper_nac[i][j].getPassengerID().equals(id))
				{
					upper_nac[i][j].setPassenger_gender("neutral");
					upper_nac[i][j].setPassengerID("not");
					if(con_can==1)
 						can_nacsl++;
				}
				}
			}
    	 for(int i=0;i<3;i++)
			{
				for(int j=0;j<2;j++) {
						
				if(lower_nac[i][j].getPassenger_sex().equals("neutral"))
					continue;
				else if(lower_nac[i][j].getPassengerID().equals(id))
				{
					lower_nac[i][j].setPassenger_gender("neutral");
					lower_nac[i][j].setPassengerID("not");
					if(con_can==1)
 						can_nacsl++;
				  }
				}
				}
    	 System.out.println("All your booking has been cancelled");
    	 Main.confirmed.remove(user_id);
     }
     public void previous_booking(String id)
     {
    	 System.out.println("......Previous booking details...........");
    	 //ac-seater
    	 
    	 for(int i=0;i<4;i++)
  		{
  			for(int j=0;j<3;j++)
  			{
  				if(seat[i][j].getPassenger_sex().equals("neutral"))
  					continue;
  				else if(seat[i][j].getPassengerID().equals(id))
  				{
  					System.out.println("Your seat no is in AC Seater"+(i+1)+(j+1));
  					System.out.println("Name of the passenger"+seat[i][j].getPassenger_Name());
  					
  				}
  			}
  		}
     	 //non ac seater
     	 for(int i=0;i<4;i++)
  		{
  			for(int j=0;j<3;j++)
  			{
  				if(seat_Non[i][j].getPassenger_sex().equals("neutral"))
  					continue;
  				else if(seat_Non[i][j].getPassengerID().equals(id))
  					{
  						System.out.println("Your seat no is in Non Ac Seater"+(i+1)+(j+1));
  						System.out.println("Name of the passenger"+seat_Non[i][j].getPassenger_Name());
  					}
  				
  			}
  		}
     	 //ac-sleeper
     	for(int i=0;i<3;i++)
			{
				for(int j=0;j<2;j++)
				{if(upper[i][j].getPassenger_sex().equals("neutral"))
					continue;
				else if(upper[i][j].getPassengerID().equals(id))
				{
					System.out.println("Your seat no is in AC Sleeper in upper"+(i+1)+(j+1));
					System.out.println("Name of the passenger"+upper[i][j].getPassenger_Name());
					
				}	
				}
			}
     	for(int i=0;i<3;i++)
		{
			for(int j=0;j<2;j++)
			{
				if(lower[i][j].getPassenger_sex().equals("neutral"))
					continue;
				else if(lower[i][j].getPassengerID().equals(id))
				{
					System.out.println("Your seat no is in Non AC sleeper in lower"+(i+1)+(j+1));
					System.out.println("Name of the passenger"+lower[i][j].getPassenger_Name());
					
				  }
				}
			}
 	 
     	 //non ac sleeper
     	 for(int i=0;i<3;i++)
 			{
 				for(int j=0;j<2;j++)
 				{
 					if(upper_nac[i][j].getPassenger_sex().equals("neutral"))
 					continue;
 				else if(upper_nac[i][j].getPassengerID().equals(id))
 				{
 					System.out.println("Your seat no is in Non AC Sleeper in upper"+(i+1)+(j+1));
 					System.out.println("Name of the passenger"+upper_nac[i][j].getPassenger_Name());
 					
 				}	
 				}
 			}
     	 for(int i=0;i<3;i++)
			{
				for(int j=0;j<2;j++)
				{
 				if(lower_nac[i][j].getPassenger_sex().equals("neutral"))
 					continue;
 				else if(lower_nac[i][j].getPassengerID().equals(id))
 				{
 					System.out.println("Your seat no is in Non AC sleeper in lower"+(i+1)+(j+1));
 					System.out.println("Name of the passenger"+lower_nac[i][j].getPassenger_Name());
 					
 				  }
 				}
 			}
     }
     public void cancelPartial(String id) throws Exception
     { //ac seater
    	 int count=0;
    	 int counting=counting_cancel.get(id);
    	 
 	    System.out.println("Total no of seats to cancel");
 	    int no = scanner.nextInt();
 	    if(counting==no)
 	    	Main.confirmed.remove(id);
 	    if(no<=counting) {
 		while(count!=no)
 		{
 			System.out.println("Enter the passenger name");
 			
 				String name = scanner.next();
 	 			if(pass_name.get(id).contains(name)) 
 	 			{
 			
 			//ac seater
    	 for(int i=0;i<4;i++)
 		{
 			for(int j=0;j<3;j++)
 			{
 				if(seat[i][j].getPassenger_sex().equals("neutral"))
 					continue;
 				else if(seat[i][j].getPassenger_Name().equalsIgnoreCase(name))
 				{
 					seat[i][j].setPassenger_gender("neutral");
 					int amount=seat[i][j].getticket_amt();
 					seat[i][j].setticket_amt(amount-count*275);
 					can_acse=can_acse+1;
 					System.out.println("Your ticket for "+name+" is cancelled");
 					count++;
 				}
 			}
 		}
    	 //non ac seater
    	 for(int i=0;i<4;i++)
 		{
 			for(int j=0;j<3;j++)
 			{
 				if(seat_Non[i][j].getPassenger_sex().equals("neutral"))
 					continue;
 				else if(seat_Non[i][j].getPassenger_Name().equalsIgnoreCase(name))
 				{
 					seat_Non[i][j].setPassenger_gender("neutral");
 					int amount=seat_Non[i][j].getticket_amt();
 					seat_Non[i][j].setticket_amt(amount-count*112);
 					can_nacse=can_nacse+1;
 					System.out.println("Your ticket for "+name+" is cancelled");
 					count++;
 				}
 			}
 		}
    	 //ac-sleeper
    	 for(int i=0;i<3;i++)
			{
				for(int j=0;j<2;j++)
				{
					if(upper[i][j].getPassenger_sex().equals("neutral"))
						continue;
					else if(upper[i][j].getPassenger_Name().equalsIgnoreCase(name))
					{
						upper[i][j].setPassenger_gender("neutral");
						int amount=upper[i][j].getticket_amt();
	 					upper[i][j].setticket_amt(amount-count*350);
	 					can_acsl=can_acsl+1;
	 					System.out.println("Your ticket for "+name+" is cancelled");
	 					count++;
						
					}
				}
			}
    	 for(int i=0;i<3;i++)
			{
				for(int j=0;j<2;j++)
				{
						
					if(lower[i][j].getPassenger_sex().equals("neutral"))
						continue;
					else if(lower[i][j].getPassenger_Name().equalsIgnoreCase(name))
					{
						lower[i][j].setPassenger_gender("neutral");
						lower[i][j].setPassengerID("not");
						int amount=lower[i][j].getticket_amt();
	 					lower[i][j].setticket_amt(amount-count*350);
	 					can_acsl=can_acsl+1;
	 					System.out.println("Your ticket for "+name+" is cancelled");
	 					count++;
					}
				}
			}
    	 //non ac sleeper
    	 for(int i=0;i<3;i++)
			{
				for(int j=0;j<2;j++)
				{
					if(upper_nac[i][j].getPassenger_sex().equals("neutral"))
					continue;
				else if(upper_nac[i][j].getPassenger_Name().equalsIgnoreCase(name))
				{
					upper_nac[i][j].setPassenger_gender("neutral");
					upper_nac[i][j].setPassengerID("not");
					int amount=upper_nac[i][j].getticket_amt();
 					upper_nac[i][j].setticket_amt(amount-count*150);
 					can_nacsl=can_nacsl+1;
 					System.out.println("Your ticket for "+name+" is cancelled");
 					count++;
				}
				}
			}
    	 for(int i=0;i<3;i++)
			{
				for(int j=0;j<2;j++)
				{
						
				if(lower_nac[i][j].getPassenger_sex().equals("neutral"))
					continue;
				else if(lower_nac[i][j].getPassenger_Name().equalsIgnoreCase(name));
				{
					lower_nac[i][j].setPassenger_gender("neutral");
					lower_nac[i][j].setPassengerID("not");
					int amount=lower_nac[i][j].getticket_amt();
 					lower_nac[i][j].setticket_amt(amount-count*150);
 					can_nacsl=can_nacsl+1;
 					System.out.println("Your ticket for "+name+" is cancelled");
 					count++;
 					
				  }
				}
			}
 		}
 	 			else
 	 	 		{
 	 	 			System.out.println("Name not matched");
 	 	 		}
 		   counting_cancel.replace(id,counting-no);
 	    }
 	    }
 	    else
 	    {
 	    	System.out.println("You canceling count is higher than booked");
 	    }
     }
     public boolean check(String arr)
     {
    	 boolean flag=false;
    	 char []c = arr.toCharArray();
 		for(int i=0;i<arr.length();i++)
 		{
 			if(Character.isDigit(c[i]))
 			{
 				flag=false;
 				continue;
 			}
 			else
 			{
 				System.out.println("Enter correct input");
 				flag=true;
 				break;
 			}
 		}
 		return flag;
     }
     public void order_filter()
     {	 int count=0;
    	//ac sleeper
     for(int i=0;i<3;i++)
		{
			for(int j=0;j<2;j++)
			{
				if(upper[i][j].getPassenger_sex().equals("neutral"))
					count=count+1;
					
				if(lower[i][j].getPassenger_sex().equals("neutral"))
					count=count+1;
			}
		}
	 map.put("1.AC sleeper",count);
	 // ac seater
	 count=0;
	 for(int i=0;i<4;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(seat[i][j].getPassenger_sex().equals("neutral"))
					count++;
			}
		}
	 map.put("2.AC seater",count);
	 //non ac sleeper
	 count=0;
	 for(int i=0;i<3;i++)
		{
			for(int j=0;j<2;j++)
			{
				if(upper_nac[i][j].getPassenger_sex().equals("neutral"))
				count++;
			    if(lower_nac[i][j].getPassenger_sex().equals("neutral"))
			    count++;
			}
		}
	 map.put("3.non AC Sleeper",count);
     // Non ac seater
	
	 count=0;
	 for(int i=0;i<4;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(seat_Non[i][j].getPassenger_sex().equals("neutral"))
					count++;
			}
		}
	 map.put("4.non AC seater",count);
     }
//     public void sortbykey()
//     {
//         // TreeMap to store values of HashMap
//         TreeMap<String, Integer> sorted = new TreeMap<>(map);
//         // Display the TreeMap which is naturally sorted
//         sorted=sortByValue(sorted);
//         for (Map.Entry<String, Integer> entry :
//              sorted.entrySet())
//         {
//        	 if(entry.getKey()!=null)
//        	 {
//             System.out.print(entry.getKey()+"-"+ entry.getValue()+"Seats");
//        	 System.out.println();
//        	 }
//         }
//         System.out.println("5.All");
//        
//     }
   
     
//    	 public static TreeMap<String, Integer> sortByValue(Map<String, Integer> map2)
//    	    {
//    	        List<Map.Entry<String, Integer> > list =new LinkedList<Map.Entry<String, Integer> >(map2.entrySet());
//    	        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
//    	            public int compare(Map.Entry<String, Integer> o1,Map.Entry<String, Integer> o2)
//    	            {
//    	                return (o2.getValue()).compareTo(o1.getValue());
//    	            }
//    	        }
//    	        );
//    	        TreeMap<String, Integer> temp = new TreeMap<String, Integer>();
//    	        for (Map.Entry<String, Integer> aa : list) 
//    	        {
//    	            temp.put(aa.getKey(), aa.getValue());
//    	        }
//    	        return temp;
//    	    }
//    	 public static HashMap<String, Integer> sortBykey(Map<String, Integer> map2)
// 	    {
// 	        List<Map.Entry<String, Integer> > list =new LinkedList<Map.Entry<String, Integer> >(map2.entrySet());
// 	        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
// 	            public int compare(Map.Entry<String, Integer> o1,Map.Entry<String, Integer> o2)
// 	            {
// 	                return (o2.getKey()).compareTo(o1.getKey());
// 	            }
// 	        }
// 	        );
// 	        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
// 	        for (Map.Entry<String, Integer> aa : list) 
// 	        {
// 	            temp.put(aa.getKey(), aa.getValue());
// 	        }
// 	        return temp;
// 	    }
     public void sortByValue(Map<String, Integer> map2){
    	 ArrayList<String> a=new ArrayList<String>();
    	 for(Map.Entry<String, Integer> i:map2.entrySet()) {
    		 a.add(i.getKey());
    	 }
    	 Collections.sort(a);
    	 int n=a.size();
    	 while(true) {
    		 boolean f=true;
    		 for(int i=1;i<n;i++) {
    			 if(map2.get(a.get(i))> map2.get(a.get(i-1))) {
    				 String temp=a.get(i);
    				 a.set(i,a.get(i-1));
    				 a.set(i-1, temp);
    				 f=false;
    			 }
    			 
    		 }
    		 if(f) {
				 break;
			 }
			 n--;
    	 }
    	for(String i:a) {
    		System.out.println(i+" "+map2.get(i));
    	}
     }
     
}
//    	 public void sorting()
//    	 {
//    		 map = map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,LinkedHashMap::new));	 
//    	 }
//    	 public void sort()
//    	 {
//    		 int[] available = new int[4];
//    		 available[0]=map.get("1.AC sleeper");
//    		 available[1]=map.get("2.AC seater");
//    		 available[2]=map.get("3.non AC Sleeper");
//    		 available[3]=map.get("4.non AC seater");
//    		 Arrays.sort(available);
//    		 Iterator <String> it=map.keySet().iterator();
//    		 ArrayList<String[]> ava = new ArrayList<>();
//    		 while(it.hasNext())
//    		 {
//    		      String []pair = new String[2];
//    		      pair[0]=it.next();
//    		      pair[1]=map.get(pair[0])+"";
//    		      ava.add(pair);
//    	     }
//    		 for(int i=0;i<3;i++)
//    		 {
//    			 for(int j=0;j<i+1;j++)
//    			 {
//    				 if(Integer.valueOf(ava.get(i)[1])<Integer.valueOf(ava.get(j)[1]))
//    				 {
//    					 String[]temp= ava.get(i);
//    					 ava.set(i, ava.get(j));
//    					 ava.set(j, temp);
//    					 
//    				 }
//    			 }
//    		 }
//    		 for(int i=0;i<4;i++)
//    		 {
//    			 System.out.println(ava.get(i)[0]+" : "+ava.get(i)[1]);
//    		 }
//    		 
//    	 }
//    	 
     
