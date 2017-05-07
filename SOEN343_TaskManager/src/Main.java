import javax.swing.JFrame;
import javax.swing.JLabel;

import com.taskman.view.ApplicationBaseUI;
import com.utils.TaskBuilderFactory;


public class Main extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	  public static void main(String[] args)
	  {
		  //TODO - At first this method will retrieve the tasks from the repository and populate the ModelLocator's List
		  TaskBuilderFactory.makeTaskListFromRepository();
		  
		  ApplicationBaseUI mainUI = new ApplicationBaseUI();
		  
		  mainUI.setVisible(true);

	  }

}
