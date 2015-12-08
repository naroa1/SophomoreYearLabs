package time;

public class Time {
	private int hour;
	private int minute;
	private boolean isAM;
	
	public Time(){
		hour=0;
		minute=0;
		isAM=false;
	}
	public Time(int hour,int minute){
		if(isValid(hour,minute))
		{
			this.hour=hour;
			this.minute=minute;
			this.isAM=false; //default choice
		}
		else
			System.out.println("Invalid time entered!");
	}
	public Time(int hour,int minute,boolean isAM){
		if(hour<13&&hour>0) //checks to make sure hour is between 1 and 12
		{
			if(isValid(hour,minute))
			{
				if(isAM==false) //if PM, converts time to 24hr
				{
					this.hour=hour+12;
					this.minute=minute;
				}
				else
				{
					this.hour=hour;
					this.minute=minute;
					this.isAM=true;
				}
			}
		}
		else
			System.out.println("Invalid time entered!");
	}
	private boolean isValid(int hour, int minute){ //checks to make sure the entries are valid
		return ((hour<24&&hour>-1)&&(minute<60&&minute>-1));
	}
	public void setTime(int hour, int minute){
		if(isValid(hour,minute))
		{
			this.hour=hour;
			this.minute=minute;
			this.isAM=false; //default AM state
		}
		else
			System.out.println("Invalid time entered!");
	}
	public void setTime(int hour, int minute, boolean isAM){
		if(hour<13&&hour>0)//checks to make sure hour is between 1 and 12
		{
			if(isValid(hour,minute))
			{
				if(isAM==false) //if PM, converts to 24hr
				{
					this.hour=hour+12;
					this.minute=minute;
				}
				else
				{
					this.hour=hour;
					this.minute=minute;
					this.isAM=true;
				}
			}
		}
		else
			System.out.println("Invalid time entered!");
	}
	public String getTime24(){
		String result="";
		if(minute>9&&hour>9) //no leading 0s in time
			result=result+hour+minute;
		else if(minute<=9&&hour<=9) //the following if statements allow the leading 0s to display correctly
			result=result+"0"+hour+"0"+minute;
		else if(minute<=9)
			result=result+hour+"0"+minute;
		else if(hour<=9)
			result=result+"0"+hour+minute;
		return result;
	}
	public String getTime12(){
		String result="";
		String meridien;
		if(isAM==true)
			meridien="AM";
		else //if isAM is false, it checks to see what time of day the entered hour is
		{
			if(hour<12)
				meridien="AM";
			else
				meridien="PM";
		}	
		if(hour<13) //prints out PM times
		{
			if(hour==0) //checks to see if it is midnight and handles printing from there
			{
				if(minute>9)
					result=result+(hour+12)+":"+minute+" "+meridien;
				else //handles leading zeroes
					result=result+(hour+12)+":0"+minute+" "+meridien;
			}
			else //handles other non-midnight prints
			{
				if(minute>9)
					result=result+hour+":"+minute+" "+meridien;
				else //handles leading zeroes
					result=result+hour+":0"+minute+" "+meridien;
			}
		}
		
		else //prints out AM times
		{
			if(minute>9)
				result=result+(hour-12)+":"+minute+" "+meridien;
			else //handles leading zeroes
				result=result+(hour-12)+":0"+minute+" "+meridien;
		}
		return result;
	}
	
	public static void main(String[] args){ //just testing
		System.out.println("Creating default time");
		Time time1=new Time();
		System.out.println(time1.getTime24());
		System.out.println("Setting time to 18,47");
		time1.setTime(18, 47);
		System.out.println(time1.getTime24());
		System.out.println("Trying to set to -1,5");
		time1.setTime(-1, 5);
		System.out.println(time1.getTime24());
		System.out.println("Trying to set to 7,-1");
		time1.setTime(7,-1);
		System.out.println(time1.getTime24());
		System.out.println("Trying to set to 24, 59");
		time1.setTime(24,59);
		System.out.println(time1.getTime24());
		System.out.println("Trying to set to 23,60");
		time1.setTime(23,60);
		System.out.println(time1.getTime24());
		System.out.println("Setting time to 6, 51, am");
		time1.setTime(6, 51,true);
		System.out.println(time1.getTime24());
		System.out.println("Setting time to 6, 51, pm");
		time1.setTime(6, 51,false);
		System.out.println(time1.getTime24());
		System.out.println("Trying to set to 0, 56, am");
		time1.setTime(0, 56,true);
		System.out.println(time1.getTime24());
		System.out.println("Setting time to 12, 56, pm");
		time1.setTime(12,56,false);
		System.out.println(time1.getTime24());
		
		System.out.println("Testing constructors!");
		System.out.println("Creating time 12, 2");
		Time time2=new Time(12,2);
		System.out.println(time2.getTime24()+" and "+time2.getTime12());
		System.out.println("Creating time 12, 2, pm");
		Time time3=new Time(12,2,false);
		System.out.println(time3.getTime24()+" and "+time3.getTime12());
		System.out.println("Creating time 0, 3");
		Time time4=new Time(0,3);
		System.out.println(time4.getTime24()+" and "+time4.getTime12());
		System.out.println("Creating time 12, 3, am");
		Time time5=new Time(12,3,true);
		System.out.println(time5.getTime24()+" and "+time5.getTime12());
		System.out.println("Creating time 9, 30");
		Time time6=new Time(9,30);
		System.out.println(time6.getTime24()+" and "+time6.getTime12());
		System.out.println("Creating time 9, 30, am");
		Time time7=new Time(9,30,true);
		System.out.println(time7.getTime24()+" and "+time7.getTime12());
		System.out.println("Creating time 21, 19");
		Time time8=new Time(21,19);
		System.out.println(time8.getTime24()+" and "+time8.getTime12());
		System.out.println("Creating time 9, 30, pm");
		Time time9=new Time(9,30,false);
		System.out.println(time9.getTime24()+" and "+time9.getTime12());
	}
}




