import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @author Klajdi_Karanxha
 * @project COMP479 - Final Project
 */
public class KMeansClustering 
{
	//Class Atributtes
	
	private int k;
	private double totalRSS;
	private List<CustomInstance> vectorSpace;
	
	//CONSTRUCTOR
	
	private KMeansClustering()
	{}
	
	public KMeansClustering(int k, List<CustomInstance> vecSpace)
	{
		this.k = k;
		this.totalRSS = 0;
		this.vectorSpace = vecSpace;
	}
	
	//Getters / Setters
	
	public int getK()
	{
		return this.k;
	}
	
	public double getTotalRSS()
	{
		return this.totalRSS;
	}
	
	public List<CustomInstance> getVectorSpace()
	{
		return this.vectorSpace;
	}
	
	//Operations
	
	/**
	 * K-Means algorithm to cluster a Vectorspace
	 */
	public ClusteredCollection  clusterVectorSpace()
	{
		//PHASE 1 - PREPARATION------------------------------------------------------
		
		//Logging the start time
		long startTime = System.currentTimeMillis();
		
		//Final collection of clustered documents to be returned
		ClusteredCollection clusteredCollection = new ClusteredCollection();
		
		//Array of cluster Sets
		ClusterSet[] clusterSet   = new ClusterSet[this.k];
		
		//Initialize empty clusters
		for(int i = 0; i <= clusterSet.length -1; i++)
		{
			clusterSet[i] = new ClusterSet(i);
		}
		
		//Initialize stop criteria to FALSE
		boolean stopCriteria = false;
		
		//Random initial centroids (doc id's)
		CustomInstance[] centroid = this.generateRandomCentroids();
		//Instance[] centroid = this.generateRandomCentroids();
		
		//Assign those random centroids to a cluster set each
		for(int i = 0; i <= clusterSet.length -1; i++)
		{
			clusterSet[i].setCentroid(centroid[i]);
		}
		

		//Initialize glogalRSS to max - goal is to minimize it
		this.totalRSS = Double.MAX_VALUE;
		int iterationCounter = 0;
		
		
		//end of PHASE 1 ------------------------------------------------------------
		
		
		//PHASE 2 - CLUSTERING-------------------------------------------------------
		
		
		while(!stopCriteria)
		{
			//Print iteration
			System.out.println("Clustering - Iteration: "+iterationCounter);
			
			
			//Empty the cluster sets
			for(int i = 0; i <= clusterSet.length-1; i++)
			{
				clusterSet[i].getClusterSet().clear();
				clusterSet[i].setRSS(0);
			}
			
			//Iterator<CustomInstance> docIterator = this.vectorSpace.iterator();
			//Iterate through all the documents
			Iterator<CustomInstance> docIterator = this.vectorSpace.iterator();
			int docCounter = 0;
			while(docIterator.hasNext())
			{
				//FOR EVERY DOCUMENT VECTOR
				//System.out.println("Document (Iteration) : "+docCounter);
				
				//Get the docVector
				
				
				CustomInstance document = docIterator.next();
				
				//compute distance from each centroid vector
				double minDistance = Double.MAX_VALUE;
				int assignedCluster = -99;
				
				//System.out.println("Before Loop");
				//iterate through the clusters
				for(int i =0; i <= this.k-1; i++)
				{   
					//Compute distance from current Doc to current Cluster Centroid Vector
					double distance = document.euclideanDistance(clusterSet[i].getCentroid());
					//check if it belongs to this cluster or not
					if(distance < minDistance)
					{
						assignedCluster = i;
						minDistance = distance;
					}
				}
				
				//insert the docVector to the cluster where its distance from that cluster is minimal
				clusterSet[assignedCluster].getClusterSet().add(document);
				
				//update rss of the cluster
				clusterSet[assignedCluster].addToRSS(minDistance * minDistance);
				
				//udpate doc counter
				docCounter++;
			}// end of doc iterator
			
			//Iterate through all the cluster sets to recompute the centroids
			for(int i =0; i <= this.k-1; i++)
			{
				if(!(clusterSet[i].getClusterSet().size() == 0))
				{
					
					//recompute the centroids
					clusterSet[i].computeCentroid();

				}
			}
			
			//Re-evaluate totalRSS
			double newTotalRSS = 0;
			for(int i =0; i <= clusterSet.length-1; i++)
			{
				newTotalRSS += clusterSet[i].getRSS();
			}
			System.out.println("Total RSS is: "+ newTotalRSS);
			System.out.println("Ratio is: "+ (newTotalRSS/totalRSS));
			stopCriteria = (newTotalRSS/totalRSS) > 0.99; // manual set the optimization
			
			this.totalRSS = newTotalRSS;

			//Print iteration end info
			System.out.println("END OF Clustering Iteration: "+iterationCounter);
			iterationCounter++;

		}
		
		
		//end of PHASE 2 ---------------------------------------------------------------
		
		
		//PHASE 3 - COLLECT RESULT------------------------------------------------------
		
		//add all sets to the collection
		for(int i =0; i <= this.k-1; i++)
		{
			clusteredCollection.add(clusterSet[i]);	
		}
		//end of PHASE 3 ------------------------------------------------------------
		
		 //PHASE 4 - RETURN CLUSTERED COLLECTION ------------------------------------------------
		//Return the clusterd collection of documents
		
		long clusteringTotalTime =  System.currentTimeMillis() - startTime;
        System.out.println("Clustering Process ended after: " + clusteringTotalTime/1000 + " sec");
		return clusteredCollection;
		//end of PHASE 4 -------------------------------------------------------------------------
	}
	
	
	//HELPER METHODS
	
	private CustomInstance[] generateRandomCentroids()
	{
       // Instance[] seeds = new Instance[this.k];
        CustomInstance[] seeds = new CustomInstance[this.k];
        
        //initialize seeds
        for(int i=0; i<= this.k-1; i++)
        {
        	//seeds[i] = new SparseInstance();
        	seeds[i] = new CustomInstance();
        	
        }
        
        Random randomGenerator = new Random();
        
        
        for(int i =0; i <= seeds.length-1; i++)
        {
        	int randomSeed = randomGenerator.nextInt(this.vectorSpace.size()-1);
        	CustomInstance instance = this.vectorSpace.get(randomSeed);
        	seeds[i] = instance;

        }
        return seeds;
    }
}
