package view;

import controller.Output_Controller;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Program{

	private JFrame mainFrame;
	private Container mainPane;

	private QueryView query;
	private InputView input;
	private ResultView result;
	
	private Statement statePanel;
	private Execution exePanel;
	private Result resPanel;

	private Color white = new Color(255, 255, 255);
	private Color brown = new Color(72, 36, 10);

	public int activeQuery = 1;
	public String activeInput = "";

	public Program()
	{
		mainFrame = new JFrame("ADVANDB MCO1");
		mainFrame.setSize(980, 660);
		mainPane = mainFrame.getContentPane();
		mainPane.setLayout(null);
		mainPane.setBackground(new Color(90, 52, 40));
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		query = new QueryView(mainFrame);
		input = new InputView(mainFrame);
		result = new ResultView(mainFrame);
		
		statePanel = new Statement(mainFrame);
		exePanel = new Execution(mainFrame);
		resPanel = new Result(mainFrame);
		
		mainPane.add(query.getQueryPanel());
		mainPane.add(input.getInputPanel());
		mainPane.add(result.getResultPanel());
		mainPane.add(statePanel.getStatementPanel());
		mainPane.add(exePanel.getExecutionPanel());
		mainPane.add(resPanel.getResultPanel());
		
		makeActionListener();
		makeInputActions();
		setStart();

		mainFrame.setResizable(false);
		mainFrame.setVisible(true);

	}
	
	public void setStart()
	{
		statePanel.getStatementPanel().setVisible(false);
		exePanel.getExecutionPanel().setVisible(false);
		resPanel.getResultPanel().setVisible(false);
	}

	public void makeInputActions(){
		ArrayList<JButton> inputButtons = input.getInputButtons();
		for(int i = 0; i < inputButtons.size(); i++){
			inputButtons.get(i).addActionListener(new input_button_action(inputButtons.get(i).getText().toString()));
		}
	}
	
	public void makeActionListener()
	{
		result.getStatement().addActionListener(new query_button_action());
		result.getExecution().addActionListener(new query_button_action());
		result.getResult().addActionListener(new query_button_action());

		ArrayList<JButton> queryButtons = query.getQueryButtons();
		for(int i = 0; i < queryButtons.size(); i++){
			queryButtons.get(i).addActionListener(new active_query_button_action(i+1));
		}
	}

	class active_query_button_action implements ActionListener
	{
		public int activeQ;
		public active_query_button_action(int queryID){
			this.activeQ = queryID;
		}

		@Override
		public void actionPerformed(ActionEvent e){
			activeQuery = activeQ;
			input.updateInputPanel(activeQ);
			makeInputActions();
		}
	}

	class input_button_action implements  ActionListener
	{
		public String activeI;
		public input_button_action(String input){
			activeI = input;
		}

		@Override
		public void actionPerformed(ActionEvent e){
			activeInput = activeI;
			Output_Controller output_controller = new Output_Controller();
			model.Result activeResult = output_controller.generate_output(activeQuery, activeInput);
			exePanel.updateExecution(activeResult);
		}
	}
	
	
	class query_button_action implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource().equals(result.getStatement()))
			{
				statePanel.getStatementPanel().setVisible(true);
				exePanel.getExecutionPanel().setVisible(false);
				resPanel.getResultPanel().setVisible(false);
				
				result.setActiveTab('s');
				
			}
				
			else if(e.getSource().equals(result.getExecution()))
			{
				statePanel.getStatementPanel().setVisible(false);
				exePanel.getExecutionPanel().setVisible(true);
				resPanel.getResultPanel().setVisible(false);
				
				result.setActiveTab('e');
				
			}
				
			else if(e.getSource().equals(result.getResult()))
			{
				statePanel.getStatementPanel().setVisible(false);
				exePanel.getExecutionPanel().setVisible(false);
				resPanel.getResultPanel().setVisible(true);
				
				result.setActiveTab('r');
				
			}
			
		}
		
	}
}