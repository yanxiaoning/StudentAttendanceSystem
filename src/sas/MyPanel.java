package sas;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

public class MyPanel extends JFrame {
	private ArrayList<Integer> list;
	
	public MyPanel(ArrayList<Integer> list)
	{
		this.list = list;
		setTitle("Histogram");
	}
	
	@Override
	public void paint(Graphics g)
	{
		g.drawString("Apr.1", 70, 500);
		g.drawString("Apr.2", 150, 500);
		g.drawString("Apr.3", 230, 500);
		g.drawString("Apr.4", 310, 500);
		g.drawString("Apr.5", 390, 500);
		g.drawString("Apr.6", 470, 500);
		
		
		
		for(int i = 0;i < list.size();i++)
		{
			if(list.get(i) >= 0)
			{
				g.fillRect(70+80*i, 470 - list.get(i)*30, 35, list.get(i)*30);
		
			g.drawString(String.valueOf(list.get(i)), 83+80*i, 455 - list.get(i)*30);
			}
		}
		
		
	}
	

}
