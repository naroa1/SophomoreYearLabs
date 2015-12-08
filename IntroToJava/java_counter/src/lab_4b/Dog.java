package lab_4b;

public class Dog {
	private String name;
	private String breed;
	private int age;
	
	public void writeOutput()
	{
		System.out.println("Name: "+name);
		System.out.println("Breed: "+breed);
		System.out.println("Age in calendar years: "+age);
		System.out.println("Age in human years: "+getAgeInHumanYears());
		System.out.println(); 
	}
	public int getAgeInHumanYears()
	{
		int humanAge=0;
		if(age<=2)
			humanAge=age*11;
		else
			humanAge=22+((age-2)*5);
		return humanAge;
	}
	//mutator methods
	public void setName(String newName)
	{
		this.name=newName;
	}
	public void setBreed(String newBreed)
	{
		this.breed=newBreed;
	}
	public void setAge(int newAge)
	{
		this.age=newAge;
	}
	//accessor methods
	public String getName()
	{
		return this.name;
	}
	public String getBreed()
	{
		return this.breed;
	}
	public int getAge()
	{
		return this.age;
	}
	//equality-truth method
	public boolean equals(Dog otherDog)
	{
		return ((this.name==otherDog.name)&&(this.breed==otherDog.breed)&&(this.age==otherDog.age));
	}
	
}
