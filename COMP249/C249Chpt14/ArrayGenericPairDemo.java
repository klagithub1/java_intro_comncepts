
import java.util.Scanner;
import java.util.ArrayList;
public class ArrayGenericPairDemo
{
    
   public static <E> void printArray(E[] inputArray) {
      for (E element : inputArray)
         System.out.print(element + " ");
      System.out.println();
   }


   public static void main(String[] args)
   {
        char[] a1 = {'a', 'b', 'c'};
        char[] a2 = {'a', 'b', 'c'};
                
                 Character[] a3 = {'a', 'b', 'c'};
                 
      /*  Pair<char[]> secretPair = 
             new Pair<char[]>(a1, a2);
             
             ArrayList<String> sList = new ArrayList<String>();
  ArrayList<Object> oList = new ArrayList<Object>();;
  
  sList.add(new Object());
  String string = sList.get(0);*/

printArray(a3);
ArrayGenericPairDemo.<Character>printArray(a3);



      /*  Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter two words:");
        String word1 = keyboard.next();
        String word2 = keyboard.next();
        Pair<String> inputPair = new Pair<String>(word1, word2);
        
        if (inputPair.equals(secretPair))
        {
            System.out.println("You guessed the secret words");
            System.out.println("in the correct order!");
        }
        else
        {
            System.out.println("You guessed incorrectly.");
            System.out.println("You guessed");
            System.out.println(inputPair);
            System.out.println("The secret words are");
            System.out.println(secretPair);
        }*/
   }
}
