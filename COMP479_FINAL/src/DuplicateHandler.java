import java.util.ListIterator;

import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.Instance;
import net.sf.javaml.distance.EuclideanDistance;


public class DuplicateHandler {
	
	public static Dataset removeDuplicates(Dataset currentSet)
	{
		Dataset finalSet = currentSet.copy();
		ListIterator<Instance> it = currentSet.listIterator();
		int currentIndex =1;
		while(it.hasNext())
		{
			
			Instance outerInstance = it.next();
			if(currentIndex > finalSet.size())
				break;
			ListIterator<Instance> it2 = finalSet.listIterator(currentIndex);
			
			while(it2.hasNext())
			{
				Instance innerInstance = it2.next();
				EuclideanDistance ed = new EuclideanDistance();
				double distance = ed.calculateDistance(outerInstance, innerInstance);
				if(distance == 0)
				{
					
					it2.remove();
					
				}
			}
			currentIndex++;
		}
		
		return finalSet;
		
	}

}
