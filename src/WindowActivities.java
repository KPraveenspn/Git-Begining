import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.setProperty("webdriver.chrome.driver", "/Users/praveenkumar/Documents/chromedriver-mac-arm64/chromedriver");
		
        WebDriver driver = new ChromeDriver();    //Initializing the WebDriver
        
        driver.manage().window().maximize();     //To maximize the window6
        
        driver.get("http://google.com");    //Launching google chrome
        
        driver.navigate().to("https://rahulshettyacademy.com"); //Navigating to website
        
        driver.navigate().back();       //navigating backward 
        
        driver.navigate().forward();    //navigating forward 
		
		
	}

}
