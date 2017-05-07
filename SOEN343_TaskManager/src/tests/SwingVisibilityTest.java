package tests;

import java.awt.Window;

import com.taskman.model.ModelLocator;
import com.taskman.view.ApplicationBaseUI;

import junit.framework.TestCase;

public class SwingVisibilityTest extends TestCase 
{
	//Create a test main window 
	ApplicationBaseUI window;
	
	public void setUp()
	{
		window = new ApplicationBaseUI();
		window.setVisible(true);
	}
	
	public void tearDown()
	{
		window.dispose();
	}
	
	//Test Main Window
	public void testMainWindowIsShowing()
	{
		assertTrue(window.isShowing());
	}
	
	//Test List 
	public void testListIsShowing()
	{
		assertTrue(( window.getList()).isShowing());
	}
	
	//Test Buttons
	public void testAddButtonIsShowing()
	{
		assertTrue(window.getAddButton().isShowing());
	}
	
	public void testAddButtonIsNotNull()
	{
		assertNotNull(window.getAddButton());
	}
	
	public void testRemoveButtonIsShowing()
	{
		assertTrue(window.getRemoveButton().isShowing());
	}
	
	public void testRemoveButtonIsNotNull()
	{
		assertNotNull(window.getRemoveButton());
	}
	
	//Test Data Entry Panel
	public void testDataInputPanel()
	{
		assertTrue(window.getDataInputPanel().isShowing());
	}
	
	public void testDataInputPanelNotNull()
	{
		assertNotNull(window.getDataInputPanel());
	}
	
	//Test if Data Displayed in the JList is BINDED to the ModelLocator's list
	//Then Implement a listData that is BINDED to ModelLocator's List Data
	//Each time the MOdelLocator's List data is updated the JList content is refreshed
	public void testListDataIsBindedToModelLocatorTaskList()
	{
		assertSame(window.getListData(),ModelLocator.getInstance().getTaskList());
	}
	
}
