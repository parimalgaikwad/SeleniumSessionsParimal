package sessions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoggerUsingLog4j {

	WebDriver driver;
public 	Logger log = Logger.getLogger(LoggerUsingLog4j.class);


@Test
public void test() throws Exception {
	PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\Files\\Log4j.properties");

	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	log.info("Launching browser");

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.navigate().to("https://demoqa.com/alerts");
	log.info("navigating to url");
	driver.manage().window().maximize();
	log.info("Window maximized");

//	WebDriverWait wait = new WebDriverWait(driver,10);
	
	
	
	
}
	
	
}
