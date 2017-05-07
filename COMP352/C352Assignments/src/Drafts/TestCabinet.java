package Drafts;

import java.util.Scanner;

public class TestCabinet {

	/**
	 * This creates a cabinet file structure  and performs several operations to test it.
	 */
	public static void main(String[] args) 
	{	
		
		/**Create the Data structure and populate the tree with the given structure.*/
		Cabinet cabinet = new Cabinet();
		cabinet.createRoot("root");//create root node
		cabinet.display();

		
		
		
		
		/**This part prompts the user to input a file or folder at a given position.*/
		// Create a Scanner Object.
		Scanner kb1 = new Scanner(System.in);
		Scanner kb2 = new Scanner(System.in);
		//Create a size variable to hold size of file if inserted a file).
		@SuppressWarnings("unused")
		double size =0.00;
		kb1.useDelimiter("/");//This is the method that will chomp the string between "/"
		System.out.println("Please input the name of the file/folder you want to insert.\n"+
				"The correct Format is:\n"+" /subparent/parent/newFile(or folder)/\n");
		String subparent = kb1.next();
		String parent = kb1.next();
		String filename=kb1.next();
		
		//In case the user inserts a file then he/she is prompted for file size.
		if (filename.contains("."))
		{
			System.out.println("Please determine the size of the file you want to create.:\n");
			size = kb2.nextDouble();
		}
		
		System.out.println("The following file/folder: "+filename+ " will be inserted at: /"+subparent+"/"+parent);
		



	}

}
