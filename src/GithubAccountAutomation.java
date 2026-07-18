import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GithubAccountAutomation {

	public static void main(String[] args) {
		

		ChromeOptions options = new ChromeOptions();  //Chrome Options
		options.addArguments("--start-maximized");    //Maximising the window
		
		WebDriver wd = new ChromeDriver(options);     //Invoking the chrome driver with options
		
		wd.get("https://github.com/signup");
		
		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
		
		By emailTextBoxLocator = By.id("email");
		WebElement emailTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(emailTextBoxLocator));
		emailTextBox.sendKeys("praveen1234@gmail.com");
		
		By passwordTextBoxLocator = By.id("password");
		WebElement passwordTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTextBoxLocator));
		passwordTextBox.sendKeys("praveen1234@");
		
		By userNameTextBoxLocator = By.id("login");
		WebElement userNameTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(userNameTextBoxLocator));
		userNameTextBox.sendKeys("praveen123456");
		
		By countryDropDownButtonLocator = By.xpath("//button[contains(@id,'select-panel')]");
		WebElement countryDropDownButton = wait.until(ExpectedConditions.visibilityOfElementLocated(countryDropDownButtonLocator));
		countryDropDownButton.click();
		
		By countrySearchBoxLocator = By.xpath("//input[contains(@id,'select-panel') and @type='search']");
		WebElement countrySearchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(countrySearchBoxLocator));
		countrySearchBox.sendKeys("Albania");
		
		By countryButtonLocator = By.xpath("//span[contains(text(),'Albania')]/..");
		WebElement countryButton= wait.until(ExpectedConditions.visibilityOfElementLocated(countryButtonLocator));
		countryButton.click();
		
		

	}

}
