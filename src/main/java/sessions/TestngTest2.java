package sessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestngTest2 extends Basepage {

	@Test
	public void openInstagram() {

		driver.navigate().to("https://www.instagram.com/?hl=en");
		driver.manage().window().maximize();
	}
	
	@Test(priority=1,enabled=true)
	public void openYoutube()  {

		driver.navigate().to("https://www.youtube.com/");
		driver.manage().window().maximize();
	}	
	
	

}
