import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");    //navigating to website
		
		driver.findElement(By.xpath("//a[contains(text(),'Free Access to')]")).click();
		Set<String> windows = driver.getWindowHandles();     //[parentid, childid]
		
		Iterator<String> it = windows.iterator();
		String parentID = it.next();       // Parent Id
		String childID = it.next();       // Child Id
		
		driver.switchTo().window(childID);    //Switching to child window
		
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());  //printing the child window title
		
		driver.findElement(By.cssSelector(".im-para.red")).getText();
		String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		
		driver.switchTo().window(parentID);    //Switching back to parent window
		
		driver.findElement(By.id("username")).sendKeys(emailId);
		
		
	}

}
