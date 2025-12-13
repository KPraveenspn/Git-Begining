import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelIntroduction {

	public static void main(String[] args) {
		
		//Invoking drivers
		//Chrome - chromeDriver  -> Methods 
		// WebDriver close get
		//WebDriver Methods + class methods 
		
		//   chromedrive.exe  -> Chrome browser
		// Step to invoke chrome driver 
		// Selenium Manager
		//System.setProperty("webdriver.chrome.driver", "/Users/praveenkumar/Documents/chromedriver-mac-arm64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        ////driver.close();                              //close the current window 
        //driver.quit();                               //close all associated window
        
        
        //Firefox Launch
        //geckodriver
        
        //Webdriver.gecko.driver
        //System.setProperty("webdriver.chrome.driver", "/Users/praveenkumar/Documents/chromedriver-mac-arm64/chromedriver");
        //WebDriver driver = new FirefoxDriver();
        
        
        
        
        
        
	}

}
