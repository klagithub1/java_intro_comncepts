// BufferedSerializeTest.java
//
// A test of the difference between buffered serialization and unbuffered serialization. 
// The timings are done with a StopWatch class that is also provided with the sources 
// files from this class.


import java.io.*;

// a simple animal class - a few instance variables and some get/set methods
class animal2 implements Serializable {

	String name;
	int age;
	int weight;

	public animal2(String name, int age, int weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}

	String getName(){
		return name;
	}
	 
	void setName(String name){
	 	this.name = name;
	}
	
	int getAge(){
		return age;
	}
	 
	void setAge(int age){
		this.age = age;
	}
		
	int getWeight(){
		return weight;
	}
	 
	void setWeight(int weight){
		this.weight = weight;
	}
	
}





public class BufferSerializeTest {

	static int count;
	static animal2[] myAnimals;
	
	public static void main ( String[] aArguments ) throws IOException{
  	
		// create buffered output stream 
		ObjectOutputStream bufferedOut = 
			new ObjectOutputStream( new BufferedOutputStream (new FileOutputStream ("SerialOutput1.ser")));
		
		// create unbuffered output stream
		ObjectOutputStream unbufferedOut = 
			new ObjectOutputStream( new FileOutputStream ("SerialOutput2.ser"));
		
		// create array of animal objects
		myAnimals = new animal2[20000];
		for(int i = 0; i < 20000; i++)
			myAnimals[i] = new animal2("Bob", 14, 57);
	
		
		StopWatch stopwatch = new StopWatch();
    
		// test the buffered output
		stopwatch.start();
		serializeWithBuffer(bufferedOut);
		stopwatch.stop();
		System.out.println("With buffering: " + stopwatch);

		// test the unbuffered output
		stopwatch.start();
		serializeWithoutBuffer(unbufferedOut);
		stopwatch.stop();
		System.out.println("Without buffering: " + stopwatch);
	}

  
  
  	
	static void serializeWithBuffer(ObjectOutputStream objectOut) throws IOException{
		
		for(int i = 0; i < myAnimals.length; i++){
			objectOut.writeObject(myAnimals[i]);
		}
		objectOut.close();
	}
  
	
	static void serializeWithoutBuffer(ObjectOutputStream objectOut)throws IOException {
	
		for(int i = 0; i < myAnimals.length; i++){
			objectOut.writeObject(myAnimals[i]);
		}
		objectOut.close();
	}
} 
