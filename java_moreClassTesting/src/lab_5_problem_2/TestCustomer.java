package lab_5_problem_2;
import java.util.Scanner;

public class TestCustomer {
	public static void main(String[] args)
	{
		//testing out the constructors
		Customer firstCustomer=new Customer();
		Customer secondCustomer=new Customer("Bruce Wayne","Wayne Manor","1-800-NOT-BATS","totallynotbatman@gotham.gov","5/5/1940");
		Customer thirdCustomer=new Customer("Clark Kent","Metropolis","1-800-SUPAMAN","6/18/1938");
		Customer fourthCustomer=new Customer("Peter Parker","New York City","1-800-SPIDERS","parkerp@esu.edu","8/25/1962","10/16/2014");
		
		Scanner keyboard=new Scanner(System.in);
		//testing out accessors
		System.out.println("The first customer's ID is: "+firstCustomer.getID());
		System.out.println("The first customer's name is: "+firstCustomer.getName());
		System.out.println("The first customer's address is: "+firstCustomer.getAddress());
		System.out.println("The first customer's phone number is: "+firstCustomer.getPhone());
		System.out.println("The first customer's email address is: "+firstCustomer.getEmail());
		System.out.println("The first customer's start date was: "+firstCustomer.getStart());
		System.out.println("The first customer's end date is: "+firstCustomer.getEnd());
		
		//testing out mutators
		System.out.println("What do you want to change the fourth customer's name to? ");
		fourthCustomer.setName(keyboard.nextLine());
		System.out.println("What do you want to change the fourth customer's address to? ");
		fourthCustomer.setAddress(keyboard.nextLine());
		System.out.println("What do you want to change the fourth customer's phone number to? ");
		fourthCustomer.setPhone(keyboard.nextLine());
		System.out.println("What do you want to change the fourth customer's email address to? ");
		fourthCustomer.setEmail(keyboard.nextLine());
		System.out.println("What do you want to change the fourth customer's start date to? ");
		fourthCustomer.setStart(keyboard.nextLine());
		System.out.println("What do you want to change the fourth customer's end date to? ");
		fourthCustomer.setEnd(keyboard.nextLine());
		
		//testing out sendMsg
		System.out.println("Please write an email for "+secondCustomer.getName()+": ");
		secondCustomer.sendMsg(keyboard.nextLine());
		
		keyboard.close();
	}
}
