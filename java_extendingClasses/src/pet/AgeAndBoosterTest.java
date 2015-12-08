package pet;

public class AgeAndBoosterTest {
	public static void main(String[] args)
	{
		Pet[] dog=new Pet[5];
		dog[0]=new Dog("Golden",false,"Lassie",67,20);
		dog[1]=new Dog("Labradoodle",false,"Ella",56.2,1);
		dog[2]=new Dog("Miniature Schnauzer",false,"Joey",12,13);
		dog[3]=new Dog("Scottish Terrier",true,"Buddy",10.5,6);
		dog[4]=new Dog("French Bulldog",false,"Target",17,2);
		
		for(int i=0;i<5;i++)
		{
			if(dog[i].getAge()>2&&((Dog) dog[i]).getBooster()==false)
			{
				System.out.println("Name: "+dog[i].getName());
				System.out.println("Breed: "+((Dog) dog[i]).getBreed()+"\n");
			}
		}
	}
}
