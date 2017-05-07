package com.taskman.objects;

public class PeriodicTask extends Task 
{
	private String taskFrequency;
	
	public PeriodicTask()
	{
		super();
	}
	
	public void setFrequency(String arg)
	{
		this.taskFrequency = arg;
	}
	
	public String getFrequency()
	{
		return this.taskFrequency;
	}
}
