import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.io.Serializable;

public class Dictionary implements Serializable{

	private static final long serialVersionUID = 1L;
	private TreeMap<String, PostingList> content;
	private boolean isCaseFolding;
	private boolean isStopWords;
	private boolean isNoNumbers;
	private HashMap<String,Integer> docSizes;
	private int totalSize;
	
	public Dictionary()
	{
		
		content = new TreeMap<String,PostingList>();
		isCaseFolding = false;
		isStopWords = false;
		isNoNumbers = false;
		docSizes = new HashMap<String,Integer>();
		totalSize = 0;
		
	}
	
	public Dictionary(TreeMap<String, PostingList> newContent, boolean newIsStopWords,boolean newIsCaseFolding,boolean newIsNoNumbers )
	{
		
		content = newContent;
		isCaseFolding = newIsCaseFolding;
		isStopWords = newIsStopWords;
		isNoNumbers = newIsNoNumbers;
		docSizes = new HashMap<String,Integer>();
		totalSize = 0;
	}

	public Dictionary(boolean newIsStopWords,boolean newIsCaseFolding,boolean newIsNoNumbers )
	{
		
		content = new TreeMap<String, PostingList>();
		isCaseFolding = newIsCaseFolding;
		isStopWords = newIsStopWords;
		isNoNumbers = newIsNoNumbers;
		docSizes = new HashMap<String,Integer>();
		totalSize = 0;
	}
	
	public boolean isCaseFolding() {
		return isCaseFolding;
	}

	public void setCaseFolding(boolean isCaseFolding) {
		this.isCaseFolding = isCaseFolding;
	}

	public boolean isStopWords() {
		return isStopWords;
	}

	public void setStopWords(boolean isStopWords) {
		this.isStopWords = isStopWords;
	}

	public boolean isNoNumbers() {
		return isNoNumbers;
	}

	public void setNoNumbers(boolean isNoNumbers) {
		this.isNoNumbers = isNoNumbers;
	}
	
	public TreeMap<String, PostingList> getContent() {
		return content;
	}

	public void setContent(TreeMap<String, PostingList> content) {
		this.content = content;
	}

	public HashMap<String, Integer> getDocSizes() {
		
		return docSizes;
	}

	public void setDocSizes(HashMap<String, Integer> docSizes) {
		this.docSizes = docSizes;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public Dictionary merge(Dictionary dict2)
	{
		
		Dictionary returnedDictionary = new Dictionary();
		returnedDictionary = this;
		Iterator<Entry<String, PostingList>> it = dict2.content.entrySet().iterator();
		
		while(it.hasNext())
	    {
		  
		  Entry<String, PostingList> entry = it.next();
		  
		  if(returnedDictionary.content.containsKey(entry.getKey()))
		  {
			  
			  returnedDictionary.content.get(entry.getKey()).addAll(entry.getValue());
			  
		  }
		  else
		  {
				
				returnedDictionary.content.put(entry.getKey(),entry.getValue());
				
		  }
	    }
		  
		returnedDictionary.getDocSizes().putAll(this.getDocSizes());
		returnedDictionary.getDocSizes().putAll(dict2.getDocSizes());
		
		return returnedDictionary;
		
	}

	public String toString()
	{
		
		Iterator<Entry<String, PostingList>> it = this.content.entrySet().iterator();
		String returnString = "";
	    
	    while(it.hasNext())
	    {
	    	
	        Entry<String, PostingList> entry = it.next();
	       
	        returnString += entry.getKey()+"\n\t"+entry.getValue().toString()+"\n";
	        
	    }
	    return returnString;
	}
	
	public int fullDocLenght()
	{
		int total =0;
		for(Map.Entry<String,Integer> entry : this.getDocSizes().entrySet()) 
		{
	    	
			total+= entry.getValue();
			
	    }
	    return total;
	}
	
}
