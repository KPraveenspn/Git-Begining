import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

//1. Give me the count of links on the page
		//a
		//2. Count of footer section
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));   // Limiting the web driver scope
		
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		
		//3. count the link in 1st coloumn of footer section
		WebElement coloumndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		
		System.out.println(coloumndriver.findElements(By.tagName("a")).size());
		
		//4. click on each link in the coloumn and check if pages are opening- 
		for(int i=1; i<coloumndriver.findElements(By.tagName("a")).size(); i++)
		{
			
			String clickonlinktab = Keys.chord(Keys.COMMAND,Keys.ENTER);
			
			coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinktab);
			Thread.sleep(5000L);
			
		}  // Opens all the tabs
		
			Set<String> abc=driver.getWindowHandles(); //4
			Iterator<String> it=abc.iterator();
			
			while(it.hasNext())                         // It will iterate all the tabs to give the title
			{
				
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
				
			}
			
			
		
		
		
		
		
	}

}
