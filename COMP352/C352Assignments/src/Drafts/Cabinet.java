package Drafts;
/*
 * ASSIGNMENT 2
 * KLAJDI KARANXHA - 6173780
 * */
public class Cabinet 
{
	/**The only attributes of the data structure is a Node object referring the current position.
	 * A node Counter that keeps track of the total nodes of the data strucutre.
	 * and a height counter that counts the height of the tree from the current node and up.*/
	protected static Node head;//The pointer to the current node.
	protected Node root;
	protected static int nodeCount=0;//increases as many times as we insert a node.
	
	
	
	/**Creates an empty data structure.*/
	public Cabinet()
	{
		head=null;
		root=null;
		
	}
	
	/**This method creates the root, which is the first node of the data structure.
	 * its parent points to null and initially root has no childrens,one can add them using insert().*/
	public void createRoot(String name)
	{	
		try {
			root= new Node(name,"dir",0.0,root);
		} catch (IllegalTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//head.parent points to null
		head=root;
		
		if(head.isRoot())
		{
			System.out.println("Root is created!");
		}
		nodeCount++;
	}
	
	
	
	/**Inserts a node under a specific parent in the tree structure.In order to eliminate confusion 
	 * we follow these steps:
	 * 1.Move the pointer to subparent
	 * 2.Access subparent's child array and find the parent.
	 * 3.move the pointer to the parent.
	 * 4.insert a new node pointing to the parent.
	 * !!! use subParent name null in case of intending insertion at root.*/
	public void insert(String name,String type, double size,String parentName, String subParent) throws IllegalMoveException
	{	
		
		//in case we are inserting to the root.
		if(subParent==null)
		{
			//root insertion. - bring head point to root.
			while(!(parentName.equals(head.getName())))
			{
				head=head.getParent();
			}
			//Mini test ot check if the pointer sucessfully moved to root !
			if(head.isRoot())
			{
				System.out.println("TEST! - head is sucessfully pointing at the root !");
			}
			//insert at the root's children array.
			for(int i=0;i<=head.getChilds().length-1;i++)
			{
				if(head.getChilds()[i]==null)
				{
					Node newnode=null;//keps the compiler happy ;-)
					try {
						
						newnode = new Node(name,type,size,head);
					} catch (IllegalTypeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					head.getChilds()[i]=newnode;
					nodeCount++;
					break;
				}
			}
		}
		
		//in other cases, at a normal insertion at an arbitrary position.
		else
		{
			if (parentName.contains(".") || subParent.contains("."))
			{
				throw new IllegalMoveException("cannot add/remove a file/folder to another file !");
			}
			
			while(!(parentName.equals(head.getName()) && subParent.equals(head.getParent().getName())))
			{
				head=head.getParent();
			}
			//check if it is pointing to the correct parent.
			System.out.println("TEST! - head is pointing to: "+head.getName()+" subParent is: "+head.getParent().getName());
			//insert at that position.
			for(int i=0;i<=head.getChilds().length-1;i++)
			{
				if(head.getChilds()[i]==null)
				{
					Node newnode=null;
					try {
						newnode = new Node(name,type,size,head);
					} catch (IllegalTypeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					head.getChilds()[i]=newnode;
					nodeCount++;
					break;
				}
			}
		}
		
		
	}
	
	/**Delete a node with all of its subnodes.*/
	public void cut(String nodeName,String subParent)
	{
		//move pointer to the node you want to delete.
		while(!(head.getName().equals(nodeName) && head.getParent().getName().equals(subParent)))
		{
			head=head.getParent();
		}
		//TEST
		System.out.println("TEST! Head is pointing:" + head.getName());
		//delete this node' array of childs.
		for(int i=0;i<=head.getChilds().length-1;i++)
		{
				head.getChilds()[i]=null;
				nodeCount--;
		}
		//delete the node itself
		head=head.getParent();//move pointer to subparent.
		//TEST
		System.out.println("TEST! Head is pointing:" + head.getName());
		//delete node from array of childrens of its parent
		for(int i=0;i<=head.getChilds().length-1;i++)
		{	
			if(head.getChilds()[i].equals(nodeName))
				{
					head.getChilds()[i]=null;
				}
		}
		
		
	}
	
	/**removes a node but leaves its childs point to the subparent*
	 * /
	 */
	public void remove(String nodeName, String parentName)
	{
		//find the node
		while(!(head.getName().equals(nodeName) && head.getParent().getName().equals(parentName)))
		{
			head=head.getParent();
		}
//		TEST
		System.out.println("TEST! Head is pointing:" + head.getName());
		//make childs point to subparent
		for(int i=0;i<=head.getChilds().length-1;i++)
		{
			
			head.getChilds()[i].setParent(head.getParent());
		}
		for(int i=0;i<=head.getChilds().length-1;i++)
		{
			if(!(head.getChilds()[i]==null))
					{
						head=head.getChilds()[i];
						break;
					}
		}
	}
		
	/**Moves a node from a position to another position.*/
	public void copy(String subParent, String node, String newSubparent, String newnode)
		{
			//move pointer to the node
			while(!(head.getName().equals(node) && head.getParent().getName().equals(subParent)))
			{
				head=head.getParent();
				
			}
			Node temp=head;
			//move pointer to new tobePlaced location
			
			while(!(head.getName().equals(newnode) && head.getParent().getName().equals(newSubparent)))
			{
				head=head.getParent();
			}
			for(int i=0;i<=head.getChilds().length-1;i++)
			{
				if(head.getChilds()[i]==null)
				{
					head.getChilds()[i]=temp;
					head=head.getChilds()[i];

					break;
				}
			}

		}
	
	
	
	/**renames a node in the tree*/
	public void rename(String nodeName,String parentName, String newName)
	{
		while(!(head.getName().equals(nodeName) && head.getParent().getName().equals(parentName)))
		{
			head=head.getParent();
		}
//		TEST
		System.out.println("TEST! Head is pointing:" + head.getName());
		head.setName(newName);
	}
	
	
	/**Returns the head node*/
	public Node getHead()
	{
		System.out.println("TEST! - head is at position:" + head.getName());
		return head;
	}
	
	/**Calculate the height of the tree from current head position and up.*/
	public int height()
	{
		int height=0;
		while(!(head.getParent()==null))
		{
			
			head=head.getParent();
			height++;
			
		}
		return height;
	}

	/**Calculate the total space occupied by the files in the linked structure.*/
	public double space()
	{
		double totalSize=0.00;
		while(!(head.getParent()==null))
		{
			for(int i=0;i<=head.getChilds().length-1;i++)
			{
					totalSize =totalSize+head.getChilds()[i].getSize();

			}
			head=head.getParent();
		}
		
		
		return totalSize;
	}
	
	/**Returns the actual node count of the tree.*/
	public int count()
	{
		return nodeCount;
	}
	
	/**There is another version of this method that goes through every node of the tree, and increments a counter.*/
	public int count_v2()
	{
		int count =0;
		while(!(head.getParent()==null))
		{
			for(int i=0;i<=head.getChilds().length-1;i++)
			{
				if(!(head.getChilds()[i]==null))
				{
					count++;
				}
			}
			head=head.getParent();
		}
		return count;
		
	}
	
	/**Returns an iterator object for the class cabinet.*/
	public Iterator iterator()
	{
		return new Iterator();
	}

	
	/**Display the Tree graphically on the screen.*/
	public void display()
	{
		while (head != null)
		{
			for(int i=0;i<=head.getChilds().length-1;i++)
			{
				System.out.println(head.getChilds()[i].toString());
			}
			
			head = head.getParent();
		}
	}

	/**Display the Tree graphically on the screen with the space occupied by each node.*/
	public void space_display()
	{
		while (head != null)
		{
			for(int i=0;i<=head.getChilds().length-1;i++)
			{
				
					System.out.println(head.getChilds()[i].toString()+" "+head.getChilds()[i].getSize());
			
			}
			
			head = head.getParent();
		}
	}
	
	/**If a Node  has no reference to an array of childs than it is external.*/
	public boolean isExternal()
	{
		if (head.getChilds()==null)
			return true;
			else
				return false;
	}

	
}
