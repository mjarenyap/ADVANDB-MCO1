package view;

import controller.Statement_Controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.*;

public class Statement
{
	private JPanel statementPanel;
	private JPanel miniStatePanel;
	private JViewport viewPort;

	private JLabel without;
	private JLabel wOne;
	private JLabel wTwo;
	private JLabel iOne;
	private JLabel iTwo;
	private JLabel temporary;
	
	private JTextArea queryWO;
	private JTextArea queryW1;
	private JTextArea queryW2;
	private JTextArea queryI1;
	private JTextArea queryI2;
	private JTextArea queryTemp;
	
	private JScrollPane statementScroll;
	
	private Color orange = new Color(238, 131, 1);
	private Color pink = new Color(242, 37,144);
	private Color brown = new Color(72, 36, 10);
	private Color lightbrown = new Color(156, 135, 110);
	private Color white = new Color(255, 255, 255);
	
	private Font header = new Font("Montserrat", Font.BOLD, 10);
	private Font head = new Font("Montserrat", Font.BOLD, 12);
	private Font sub = new Font("Montserrat", Font.PLAIN, 10);

	private JFrame basisFrame;

	public Statement(JFrame basisFrame)
	{
		this.basisFrame = basisFrame;
		setStatementPanel();
		setStatementScrollPane();
		setQueries(8);
		collect();
	}
	
	public void collect()
	{
		miniStatePanel.add(without);
		miniStatePanel.add(wOne);
		miniStatePanel.add(wTwo);
		miniStatePanel.add(iOne);
		miniStatePanel.add(iTwo);
		miniStatePanel.add(temporary);
		miniStatePanel.add(queryWO);
		miniStatePanel.add(queryW1);
		miniStatePanel.add(queryW2);
		miniStatePanel.add(queryI1);
		miniStatePanel.add(queryI2);
		miniStatePanel.add(queryTemp);
		
		//statementPanel.add(miniStatePanel);
		statementPanel.add(statementScroll);
	}

	public void updateStatements(int queryID){
		miniStatePanel.removeAll();
		miniStatePanel.revalidate();
		miniStatePanel.repaint();

		setQueries(queryID);
		collect();
	}

	public void setStatementPanel()
	{
		statementPanel = new JPanel(null);
		statementPanel.setBounds(basisFrame.getWidth() - basisFrame.getWidth() / 5 * 3, 50,
				basisFrame.getWidth() - basisFrame.getWidth() / 5 * 2, basisFrame.getHeight() - 50);
		statementPanel.setBackground(lightbrown);
		
		miniStatePanel = new JPanel(null);
		miniStatePanel.setBounds(0, 0, 890, 1000);
		miniStatePanel.setBackground(white);
	}
	
	public void setHeads(int m1, int m2, int m3, int m4, int m5, int m6)
	{
		without = new JLabel("NORMAL QUERY");
		wOne = new JLabel("USING 1 INDEX");
		wTwo = new JLabel("USING 2 INDEXES");
		iOne = new JLabel("USING 1 VIEW");
		iTwo = new JLabel("USING 2 VIEWS");
		temporary = new JLabel("USING TEMPORARY TABLE");

		int offset = 50;
		int perLineHeight = 5;
		
		without.setBounds(35, -20, 400, 150);
		without.setForeground(brown);
		without.setFont(head);

		offset += 10;
		
		wOne.setBounds(35, m1 * perLineHeight + offset, 400, 150);
		wOne.setForeground(brown);
		wOne.setFont(head);

		offset += 10;
		
		wTwo.setBounds(35, m2 * perLineHeight + offset, 400, 150);
		wTwo.setForeground(brown);
		wTwo.setFont(head);

		offset += 10;
		
		iOne.setBounds(35, m3 * perLineHeight + offset, 400, 150);
		iOne.setForeground(brown);
		iOne.setFont(head);

		offset += 10;
		
		iTwo.setBounds(35, m4 * perLineHeight + offset, 400, 150);
		iTwo.setForeground(brown);
		iTwo.setFont(head);

		offset += 10;
		
		temporary.setBounds(35, m5 * perLineHeight + offset, 400, 150);
		temporary.setForeground(brown);
		temporary.setFont(head);
	}
	
