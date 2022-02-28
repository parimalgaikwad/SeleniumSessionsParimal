package sessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class AlertsLearn {

	WebDriver driver;

	@Test
	public void test() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		WebElement alertWithOk = driver.findElement(By.xpath("//*[@href='#OKTab']"));
		WebElement button = driver.findElement(By.xpath("//*[@onclick='alertbox()']"));
		alertWithOk.click();
		button.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
//		alert.dismiss();
//		alert.sendKeys(null);
	}

}
