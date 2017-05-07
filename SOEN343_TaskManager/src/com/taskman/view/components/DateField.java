package com.taskman.view.components;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class DateField extends JPanel
{
	//attributes
	private JComboBox daySelector;
	private JComboBox monthSelector;
	private JComboBox yearSelector;
	
	public static final int MAX_DAYS_OF_MONTH =31;
	public static final int MAX_MONTHS_OF_YEAR =12;
	//From 2010 to 2060 or 10 to 60
	public static final int MAX_YEARS_IN_CALENDAR =50;
	
	
	public DateField()
	{	
		//Call superclass JPanel();
		super();
		
		//Initialize Components
		this.daySelector = new JComboBox();
		this.monthSelector = new JComboBox();
		this.yearSelector = new JComboBox();
		
		//Create their fields
		this.makeDaySelector();
		this.makeDateSelector();
		this.makeYearSelector();
		
		//Add them to the panel
		this.AddComponents();
		
	}
	
	private void AddComponents()
	{
		this.add(this.daySelector);
		this.add(this.monthSelector);
		this.add(this.yearSelector);
	}

	
	private void makeDaySelector()
	{
		for (int i=0; i<DateField.MAX_DAYS_OF_MONTH;i++)
		{
			this.daySelector.addItem(Integer.toString(i+1));
		}
	}
	
	private void makeDateSelector()
	{
		for (int i=0; i<DateField.MAX_MONTHS_OF_YEAR;i++)
		{
			this.monthSelector.addItem(Integer.toString(i+1));
		}
	}
	
	private void makeYearSelector()
	{
		for (int i=9; i<DateField.MAX_YEARS_IN_CALENDAR;i++)
		{
			;
			this.yearSelector.addItem(Integer.toString(i+1));
		}
	}
	
	public JComboBox getDaySelector()
	{
		return this.daySelector;
	}
	
	public JComboBox getMonthSelector()
	{
		return this.monthSelector;
	}
	
	public JComboBox getYearSelector()
	{
		return this.yearSelector;
	}
	

	
}
