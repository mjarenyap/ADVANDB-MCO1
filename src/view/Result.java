package view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.*;

public class Result
{
	private JPanel resultPanel;
	private JPanel miniResultPanel;
	
	private JViewport viewPort;
	private JScrollPane resultScroll;
	
	private Color orange = new Color(238, 131, 1);
	private Color pink = new Color(242, 37,144);
	private Color brown = new Color(72, 36, 10);
	private Color lightbrown = new Color(156, 135, 110);
	private Color white = new Color(255, 255, 255);
	
	private JTextField[] columns = new JTextField[7];
	private JFrame basisFrame;

	public Result(JFrame basisFrame)
	{
		this.basisFrame = basisFrame;
		setResultPanel();
		addColumnPanels();
		setColumnPanels();
		setResultScrollPane();
		collect();
	}

	public void collect()
	{
		for(int i = 0; i < columns.length; i++)
		{
			miniResultPanel.add(columns[i]);
		}
		
		resultPanel.add(resultScroll);
		
	}

	public void setResultPanel()
	{
		resultPanel = new JPanel(null);
		resultPanel.setBounds(basisFrame.getWidth() - basisFrame.getWidth() / 5 * 3, 50,
				basisFrame.getWidth() - basisFrame.getWidth() / 5 * 2, basisFrame.getHeight() - 50);
		resultPanel.setBackground(white);
		
		miniResultPanel = new JPanel(null);
		miniResultPanel.setBounds(604, 100, 890, 1500);
		miniResultPanel.setBackground(lightbrown);
	}
	
	public void setResultScrollPane()
	{
		viewPort = new JViewport();
		resultScroll = new JScrollPane(miniResultPanel);
		resultScroll.setBounds(0, 0, 890, 690);
		miniResultPanel.setPreferredSize(new Dimension(890, 1000));
		resultScroll.getViewport().setBackground(white);
		resultScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		resultScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		resultScroll.getVerticalScrollBar().setUnitIncrement(10);
		resultScroll.setVisible(true);
	}
	
	public void addColumnPanels()
	{
		for(int i = 0; i < 7; i++)
		{
			columns[i] = new JTextField("");
		}
	}
	
	public void setColumnPanels()
	{
		int n = 0;
		
		for(int i = 0; i < columns.length; i++)
		{
			columns[i].setBounds(0 + n, 0, 127, 1000);
			columns[i].setBackground(white);
			
			n += 127;
		}
		
	}
	

	public JPanel getResultPanel()
	{
		return resultPanel;
	}
}