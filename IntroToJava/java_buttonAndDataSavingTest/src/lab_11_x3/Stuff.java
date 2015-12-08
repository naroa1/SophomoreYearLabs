package lab_11_x3;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


@SuppressWarnings("serial")
public class Stuff extends JFrame implements ActionListener{
	public static final int WIDTH=600;
	public static final int HEIGHT=300;
	
	private JTextArea theText;
	private String memo1="No memo1";
	private String memo2="No memo2";
	
	public Stuff()
	{
		setSize(WIDTH,HEIGHT);
		setTitle("Memo Saver");
		Container contentPane=getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		JPanel buttonPanel=new JPanel();
		buttonPanel.setBackground(Color.WHITE);
		buttonPanel.setLayout(new FlowLayout());
		
		JButton memo1Button=new JButton("Save memo1");
		memo1Button.addActionListener(this);
		buttonPanel.add(memo1Button);
		
		JButton memo2Button=new JButton("Save memo2");
		memo2Button.addActionListener(this);
		buttonPanel.add(memo2Button);
		
		JButton clearButton=new JButton("Clear");
		clearButton.addActionListener(this);
		buttonPanel.add(clearButton);
		
		JButton get1Button=new JButton("Get Memo1");
		get1Button.addActionListener(this);
		buttonPanel.add(get1Button);
		
		JButton get2Button=new JButton("Get Memo2");
		get2Button.addActionListener(this);
		buttonPanel.add(get2Button);
		contentPane.add(buttonPanel,BorderLayout.SOUTH);
		
		JPanel textPanel=new JPanel();
		textPanel.setBackground(Color.BLUE);
		theText=new JTextArea(10,40);
		theText.setBackground(Color.WHITE);
		textPanel.add(theText);
		contentPane.add(textPanel,BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent e) {
		String actionCommand=e.getActionCommand();
		if(actionCommand.equals("Save memo1"))
			memo1=theText.getText();
		else if(actionCommand.equals("Save memo2"))
			memo2=theText.getText();
		else if(actionCommand.equals("Clear"))
			theText.setText("");
		else if(actionCommand.equals("Get Memo1"))
			theText.setText(memo1);
		else if(actionCommand.equals("Get Memo2"))
			theText.setText(memo2);
	}
	
	public static void main(String[] args)
	{
		Stuff guiMemo=new Stuff();
		guiMemo.setVisible(true);
	}
}
