import java.util.Map;


public class TFIDFCalc 
{

	public static double calculateInput(String input, String docId,Dictionary dict)
	{
		
		double N = dict.getDocSizes().size();
		
		if(dict.isCaseFolding())
			input = input.toLowerCase();
		if(dict.isNoNumbers())
			input = input.replaceAll("\\d", "");
		
		double w = 0.0;
		if(dict.getContent().containsKey(input))
		{
			
			PostingList currentPosting = dict.getContent().get(input);
			double dft = currentPosting.size();
			double tf = currentPosting.getPostingList().get(docId);
			double normalizeTf = 1+Math.log10(tf);
			double idf = Math.log10(N/dft);
			
			w = normalizeTf*idf;
			
		}
			
		return w;
		
	}
	
	
	public static double calculateQuery(String input, String docId,Dictionary dict,Map<String,PostingList> dictForQuery,String query)
	{
		
		double N = dict.getDocSizes().size();
		
		if(dict.isCaseFolding())
			input = input.toLowerCase();
		if(dict.isNoNumbers())
			input = input.replaceAll("\\d", "");
		
		double w = 0.0;
		
		
		Map<String,Integer> queryTFMap = QueryVector.buildTermTF(query);
		//System.out.println(queryTFMap.get("concordia").toString() + " size is " + queryTFMap.size());
		
		
		for(String termInQuery: queryTFMap.keySet())
		{
			if(dict.getContent().containsKey(termInQuery))
		//if(dictForQuery.containsKey(input))
			
		{
			PostingList currentPosting = dict.getContent().get(termInQuery);
			double dft = currentPosting.size();
			double idf = Math.log10(N/dft);
			double tf = queryTFMap.get(termInQuery);
			double normalizeTf = 1+Math.log10(tf);
			
			w = normalizeTf*idf;
		//	System.out.println(w);
			if(w!=0.0)
			System.out.println("WEIGHT FOR QUERY " + w);
		}
		
		}
		
			
		return w;
		
	}
	
	
	
	
	
}
