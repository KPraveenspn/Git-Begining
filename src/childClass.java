import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class childClass extends parentClass {

	
	@Test
	public void testRun()
	{
		childClass2 cc2=new childClass2(3);    //Parameterized constructor
		int a=3;
		doThis();       //method of parent class
		
		System.out.println(cc2.increment());
		System.out.println(cc2.decrement());
		
		
		System.out.println(cc2.multiplyTwo());
		
		
	}
}
