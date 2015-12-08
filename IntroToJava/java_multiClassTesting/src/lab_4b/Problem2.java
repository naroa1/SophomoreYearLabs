package lab_4b;

public class Problem2 {
	public static void main(String[] args)
	{
		//testing the mutator methods in setting up each dog
		
		Dog firstDog=new Dog();
		firstDog.setName("Shadow Friend");
		firstDog.setBreed("Ozkavosh");
		firstDog.setAge(25);
		firstDog.writeOutput();
		
		Dog secondDog=new Dog();
		secondDog.setName("Banehello");
		secondDog.setBreed("Lycanrope");
		secondDog.setAge(16);
		secondDog.writeOutput();
		
		Dog thirdDog=new Dog();
		thirdDog.setName("Shadow Friend");
		thirdDog.setBreed("Ozkavosh");
		thirdDog.setAge(25);
		thirdDog.writeOutput();
		
		
		//testing equality and accessor methods at the same time
		
		System.out.println("Testing equality of "+secondDog.getName()+" and "+firstDog.getName()+".");
		
		if(secondDog.equals(firstDog))
			System.out.println("These dogs are the same! They are both "+secondDog.getBreed()+", "+secondDog.getAge()+" dog-years old and"+firstDog.getAgeInHumanYears()+" years old!");
		else
			System.out.println("These are two very different dogs!");
		System.out.println("\n\nTesting equality of "+thirdDog.getName()+" and "+firstDog.getName()+".");
		if(thirdDog.equals(firstDog))
			System.out.println("These dogs are the same! They are both "+thirdDog.getBreed()+", "+thirdDog.getAge()+" dog-years old and "+firstDog.getAgeInHumanYears()+" years old!");
		else
			System.out.println("These are two very different dogs!");
	}
}
