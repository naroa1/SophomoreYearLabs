package lab_1;
import java.util.Scanner;

public class Lab {
	public static void main(String[] args)
	{
		int problem=0;					//this value is used to determine which problem the program will solve in this instance
		int quarters=0,dimes=0,nickels=0,pennies=0;		//these values will be used for problems 1 and 2 as the coin quantities
		double value=0;		//this value will be used for problems 1 and 2 as the cash value
		String date;
		String trash;
		String[] temp;
		
		
		System.out.println("Please select a desired function:\n\n1. Input quantity and type of coins and return cash value");
		System.out.println("\n2. Input cash value and return quantity and type of coins");
		System.out.println("\n3. Input a date in US format and return EU format");
		Scanner keyboard=new Scanner(System.in);
		problem=keyboard.nextInt();
		
		switch(problem)
		{
		case 1:
			System.out.println("Enter number of quarters: ");
			quarters=keyboard.nextInt();
			System.out.println("Enter number of dimes: ");
			dimes=keyboard.nextInt();
			System.out.println("Enter number of nickels: ");
			nickels=keyboard.nextInt();
			System.out.println("Enter number of pennies: ");
			pennies=keyboard.nextInt();
			value=(.25*(int)quarters)+(.1*(int)dimes)+(.05*(int)nickels)+(.01*(int)pennies); //calculates cash value of the entered quantities of coins
			System.out.println("The cash value of these coins is: $"+value);
			break;
			
		case 2:
			System.out.println("Enter cash value: ");
			value=keyboard.nextDouble();
			value=(double)value*100; //this was implemented to counteract a strange rounding error that was happening with decimals, so no there are no decimals with any cash value but the computation will still be accurate
				while(value>24) //increases quantity of quarters in the solution and adjusts the cash value for further computation.
				{
					quarters=quarters+1;
					value=(double)value-25;
				}
				while(value>9) //increases quantity of dimes in the solution and adjusts the cash value for further computation
				{
					dimes=dimes+1;
					value=(double)value-10;
				}
				while(value>4) //increases quantity of nickels in the solution and adjusts the cash value for further computation
				{
					nickels=nickels+1;
					value=(double)value-5;
				}
				while(value>0) //increases quantity of pennies in the solution and adjusts the cash value for further computation
				{
					pennies=pennies+1;
					value=(double)value-1;
				}
			System.out.println("The least number of coins needed to fill this cash value is:");
			System.out.println("\tQuarters: "+quarters+"  Dimes: "+dimes+"  Nickels: "+nickels+"  Pennies: "+pennies);
			break;
			
		case 3:
			System.out.println("Enter US formatted date(MM/DD/YY): ");
			trash=keyboard.nextLine(); //takes in the extra garbage before data is collected
			date=keyboard.nextLine();
			temp=date.split("/"); //splits the original date by the forward slash into indexes in array of strings temp
			System.out.println("Here is the EU formatted date: ");
			System.out.println(temp[1]+"/"+temp[0]+"/"+temp[2]); //creates a EU formatted date
			break;
		}
		keyboard.close(); //closes out keyboard input for safety measures
	}
}
