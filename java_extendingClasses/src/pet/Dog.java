package pet;

public class Dog extends Pet{
	private String breed;
	private boolean boosterShot;

	public Dog()
	{
		super();
		breed="No breed set";
		boosterShot=false;
	}
	public Dog(String breed)
	{
		super();
		this.breed=breed;
		boosterShot=false;
	}
	public Dog(String breed,String initialName)
	{
		super(initialName);
		this.breed=breed;
		boosterShot=false;
	}
	public Dog(String breed,double initialWeight)
	{
		super(initialWeight);
		this.breed=breed;
		boosterShot=false;
	}
	public Dog(String breed,int initialAge)
	{
		super(initialAge);
		this.breed=breed;
		boosterShot=false;
	}
	public Dog(String breed,String initialName,double initialWeight,int initialAge)
	{
		super(initialName,initialAge,initialWeight);
		this.breed=breed;
		boosterShot=false;
	}
	public Dog(boolean boosterShot)
	{
		super();
		this.boosterShot=boosterShot;
		breed="No breed set";
	}
	public Dog(boolean boosterShot,String initialName)
	{
		super(initialName);
		this.boosterShot=boosterShot;
		breed="No breed set";
	}
	public Dog(boolean boosterShot,double initialWeight)
	{
		super(initialWeight);
		this.boosterShot=boosterShot;
		breed="No breed set";
	}
	public Dog(boolean boosterShot,int initialAge)
	{
		super(initialAge);
		this.boosterShot=boosterShot;
		breed="No breed set";
	}
	public Dog(boolean boosterShot,String initialName, double initialWeight,int initialAge)
	{
		super(initialName,initialAge,initialWeight);
		this.boosterShot=boosterShot;
		breed="No breed set";
	}
	public Dog(String breed, boolean boosterShot)
	{
		super();
		this.breed=breed;
		this.boosterShot=boosterShot;
	}
	public Dog(String breed, boolean boosterShot,String initialName)
	{
		super(initialName);
		this.breed=breed;
		this.boosterShot=boosterShot;
	}
	public Dog(String breed, boolean boosterShot,double initialWeight)
	{
		super(initialWeight);
		this.breed=breed;
		this.boosterShot=boosterShot;
	}
	public Dog(String breed, boolean boosterShot,int initialAge)
	{
		super(initialAge);
		this.breed=breed;
		this.boosterShot=boosterShot;
	}
	public Dog(String breed, boolean boosterShot,String initialName, double initialWeight,int initialAge)
	{
		super(initialName,initialAge,initialWeight);
		this.breed=breed;
		this.boosterShot=boosterShot;
	}
	public void setBreed(String newBreed)
	{
		this.breed=newBreed;
	}
	public void setBooster(boolean newBooster)
	{
		this.boosterShot=newBooster;
	}
	public void setDog(String breed, boolean boosterShot, String newName, double newWeight,int newAge)
	{
		this.setPet(newName, newAge, newWeight);
		this.breed=breed;
		this.boosterShot=boosterShot;
	}
	public String getBreed()
	{
		return this.breed;
	}
	public boolean getBooster()
	{
		return this.boosterShot;
	}
	public void writeOutput()
	{
		System.out.println("Name: "+this.getName());
		System.out.println("Age: "+this.getAge()+" years");
		System.out.println("Weight: "+this.getWeight()+" pounds");
		System.out.println("Breed: "+breed);
		if(boosterShot==true)
			System.out.println("Booster shot?: Yes");
		else
			System.out.println("Booster shot?: No");
	}

	public static void main(String[] args)
	{
		Dog testDog0=new Dog();
		Dog testDog1=new Dog("Labradoodle");
		Dog testDog2=new Dog("Golden","Riley");
		Dog testDog3=new Dog("Husky",80.5);
		Dog testDog4=new Dog("Wolf",12);
		Dog testDog5=new Dog("Corgi","Steve",12.5,6);
		Dog testDog6=new Dog(true);
		Dog testDog7=new Dog(true,"Juanito");
		Dog testDog8=new Dog(false,50.7);
		Dog testDog9=new Dog(false,2);
		Dog testDog10=new Dog(true,"Lassie",67.2,30);
		Dog testDog11=new Dog("Husky",false);
		Dog testDog12=new Dog("Wolf",false,"Wolfie");
		Dog testDog13=new Dog("Corgi",true,13.7);
		Dog testDog14=new Dog("Golden",true,10);
		Dog testDog15=new Dog("Labradoodle",true,"Ella",56.2,2);
		Pet testPet=new Pet();
		
		testDog0.setBooster(true);
		testDog1.setBreed("Huey");
		testDog2.setName("Jake");
		testDog3.setWeight(13.37);
		testDog4.setAge(7);
		testDog5.setDog("Mikoto", true, "Misaka", 39.5, 4);
		testDog6.setPet("Harry", 7, 21.8);
		System.out.println(testDog7.getName());
		System.out.println(testDog8.getWeight());
		System.out.println(testDog9.getAge());
		System.out.println(testDog10.getBreed());
		System.out.println(testDog11.getBooster());
		System.out.println(testDog12.getWeight());
		System.out.println(testDog13.getAge());
		System.out.println(testDog14.getName());
		testPet.writeOutput();
		testDog15.writeOutput();
	}

}