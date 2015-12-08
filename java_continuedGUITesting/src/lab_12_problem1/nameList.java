package lab_12_problem1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial") //just cleaning up an unneccesary warning
public class nameList extends JFrame implements ActionListener{
	public static final int WIDTH=355;
	public static final int HEIGHT=245;
	
	private JTextArea text; //used to take in the text from the user
	private JTextArea textcopy; //used to copy the text taken from the user and display it on screen
	private int i=0; //used to allow for proper display in the textDisplay
	private String names; //storing the names
	
	public nameList()
	{
		setSize(WIDTH,HEIGHT);
		addWindowListener(new WindowDestroyer());
		setTitle("Create a list of names");
		Container contentPane=getContentPane();
		contentPane.setLayout(new BorderLayout());
		JPanel buttonPanel=new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		text=new JTextArea(1,20); //creating the buttonPanel part of the window, the text entry field is included in this panel for cleanliness' sake
		text.setText("");
		buttonPanel.add(text);
		JButton acceptButton=new JButton("Accept");
		acceptButton.addActionListener(this);
		buttonPanel.add(acceptButton);
		
		JPanel textDisplay=new JPanel(); //creating the default box the user sees
		textcopy=new JTextArea(10,30);
		textcopy.setText("No names!");
		textDisplay.add(textcopy);
		
		JScrollPane scrolledText=new JScrollPane(textcopy); //allowing the box to expand and have a scroll bar
		scrolledText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); //forcing no horizontal scroll bar
		scrolledText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); //the vertical scroll bar only appears when there's more than 10 lines in the textDisplay
		textDisplay.add(scrolledText); //putting the scroll function into the textDisplay
		contentPane.add(textDisplay,BorderLayout.NORTH);
		
		contentPane.add(buttonPanel,BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e) {
		String actionCommand=e.getActionCommand();
		
		if(actionCommand.equals("Accept"))
		{
			names=text.getText(); //extracting the name
			if(i==0) //runs only on the first iteration to get the basis started cleanly
				textcopy.setText(names);
			else //runs on every other iteration to add the name to a new line
			{
				textcopy.append("\n");
				textcopy.append(names);
			}
			i++;
			text.setText(""); //emptying the text entry field
		}
	}
	
	public static void main(String[] args)
	{
		nameList gui=new nameList();
		gui.setVisible(true);
	}
}
