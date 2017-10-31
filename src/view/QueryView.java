package view;

import controller.Query_Controller;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class QueryView
{
	
	private JPanel queryPanel;
	private JPanel miniQueryPanel;
	private JTextField queryTextField;
	
	private ArrayList<JButton> queryButtons;
	private ArrayList<String> queryStrings;
	
	private JScrollPane queryScroll;
	
	private Color orange = new Color(238, 131, 1);
	private Color pink = new Color(242, 37,144);
	private Color brown = new Color(72, 36, 10);
	private Color lightbrown = new Color(156, 135, 110);
	private Color white = new Color(255, 255, 255);

	private Font header = new Font("Montserrat", Font.BOLD, 12);
	private Font butt = new Font("Montserrat", Font.PLAIN, 12);
	
	private int panelSize = 0;
	private JFrame basisFrame;

	public QueryView(JFrame basisFrame){

		this.basisFrame = basisFrame;

		setQueryPanel();
		setQueryTextField();
		setQueryScrollPane();
		//addQueryButtons();
		setQueryButtons();
		collect();
	}

	public void collect()
	{
		queryPanel.add(queryTextField);
		queryPanel.add(queryScroll);
		
		for(int i = 0; i < queryButtons.size(); i++){
			miniQueryPanel.add(queryButtons.get(i));
		}
		
	}

	public void setQueryPanel()
	{
		queryPanel = new JPanel(null);
		queryPanel.setBounds(0, 0, basisFrame.getWidth() / 5, basisFrame.getHeight());
		queryPanel.setBackground(new Color(251, 173, 80));
		
		miniQueryPanel = new JPanel(null);
		miniQueryPanel.setBounds(0, 100, 320, 1200);
		miniQueryPanel.setBackground(lightbrown);
		
	}

	public void setQueryTextField()
	{
		queryTextField = new JTextField("CHOOSE A QUERY");
		queryTextField.setBounds(-3, -4, queryPanel.getWidth() + 6, 57);
		queryTextField.setForeground(white);
		queryTextField.setBackground(pink);
		queryTextField.setFont(header);
		queryTextField.setEditable(false);
		queryTextField.setHorizontalAlignment(JTextField.CENTER);
	}

	public void setQueryScrollPane()
	{
		queryScroll = new JScrollPane(miniQueryPanel);
		queryScroll.setBounds(-3, queryTextField.getHeight() - 7, queryPanel.getWidth() + 19, queryPanel.getHeight() - queryTextField.getHeight());
		miniQueryPanel.setPreferredSize(new Dimension(320, 1200));
		queryScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    	queryScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    	queryScroll.getVerticalScrollBar().setUnitIncrement(10);
		queryScroll.setVisible(true);
	}
	/*
	public void addQueryButtons()
	{
		queryButtons = new ArrayList<>();
		queryStrings = new ArrayList<>(); 
		int n = 1;
		
		for(int i = 0; i < 8; i++)
		{
			queryButtons.add(new JButton());
			queryStrings.add("Query " + n + ": I want to count the number of books published by a certain publisher.");
			n++;
		}
	}
	*/

	public void setQueryButtons()
	{
		int offset = 0;

		Query_Controller query_controller = new Query_Controller();
		ArrayList<String> queries = query_controller.getAllQueries();
		queryButtons = new ArrayList<>();

		for(int i = 0; i < queries.size(); i++){
			queryButtons.add(new JButton("<html><p style=\"padding: 30px 10px;\">" + queries.get(i).replaceAll("\\n", "<br/>") + "</p></html>"));
			queryButtons.get(i).setBounds(0, 0 + offset, queryPanel.getWidth(), 130);
			queryButtons.get(i).setFont(butt);
			queryButtons.get(i).setHorizontalAlignment(JTextField.CENTER);
			queryButtons.get(i).setBorderPainted(true);
			queryButtons.get(i).setBorder(new LineBorder(brown));
			queryButtons.get(i).setForeground(white);
			queryButtons.get(i).setBackground(lightbrown);
			queryButtons.get(i).setMargin(new Insets(1, 1, 1, 1));
			offset += 130;

			miniQueryPanel.setPreferredSize(new Dimension(queryPanel.getWidth(), offset));
		}
	}
	
	public JPanel getQueryPanel()
	{
		return queryPanel;
	}

	public ArrayList<JButton> getQueryButtons(){
		return queryButtons;
	}
}