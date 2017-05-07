package com.taskman.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.taskman.control.Controller;
import com.taskman.control.IObserver;
import com.taskman.control.ITaskListener;
import com.taskman.events.TaskEvent;
import com.taskman.model.ModelLocator;
import com.taskman.view.components.DataPanel;
import com.taskman.view.components.DateField;
import com.taskman.view.components.TButton;
import com.utils.TaskBuilderFactory;

public class ApplicationBaseUI extends JFrame implements ActionListener, ListSelectionListener, IObserver
{
	
	private static final long serialVersionUID = 1L;
	private static final int DESKTOP_PREFERRED_WIDTH = 800;
	private static final int DESKTOP_PREFERRED_HEIGHT = 600;

	// Instance attributes
	private	JPanel		topPanel;
	private	JList		listbox;
	@SuppressWarnings("unchecked")
	private	Vector		listData;
	private	TButton		addButton;
	private	TButton		removeButton;


	private	JScrollPane scrollPane;
	private DataPanel dataInputPanel;
	
	//Controller that listens to events happening in UI
	private ITaskListener controller;
	
	//ModelLocator that contains the array of Tasks
	private ModelLocator model;
	
	
	// Constructor of main frame
	public ApplicationBaseUI()
	{
		//Initialize Controller
		controller = new Controller();
		
		//Initialize data model
		model = ModelLocator.getInstance();
		
		//BIND the array source of the JList to the Model's array.
		listData = model.getTaskList();
		
		//Create the List
		CreateDataDisplayList();
		
		//Create the Entry Panel
		CreateDataEntryPanel();
	}
	
	public void CreateDataDisplayList()
	{
		// Set the frame characteristics
		setTitle( "Task Manager Alpha 1.0" );
		setSize( ApplicationBaseUI.DESKTOP_PREFERRED_WIDTH, ApplicationBaseUI.DESKTOP_PREFERRED_HEIGHT );
		setBackground( Color.gray );

		// Create a panel to hold all other components
		topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );

		// Create a new listbox control
		listbox = new JList( listData );
		
		// Add the listbox to a scrolling pane
		scrollPane = new JScrollPane();
		scrollPane.getViewport().add( listbox );
		topPanel.add( scrollPane, BorderLayout.CENTER );
		
		//Make this Application listen to list selection events thrown by the JList.
		listbox.addListSelectionListener( this );

		
	}
	

	public void CreateDataEntryPanel()
	{
		//Initialize dataInputPanel
		this.dataInputPanel = new DataPanel();
		
		// Create a panel to hold the DataInputPanel in Center
		JPanel dataPanel = new JPanel();
		dataPanel.setLayout( new BorderLayout() );
		topPanel.add( dataPanel, BorderLayout.SOUTH );
		
		// Create some function buttons
		addButton = new TButton( "Add" );
		removeButton = new TButton( "Delete" );
		dataPanel.add( addButton, BorderLayout.EAST );
		dataPanel.add( removeButton, BorderLayout.WEST );
		
		//Add Listeners to Events dispatched by the buttons
		addButton.addActionListener( this );
		removeButton.addActionListener( this );
		dataInputPanel.getTaskDoneButton().addActionListener( this );
		
		//Controller listens to their events
		addButton.addTaskListener(this.controller);
		removeButton.addTaskListener(this.controller);
		dataInputPanel.getTaskDoneButton().addTaskListener(this.controller);

		//Add the Input Panel in center of the dataPanel
		dataPanel.add( dataInputPanel, BorderLayout.CENTER );
	}

	
	@Override
	public void actionPerformed(ActionEvent event) 
	{
		if( event.getSource() == addButton )
		{
			// Get the text field value
			String stringValue = dataInputPanel.getDataInputField().getText();
			
			String[] argsToPass = new String[DataPanel.TOTAL_NR_OF_DATA_FIELDS];
			
			//Collect all the data from the fields and fill up the array
			
			//Task Name
			argsToPass[0] = this.dataInputPanel.getDataInputField().getText();
			
			//Task Type (Single/Periodic)
			argsToPass[1] = (String) this.dataInputPanel.getTaskTypeSelector().getSelectedItem();
			
			//Task Frequency if periodic
			argsToPass[2] = (String) this.dataInputPanel.getTaskFrequencySelector().getSelectedItem();
			
			//Date
			argsToPass[3] = (String) this.dataInputPanel.getDateField().getDaySelector().getSelectedItem();
			
			//Month
			argsToPass[4] = (String) this.dataInputPanel.getDateField().getMonthSelector().getSelectedItem();
			
			//Year
			argsToPass[5] = (String) this.dataInputPanel.getDateField().getYearSelector().getSelectedItem();
			
			//reset text field
			dataInputPanel.getDataInputField().setText( "" );
			
			// Add this item to the list and refresh
			if( stringValue != null )
			{
				//Dispatch the add task event
				TaskEvent ev = new TaskEvent(this,TaskEvent.ADD_NEW_TASK_EVENT,argsToPass);
				this.addButton.dispatchTaskEvent(ev);
				this.Refresh();
			}
			
		}

		if( event.getSource() == removeButton )
		{
			// Get the current selection
			int selection = listbox.getSelectedIndex();
			if( selection >= 0 )
			{
				// Remove this item from the list and refresh
				TaskEvent evt = new TaskEvent(this,TaskEvent.REMOVE_TASK_EVENT,String.valueOf(selection));
				this.removeButton.dispatchTaskEvent(evt);
				
				this.Refresh();

				// As a nice touch, select the next item
				if( selection >= listData.size() )
					selection = listData.size() - 1;
				listbox.setSelectedIndex( selection );
				
			}
		}
		if(event.getSource() == this.dataInputPanel.getTaskDoneButton())
		{
			// Get the current selection
			int selection = listbox.getSelectedIndex();
			if( selection >= 0 )
			{
				//Dispatch SET DONE event and Refresh the List
				TaskEvent evt = new TaskEvent(this,TaskEvent.SET_TASK_DONE_EVENT,String.valueOf(selection));
				this.dataInputPanel.getTaskDoneButton().dispatchTaskEvent(evt);
				this.Refresh();
			}
		}
	}

	
	@Override
	public void valueChanged(ListSelectionEvent event)
	{
			//TODO
	}
	
	//IObserver method
	public void Refresh()
	{
		listbox.setListData( listData );
		scrollPane.revalidate();
		scrollPane.repaint();
	}

	public JList getList() 
	{
		return this.listbox;
		
	}

	public JButton getAddButton() {
		// TODO Auto-generated method stub
		return this.addButton;
	}
	
	public JButton getRemoveButton() {
		// TODO Auto-generated method stub
		return this.removeButton;
	}

	public JPanel getDataInputPanel() {
		// TODO Auto-generated method stub
		return this.dataInputPanel;
	}
	
	@SuppressWarnings("unchecked")
	public Vector getListData()
	{
		return this.listData;
	}
	
	

}
