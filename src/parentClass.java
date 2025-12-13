import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class parentClass {
	
	public void doThis()
	{
		System.out.println("I am from parent class");
	}

	@BeforeMethod
	public void beforeRun()
	{
		System.out.println("Run me first");
	}
	
	@AfterMethod
	public void afterRun()
	{
		System.out.println("Run me last");
	}
	
}
