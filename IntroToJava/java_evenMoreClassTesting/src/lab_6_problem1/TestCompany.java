package lab_6_problem1;
import java.util.Scanner;

public class TestCompany {
	public static void main(String[] args)
	{
		Company testCompany1=new Company();
		testCompany1.newCustomer();
		testCompany1.newCustomer();
		testCompany1.endCustomer();
		testCompany1.sendBroadcast();
		
		Scanner keyboard=new Scanner(System.in);
		Company testCompany2=new Company(keyboard.nextLine());
		testCompany2.newCustomer();
		testCompany2.newCustomer();
		testCompany2.endCustomer();
		testCompany2.sendBroadcast();
		
		keyboard.close();
	}
}
