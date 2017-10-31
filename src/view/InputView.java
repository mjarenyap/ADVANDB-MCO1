package view;

import controller.Input_Controller;
import controller.Query_Controller;
import oracle.jvm.hotspot.jfr.JFR;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class InputView
{
	private JPanel inputPanel;
	private JPanel miniInputPanel;
	private JTextField inputTextField;
	
	private ArrayList<JButton> inputButtons;
	private ArrayList<String> inputStrings;
	
	private JScrollPane inputScroll;

	private Color orange = new Color(238, 131, 1);
	private Color pink = new Color(242, 37,144);
	private Color brown = new Color(72, 36, 10);
	private Color lightbrown = new Color(156, 135, 110);
	private Color white = new Color(255, 255, 255);
	
	private Font header = new Font("Montserrat", Font.BOLD, 12);
	private Font butt = new Font("Montserrat", Font.PLAIN, 12);
	
	private int countData = 0;
	private JFrame basisFrame;

	public InputView(JFrame basisFrame)
	{
		this.basisFrame = basisFrame;

		setInputPanel();
		setInputTextField();
		setInputScrollPane();
		setInputButtons(1);

		collect();

	}

	public void collect()
	{
		inputPanel.add(inputTextField);
		inputPanel.add(inputScroll);
		
		for(int i = 0; i < inputButtons.size(); i++)
		{
			miniInputPanel.add(inputButtons.get(i));
		}
	}

	public void setInputPanel()
	{
		inputPanel = new JPanel(null);
		inputPanel.setBounds(basisFrame.getWidth() / 5, 0, basisFrame.getWidth() / 5, basisFrame.getHeight());
		inputPanel.setBackground(orange);
		
		miniInputPanel = new JPanel(null);
		miniInputPanel.setBounds(322, 0, 290, 1000);
		miniInputPanel.setBackground(lightbrown);
	}

	public void setInputTextField(){
		inputTextField = new JTextField("SELECT AN INPUT");
		inputTextField.setBounds(-3, -4, inputPanel.getWidth() + 6, 57);
		inputTextField.setForeground(white);
		inputTextField.setBackground(pink);
		inputTextField.setFont(header);
		inputTextField.setEditable(false);
		inputTextField.setHorizontalAlignment(JTextField.CENTER);
	}

	public void setInputScrollPane()
	{
		inputScroll = new JScrollPane(miniInputPanel);
		inputScroll.setBounds(-3, inputTextField.getHeight() - 7, inputPanel.getWidth() + 19, inputPanel.getHeight() - inputTextField.getHeight());
		miniInputPanel.setPreferredSize(new Dimension(320, 1200));
		inputScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    	inputScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    	inputScroll.getVerticalScrollBar().setUnitIncrement(16);
		inputScroll.setVisible(true);
	}
	
	public void updateInputPanel(int queryID)
	{
		miniInputPanel.removeAll();
		miniInputPanel.revalidate();
		miniInputPanel.repaint();

		setInputButtons(queryID);
		collect();
	}
	
	public void setInputButtons(int queryID)
	{
		int offset = 0;

		Input_Controller input_controller = new Input_Controller();
		ArrayList<String> inputs = input_controller.getInputs(queryID);

		inputButtons = new ArrayList<>();

		for(int i = 0; i < inputs.size(); i++){
			inputButtons.add(new JButton(inputs.get(i)));
			inputButtons.get(i).setBounds(0, 0 + offset, inputPanel.getWidth(), 130);
			inputButtons.get(i).setFont(butt);
			inputButtons.get(i).setHorizontalAlignment(JTextField.CENTER);
			inputButtons.get(i).setBorderPainted(true);
			inputButtons.get(i).setBorder(new LineBorder(brown));
			inputButtons.get(i).setForeground(white);
			inputButtons.get(i).setBackground(lightbrown);
			inputButtons.get(i).setMargin(new Insets(1, 1, 1, 1));
			offset += 130;

			miniInputPanel.setPreferredSize(new Dimension(inputPanel.getWidth(), offset));
		}

		/*
		int n = 0;
		
		for(int i = 0; i < inputButtons.size(); i++)
		{
			inputButtons.get(i).setText(inputStrings.get(i));
			inputButtons.get(i).setBounds(0, 0 + n, 280, 110);
			inputButtons.get(i).setBackground(orange);
			inputButtons.get(i).setFont(butt);
			inputButtons.get(i).setForeground(white);
			
			n += 100;
			
		}*/
		
	}

	public JPanel getInputPanel()
	{
		return inputPanel;
	}

	public ArrayList<JButton> getInputButtons(){
		return inputButtons;
	}
	
}