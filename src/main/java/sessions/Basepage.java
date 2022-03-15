package sessions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basepage {
	
	public static WebDriver driver;
	public static Properties config;

	public Basepage() {
		
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\Files\\Log4j.properties");

		config = new Properties();
		try {
			config.load(new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
//	@AfterClass(alwaysRun = true)
	public void tearDown() {
		System.out.println("test tear down");

		driver.quit();

	}

	@BeforeClass(alwaysRun= true)
	public void driverSetup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("test setup");
		
	}

}

