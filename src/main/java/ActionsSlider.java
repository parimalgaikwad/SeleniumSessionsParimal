
package session;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsSlider {
	WebDriver driver;

	@Test
	public void test() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://jqueryui.com/slider/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,10);

		driver.switchTo().frame(0);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='slider']/span")));
		WebElement mainSlider = driver.findElement(By.xpath("//*[@id='slider']"));
		WebElement slider = driver.findElement(By.xpath("//*[@id='slider']/span"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(slider, mainSlider.getSize().width/2, 0).perform();
//		action.dra
		
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
	}

}