package com.utils;

import com.taskman.objects.PeriodicTask;
import com.taskman.objects.Task;

public class TaskBuilderFactory
{
	//Dictionary Array of Titles
	private static String[] title = {"NAME: ","TYPE: ","FREQUENCY: ","DUE DATE: ","",""};
	
	/*Factory methods*/
	
	public static void makeTaskListFromRepository()
	{
		//TODO
		//Will retrieve all the task from the repository and populate the ModelLocator's TaskList
	}
	
	public static Task createSingleTaskFromStringArray(String[] args)
	{
		if(args[1].equals(Task.PERIODIC_TASK))
		{
			PeriodicTask periodic = new PeriodicTask();
			periodic.setTaskType(args[1]);
			periodic.setFrequency(args[2]);
			
			periodic.setTaskName(args[0]);
			periodic.setTaskDueDate((args[3]+" "+args[4]+" "+args[5]));
			
			periodic.setTaskStatus(Task.NOT_DONE);
			
			String completeTask = "";
			for (int i = 0; i<=(args.length-1);i++)
			{
				completeTask = completeTask+" "+TaskBuilderFactory.title[i]+" "+args[i]+",";
			}
			completeTask = completeTask+" STATUS: "+Task.NOT_DONE;
			periodic.setTaskDescription(completeTask);
			return periodic;
		}
		else
		{
			Task single = new Task();
			single.setTaskName(args[0]);
			single.setTaskType(args[1]);
			single.setTaskDueDate((args[3]+" "+args[4]+" "+args[5]));
			
			single.setTaskStatus(Task.NOT_DONE);
			
			String completeTask = "";
			for (int i = 0; i<=(args.length-1);i++)
			{
				completeTask = completeTask+" "+TaskBuilderFactory.title[i]+" "+args[i]+",";
			}
			completeTask = completeTask+" STATUS: "+Task.NOT_DONE;
			single.setTaskDescription(completeTask);
			
			
			return single;
		}
		
	}
}
