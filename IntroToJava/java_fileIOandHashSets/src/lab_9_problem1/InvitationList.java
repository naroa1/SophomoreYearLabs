package lab_9_problem1;
import java.util.HashSet;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InvitationList {
	public static void main(String[] args)
	{
		Scanner inputStream=null; //initializing the stream
		String fileName="test.txt";
		
		try //opening up the file
		{
			inputStream=new Scanner(new File(fileName));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error opening file "+fileName+"!");
			System.exit(0);
		}
		
		HashSet<String> invitedPersons=new HashSet<String>(); //initializing the hashset
		
		while(inputStream.hasNextLine()) //this loop interates through the entire file
		{
			invitedPersons.add(inputStream.nextLine()); //storing each input into the hashset
		}
		
		int size=0; //initializing the size variable
		size=invitedPersons.size();
		System.out.println("The invitation list contains:");
		System.out.println("-----------------------------");
		Object[] names=invitedPersons.toArray(); //spitting out the elements in the hashset to an array for cleaner printing
		for(int i=0;i<size;i++) //printing out the array
			System.out.println(names[i]);

		inputStream.close();
	}
}
