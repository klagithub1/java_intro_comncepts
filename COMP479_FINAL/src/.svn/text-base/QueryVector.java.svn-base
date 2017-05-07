import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

import net.sf.javaml.core.Instance;
import net.sf.javaml.core.SparseInstance;

import java.util.ArrayList;

import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.DefaultDataset;
import net.sf.javaml.distance.CosineSimilarity;

public class QueryVector {
	
	//returns a map with each term and its term frequency of the query;
	public static Map<String,Integer> buildTermTF(String query)
	{
		Map<String, Integer> dic = new HashMap<String, Integer>();
		StringTokenizer tokenizer = new StringTokenizer(query);
		
		while (tokenizer.hasMoreTokens()) {
            try{
               // String token = processToken(st.nextToken()); // may throw IllegalArgumentException
            	String token = tokenizer.nextToken().toLowerCase();
                if(dic.containsKey(token)){
                    int tf = dic.get(token);
                    dic.put(token, tf+1);
                }else{
                    dic.put(token, 1);
                }
            }catch(IllegalArgumentException skipToken){}
        }
		
		return dic;
		
	}
	
	public static Map<String,PostingList> createDictForQuery(String query, Dictionary dict)
	{
		
		Map<String, Integer> map = QueryVector.buildTermTF(query);
		Map<String,PostingList> dictForQuery = new HashMap<String, PostingList>();
		PostingList currentPosting = null;
		
		for(String termInQuery: map.keySet())
		{
			
			if(dict.getContent().containsKey(termInQuery))
			{
				currentPosting = dict.getContent().get(termInQuery);
				dictForQuery.put(termInQuery, currentPosting);
			}
			
		}
		
		return dictForQuery;
		
	}
	
	public static ClusterSet clusterForQuery(ArrayList<ClusterSet> returnedClusters,String query,Dictionary dict)
	{
		
		double minDistance = Double.MAX_VALUE;
		CustomInstance queryVector = QueryVector.vectorizeQuery1(query, dict);
		double distance;
		ClusterSet candidateCluster = null;
		ClusterSet current = null;
		CustomInstance centroid = null;
		
		for(int i = 0; i<returnedClusters.size();i++)
		{
			
			//CosineSimilarity cs = new CosineSimilarity();
			
			current  = returnedClusters.get(i);
			centroid = current.getCentroid();
			//distance = cs.measure(queryVector.getInst(), centroid.getInst());
			distance = queryVector.euclideanDistance(centroid);
			
			if(distance < minDistance){
                candidateCluster = current;
                minDistance = distance;
            }
			
		}

		return candidateCluster;
		
	}
	
	public static CustomInstance vectorizeQuery1(String query, Dictionary dict)
	{
		
		double tfIdf = 0.0;
		double normalizeTf = 0.0;
		double dft = 0.0;
		int tf =0;
		double idf = 0.0;

		Map<String, Integer> map = QueryVector.buildTermTF(query);
		double nbrOfDocuments = dict.getDocSizes().size();
		
		CustomInstance customInstance = new CustomInstance();
		Instance instance   = new SparseInstance(dict.getContent().size());
		
		int i =0;
		
		for(String termInQuery: map.keySet())
		{
			
			if(dict.getContent().containsKey(termInQuery))
			{   
				
				PostingList currentPosting = dict.getContent().get(termInQuery);
				//dictForQuery.put(termInQuery, currentPosting);
				
				tf = map.get(termInQuery);
				
				normalizeTf = 1+Math.log10(tf); 
				dft = currentPosting.size();
				idf = Math.log10(nbrOfDocuments)/dft;
				
			    tfIdf = normalizeTf * idf;
			  //  System.out.print("TFIDF " + tfIdf);
			    instance.put(i, tfIdf);
			    customInstance.setInst(instance);
			   
			}
			i++;
			
		}
		
		return customInstance;
	}
	
	public static Dataset vectorizeQuery2(Dictionary dict , HashMap<String,String> docContent,String query)
	{
		Dataset data = new DefaultDataset();
		Map<String, PostingList> dictForQuery = QueryVector.createDictForQuery(query, dict);
		TreeMap<String, PostingList> dictContent = dict.getContent();
		
	
		for(String docKey: docContent.keySet())
		{
			
			
			Instance instance = new SparseInstance(dict.getContent().size(),docKey);
			int i = 0;
			for (String key : dictContent.keySet()) 
	        {
				if(!key.equals(""))
				{
					
					PostingList currentPosting = dict.getContent().get(key);
					if(currentPosting.getPostingList().containsKey(docKey))
					{
						double w = TFIDFCalc.calculateQuery(key, docKey, dict,dictForQuery,query);
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