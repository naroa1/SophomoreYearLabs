package pet;

public class Pet {
	private int age;
	private double weight;
	private String name;
	
	public Pet(String initialName, int initialAge, double initialWeight)
	{
		name=initialName;
		if((initialAge<0)||(initialWeight<0))
			System.out.println("ERROR: Negative age or weight.");
		else
		{
			age=initialAge;
			weight=initialWeight;
		}
	}
	public void setPet(String newName, int newAge, double newWeight)
	{
		name=newName;
		if((newAge<0)||(newWeight<0))
			System.out.println("ERROR: Negative age or weight.");
		else
		{
			age=newAge;
			weight=newWeight;
		}
	}
	public Pet(String initialName)
	{
		name=initialName;
		age=0;
		weight=0;
	}
	public void setName(String newName)
	{
		name=newName;
	}
	public Pet(int initialAge)
	{
		if(initialAge<0)
			System.out.println("ERROR: Negative age");
		else
			age=initialAge;
		name="No name yet";
		weight=0;
	}
	public void setAge(int newAge)
	{
		age=newAge;
	}
	public Pet(double initialWeight)
	{
		if(initialWeight<0)
			System.out.println("ERROR: Negative weight");
		else
			weight=initialWeight;
		name="No name yet";
		age=0;
	}
	public void setWeight(double newWeight)
	{
		weight=newWeight;
	}
	public Pet()
	{
		age=0;
		weight=0;
		name="No name yet";
	}
	
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public double getWeight()
	{
		return weight;
	}
	
	public void writeOutput()
	{
		System.out.println("Name: "+name);
		System.out.println("Age: "+age+" years");
		System.out.println("Weight: "+weight+" pounds");
	}
}
