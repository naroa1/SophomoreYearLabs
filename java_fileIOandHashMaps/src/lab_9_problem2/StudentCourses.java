package lab_9_problem2;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;	
import java.lang.Integer;

public class StudentCourses {
	public static void main(String[] args)
	{
		Scanner inputStream=null; //initializing the inputstream
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
		
		HashMap<Integer, ArrayList<String>> students=new HashMap<Integer, ArrayList<String>>(); //initializing the hashmap
		int id=0; //will be used to store the id numbers for each student
		String course=new String(); //will be used to store the courses for each student
		String temp=new String(); //used to cut the string into two parts, ID and course
		String string=new String(); //used to extract the text from the file
		
		while(inputStream.hasNextLine())
		{
			string=inputStream.nextLine();
			temp=string.substring(0,2); //grabbing the ID number from the input
			temp=temp.trim(); //deleting extraneous spaces
			id=Integer.parseInt(temp); //translating the string to a integer
			course=string.substring(2); //grabbing the course from the input
			course=course.trim(); //deleting extraneous spaces
			if(id==-1)//breaks out of the loop if the ID number is -1
				break;
			if(students.get(id)==null) //activates if there is no entry with the student's ID number yet
			{
				students.put(id,new ArrayList<String>()); //gets the individual student initialized
				students.get(id).add(course); //drops the course number into the arraylist
			}
			else
				students.get(id).add(course); //drops the course number into the arraylist
		}
		
		int size=students.size(); //used to break out of the loop
		int i=0; //will be used to increment inside the following while loop
		System.out.println("All student data:");
		System.out.println("-----------------------------");
		while(size>0)
		{
			if(students.containsKey(i))
			{
				System.out.println("Student ID: "+i);
				System.out.println("Classes: ");
				Object[] classes=students.get(i).toArray(); //this and the following for-loop are for printing out the courses for each student more cleanly
				for(int j=0;j<classes.length;j++)
					System.out.println("  "+classes[j]);
				System.out.println();
				size--;
			}
			i++;
		}
		
		System.out.println("-----------------------------");
		System.out.println("End of program");
		inputStream.close();
	}
}
