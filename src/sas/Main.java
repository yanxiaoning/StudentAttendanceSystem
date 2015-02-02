package sas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Main {
	public static void main(String[] args)
	{
	
		File file = new File("res");
		if(!file.exists())
			file.mkdir();
		
		if(file.listFiles().length == 0)
		{
			System.out.println("making..");
			CourseManager cm = new CourseManager();
			StudentManager sm = new StudentManager();
			sm.initialize();
			cm.initialize();
		}
		else
			System.out.println("existed");
		
		
		
		MyFrame f=new MyFrame();
		f.establish();
		
		//System.out.println((new CourseManager()).getRateList("101"));
		
		
	}

}
