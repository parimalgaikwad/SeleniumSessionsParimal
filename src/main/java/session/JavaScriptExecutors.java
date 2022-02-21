package session;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutors {
	WebDriver driver;
	
	@Test
	public void test() {
	
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.navigate().to("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
	driver.manage().window().maximize();
	
	JavascriptExecutor js = (JavascriptExecutor) driver;

	try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}

	js.executeScript("window.scrollBy(0,500)", "");   // to scroll down

	try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	js.executeScript("window.scrollBy(0,-500)", "");   // to scroll up

	

	}
}
