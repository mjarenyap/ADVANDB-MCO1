package view;

import method.Method_Four;
import method.Method_One;
import method.Method_Three;
import method.Method_Two;
import model.Result;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class Execution
{
	private JPanel executionPanel;
	private JLabel norm;
	private JLabel view1;
	private JLabel view2;
	private JLabel index1;
	private JLabel index2;
	private JLabel temp;
	
	private JLabel normCount;
	private JLabel view1Count;
	private JLabel view2Count;
	private JLabel index1Count;
	private JLabel index2Count;
	private JLabel tempCount;
	
	private String c1 = "0.0000sec";
	private String c2 = "0.0000sec";
	private String c3 = "0.0000sec";
	private String c4 = "0.0000sec";
	private String c5 = "0.0000sec";
	private String c6 = "0.0000sec";
	
	private Color orange = new Color(238, 131, 1);
	private Color pink = new Color(242, 37,144);
	private Color brown = new Color(72, 36, 10);
	private Color lightbrown = new Color(156, 135, 110);
	private Color white = new Color(255, 255, 255);
	
	private Font head = new Font("Montserrat", Font.BOLD, 12);
	private Font sub = new Font("Montserrat", Font.PLAIN, 10);

	JFrame basisFrame;
	
	public Execution(JFrame basisFrame)
	{
		this.basisFrame = basisFrame;
		setExecutionPanel();
		setHeaders();
		setTimeCount();
		collect();
	}
	
	public void collect()
	{
		executionPanel.add(norm);
		executionPanel.add(index1);
		executionPanel.add(index2);
		executionPanel.add(view1);
		executionPanel.add(view2);
		executionPanel.add(temp);
		
		executionPanel.add(normCount);
		executionPanel.add(index1Count);
		executionPanel.add(index2Count);
		executionPanel.add(view1Count);
		executionPanel.add(view2Count);
		executionPanel.add(tempCount);
	}

	public void updateExecution(Result theResult){
		executionPanel.removeAll();
		executionPanel.revalidate();
		executionPanel.repaint();

		normCount.setText(theResult.getTimes().getNormal_query() + "sec");
		index1Count.setText(theResult.getTimes().getOne_index() + "sec");
		index2Count.setText(theResult.getTimes().getTwo_indexes() + "sec");
		view1Count.setText(theResult.getTimes().getOne_view() + "sec");
		view2Count.setText(theResult.getTimes().getTwo_views() + "sec");
		tempCount.setText(theResult.getTimes().getOne_temp_table() + "sec");

		collect();
	}

	public void setExecutionPanel()
	{
		executionPanel = new JPanel(null);
		executionPanel.setBounds(basisFrame.getWidth() - basisFrame.getWidth() / 5 * 3, 50,
				basisFrame.getWidth() - basisFrame.getWidth() / 5 * 2, basisFrame.getHeight() - 50);
		executionPanel.setBackground(white);
	}
	
	public void setHeaders()
	{
		norm = new JLabel("NORMAL QUERY");
		view1 = new JLabel("USING 1 VIEW");
		view2 = new JLabel("USING 2 VIEWS");
		index1 = new JLabel("USING 1 INDEX");
		index2 = new JLabel("USING 2 INDEXES");
		temp = new JLabel("1 TEMPORARY VIEW");
		
		norm.setBounds(35, 30, 250, 50);
		norm.setForeground(brown);
		norm.setFont(head);
		
		index1.setBounds(35, 190, 250, 50);
		index1.setForeground(brown);
		index1.setFont(head);
		
		index2.setBounds(35, 350, 250, 50);
		index2.setForeground(brown);
		index2.setFont(head);
		
		view1.setBounds(270, 30, 250, 50);
		view1.setForeground(brown);
		view1.setFont(head);
		
		view2.setBounds(270, 190, 250, 50);
		view2.setForeground(brown);
		view2.setFont(head);
		
		temp.setBounds(270, 350, 250, 50);
		temp.setForeground(brown);
		temp.setFont(head);
		
	}

	public void setTimeCount()
	{
		normCount = new JLabel("");
		view1Count = new JLabel("");
		view2Count = new JLabel("");
		index1Count = new JLabel("");
		index2Count = new JLabel("");
		tempCount = new JLabel("");
		
		normCount.setBounds(35, 70, 250, 50);
		normCount.setForeground(brown);
		normCount.setFont(sub);
		normCount.setText(c1);
		
		index1Count.setBounds(35, 230, 250, 50);
		index1Count.setForeground(brown);
		index1Count.setFont(sub);
		index1Count.setText(c2);
		
		index2Count.setBounds(35, 390, 250, 50);
		index2Count.setForeground(brown);
		index2Count.setFont(sub);
		index2Count.setText(c3);
		
		view1Count.setBounds(270, 70, 250, 50);
		view1Count.setForeground(brown);
		view1Count.setFont(sub);
		view1Count.setText(c4);
		
		view2Count.setBounds(270, 230, 250, 50);
		view2Count.setForeground(brown);
		view2Count.setFont(sub);
		view2Count.setText(c5);
		
		tempCount.setBounds(270, 390, 250, 50);
		tempCount.setForeground(brown);
		tempCount.setFont(sub);
		tempCount.setText(c6);
	}
	
	public JPanel getExecutionPanel() 
	{
		return executionPanel;
	}
	
}