	public void setQueries(int queryID)
	{
		Statement_Controller statement_controller = new Statement_Controller();

		ArrayList<String> normalQuery = statement_controller.getStatement(queryID, 1);
		ArrayList<String> oneIndex = statement_controller.getStatement(queryID, 2);
		ArrayList<String> twoIndexes = statement_controller.getStatement(queryID, 3);
		ArrayList<String> oneView = statement_controller.getStatement(queryID, 4);
		ArrayList<String> twoViews = statement_controller.getStatement(queryID, 5);
		ArrayList<String> tempTable = statement_controller.getStatement(queryID, 6);

		String m1, m2, m3, m4, m5, m6;
		m1 = "";
		m2 = "";
		m3 = "";
		m4 = "";
		m5 = "";
		m6 = "";

		for(int i = 0; i < normalQuery.size(); i++){
			m1 += normalQuery.get(i);
			m1 += "\n";
		}

		for(int i = 0; i < oneIndex.size(); i++){
			m2 += oneIndex.get(i);
			m2 += "\n";
		}

		for(int i = 0; i < twoIndexes.size(); i++){
			m3 += twoIndexes.get(i);
			m3 += "\n";
		}

		for(int i = 0; i < oneView.size(); i++){
			m4 += oneView.get(i);
			m4 += "\n";
		}

		for(int i = 0; i < twoViews.size(); i++){
			m5 += twoViews.get(i);
			m5 += "\n";
		}

		for(int i = 0; i < tempTable.size(); i++){
			m6 += tempTable.get(i);
			m6 += "\n";
		}

		queryWO = new JTextArea();
		queryW1 = new JTextArea();
		queryW2 = new JTextArea();
		queryI1 = new JTextArea();
		queryI2 = new JTextArea();
		queryTemp = new JTextArea();

		int offset = 60;
		int perLineHeight = 5;
		
		queryWO.setBounds(35, 80, statementScroll.getWidth() - 70, 150);
		queryWO.setBackground(white);
		queryWO.setText(m1);
		queryWO.setFont(sub);
		queryWO.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		queryWO.setEditable(false);
		queryWO.setLineWrap(true);
		queryWO.setWrapStyleWord(true);

		offset += 30;
		
		queryW1.setBounds(35, normalQuery.size() * perLineHeight + offset, statementScroll.getWidth() - 70, 150);
		queryW1.setBackground(white);
		queryW1.setText(m2);
		queryW1.setFont(sub);
		queryW1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		queryW1.setEditable(false);
		queryW1.setLineWrap(true);
		queryW1.setWrapStyleWord(true);

		offset += 30;
		
		queryW2.setBounds(35, oneIndex.size() * perLineHeight + offset, statementScroll.getWidth() - 70, 150);
		queryW2.setBackground(white);
		queryW2.setText(m3);
		queryW2.setFont(sub);
		queryW2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		queryW2.setEditable(false);
		queryW2.setLineWrap(true);
		queryW2.setWrapStyleWord(true);

		offset += 30;
		
		queryI1.setBounds(35, twoIndexes.size() * perLineHeight + offset, statementScroll.getWidth() - 70, 150);
		queryI1.setBackground(white);
		queryI1.setText(m4);
		queryI1.setFont(sub);
		queryI1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		queryI1.setEditable(false);
		queryI1.setLineWrap(true);
		queryI1.setWrapStyleWord(true);

		offset += 30;
		
		queryI2.setBounds(35, oneView.size() * perLineHeight + offset, statementScroll.getWidth() - 70, 150);
		queryI2.setBackground(white);
		queryI2.setText(m5);
		queryI2.setFont(sub);
		queryI2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		queryI2.setEditable(false);
		queryI2.setLineWrap(true);
		queryI2.setWrapStyleWord(true);

		offset += 30;
		
		queryTemp.setBounds(35, twoViews.size() * perLineHeight + offset, statementScroll.getWidth() - 70, 150);
		queryTemp.setBackground(white);
		queryTemp.setText(m6);
		queryTemp.setFont(sub);
		queryTemp.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		queryTemp.setEditable(false);
		queryTemp.setLineWrap(true);
		queryTemp.setWrapStyleWord(true);

		setHeads(normalQuery.size(), oneIndex.size(), twoIndexes.size(), oneView.size(), twoViews.size(), tempTable.size());
		
	}
	
	public void setStatementScrollPane()
	{
		viewPort = new JViewport();
		statementScroll = new JScrollPane(miniStatePanel);
		statementScroll.setBounds(0, 0, 890, 690);
		miniStatePanel.setPreferredSize(new Dimension(890, 2000));
		statementScroll.getViewport().setBackground(white);
		statementScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    	statementScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    	statementScroll.getVerticalScrollBar().setUnitIncrement(10);
		statementScroll.setVisible(true);
	}
	
	public JViewport getViewport()
	{
		return viewPort;
	}
	
	
	public JPanel getStatementPanel()
	{
		return statementPanel;
	}
}