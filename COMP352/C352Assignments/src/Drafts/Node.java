package Drafts;
/*
 * ASSIGNMENT 2
 * KLAJDI KARANXHA - 6173780
 * */

/**The Node class represents a single node of the general tree linked structure.
 * each node has a String name, a pointer to its parent and a pointer to an internal array of nodes, 
 * abstracting the childs of a tree.*/
public class Node
{
	/**Attributes of a Tree node.*/
	private String name;//name of a node.
	private String type;//type if is file or directory
	//constants defining type directory or file
	private static String dir="dir";
	private static String file="file";
	private double size;//size of a file
	private Node[]childs;//array of child nodes
	private Node parentNode;//parent node
	
	/**Default Node constructor*/
	public Node()
	{
		this.name="default";//default name
		this.type=dir;
		this.size=0.00;
		this.childs=new Node[10];
		for(int i=0;i<=childs.length-1;i++)
		{
			childs[i]=null;
		}
		this.parentNode=null;
	}
	
	/**Specific Node constructor that takes arguments
	 * @throws IllegalTypeException */
	public Node(String name, String type, double size,Node parent) throws IllegalTypeException
	{
		this.name=name;
		this.type=type;
		
		if (type.equals(dir))
		{
			this.size = 0.00;
		}
		else if (type.equals(file))
		{
			if (!(name.contains(".")))
			{
				throw new IllegalTypeException("The name entered is a folder name!");
			}
			this.size=size;
		}
		
		
		//initially 10 childrens which are empty.
		this.childs=new Node[10];
		for(int i=0;i<=childs.length-1;i++)
		{
			childs[i]=null;
		}
		this.parentNode=parent;
		
	
	}
	
	/**Return Node name as String.*/
	public String getName()
	{
		return name;
	}
	
	/**Return type of node file or directory.*/
	public String getType()
	{
		return type;
	}
	
	/**return size of the file.*/
	public double getSize()
	{	
		if (getType().equals(dir))
	{
		return 0.00;
	}
		return size;
	}
	
	/**returns the array of childs node attribute.*/
	public Node[] getChilds()
	{
		return childs;
	}

	/**return parent Node of current Node.*/
	public Node  getParent()
	{
		return parentNode;
	}
	
	
		/**Set the name of a node*/
	public void setName(String name)
	{
		this.name=name;
	}
	/**Set parent of a Node*/
	public void setParent(Node newNode)
	{
		this.parentNode=newNode;
	}
	/**Checks if a node is root**/
	public boolean isRoot()
	{
		if(getParent()==null)
			return true;
		else
			return false;
	}
	/**Displays info about a node*/
	public String toString()
	{
		return "Node: "+name+" "+type+" "+size+" ";
	}
}
