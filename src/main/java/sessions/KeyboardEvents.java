package sessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardEvents {

	WebDriver driver;

	@Test
	public void test() throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 10);

		Actions action = new Actions(driver);
		WebElement firstname = driver.findElement(By.xpath("//*[@name='firstname']"));
		WebElement lastname = driver.findElement(By.xpath("//*[@name='lastname']"));
		firstname.sendKeys(Keys.CONTROL);
		firstname.sendKeys("parimal");
		action.sendKeys(firstname, Keys.TAB).perform(); // to press tab button in firstname field
		action.sendKeys(Keys.TAB).perform(); // to press tab button again
		action.sendKeys(Keys.SPACE).perform(); // to press Space button

		action.click(firstname);					// to press CTRL+A button to select all
		action.keyDown(Keys.CONTROL);
		action.sendKeys("a");
		action.keyUp(Keys.CONTROL);
		action.build().perform();
		
		action.keyDown(Keys.CONTROL);			// to press CTRL+C to copy content selected
		action.sendKeys("c");
		action.keyUp(Keys.CONTROL);
		action.build().perform();	
		
		action.click(lastname);					// to press CTRL+V to paste content copied
		action.keyDown(Keys.CONTROL);
		action.sendKeys("v");
		action.keyUp(Keys.CONTROL);
		action.build().perform();	
		
		
		
		// to perform copy paste action in method chaining way
		action.click(firstname).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		action.click(lastname).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

		Thread.sleep(5000);

		driver.close();
	}

}
