import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


import net.sf.javaml.core.Instance;

import net.sf.javaml.distance.EuclideanDistance;
import net.sf.javaml.distance.CosineSimilarity;

public  class DocVector 
{
	
	
	
	private Map<Integer,Double> mapVectors = null; // coordinate -> value
	private Integer docID;

	
	
	 public double length() 
	 {
	        Iterator<Double> valuesIter = mapVectors.values().iterator();
	        double sumOfSquares = 0;
	        while (valuesIter.hasNext())
	        {
	            double value = valuesIter.next();
	            sumOfSquares += Math.pow( value, 2 );
	        }
	        double distance = Math.sqrt(sumOfSquares);
	        return distance;
	 }
	
	
	
	
	public DocVector(Integer docID)
	{
		
		this.docID = docID;
		mapVectors = new HashMap<Integer,Double>();
		
	}
	
	public void addValue(Integer docID, Double weight){
		
		mapVectors.put(docID, weight);
	}
	
	 public Double getValue( Integer dimension ) 
	 {
	        if (mapVectors.containsKey(dimension))
	            return mapVectors.get( dimension );
	        else
	            return 0.0;
	 }
	 
	public HashMap<Integer, Double> getMap()
	{
		return (HashMap<Integer, Double>) this.mapVectors;
	}
	 
	 
	 public int getSize(){
		 
		 return mapVectors.size();
	 }
	 
	 
	 public Integer getID()
	 {
		 return this.docID;
	 }
	 
	 public String toString(){
		 
		 return docID.toString() + " : " + mapVectors.toString();
	 }
	 
	 public Set<Entry<Integer, Double>> getAllEntries() 
	 {
	        return mapVectors.entrySet();
	    }
	 
	 public double calculateEuclideanDistance( DocVector docVecB ) {
		 
		 	//initialize euclidean vector
	        double eucVector = 0;
	        for ( Entry<Integer, Double> entry : mapVectors.entrySet() )
	        {
	            double diff = (entry.getValue()-((DocVector) mapVectors).getValue(entry.getKey()));
	            eucVector += diff*diff;
	        }
	        
	        //if the second documentVector hashMap has more keys.
	        for ( Entry<Integer, Double> entry : docVecB.getAllEntries() )
	        {
	            if (mapVectors.containsKey(entry.getKey()))
	            {
	                continue;

	            }
	            double value = entry.getValue();
	           eucVector += value*value;
	        }
	        return Math.sqrt(eucVector);

	    }
	 
	 //useless for now ( method used from the java.ml)
	public static double calculateDistance(Instance v1, Instance v2){
		
		EuclideanDistance ed = new EuclideanDistance();
	  double distance =  ed.calculateDistance(v1, v2);
	  
	  
	  return distance;
	}
	//useless for now ( method used from the java.ml)
	public double calculateCosineSimilarity(Instance v1, Instance v2){
		CosineSimilarity cosine = new CosineSimilarity();
		double cosineSimilarity = cosine.measure(v1, v2);
		
		return cosineSimilarity;
	}
	
	
	 public DocVector getLengthNormalizedReuseId(){
	        DocVector docVector = new DocVector(this.docID);

	        for ( Entry<Integer, Double> entry : mapVectors.entrySet() )
	        {
	        	int key = entry.getKey();
	        	double value = entry.getValue();
	        	docVector.addValue(key, value);
	        }

	      
	        docVector.scalarMultiply((double) 1/docVector.length());
	        return docVector;
	    }
	
	 public void scalarMultiply( double scalar ) 
	 {
	        Iterator<Integer> keysIter = mapVectors.keySet().iterator();
	        while (keysIter.hasNext())
	        {
	            Integer key = keysIter.next();
	            Double newValue = mapVectors.get(key)*scalar;
	            mapVectors.put(key, newValue);
	        }
	  }
	 
	 public static DocVector scalarMultiply( DocVector d1, double scalar) 
	 {
		 	
		 	
	        Iterator<Integer> keysIter = d1.getMap().keySet().iterator();
	        while (keysIter.hasNext())
	        {
	            Integer key = keysIter.next();
	            Double newValue = d1.getMap().get(key)*scalar;
	            d1.getMap().put(key, newValue);
	        }
			return d1;
	  }
	
	
	
	
	
	

}
