import net.sf.javaml.core.Instance;
import net.sf.javaml.core.SparseInstance;
import net.sf.javaml.distance.EuclideanDistance;


public class CustomInstance {

	private String name;
	private Instance inst;
	
	public CustomInstance()
	{
		
		name = "";
		inst = new SparseInstance();
	}

	public CustomInstance(int size, String newName)
	{
		
		name = newName;
		inst = new SparseInstance(size);
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Instance getInst() {
		return inst;
	}

	public void setInst(Instance inst) {
		this.inst = inst;
	}
	
	public void put(int index, double value)
	{
		inst.put(index, value);
	}
	
	public double euclideanDistance(CustomInstance second)
	{
		
		EuclideanDistance euc = new EuclideanDistance();
		return euc.calculateDistance(this.getInst(), second.getInst());
	}
	
	public double get(int index)
	{
		
		return inst.get(index);
	}
	
	public  CustomInstance multiply(double value)
	{
		CustomInstance returned = new CustomInstance();
		returned.inst = inst.multiply(value);
		returned.name = "centroid";
		return returned;
	}
	
	public  CustomInstance add(CustomInstance second)
	{
		CustomInstance returned = new CustomInstance();
		returned.inst = inst.add(second.getInst());
		returned.name = this.name;
		return returned;
	}

}
