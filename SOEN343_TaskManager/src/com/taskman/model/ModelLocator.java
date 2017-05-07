package com.taskman.model;

import java.util.ArrayList;
import java.util.Vector;

import com.taskman.objects.TaskList;

public class ModelLocator 
{
	private static ModelLocator modelLocator;
	
	
	//List to be bounded to display 
	private TaskList taskList;
	
	
	public ModelLocator()
	{
		this.taskList = new TaskList();
		
		if(modelLocator != null)
		{
			throw new Error("Singletton Pattern Violation! - There should be only one ModelLocator instantiated!");
		}
	}
	
	
	public static ModelLocator getInstance()
	{
		if(modelLocator == null)
		{
			modelLocator = new ModelLocator();
			return modelLocator;
		}
		else
		{
			return modelLocator;
		}
	}
	
	
	
	public TaskList getTaskList()
	{
		return this.taskList;
	}

	
}
