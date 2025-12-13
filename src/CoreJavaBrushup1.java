import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJavaBrushup1 {

	public static void main(String[] args) {
		
		//For Loop
		
		String[] name = {"Praveen", "Kumar", "Selenium"};
		
		//for(int i=0; i<name.length; i++)
		//{
			//System.out.println(name[i]);
		//}

		for(String s: name)
		{
			System.out.println(s);
		}
		
		//ArrayList a = new ArrayList();    //object to invoke ArrayList Class
		ArrayList<String> a = new ArrayList<String>();  //For string value
		a.add("Praveen");                  // Method to add element
		a.add("Kumar");                              //a.remove(index value);  //To remove the element
		a.add("Selenium");
		a.add("Java");                        //a.get(index)   ---> to call the value
		System.out.println(a.get(0));
		
		for(int i=0; i<a.size(); i++)
		{
			System.out.println(a.get(i));
		}
		
		for(String val: a)
		{
			System.out.println(val);
		}
		
		//Item present in Array list
		System.out.println(a.contains("Selenium"));
		
		//String[] name = {"Praveen", "Kumar", "Selenium"};
		//List<String> nameArrayList = Arrays.asList(name);  //to convert Array into ArrayList
		
		String name2 = "Praveen Kumar Selenium";
		String[] splittedString = name2.split(" ");      //breaking the string 
		System.out.println(splittedString[0]);
		System.out.println(splittedString[1]);
		
		
		
	}

}
