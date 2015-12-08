package lab_4;

public class Counter {
	public int count;
	
	public void setToZero()
	{
		count=0;
	}
	public void increaseCount()
	{
		count++;
	}
	public void decreaseCount()
	{
		if(count-1>0)
			count--;
	}
	public void displayCount()
	{
		System.out.println("Current count= "+count);
	}
	public int returnCount()
	{
		return count;
	}
}
