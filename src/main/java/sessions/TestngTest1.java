package sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class TestngTest1 extends Basepage {

	
//	@Parameters("username")
	@Test(groups={"regression"})
	public void openFacebook() {
		
		String url = "https://www.facebook.com/";
		driver.navigate().to(url);
		driver.manage().window().maximize();
		
		WebElement login = driver.findElement(By.xpath("//button[@name='login']"));
		Assert.assertEquals(url, driver.getCurrentUrl(),"check url");
		Assert.assertTrue(login.isDisplayed(),"check login button");
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(url, driver.getCurrentUrl(),"check url");
		sa.assertTrue(login.isDisplayed(),"check login button");
	sa.assertAll();	
		
		
	}

	@Test(priority=1,dependsOnMethods = { "openFacebook" },alwaysRun=true)
	public void openGoogle() {
		driver.navigate().to("https://www.google.com/");
		driver.manage().window().maximize();
	}

	
}
