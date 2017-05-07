import java.util.Comparator;
import java.util.Map;

class ValueComparator implements Comparator<Object> {

	Map<String,Double> base;
	public ValueComparator(Map<String,Double> base) 
	{
		this.base = base;
	}

	public int compare(Object a, Object b) 
	{

	    if((Double)base.get(a) < (Double)base.get(b)) {
	      return 1;
	    } else if((Double)base.get(a) == (Double)base.get(b)) {
	      return 0;
	    } else {
	      return -1;
	    }
	    
	}
  
	public String toString()
	{
		String returnString = "";
		for(Map.Entry<String,Double> entry : this.base.entrySet()) 
		{
			String key = entry.getKey();
			double value = entry.getValue();
			
			returnString += key+"\t"+value+"\n";
		}
		return returnString;
	  
	}
}