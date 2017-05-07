    
     // Using algorithms reverse, fill, copy, min and max.
import java.util.*;

import java.util.Collections;
   
public class Algorithms {
   private String letters[] = { "P", "C", "M" }, lettersCopy[];
   private List<String> list, copyList;
     
        // create a List and manipulate it with methods from Collections
   public void tryMe() {       
          list = Arrays.asList(letters);     // get List
          lettersCopy = new String[3];
          copyList = Arrays.asList(lettersCopy);
    
          System.out.println("Initial list: ");
          output(list);
    
          Collections.reverse(list);         // reverse order
          System.out.println("\nAfter calling reverse: ");
          output(list);
    
          Collections.copy(copyList, list);  // copy List
          System.out.println("\nAfter copying: ");
          output(copyList );
          Collections.fill(list, "R");       // fill list with Rs
          System.out.println("\nAfter calling fill: ");
          output(list);
   } 
    
    // output List information
   private void output(List listRef)
   {
      System.out.print("The list is: ");
   
       for (int k = 0; k < listRef.size(); k++)
          System.out.print(listRef.get(k) + " " );
    
       System.out.print("\nMax: " + Collections.max(listRef));
       System.out.println("  Min: " + Collections.min(listRef));
   }
   

   public static void main(String args[]) {
     Algorithms test = new Algorithms();
     test.tryMe();
   }                                               
} 

   
