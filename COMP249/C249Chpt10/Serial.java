// Serial.java
//
// Serialization allows us to write the "state" of an object to disk and read it back 
// in later. It is quite easy to do. In this case, we will create an array of 
// animal objects and serialize/de-serialize the array to disk. We use the 
// ObjectOutputStream to serialize object and the ObjectInputStream to 
// deserialize objects.

import java.io.*;

// an animal class. Nothing fancy - just some fileds and basic method. When we serialize
// this object, java will store the value of the instance variables.

class animal implements Serializable{

	String name;
	int age;
	int weight;

	public animal(String name, int age, int weight){
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
	
	public String toString(){
		return ("Name = " + name + ", Age = " + age + ", Weight = " + weight);
	}
	
}


public class Serial {

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		
		// create an array of 5 animal objects
		animal[] myAnimals = new animal[5];
		myAnimals[0] = new animal("Bob", 14, 57);
		myAnimals[1] = new animal("Amanda", 14, 57);
		myAnimals[2] = new animal("Sammy", 3, 578);
		myAnimals[3] = new animal("Popeye", 141, 37);
		myAnimals[4] = new animal("Helen", 34, 454);
		
		// print the animal array
		System.out.println("The original animal list:");
		for(int i = 0; i < myAnimals.length; i++){
			System.out.println(myAnimals[i]);
		}
		
		// Use the ObjectOutputStream for serialization
		String outFile = "ObjectOutput.ser";
		ObjectOutputStream objectOut = 
			new ObjectOutputStream( new FileOutputStream (outFile));
		
		// write the objects in a loop
		for(int i = 0; i < myAnimals.length; i++){
			objectOut.writeObject(myAnimals[i]);
		}
		objectOut.close();
		
		
		// reverse the process to de-serialize
		ObjectInputStream objectIn = 
			new ObjectInputStream( new FileInputStream (outFile));
		
		animal[] myNewAnimals = new animal[5];
		for(int i = 0; i < myAnimals.length; i++){
			myNewAnimals[i] = (animal)objectIn.readObject();
		}
		objectIn.close();
		
		
		// print the de-serialized objects
		System.out.println("\nThe de-serialized animal list:");
		for(int i = 0; i < myNewAnimals.length; i++){
			System.out.println(myNewAnimals[i]);
		}
		
	}
}
