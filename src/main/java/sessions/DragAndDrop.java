package sessions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	WebDriver driver;

	@Test
	public void test() throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 10);

		driver.switchTo().frame(0);

		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);

		action.dragAndDrop(draggable, droppable).perform();    //Basic command for drag and drop
		
		
		
		// if normal drag and drop command does not work try option given below
		action.clickAndHold(draggable).pause(Duration.ofSeconds(5)).moveToElement(droppable)
				.pause(Duration.ofSeconds(5)).release().perform();
		action.clickAndHold(draggable).perform();
		
		Thread.sleep(5000);
		driver.close();
	}

}
