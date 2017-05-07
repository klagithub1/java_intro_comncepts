package Drafts;

/**Inner class of Iterator*/
public class Iterator
{
	private Node position;
	private Node previous;

	public Iterator()
	{
		position = Cabinet.head;
		previous = null;
	}
	/**Reset the iterator*/
	public void restart()
	{
		position = Cabinet.head;
		previous = null;
	}
	
	/**This method makes the iterator object point to each node of the tree structure.
	 * @throws endOfTreeException */
	public String move() throws endOfTreeException
	{
		position=Cabinet.head;
		previous=Cabinet.head.getParent();
		if(!(position.getParent()==null))
		{
			position=position.getParent();
			previous=previous.getParent();
		}
		else{
		throw new endOfTreeException("Tree has reached node.");
			
		}
		return position.getName();
		
	}
	
	/**Checks if the next position is not null*/
	public boolean hasNext()
	{
		return (position.getParent() != null);
	}
	
	public void remove(String node) throws IllegalMoveException, endOfTreeException
	{
		while(!(position.getParent()==null))
		{
			if (position==null)
				
			{
				throw new IllegalMoveException("Cannot delete from an empty tree!");
			}
			if(position.getName().equals(node))
				
			{
				for(int i=0;i<=position.getChilds().length-1;i++)
				{
					//delete all childs
					position.getChilds()[i]=null;
					Cabinet.nodeCount--;
				}
				
			}
			else if(previous ==null)
			{
				throw new endOfTreeException("End of tree is reached! Cannot delete root!");
			}
			//move to next position.
			position=position.getParent();
			previous=previous.getParent();
		}
		
	}

	
	}
