import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");  //Navigating to Amazon website
		
		Thread.sleep(3000);
		
		Actions a=new Actions(driver);   //Action class 
		
		WebElement move=driver.findElement(By.xpath("//a[@aria-controls='nav-flyout-accountList']"));
		
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		//moves to specific element
		// context click is used to right click the element
		a.moveToElement(move).contextClick().build().perform();   //performing the right click
		
		

	}

}
