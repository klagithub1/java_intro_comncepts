package com.taskman.objects;

import java.util.ArrayList;
import java.util.Vector;

public class TaskList extends Vector
{
	public TaskList()
	{
		super();
	}
	
	@Override
	public boolean add(Object o)
	{
		Task taskToAdd = (Task)o;
		
		if(taskToAdd.getTaskType().equals(Task.PERIODIC_TASK))
		{
			boolean add = super.add((PeriodicTask)taskToAdd);
			return add;
		}
		else
		{
			boolean add = super.add(taskToAdd);
			return add;
		}
		
		
	}
	
}
