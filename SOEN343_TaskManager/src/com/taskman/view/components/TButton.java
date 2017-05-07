package com.taskman.view.components;
import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;

import com.taskman.control.ITaskListener;
import com.taskman.events.TaskEvent;

public class TButton extends JButton
{
	private ArrayList eventListeners;
	private static final long serialVersionUID = 1L;
	
	public TButton()
	{
		super();
		eventListeners = new ArrayList();
	}
	
	public TButton(String arg)
	{
		super(arg);
		eventListeners = new ArrayList();
	}
	
	 public synchronized void addTaskListener( ITaskListener listener ) {
	        eventListeners.add(listener);
	    }
	    
	 public synchronized void removeTaskListener( ITaskListener listener ) {
	        
			eventListeners.remove(listener);
	    }
	 
	 public synchronized void dispatchTaskEvent(TaskEvent event)
	 {
		 Iterator listeners = eventListeners.iterator();
	        while( listeners.hasNext() ) {
	            ( (ITaskListener) listeners.next() ).eventReceived( event );
	        }
	 }
}
