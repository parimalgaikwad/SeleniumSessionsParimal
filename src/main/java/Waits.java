
package session;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Waits {

	WebDriver driver;

	@Test
	public void test() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
		driver.manage().window().maximize();

		// for expected condition of text to be present

		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement text = driver.findElement(By.xpath("//*[@id='h2']")); // element whose text changes after clicking on
																			// populateText button
		System.out.println("text before change :" + text.getText());
		WebElement populateText = driver.findElement(By.xpath("//*[@id='populate-text']"));
		populateText.click();
		wait.until(ExpectedConditions.textToBePresentInElement(text, "Selenium Webdriver")); // waits until text changes
																								// to "Selenium
																								// Webdriver"
		System.out.println("text after change :" + text.getText());

		// for expected condition of visibility

		WebElement hidden = driver.findElement(By.xpath("//*[@id='hidden']")); // element for whome visibility needs to
																				// be checked
		System.out.println("Element visible before click :" + hidden.isDisplayed());
		WebElement diplayOtherButton = driver.findElement(By.xpath("//*[@id='display-other-button']"));
		diplayOtherButton.click();
		wait.until(ExpectedConditions.visibilityOf(hidden));
		System.out.println("Element visible after click :" + hidden.isDisplayed());

		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();

	}
}