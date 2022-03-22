package sessions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//@Listeners(sessions.CustomListener.class)			

public class TestngTest1 extends Basepage {
	public Logger log = Logger.getLogger(TestngTest1.class);

	@Test(priority=0,groups= {"test"})
	public void openFacebook() {

		log.info(config.getProperty("url"));
		log.info(config.getProperty("username"));

		String url = config.getProperty("url");
		driver.navigate().to(url);
		Assert.assertTrue(true);
	}

	@Test(priority=1)
	public void openGoogle() {
		driver.navigate().to("https://www.google.com/");
		driver.manage().window().maximize();
		Assert.assertTrue(true);

	}

}
