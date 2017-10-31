package view;

import oracle.jvm.hotspot.jfr.JFR;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class ResultView
{
	private JPanel resultPanel;
	private JPanel displayPanel;
	private JButton statement;
	private JButton execution;
	private JButton result;
	
	private Color orange = new Color(238, 131, 1);
	private Color pink = new Color(242, 37,144);
	private Color brown = new Color(72, 36, 10);
	private Color lightbrown = new Color(156, 135, 110);
	private Color white = new Color(255, 255, 255);
	
	private Font header = new Font("Montserrat", Font.BOLD, 12);

	private JFrame basisFrame;

	public ResultView(JFrame basisFrame)
	{
		this.basisFrame = basisFrame;
		setResultPanel();
		setButtons();

		collect();
	}

	public void collect()
	{
		resultPanel.add(statement);
		resultPanel.add(execution);
		resultPanel.add(result);
		
	}

	public void setResultPanel()
	{
		resultPanel = new JPanel(null);
		resultPanel.setBounds(basisFrame.getWidth() / 5 * 2, 0, basisFrame.getWidth() - basisFrame.getWidth() / 5 * 2, 50);
		resultPanel.setBackground(brown);
	}

	public void setButtons()
	{
		statement = new JButton("SQL STATEMENT");
		execution = new JButton("EXECUTION TIME");
		result = new JButton("RESULT TABLE");

		statement.setBounds(-2,-3,basisFrame.getWidth() / 5, 50);
		statement.setBackground(brown);
		statement.setForeground(new Color(255,255,255));
		statement.setBorderPainted(false);
		statement.setVisible(true);
		statement.setFont(header);

		execution.setBounds(-2 + basisFrame.getWidth() / 5,0,basisFrame.getWidth() / 5, 50);
		execution.setBackground(brown);
		execution.setForeground(new Color(255,255,255));
		execution.setBorderPainted(false);
		execution.setVisible(true);
		execution.setFont(header);

		result.setBounds(-2 + basisFrame.getWidth() / 5 * 2,0,basisFrame.getWidth() / 5, 50);
		result.setBackground(brown);
		result.setForeground(new Color(255,255,255));
		result.setBorderPainted(false);
		result.setVisible(true);
		result.setFont(header);

	}
	
	public void setActiveTab(char command)
	{
		if(command == 's')
		{
			statement.setBackground(brown);
			execution.setBackground(lightbrown);
			result.setBackground(lightbrown);
		}
		
		else if(command == 'e')
		{
			statement.setBackground(lightbrown);
			execution.setBackground(brown);
			result.setBackground(lightbrown);
		}
		
		else if(command == 'r')
		{
			statement.setBackground(lightbrown);
			execution.setBackground(lightbrown);
			result.setBackground(brown);
		}
	}

	public JPanel getResultPanel()
	{
		return resultPanel;
	}

	public JButton getStatement()
	{
		return statement;
	}

	public JButton getExecution()
	{
		return execution;
	}

	public JButton getResult()
	{
		return result;
	}
}