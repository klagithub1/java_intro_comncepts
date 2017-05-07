package com.taskman.control;
import com.taskman.events.TaskEvent;
import com.taskman.model.ModelLocator;
import com.taskman.objects.PeriodicTask;
import com.taskman.objects.Task;
import com.utils.TaskBuilderFactory;


public class Controller implements ITaskListener
{
	
	private Task makeTaskFromArray(String[] array)
	{
		//Delegate
		return TaskBuilderFactory.createSingleTaskFromStringArray(array);
		
	}
	
	//Function that map events to commands
	@Override
	public void eventReceived(TaskEvent event) 
	{
		//Add new Item
		if (event.getOperationType() == TaskEvent.ADD_NEW_TASK_EVENT)
		{
			System.out.println("Add a new item to the List");
			ModelLocator.getInstance().getTaskList().add((makeTaskFromArray((String[]) event.parametersToCommand())));
			System.out.println(ModelLocator.getInstance().getTaskList());
		}
		else if (event.getOperationType() == TaskEvent.REMOVE_TASK_EVENT)
		{
			System.out.println("Remove Item from the List");
			ModelLocator.getInstance().getTaskList().removeElementAt(Integer.parseInt((String)(event.parametersToCommand())));
			System.out.println(ModelLocator.getInstance().getTaskList());
		}
		else if(event.getOperationType() == TaskEvent.SET_TASK_DONE_EVENT)
		{
			//To be implemented
			
		}
		else
			System.out.println("Error!!!!!");
		
	}

}
