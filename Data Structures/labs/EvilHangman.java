package labs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/**
 * In Evil Hangman, the computer maintains a list of every word in the
 * English language, then continuously pares down the word list to try
 * to dodge the player's guesses as much as possible.
 *
 * Details here:
 * http://nifty.stanford.edu/2011/schwarz-evil-hangman/Evil_Hangman.pdf
 */
public class EvilHangman extends Hangman {
	private HashMap<Integer,ArrayList<String>> dictionary=new HashMap<Integer,ArrayList<String>>();
	private ArrayList<String> possibleWords=new ArrayList<String>(); //this will be used to keep a defined list of all possible solutions
	private int wordLength;
	
	EvilHangman() throws FileNotFoundException {
		super();
		File file = new File("resources/dictionary.txt");
		FileReader reader = new FileReader(file);
		Scanner scanner = new Scanner(reader);
		// TODO: build up a data structure here
		
		//okay, we're throwing the dictionary into a HashMap of ArrayLists because that seems to make the most sense to me for the task!
		while(scanner.hasNextLine()){
			String currentWord=scanner.nextLine();
			if(dictionary.get(currentWord.length())==null)
			{
				dictionary.put(currentWord.length(),new ArrayList<String>());
				dictionary.get(currentWord.length()).add(currentWord);
			}
			else
				dictionary.get(currentWord.length()).add(currentWord);
		}
				
			//System.out.println(scanner.nextLine());
		scanner.close();
		}
		
	// TODO: extend existing methods to be evil
	
	//change up for setWord, getWord, and makeGuess. Those are the only 3 methods related to EvilHangman, afaik
	//visible should work fine because i choose one word randomly from the family that fits the bill :)
	
	public void setWord(){ //should be done :D
		//set the word to some random word of random length
		Random rand=new Random();
		wordLength=rand.nextInt(6);
		possibleWords.addAll(dictionary.get(wordLength)); //assembling all of the potential words
		word=possibleWords.get(0); //arbitrarily setting the word as the first word in the collection
	}
	
	public void getWord(String word){ //should be done :D
		//choose from one of the words in the set we're working with :)
		Random rand=new Random();
		int aggravation=rand.nextInt(); //more randomness just to annoy the user(and apparently the developer)
		word=possibleWords.get(aggravation);
	}
	
	public boolean makeGuess(char letter){
		if (this.guesses.contains(letter)) {
			return false;
		}
		guesses.add(letter);
		
		HashMap<Integer,HashSet<String>> family=new HashMap<Integer,HashSet<String>>();
		 //we're storing each family of possibilities in their own HashSet(since order doesn't matter)
		 //and we're keeping track of the different families within the HashMap
		
		int matchCounter=0; //counts the number of times the guessed letter matches a letter in a word
		boolean[] letterMatchPattern=new boolean[possibleWords.get(0).length()]; //will be used to check to see where matches are in each word
		HashMap<Integer,boolean[]> matchPatterns=new HashMap<Integer,boolean[]>();//tracks the matchpattern for each family
		
		for(int i=0;i<possibleWords.size();i++){ //checks to see how many letter matches we have in each word!
			if(!possibleWords.get(i).contains(""+letter)){  //if the letter is not in the word
				matchCounter=0;
				if(family.get(matchCounter)==null){ //checking to see if we need to initialize the hashset
					family.put(matchCounter,new HashSet<String>()); //initializing the hashset
					family.get(matchCounter).add(possibleWords.get(i)); //all zero matches go together!
				}
				else
					family.get(matchCounter).add(possibleWords.get(i)); //all zero matches go together!
			}
			else{
				for(int j=0;j<possibleWords.get(i).length();j++){
					if(letter==possibleWords.get(i).charAt(j)) //checks each position for a match
					{
						matchCounter++;
						letterMatchPattern[j]=true;
					}
					else{
						letterMatchPattern[j]=false;
					}
				}
				
				if(family.get(matchCounter)==null) //checks to see if the family has been initialized yet
				{
					matchPatterns.put(matchCounter, letterMatchPattern); //this will be used to check future words to see if it belongs in this family
					family.put(matchCounter,new HashSet<String>()); //initializes the family
					family.get(matchCounter).add(possibleWords.get(i)); //adding the word to the family
				}
				else{
					for(int k=0;k<=family.size();k++){ //checking to see if there are any families we can fit into
						//if(letterMatchPattern.equals(matchPatterns.get(k))){ //checks to see if family pattern matches
						if(Arrays.equals(letterMatchPattern,matchPatterns.get(k))){
							family.get(matchCounter).add(possibleWords.get(i)); //adding to the family!
							break;
						}
						if(k==family.size()){ //if we reach the end of the array and it hasn't found a home, we give it a new one!
							k++;
							matchPatterns.put(k,letterMatchPattern); //used to check future words
							family.put(k,new HashSet<String>()); //initializes the family
							family.get(matchCounter).add(possibleWords.get(i)); //adding to the family
						}
					}
				}
			}
			matchCounter=0; //resetting match count for next run-through
			//Arrays.fill(letterMatchPattern, false); //resetting letterMatchPattern for next word
		}
		
		// At this point, all families should be constructed! Perhaps not in a pretty order, but they're constructed! ;D
		
		int biggestFamily=1;
		
		for(int l=2;l<family.size();l++){
			if(family.get(l).size()>family.get(biggestFamily).size()){ //checks to see how big the family is!
				biggestFamily=l; //sets the biggest family placeholder to the new biggest family!
			}
		}
		
		//now, we should have the biggest family! it has been so long since I've worked on this, I don't even remember where to go from here.
		possibleWords.clear();;
		possibleWords.addAll(family.get(biggestFamily)); //this should set the possible words to the biggest family
		return true;
		
		
	}
}
