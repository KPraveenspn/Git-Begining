import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class base {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
 
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);    //implicit wait 
		
		WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(5));
		
		
		String[] itemsNeeded={"Cucumber","Brocolli","Beetroot","Carrot"};    //Array of string type
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");     //navigating to portal 
		
		 Thread.sleep(3000);
		 addItems(driver,itemsNeeded);
		
		 //base b=new base();
		 //b.addItems(driver, itemsNeeded);
		 
		 driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		 
		 driver.findElement(By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']")).click();
		 
		 w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));   //explicit wait - wait until the condition satisfy 
		 
		 driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		 driver.findElement(By.cssSelector("button.promoBtn")).click();
		  
		 
		 w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));   //explicit wait
		 
		 System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		 
		 
		
	}
	
	public static void addItems(WebDriver driver,String[] itemsNeeded)
	{
		 int c=0;

		List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i=0; i<products.size(); i++)
		{
			
			//Brocolli - 1kg
			//Brocolli,  1kg
			
			String[] name=products.get(i).getText().split("-");
			String formattedName=name[0].trim();
			
			//format the name to get the actual vegetable name
			
			//convert array into arrayList for easy search
			//check whether name you extracted is present in arrayList or not 
			
			List itemsNeededList = Arrays.asList(itemsNeeded);
			
			
			 
			if(itemsNeededList.contains(formattedName))
			{
				c++;
				//click on Add to cart
				driver.findElements(By.xpath("//div[@class=\"product-action\"]/button")).get(i).click();
				
				//while using the arrayList you can not use break statement
				//break;
				
				if(c==itemsNeeded.length)
				{
					break;
				}
			
			}
			
		}
	}

}
