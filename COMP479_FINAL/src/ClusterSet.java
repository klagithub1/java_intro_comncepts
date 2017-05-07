import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author Klajdi_Karanxha
 *
 */
public class ClusterSet 
{
	//ATTRIBUTES
	private List<CustomInstance> clusterDocuments;
	private CustomInstance centroid;
	private double rss;
	private String name;
	
	//CONSTRUCTOR
	public ClusterSet()
	{
		this.clusterDocuments = new ArrayList<CustomInstance>();
		this.centroid = null;
		this.rss = 0 ;
		name = "";
	}
	
	public ClusterSet(int clusterID)
	{
		this.clusterDocuments = new ArrayList<CustomInstance>();
		this.centroid = null;
		this.rss = 0 ;
		name = "Cluster"+clusterID;
	}
	
	//GETTERS / SETTERS
	
	public ArrayList<CustomInstance> getClusterSet()
	{
		return  (ArrayList<CustomInstance>) this.clusterDocuments;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRSS()
	{
		return this.rss;
	}
	
	public CustomInstance getCentroid()
	{
		return this.centroid;
	}
	
	public void setRSS(double rss)
	{
		this.rss = rss;
	}
	
	public void setCentroid(CustomInstance c)
	{
		this.centroid = c;
	}
	
	public void addToRSS(double rss)
	{
		this.rss += rss;
	}

	public void computeCentroid()
	{
		if(this.clusterDocuments.size() == 0)
		{
			throw new Error("Cannot Compute Centroid for Empty Set - Shouldn't come here !!!!");
		}
		else if (this.clusterDocuments.size() == 1)
		{
			this.centroid = this.clusterDocuments.get(0);
		}
		else
		{
			CustomInstance sumVector = new CustomInstance();
			sumVector = this.clusterDocuments.get(0); // the first vector is assigned
			//Iterator<Instance> iterator = instanceSet.iterator();
			
			for(int i =1; i <= clusterDocuments.size()-1; i++)
			{
				sumVector = clusterDocuments.get(i).add(sumVector);
			}	
			
			this.centroid = sumVector.multiply((double)1/this.clusterDocuments.size());
		}	
	}

	public boolean contains(String key) {

		Iterator<CustomInstance> it = clusterDocuments.iterator();
		while(it.hasNext())
		{
			CustomInstance current = it.next();
			if(current.getName().equals(key))
				return true;
		}
		return false;
	}
}