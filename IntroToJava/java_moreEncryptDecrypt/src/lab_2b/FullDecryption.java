package lab_2b;
import java.util.Scanner;


public class FullDecryption {
	public static void main(String[] args)
	{
		int shift;	
		int length; //used to hold the length of the string
		char[] cipher; //used to encrypt/decrypt input string from user in problem 1
		String input;
		String output[]; //used to display all possible decrypts in problem 2
		output=new String[26];
		
		Scanner keyboard=new Scanner(System.in);
		
		System.out.println("Please enter the string to be decrypted: ");
		input=keyboard.nextLine();
		length=input.length();
		cipher=new char[length]; //initializing cipher array to the size of the input string
		
		for(shift=1;shift<26;shift++)
		{
			for(int x=0;x<length;x++)
			{
				cipher[x]=input.charAt(x);
				
					if(((cipher[x]>='A')&&(cipher[x]<='Z'))) //checks to see if it is an uppercase letter
					{
						if((cipher[x]+shift<='Z') && (cipher[x]+shift>='A')) //normal uppercase shift
							cipher[x]=(char) (cipher[x]+shift); 
						else
						{
							if(cipher[x]+shift>='Z')
								cipher[x]=(char) (cipher[x]-26+shift); //shifts uppercase to beginning of alphabet
						}
					}
					else if(((cipher[x]>='a')&&(cipher[x]<='z'))) //checks to see if it is a lowercase letter
					{
						if((cipher[x]+shift<='z') && (cipher[x]+shift>='a')) //normal lowercase shift
							cipher[x]=(char) (cipher[x]+shift); 
						else
						{
							if(cipher[x]+shift>='z')
								cipher[x]=(char) (cipher[x]-26+shift); //shifts lowercase to beginning of alphabet
						}
					}
			}
			output[shift]=new String (cipher);
		}
		shift=25;
		while(shift>0) //this loop prints out all of the possible shifts
		{
			System.out.println(output[shift]);
			shift--;
		}
		
		keyboard.close();
	}

}
