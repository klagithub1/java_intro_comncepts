import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public class PostingList implements Serializable {

	private static final long serialVersionUID = 1L;
	private TreeMap<String,Integer> postingList;
	
	PostingList()
	{
		
		postingList = new TreeMap<String,Integer>();
	}

	PostingList(String docId, int value)
	{
		postingList = new TreeMap<String,Integer>();
		postingList.put(docId, value);
	}
	
	PostingList(TreeMap<String,Integer> newPostingList)
	{
		
		postingList = newPostingList;
	}

	public TreeMap<String,Integer> getPostingList() {
		
		return postingList;
	}

	public void setPostingList(TreeMap<String,Integer> postingList) {
		this.postingList = postingList;
	}
	
	public PostingList addAll(PostingList newPostingList)
	{
		this.getPostingList().putAll(newPostingList.getPostingList());
		return this;
	}
	
	public String toString()
	{
	
		String returned = "";
		boolean flag = true;
		
		for(Map.Entry<String,Integer> entry : this.getPostingList().entrySet()) 
		{
			
			String key = entry.getKey();
			int value = entry.getValue();

			if(flag)
			{
				returned = key + " => " + value;
				flag = false;
			}
			else
				returned += "\n"+key + " => " + value;
			  
		}

		return returned;
		
	}

	public boolean isEmpty() 
	{
		
		return this.getPostingList().isEmpty();
	}
	
	public int size() 
	{
		
		return this.getPostingList().size();
	}
	
	public boolean contains(String posting) 
	{
		
		return this.getPostingList().containsKey(posting);
	}
	
	public void add(String docId) 
	{
		
		if(!this.contains(docId))
			this.getPostingList().put(docId, 1);  
		else
			this.getPostingList().put(docId, this.getPostingList().get(docId)+1);
		
	}
	
	public int sumOfPostings()
	{
		
		int total = 0;
		for(Map.Entry<String,Integer> entry : this.getPostingList().entrySet()) 
		{
			int value = entry.getValue();
			
			total+=value;
		}
		
		return total;
	}
	
}
