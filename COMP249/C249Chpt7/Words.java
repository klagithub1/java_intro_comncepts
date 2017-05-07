// Words.java
//
// A simple inheritance example. The Dictionary class extends the 
// Book class. In our main method, we simply declare a new Dictionary
// object. We do not need to declare a Book object in order to access
// its inherited methods.

public class Words {

	public static void main(String[] args) {
			  Dictionary webster = new Dictionary();
			  System.out.println ("Number of pages: " + webster.getPages());
			  System.out.println ("Number of definitions: " +
								  webster.getDefinitions());
			  System.out.println ("Definitions per page: " +
								  webster.computeRatio());
	}
	
}

// The base class
class Book {
   private int pages = 1500;

   public void setPages (int numPages){
	  pages = numPages;
   }

   public int getPages (){
	  return pages;
   }
}

// The child class - the Dictionary "is-a" book, it just adds or refines its
// functionality

class Dictionary extends Book{
   private int definitions = 52500;

   public double computeRatio (){
	  return definitions/getPages();
   }

   public void setDefinitions (int numDefinitions){
	  definitions = numDefinitions;
   }

   public int getDefinitions (){
	  return definitions;
   }
}
