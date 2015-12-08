package lab_10_problem2;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GuiApplication extends JFrame{
	
	private static final int WIDTH=300;
	private static final int HEIGHT=200;
	private static final long serialVersionUID=129309301; //just a random serial to eliminate a warning
		
	public GuiApplication(String text,String label,Color bgcolor)
	{
		super();
		
		JFrame myWindow=new JFrame(label); //giving the window a title
		myWindow.setSize(WIDTH,HEIGHT); //setting initial size
		myWindow.getContentPane().setBackground(bgcolor); //coloring the background
		JLabel myLabel=new JLabel(text);
		myWindow.getContentPane().add(myLabel); //putting in the text

		myWindow.setVisible(true); //making the windows appear!
	}
	
	
	@SuppressWarnings("unused") //just taking out the unused variable warnings since they're superfluous
	public static void main(String[] args)
	{
		String firstMessage="Where is John?";
		String secondMessage="John is water skiing";
		String thirdMessage="John is good in skiing";
		GuiApplication window1=new GuiApplication(firstMessage,"MAGENTA",Color.MAGENTA);
		GuiApplication window2=new GuiApplication(secondMessage,"ORANGE",Color.ORANGE);
		GuiApplication window3=new GuiApplication(thirdMessage,"GREEN",Color.GREEN);
	}
}
