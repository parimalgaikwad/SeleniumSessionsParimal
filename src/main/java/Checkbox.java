

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox {

	WebDriver driver;

	@Test
	public void test() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
		driver.manage().window().maximize();

		WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));  // to click checkbox
		Boolean statusBeforeClick = checkbox.isSelected();
		System.out.println(statusBeforeClick);
		checkbox.click();
		Boolean statusAfterClick = checkbox.isSelected();
		System.out.println(statusAfterClick);

	}
}