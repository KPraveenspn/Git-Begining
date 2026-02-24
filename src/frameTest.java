import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriver driver = new ChromeDriver();   //Initializing WebDriver
		
		driver.get("https://jqueryui.com/droppable/");    //Navigating to Website
//		driver.switchTo().frame(1);
		
		System.out.println(driver.findElements(By.tagName("iframe")).size()); 
		driver.switchTo().frame(0);
//		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class=\"demo-frame\"]")));
//		driver.findElement(By.id("draggable")).click();
		
		Actions a = new Actions(driver);     //Action class
		WebElement source = driver.findElement(By.id("draggable"));     //Source Frame id
		WebElement target = driver.findElement(By.id("droppable"));     //Target Frame id
		
		a.dragAndDrop(source, target).build().perform();     
		driver.switchTo().defaultContent();
		
		
	}

}
