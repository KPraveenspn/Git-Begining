import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

public class Miscelleanous {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	//	driver.manage().deleteCookieNamed("sessionkey");  // to delete a specified cookies 
		
		
		driver.get("http://google.com");
		// Thread.sleep(3000);
		 
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);   // this step take the screenshot
		
	     FileUtils.copyFile(src, new File("/Users/praveenkumar/downloads/screenshot.png"));  // this will save screenshot in local folder 
	
		
	}

}
