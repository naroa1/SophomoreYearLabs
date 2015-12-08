package lab_6_problem1;
import java.util.Scanner;
import java.util.ArrayList;

public class Company {
	private String name;
	private ArrayList<Customer> customers=new ArrayList<Customer>();
	private int customercount;
	Scanner keyboard=new Scanner(System.in);
	
	public Company()
	{
		System.out.println("What is the name of the company?");
		name=keyboard.nextLine();
	}
	public Company(String name)
	{
		this.name=name;
	}
	public void newCustomer()
	{
		customers.add(customercount,new Customer());
		customercount++;
	}
	public void endCustomer()
	{
		System.out.println("Which customer would you like to end?");
		int endNumber=keyboard.nextInt();
		String trash=keyboard.nextLine();
		System.out.println("What is the end date of the customer?");
		String endDate=keyboard.nextLine();
		customers.get(endNumber).setEnd(endDate);
	}
	public void sendBroadcast()
	{
		System.out.println("What message would you like to broadcast to all customers? ");
		String message=keyboard.nextLine();
		for(int i=0;i<customers.size();i++)
		{
			customers.get(i).sendMsg(message);
		}
	}
	
}
