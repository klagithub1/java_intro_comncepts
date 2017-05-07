import java.util.*;

class CollectionTest
{   
    public static void main(String [] args)
    {
        List<String> l1 = new ArrayList<String>();
        l1.add("Carol");  l1.add("Amy"); l1.add("Bill"); l1.add("Bill");
                
        List<String> l2 = new LinkedList<String>();
        l2.add("Carol");  l2.add("Amy"); l2.add("Bill"); l2.add("Bill");

        Set<String> s1 = new TreeSet<String>();
        s1.add("Carol");  s1.add("Amy"); s1.add("Bill"); s1.add("Bill");

        Set<String> s2 = new HashSet<String>();
        s2.add("Carol");  s2.add("Amy"); s2.add("Bill"); s2.add("Bill");

        Set<String> s3 = new TreeSet<String>(Collections.reverseOrder());
        s3.add("Carol");  s3.add("Amy"); s3.add("Bill"); s3.add("Bill");
        
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);  
        
        System.out.println();                  
      }
}


