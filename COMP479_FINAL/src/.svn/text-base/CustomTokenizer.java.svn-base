import java.io.File;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class CustomTokenizer 
{

	public static Dictionary newTokenize(String content, String docId, boolean isCaseFolding, boolean isStopWords, boolean isNoNumbers, Dictionary currentDict)
	{
		TreeMap<String,PostingList> returnedTree = new TreeMap<String,PostingList>();
		if(!currentDict.getContent().isEmpty())
			returnedTree = currentDict.getContent();
		
		Set<String> stopWords = null;
		
		if(isStopWords)
			stopWords = StopWords.getStopWords();
		
		if(isNoNumbers)
			content = content.replaceAll("\\d", "");
		
		StringTokenizer st = new StringTokenizer(content);

		while (st.hasMoreTokens()) 
	    {
	    	
	    	String currentToken = st.nextToken();
	    	currentToken = currentToken.replaceAll("\\p{Punct}", "");
	    	PostingList postingList = new PostingList();
	    	
	    	if(isCaseFolding)
	    		currentToken = currentToken.toLowerCase();
	    	
			if(isStopWords)
	    	{

				if(!stopWords.contains(currentToken))
	    		{

	    			//if it contains the key already add the new doc id to the existing postinglist
	    			//if it does not contain the key make a new posting list and add add it to the tree
	    			if(returnedTree.containsKey(currentToken))
	    				postingList = returnedTree.get(currentToken);
	    			
	    			postingList.add(docId);
			    	returnedTree.put(currentToken,postingList);
	    		
	    		}
				
	    	}
	    	else 
	    	{
	    		
	    		//if it contains the key already add the new doc id to the existing postinglist
    			//if it does not contain the key make a new posting list and add add it to the tree
    			if(returnedTree.containsKey(currentToken))
    				postingList = returnedTree.get(currentToken);
    			
    			postingList.add(docId);
		    	returnedTree.put(currentToken,postingList);
		    	
	    	}
	    	
	    }

		//Getting current document size
		String[] words = content.split(" ");
		int currentDocSize =words.length;
		
		currentDict.getDocSizes().put(docId,currentDocSize);
	    currentDict.setContent(returnedTree);
	    
		return currentDict;
		
	}
	
	//Recursive function to find all files within a set of folders
	public static LinkedList<String> getAllFiles(LinkedList<String> returned, String path)
	{
	
		File files = new File(path);
		String[] fileNames = files.list();
		
		for(int i = 0; i<fileNames.length;i++)
		{
			String fullPath = path+fileNames[i];
			File f1 = new File(fullPath);
			if(f1.isDirectory())
			{
				fullPath +="\\";
				getAllFiles(returned,fullPath);
			}
			else
			{
				File f2 = new File(fullPath);
				if(!f2.isDirectory())
				{
					
					if(fullPath.indexOf(".html") != -1||fullPath.indexOf(".php") == (fullPath.length()-4)||fullPath.indexOf(".txt") != -1)
					{
						returned.add(fullPath);
					}
					
				}
					
			}
			
		}
		
		return returned;
		
	}
	
}
