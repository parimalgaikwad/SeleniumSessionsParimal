package sessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAlerts {
	

WebDriver driver;

@Test
public void test() throws Exception {

	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.navigate().to("https://demoqa.com/alerts");
	driver.manage().window().maximize();
	WebDriverWait wait = new WebDriverWait(driver,10);
	
	WebElement alertButton = driver.findElement(By.id("alertButton"));
	alertButton.click();
	Alert alert = 	driver.switchTo().alert();
	Thread.sleep(5000);
	
	alert.accept();

	
	Thread.sleep(10000);
	driver.close();
}

}
