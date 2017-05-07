package com.taskman.events;
import java.util.EventObject;

public class TaskEvent extends EventObject implements Cloneable
{	
	public static final String ADD_NEW_TASK_EVENT = "add_new_task_event";
	public static final String REMOVE_TASK_EVENT = "remove_task_event";
	public static final String SET_TASK_DONE_EVENT = "set_task_done_event";
	
	private String operationType;
	private Object parametersToCommand;
	
	 public TaskEvent( Object source, String operationType, Object parametersToCommand )
	 {
	     super( source );
	     this.operationType = operationType;
	     this.parametersToCommand = parametersToCommand;
	 }
	 
	 public String getOperationType()
	 {
		 return this.operationType;
	 }
	 
	 public Object parametersToCommand()
	 {
		 return this.parametersToCommand;
	 }
}
