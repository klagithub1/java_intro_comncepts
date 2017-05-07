import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BMCalc {
	
	public static HashMap<String,Double> calculate(String query, Dictionary dict)
	{

		double totalDocumentSize = dict.getTotalSize();
		double nbrOfDocuments = dict.getDocSizes().size();
		double averageDocSize =totalDocumentSize/nbrOfDocuments;
		double k = 1.75;
		double b = 0.25;
		double RSVTotal = 0.0;
		double dft = 0.0;
		
		StringTokenizer tokenizedQuery = new StringTokenizer(query);
		HashMap<String,Double> returnMap = new HashMap<String,Double>();
		
		while(tokenizedQuery.hasMoreTokens())
		{
			
			String currentToken = tokenizedQuery.nextToken(); 
			
			
			if(dict.isCaseFolding())
				currentToken = currentToken.toLowerCase();
			if(dict.isNoNumbers())
				currentToken = currentToken.replaceAll("\\d", "");
			
			if(dict.getContent().containsKey(currentToken))
			{
				
				PostingList currentPosting = dict.getContent().get(currentToken);
				dft = currentPosting.size();
				String key = "";
				for(Map.Entry<String,Integer> entry : currentPosting.getPostingList().entrySet()) 
				{
					
					key = entry.getKey();
					double currentDocSize = dict.getDocSizes().get(key);
					double tf = currentPosting.getPostingList().get(key);
					double denominator = k*((1-b)+b*(currentDocSize/averageDocSize))+tf;
					double numerator = ((k+1)*tf);
					double impovement = numerator/denominator;
					double idf = Math.log10(nbrOfDocuments/dft);
					RSVTotal = idf*impovement;
					
					if(returnMap.containsKey(key))
					{
						returnMap.put(key,returnMap.get(key)+RSVTotal);
						
					}
					else
						returnMap.put(key, RSVTotal);
					
				}
				
			}
			
		}
		
		return returnMap;
		
	}

	public static HashMap<String, Double> calculate(String query, Dictionary dict, ClusterSet bestCluster) 
	{

		double totalDocumentSize = dict.getTotalSize();
		double nbrOfDocuments = dict.getDocSizes().size();
		double averageDocSize =totalDocumentSize/nbrOfDocuments;
		double k = 1.75;
		double b = 0.25;
		double RSVTotal = 0.0;
		double dft = 0.0;
		
		StringTokenizer tokenizedQuery = new StringTokenizer(query);
		HashMap<String,Double> returnMap = new HashMap<String,Double>();
		
		while(tokenizedQuery.hasMoreTokens())
		{
			
			String currentToken = tokenizedQuery.nextToken(); 
			
			
			if(dict.isCaseFolding())
				currentToken = currentToken.toLowerCase();
			if(dict.isNoNumbers())
				currentToken = currentToken.replaceAll("\\d", "");
			
			if(dict.getContent().containsKey(currentToken))
			{
				
				PostingList currentPosting = dict.getContent().get(currentToken);
				dft = currentPosting.size();
				String key = "";
				for(Map.Entry<String,Integer> entry : currentPosting.getPostingList().entrySet()) 
				{
					key = entry.getKey();
					if(bestCluster.contains(key))
					{
						
						double currentDocSize = dict.getDocSizes().get(key);
						double tf = currentPosting.getPostingList().get(key);
						double denominator = k*((1-b)+b*(currentDocSize/averageDocSize))+tf;
						double numerator = ((k+1)*tf);
						double impovement = numerator/denominator;
						double idf = Math.log10(nbrOfDocuments/dft);
						RSVTotal = idf*impovement;
						
						if(returnMap.containsKey(key))
						{
							returnMap.put(key,returnMap.get(key)+RSVTotal);
							
						}
						else
							returnMap.put(key, RSVTotal);
					}
				}
				
			}
			
		}
		
		return returnMap;
		
	}

}