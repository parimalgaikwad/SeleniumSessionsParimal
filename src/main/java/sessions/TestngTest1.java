package sessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestngTest1 extends Basepage {

	@Test(enabled=false,priority=1)
	public void openFacebook() {

		driver.navigate().to("https://www.facebook.com/");
		driver.manage().window().maximize();
	}

	@Test(priority=1)
	public void openGoogle() {

		driver.navigate().to("https://www.google.com/");
		driver.manage().window().maximize();
	}

	
}
