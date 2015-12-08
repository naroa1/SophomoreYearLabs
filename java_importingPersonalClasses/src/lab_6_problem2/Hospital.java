package lab_6_problem2;
import utils.Pet;
import java.util.Scanner;

public class Hospital {
	public static void main(String[] args)
	{
		Scanner keyboard=new Scanner(System.in);
		System.out.println("What is the name of the pet? ");
		String name=keyboard.nextLine();
		System.out.println("What is the breed of the pet? ");
		String breed=keyboard.nextLine();
		System.out.println("What is the age of the pet? ");
		int age=keyboard.nextInt();
		String trash=keyboard.nextLine();//just collecting garbage here to prevent contamination
		
		Pet firstPet=new Pet(name,age,breed);
		Pet secondPet=new Pet();
		
		System.out.println("What is the name of the pet? ");
		String name2=keyboard.nextLine();
		System.out.println("What is the breed of the pet? ");
		String breed2=keyboard.nextLine();
		System.out.println("What is the age of the pet? ");
		int age2=keyboard.nextInt();
		
		secondPet.setName(name2);
		secondPet.setAge(age2);
		secondPet.setBreed(breed2);
		
		System.out.println("The name of the first pet is: "+firstPet.getName());
		System.out.println("The age of the first pet is: "+firstPet.getAge());
		System.out.println("The breed of the first pet is: "+firstPet.getBreed());
		System.out.println("The name of the second pet is: "+secondPet.getName());
		System.out.println("The age of the second pet is: "+secondPet.getAge());
		System.out.println("The breed of the second pet is: "+secondPet.getBreed());
		keyboard.close();
	}
}
