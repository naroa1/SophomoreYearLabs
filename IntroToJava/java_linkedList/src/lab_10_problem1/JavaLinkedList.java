package lab_10_problem1;
import java.util.LinkedList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JavaLinkedList {
	public static void main(String[] args)
	{
		LinkedList<String> dishes=new LinkedList<String>(); //initializing the LinkedList
		Scanner inputStream=null; //initializing the inputStream
		String fileName="list.txt";
		
		try //opening up the file
		{
			inputStream=new Scanner(new File(fileName));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error opening file "+fileName+"!");
			System.exit(0);
		}
		
		while(inputStream.hasNextLine()) //filling the LinkedList with the contents in the text
			dishes.add(inputStream.nextLine());
		
		System.out.println("Current item list:");
		System.out.println("-------------------------");
		for(String element:dishes) //printing out the LinkedList
		{
			System.out.println(element);
		}
		System.out.println("-------------------------\n");
		System.out.println("Adding an item to the front of the list and one to the back of the list...\n");
		dishes.push("Wild Rice Pilad");
		dishes.add("Green Bean Lasagna");
		System.out.println("Current item list:");
		System.out.println("-------------------------");
		for(String element:dishes) //printing out the LinkedList
		{
			System.out.println(element);
		}
		System.out.println("-------------------------\n");
		System.out.println("Deleting 'Bread' from the list...\n");
		dishes.remove("Bread");
		System.out.println("Current item list:");
		System.out.println("-------------------------");
		for(String element:dishes) //printing out the LinkedList
		{
			System.out.println(element);
		}
		System.out.println("-------------------------\n");
		
		inputStream.close();
	}
}
