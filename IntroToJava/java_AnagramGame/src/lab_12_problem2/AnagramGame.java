package lab_12_problem2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


@SuppressWarnings("serial") //just cleaning up an unneccesary warning
public class AnagramGame extends JFrame implements ActionListener{

	public static final int WIDTH=400;
	public static final int HEIGHT=100;
	
	private JTextArea textField; //where the user will enter the guess
	private JLabel updater; //where the program will inform the user of their current status
	private JLabel puzzle; //where the anagram will be displayed
	private String guess="Enter guess here"; //initializing the guess extractor
	private int i=0; //iterator
	private int guesses=0; //guess count
	
	private String[][] words={{"anagram","racecar","method","internet","blackboard","wentworth","massachusetts","table","toothbrush","dictionary"},{"gramana","rcacera","dohtem","nitetern","cabbalkrod","rewnthwot","casatssmtuseh","bleta","botthursho","ticraydnio"}};
	//the above is the two dimensional array that contains all of the answers and puzzles
	
	public AnagramGame()
	{
		setSize(WIDTH,HEIGHT);
		addWindowListener(new WindowDestroyer());
		setTitle("Anagram Game");
		Container contentPane=getContentPane();
		contentPane.setLayout(new BorderLayout());
		JPanel buttonPanel=new JPanel();
		buttonPanel.setLayout(new BorderLayout());
		
		JButton checkButton=new JButton("Check"); //creating the buttons for the program
		checkButton.addActionListener(this);
		checkButton.setPreferredSize(new Dimension(175,25)); //setting dimensions for the button to have a uniform size
		buttonPanel.add(checkButton,BorderLayout.WEST);
		JButton answerButton=new JButton("Give up");
		answerButton.addActionListener(this);
		answerButton.setPreferredSize(new Dimension(175,25)); //setting dimensions for the button to have a uniform size
		buttonPanel.add(answerButton,BorderLayout.EAST);
		
		contentPane.add(buttonPanel,BorderLayout.NORTH); //adding the buttons to the window
		
		JPanel textPanel=new JPanel(); //creating the area for the user to guess with
		textField=new JTextArea(1,15);
		textField.setText(guess);
		textPanel.add(textField);
		contentPane.add(textPanel,BorderLayout.EAST); //adding the interaction field to the window
		puzzle=new JLabel(words[1][i]); 
		contentPane.add(puzzle,BorderLayout.WEST); //displaying the first puzzle
		updater=new JLabel();
		contentPane.add(updater,BorderLayout.SOUTH); //initializing the area for updates
	}
	
	public void actionPerformed(ActionEvent e) {
		String actionCommand=e.getActionCommand();
		if(actionCommand.equals("Check")) //user is guessing
		{
			guess=textField.getText();
			if(guess.equals(words[0][i])) //user guessed right
			{
				updater.setText("That is correct. Here's a new word to try!");
				i++; //advancing the iterator to allow passage to the next puzzle
				if(i<10)
					puzzle.setText(words[1][i]); //putting up the next puzzle
				else
					updater.setText("Congrats! You completed all the puzzles!");
				guesses=0;
			}
			else //user guessed wrong
			{
				guesses++;
				updater.setText("Guess "+guesses+": Sorry, that is incorrect. Please try again.");
			}
		}
		else if(actionCommand.equals("Give up")) //user gave up, display answer
		{
			updater.setText("Giving up already? All right, fine. The answer was: "+words[0][i]);
			i++;
			puzzle.setText(words[1][i]);
		}
	}
	
	public static void main(String[] args)
	{
		AnagramGame gui=new AnagramGame();
		gui.setVisible(true);
	}
}
