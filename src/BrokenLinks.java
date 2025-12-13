import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
//		
//		//broken links
//		//Step 1 - Is to get all the url's tied up to the links using selenium
//		// Java Methods will call the URL's and get you the status code 
//		// if status code >400 then that url is not working -> link tied up to url is broken
//		// ('a[href*="soapui"]')
//		
//		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//		
//		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
//		
//		SoftAssert a = new SoftAssert();
//		
//		for(WebElement link : links)
//		{
//
//			String url = link.getAttribute("href");
//			
//			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
//			conn.setRequestMethod("HEAD");
//			conn.connect();
//			int respcode = conn.getResponseCode();
//			
//			System.out.println(respcode);
//			
//		
//			
//			a.assertTrue(respcode<400, "The link with text "+link.getText()+" is broken with code "+respcode);
//			
//		}
//		
//		a.assertAll();
//			
		
		
		driver.get("http://www.deadlinkcity.com/");


        List<WebElement> links = driver.findElements(By.tagName("a"));
        
		for (WebElement link : links) {
            String url = link.getAttribute("href");

            if (url == null || url.isEmpty()) {
                System.out.println("URL is empty/skipped");
                continue;
            }

            try {
                HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
                conn.setRequestMethod("HEAD");
                conn.connect();

                int responseCode = conn.getResponseCode();


                        if (responseCode >= 400)
                            System.out.println(url + " --> Broken link (Status: " + responseCode + ")");
                        else
                            System.out.println(url + " --> Valid link");

                    } catch (Exception e) {
                        System.out.println(url + " --> Exception: " + e.getMessage());
                    }
                });

        driver.quit();
	}

}
