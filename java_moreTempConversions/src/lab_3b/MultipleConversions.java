package lab_3b;
import java.util.Scanner;

public class MultipleConversions {
	public static void main(String[] args)
	{
		int temperature;
		int celciustruth; //used as a placeholder to see if the unit is celcius
		int farenheittruth; //used as a placeholder to see if the unit is farenheit
		String quit; //used to allow user to quit out of the second case's loop
		String input;
		String trash; //standard garbage collection
		
		Scanner keyboard=new Scanner(System.in);
		do{
			System.out.println("Please enter the temperature value: ");
			temperature=keyboard.nextInt();
			System.out.println("Please enter the letter for the unit: ");
			trash=keyboard.nextLine();
			input=keyboard.nextLine();
			celciustruth=input.compareToIgnoreCase("c"); //comparing to see if unit is celcius
			farenheittruth=input.compareToIgnoreCase("F"); //comparing to see if unit is farenheit
			if(celciustruth==0)
			{
				//Celcius conversions
				temperature=((9*temperature)/5)+32;
				System.out.println("The temperature in Farenheit is: "+temperature+" degrees.");
			}
			else if(farenheittruth==0)
			{
				//farenheit conversions
				temperature=5*(temperature-32)/9;
				System.out.println("The temperature in Celcius is: "+temperature+" degrees.");
			}
			else
			{
				System.out.println("You have entered an invalid unit. Conversion cannot be completed.");
			}
			System.out.println("Enter Q or q to quit, or anything else to do more conversions: ");
			quit=keyboard.nextLine();
		}while(quit.compareToIgnoreCase("Q")!=0); //quits the program if anything besides Q or q is entered
	}
}
