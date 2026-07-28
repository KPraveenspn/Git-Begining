import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NaukriAutomation {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();  //Chrome Options
		options.addArguments("--start-maximized");    //Maximising the window
		
		WebDriver wd = new ChromeDriver(options); 
		
		wd.get("https://www.naukri.com/nlogin/login");
		
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(60));      //Explicit Wait
		
		By emailTextBoxLocator = By.id("usernameField");      //Locator using By class 
		WebElement emailTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(emailTextBoxLocator));
		emailTextBox.sendKeys("kpraveenspn@gmail.com");     //Action step
		
		By passwordTextBoxLocator = By.id("passwordField");     //Locator using By class 
		WebElement passwordTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTextBoxLocator));
		passwordTextBox.sendKeys("Praveen@5752");        //Action step
		
		By loginButtonLocator = By.xpath("//button[contains(@class,'blue-btn')]");
		WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButtonLocator));
		loginButton.click();
		
		By profileButtonLocator = By.xpath("//button[@aria-label='Open profile menu']");
		WebElement profileButton = wait.until(ExpectedConditions.visibilityOfElementLocated(profileButtonLocator));
		profileButton.click();
		
		By profileUpdateButtonLocator = By.xpath("//a[contains(text(),'View & Update Profile')]");
		WebElement profileUpdateButton = wait.until(ExpectedConditions.visibilityOfElementLocated(profileUpdateButtonLocator));
		profileUpdateButton.click();
		
//		By careerEditLocator = By.xpath("//span[contains(text(),'Career profile')]/parent::*//*[contains(@class,'edit')]");
//		WebElement careerEditIcon = wait.until(ExpectedConditions.elementToBeClickable(careerEditLocator));
//		careerEditIcon.click();
		
		JavascriptExecutor js = (JavascriptExecutor) wd;

		// Scroll down in steps to trigger lazy-load sections
		long lastHeight = (long) js.executeScript("return document.body.scrollHeight");
		while (true) {
		    js.executeScript("window.scrollBy(0, 800);");
		    Thread.sleep(500); // let lazyload fire and content render

		    long newHeight = (long) js.executeScript("return document.body.scrollHeight");
		    if (newHeight == lastHeight) {
		        break; // reached bottom, no more new content loading
		    }
		    lastHeight = newHeight;
		}
		
		By careerEditLocator = By.xpath("//span[contains(@class,'widgetTitle') and normalize-space(text())='Career profile']/following-sibling::span[contains(@class,'edit')]");
		WebElement careerEditIcon = wait.until(ExpectedConditions.presenceOfElementLocated(careerEditLocator));
		

		js.executeScript(
		    "var el = arguments[0];" +
		    "var header = document.querySelector('.nI-gNb-header__wrapper');" +
		    "var headerHeight = header ? header.getBoundingClientRect().height : 0;" +
		    "var elRect = el.getBoundingClientRect();" +
		    "var scrollY = window.pageYOffset + elRect.top - headerHeight - 20;" + // 20px extra buffer
		    "window.scrollTo(0, scrollY);",
		    careerEditIcon
		);

		Thread.sleep(500);
		
		wait.until(ExpectedConditions.elementToBeClickable(careerEditIcon));
		careerEditIcon.click();
		
		//Updating the Expected Salary
		
		By salaryInputLocator = By.cssSelector("input.currency-input");
		WebElement salaryInput = wait.until(ExpectedConditions.visibilityOfElementLocated(salaryInputLocator));

		js.executeScript("arguments[0].scrollIntoView({block:'center'});", salaryInput);
		Thread.sleep(300);

		// Read and clean current value
		String currentValueRaw = salaryInput.getAttribute("value");
		int currentValue = Integer.parseInt(currentValueRaw.replaceAll("[^0-9]", ""));
		int newValue = (currentValue == 550000) ? 560000 : 550000;

		// Click and select all
		salaryInput.click();
		salaryInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		salaryInput.sendKeys(Keys.DELETE);

		// Verify field actually cleared — if not, force-clear with backspaces
		String afterClear = salaryInput.getAttribute("value");
		int guard = 0;
		while (!afterClear.isEmpty() && guard < 15) {
		    salaryInput.sendKeys(Keys.BACK_SPACE);
		    afterClear = salaryInput.getAttribute("value");
		    guard++;
		}

		// Type digits only — no commas, let the field auto-format
		salaryInput.sendKeys(String.valueOf(newValue));

		// Confirm it updated correctly
		String updatedValueRaw = salaryInput.getAttribute("value");
		int updatedValueClean = Integer.parseInt(updatedValueRaw.replaceAll("[^0-9]", ""));

		System.out.println("Field now shows: " + updatedValueRaw);
		if (updatedValueClean == newValue) {
		    System.out.println("Value updated correctly.");
		} else {
		    System.out.println("MISMATCH — expected " + newValue + " but field shows " + updatedValueClean);
		}

		// Click Save
		By saveButtonLocator = By.id("saveDesiredProfile");
		WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(saveButtonLocator));
		saveButton.click();
		
	}

}
