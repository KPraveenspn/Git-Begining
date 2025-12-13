import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {

	// Count the no of names starting with "A"
	
	//@Test
	public void regular()
	{
		ArrayList<String> names=new ArrayList<String>();
		names.add("Abhi");
		names.add("Jon");
		names.add("Anshu");
		names.add("Alok");
		names.add("Ram");
		
		int count=0;
		for(int i=0; i<names.size(); i++)
		{
			String actual=names.get(i);
			if(actual.startsWith("A"))
			{
				count++;
			}
		}
		System.out.println(count);
		
	}


     //@Test
     public void streamFilter()
     {
    	 ArrayList<String> names=new ArrayList<String>();
 		names.add("Abhijeet");
 		names.add("Jon");
 		names.add("Anshu");
 		names.add("Alok");
 		names.add("Ram");
 		//there is no life of intermediate operation if there is no terminal opt. 
 	   //terminal operation will execute only if intermediate operation (Filter) returns true
 	   //We can create stream
 	  //how to use filter in stream API 
     
     Long c=names.stream().filter(s->s.startsWith("A")).count();
     System.out.println(c);
     
     Long d=Stream.of("Abhi","Jon","Anshu","Alok","Ram").filter(s->
     {
    	 s.startsWith("A");
    	 return true;
    	 
     }).count();
     
     System.out.println(d);
     
         // Print all the names of ArrayList
     names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
     names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));   //apply the limit of o/p
     
     }

      //@Test
      public void streamMap()
      {
    	  ArrayList<String> names=new ArrayList<String>();
   		names.add("men");
   		names.add("Jon");
   		names.add("women");
    	 //print the names which has latter as "a" with uppercase 
    	Stream.of("Abha","Jon","Anshu","Alok","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
    	  .forEach(s->System.out.println(s));
    	  
    	  //print names which have first latter as "a" with uppercase and sorted
    	  
    	  List<String> names1=Arrays.asList("Abha","Jon","Anshu","Alok","Rama");
    	 names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase())
    	  .forEach(s->System.out.println(s));
    	  
    	  //Merging 2 different lists
    	  Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
    	  newStream.sorted().forEach(s->System.out.println(s));
    	  
    	  boolean flag=newStream.anyMatch(s->s.equalsIgnoreCase("Alok"));
    	  //System.out.println(flag);
    	  Assert.assertTrue(flag);
    	  
      }
      
      @Test
      public void streamCollection()
      {
    	  //converting streams to the list
    	  List<String> ls=Stream.of("Abha","Jon","Anshu","Alok","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
    			            .collect(Collectors.toList());
    	//  System.out.println(ls.get(0));
    	  
    	  List<Integer> values=Arrays.asList(3,2,2,7,5,1,9,7);
    	  //print unique no from this array
    	  //sort the array - 3rd index
    	  
    	  values.stream().distinct().forEach(s->System.out.println(s));
    	  List<Integer> li= values.stream().distinct().sorted().collect(Collectors.toList());
    	  System.out.println(li.get(2));
      
      }
}   
