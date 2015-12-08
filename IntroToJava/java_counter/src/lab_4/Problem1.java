package lab_4;

public class Problem1 {
	public static void main(String[] args)
	{
		Counter number=new Counter();
		number.setToZero();
		number.displayCount();
		for(int i=0;i<10;i++)
		{
			number.increaseCount();
		}
		System.out.println("The count after 10 increments is: "+number.returnCount());
		for(int d=0;d<5;d++)
			number.decreaseCount();
		System.out.println("The count after 5 decrements is: "+number.returnCount());
		System.out.println("\n\nResetting the count for more testing...\n\n");
		number.setToZero();
		number.displayCount();
		for(int d=0;d<3;d++)
			number.decreaseCount();
		System.out.println("The count after 3 decrements is: "+number.returnCount());
		for(int i=0;i<13;i++)
			number.increaseCount();
		System.out.println("The count after 13 increments is: "+number.returnCount());
	}
}
