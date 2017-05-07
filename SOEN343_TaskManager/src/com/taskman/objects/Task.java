package com.taskman.objects;

public class Task 
{
	//constants
	public static final String PERIODIC_TASK = "Periodic";
	public static final String SINGLE_TASK = "Single";
	public static final String DAILY_TASK = "Daily";
	public static final String WEEKLY_TASK = "Weekly";
	public static final String MONTHLY_TASK = "Monthly";
	public static final String YEARLY_TASK = "Yearly";
	public static final String DONE = "DONE";
	public static final String NOT_DONE = "In Progress";
	
	private String taskDescription;
	private String taskName;
	private String taskDueDate;
	private String taskType;
	private String taskStatus;
	
	public Task()
	{
	}
	
	public Task(String name, String day, String month, String year)
	{
		this.taskName = name;
		this.taskDueDate = day;
		this.taskDueDate = taskDueDate+" "+month;
		this.taskDueDate = taskDueDate+" "+year;
	}
	
	public void setTaskDescription(String arg)
	{
		this.taskDescription = arg;
	}
	
	public String getTaskDescription()
	{
		return this.taskDescription;
	}
	
	public void setTaskName(String arg)
	{
		this.taskName = arg;
	}
	
	public String getTaskName()
	{
		return this.taskName;
	}
	
	public void setTaskDueDate(String args)
	{
		this.taskDueDate = args;
	}
	
	public String getTaskDueDate()
	{
		return this.taskDueDate;
	}
	
	public void setTaskType(String arg)
	{
		this.taskType = arg;
	}
	
	public String getTaskType()
	{
		return this.taskType;
	}
	
	public String getTaskStatus()
	{
		return this.taskStatus;
	}
	
	public void setTaskStatus(String arg)
	{
		if(arg.equals(Task.DONE))
		{
			this.taskStatus = Task.DONE;
		}
	}
	
	public String toString()
	{
		return taskDescription;
		
	}
	
}
