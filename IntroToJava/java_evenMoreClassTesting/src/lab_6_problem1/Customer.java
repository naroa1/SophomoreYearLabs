package lab_6_problem1;
import java.util.Scanner;

public class Customer {
	
	Scanner keyboard=new Scanner(System.in);
	private static int lastid=0;
	private int id;
	private String name;
	private String address;
	private String phone;
	private String email;
	private String beginDate;
	private String endDate;
	
	//constructors
	public Customer() //default constructor
	{
		incrementId();
		id=lastid;
		System.out.println("What is the name? ");
		name=keyboard.nextLine();
		System.out.println("What is the address? ");
		address=keyboard.nextLine();
		System.out.println("What is the phone number? ");
		phone=keyboard.nextLine();
		System.out.println("What is the email address? ");
		email=keyboard.nextLine();
		System.out.println("What is the start date?(MM/DD/YYYY) ");
		beginDate=keyboard.nextLine();
		System.out.println("What is the end date?(MM/DD/YYYY) ");
		endDate=keyboard.nextLine();
	}
	public Customer(String customername, String location, String number, String emailaddress, String start) //constructor that activates when there is no endDate
	{
		incrementId();
		name=customername;
		id=lastid;
		address=location;
		phone=number;
		email=emailaddress;
		beginDate=start;
		endDate="No end date set";
	}
	public Customer(String customername, String location, String number, String start) //constructor that activates when there is no email and no endDate
	{
		incrementId();
		name=customername;
		id=lastid;
		address=location;
		phone=number;
		email="No email address on file";
		beginDate=start;
		endDate="No end date set";
	}
	public Customer(String customername, String location, String number,String emailaddress,String start,String end) //constructor that activates when all information is given
	{
		incrementId();
		name=customername;
		id=lastid;
		address=location;
		phone=number;
		email=emailaddress;
		beginDate=start;
		endDate=end;
	}
	
	public void incrementId()//method used to increment the lastId every time a constructor is called
	{
		lastid++;
	}
	
	//accessors
	public int getID()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public String getAddress()
	{
		return address;
	}
	public String getPhone()
	{
		return phone;
	}
	public String getEmail()
	{
		return email;
	}
	public String getStart()
	{
		return beginDate;
	}
	public String getEnd()
	{
		return endDate;
	}
	
	//mutators
	public void setName(String change)
	{
		name=change;
	}
	public void setAddress(String change)
	{
		address=change;
	}
	public void setPhone(String change)
	{
		phone=change;
	}
	public void setEmail(String change)
	{
		email=change;
	}
	public void setStart(String change)
	{
		beginDate=change;
	}
	public void setEnd(String change)
	{
		endDate=change;
	}
	
	public void sendMsg(String message)
	{
		System.out.println("Sending an email to "+email+" with the message: "+message);
	}
}
