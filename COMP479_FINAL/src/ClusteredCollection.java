
import java.util.List;
import java.util.ArrayList;

/**
 * 
 * @author Klajdi_Karanxha
 *
 */
public class ClusteredCollection 
{
	//ATTRIBUTES
	
	private List<ClusterSet> clusteredCollection;
	
	//CONSTRUCTORS
	
	public ClusteredCollection()
	{
		this.clusteredCollection = new ArrayList<ClusterSet>();
	}
	
	//GETTERS / SETTERS 
	
	public ArrayList<ClusterSet> getClusteredCollection()
	{
		return (ArrayList<ClusterSet>) this.clusteredCollection;
	}
	
	public boolean add(ClusterSet cluster)
	{
		if(this.clusteredCollection.add(cluster))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
