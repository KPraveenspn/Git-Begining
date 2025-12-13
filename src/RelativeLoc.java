import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;   //need to import this package manually for relative locators

public class RelativeLoc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
	    WebElement nameEditBox =driver.findElement(By.cssSelector("[name='name']"));
	
	    System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
	    WebElement dateofBirth =driver.findElement(By.cssSelector("[for='dateofBirth']"));
	    driver.findElement(with(By.tagName("input")).below(dateofBirth)).click();
	    
	    WebElement iceCreamlevel =driver.findElement(By.xpath("//label[normalize-space()='Check me out if you Love IceCreams!']"));
	    driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamlevel)).click();
	    
	    WebElement rdb =driver.findElement(By.id("inlineRadio1"));
	    System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());
	    
				
	}

}
