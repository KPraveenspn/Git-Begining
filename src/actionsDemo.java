import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=155259813593&hvpone=&hvptwo=&hvadid=674893540034&hvpos=&hvnetw=g&hvrand=4522294025588933581&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9301594&hvtargid=kwd-64107830&hydadcr=14452_2316413&gad_source=1");
		Actions a=new Actions(driver);
		WebElement move=(driver.findElement(By.cssSelector("a[data-csa-c-slot-id='nav-link-accountList']")));
		
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		//moves to specific element
		// context click is used to right click the element
		a.moveToElement(move).contextClick().build().perform();
		
		

	}

}
