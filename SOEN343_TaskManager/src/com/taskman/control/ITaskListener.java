package com.taskman.control;
import com.taskman.events.TaskEvent;


public interface ITaskListener 
{
	public void eventReceived(TaskEvent event);
}
