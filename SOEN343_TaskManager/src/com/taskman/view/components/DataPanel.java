package com.taskman.view.components;

import java.awt.Dimension;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.taskman.objects.Task;

public class DataPanel extends JPanel
{
	//constants
	public static final int TOTAL_NR_OF_DATA_FIELDS = 6;
	
	
	//attributes
	private	JTextField	dataInputField;
	private JComboBox taskTypeSelector;
	private JComboBox taskFrequencySelector;
	private DateField dateField;
	private TButton taskDoneButton;
	
	public DataPanel()
	{	
		//Call the superclass constructor
		super();
		
		//Initialize components
		this.Initialize();
		
		//Add components to Panel
		this.add(this.dataInputField);
		this.add(this.taskTypeSelector);
		this.add(this.taskFrequencySelector);
		this.add(this.dateField);
		this.add(this.taskDoneButton);
		
	}

	private void Initialize() 
	{
		this.dataInputField = new JTextField();
		this.dataInputField.setPreferredSize(new Dimension(170,50));
		this.dataInputField.setText("Enter task name");
		
		this.taskTypeSelector = new JComboBox();
		this.taskTypeSelector.addItem(new String(Task.SINGLE_TASK));
		this.taskTypeSelector.addItem(new String(Task.PERIODIC_TASK));
		
		this.taskFrequencySelector = new JComboBox();
		this.taskFrequencySelector.addItem("...");
		this.taskFrequencySelector.addItem(Task.DAILY_TASK);
		this.taskFrequencySelector.addItem(Task.WEEKLY_TASK);
		this.taskFrequencySelector.addItem(Task.MONTHLY_TASK);
		this.taskFrequencySelector.addItem(Task.YEARLY_TASK);
		
		this.dateField = new DateField();
		
		this.taskDoneButton = new TButton("Set Done");
		
	}
	
	//Getter Methods
	public JTextField getDataInputField()
	{
		return this.dataInputField;
	}
	
	public JComboBox getTaskTypeSelector()
	{
		return this.taskTypeSelector;
	}
	
	public DateField getDateField()
	{
		return this.dateField;
	}
	
	public JComboBox getTaskFrequencySelector()
	{
		return this.taskFrequencySelector;
	}
	
	public TButton getTaskDoneButton()
	{
		return this.taskDoneButton;
	}
	
}
