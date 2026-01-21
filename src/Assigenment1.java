import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assigenment1 {
	
	public static void main(String[] arg)
	{
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com");
		
		WebElement userid = driver.findElement(By.id("userid"));
		WebElement password = driver.findElement(By.linkText("secret_sauce"));
		
		
		userid.click().sendkeys(standard_user);
		password.click().sendkeys(secret_sauce);
		
		driver.findElement(By.id("login")).click(); // to login on portal for valid credentials
		
		// for invalid login
		
		driver.findElement(By.xpath("//input[contains(text(),'wrong_user')]")).click().sendkeys();
		driver.findElement(By.xpath("//input[contains(text(),'wrong_pass')]")).click().sendkeys();
		
		
		driver.findElement(By.id("login")).click();  //trying to login with invalid credentails 
		
		
	}

}
