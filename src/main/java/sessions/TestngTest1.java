package sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//@Listeners(sessions.CustomListener.class)			

public class TestngTest1 extends Basepage {

	
	@Parameters("username")
	@Test(groups={"regression"})
	public void openFacebook(String username) {


		
		System.out.println(username);
		
		System.out.println(config.getProperty("url"));
		System.out.println(config.getProperty("username"));
		
		String url = config.getProperty("url");
		driver.navigate().to(url);
//		System.out.println("navigating to "+url);
//		driver.manage().window().maximize();
//		
//		WebElement login = driver.findElement(By.xpath("//button[@name='login']"));
//		Assert.assertEquals(url, driver.getCurrentUrl(),"check url");
//		Assert.assertFalse(login.isDisplayed(),"check login button");
//		
		
	}

//	@Test(priority=1,dependsOnMethods = { "openFacebook" },alwaysRun=true)
	public void openGoogle() {
		driver.navigate().to("https://www.google.com/");
		driver.manage().window().maximize();
	}

	
}
