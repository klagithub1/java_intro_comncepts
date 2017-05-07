import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class VectorSpace 
{
	
	public static List<CustomInstance> vectorize(Dictionary dict , HashMap<String,String> docContent)
	{
		
		List<CustomInstance> data = new LinkedList<CustomInstance>();
		
		TreeMap<String, PostingList> dictContent = dict.getContent();
		
		for(String docKey: docContent.keySet())
		{
			CustomInstance instance = new CustomInstance(dict.getContent().size(),docKey);
			int i = 0;
			for (String key : dictContent.keySet()) 
	        {
				if(!key.equals(""))
				{
					
					PostingList currentPosting = dict.getContent().get(key);
					if(currentPosting.getPostingList().containsKey(docKey))
					{
						double w = TFIDFCalc.calculateInput(key, docKey, dict);
						instance.put(i, w);
					}
				      
					i++;
					
				}
	        }
			data.add(instance);
			
		}
		
		return data;
	}
}