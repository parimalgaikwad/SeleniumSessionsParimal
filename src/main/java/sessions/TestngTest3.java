package sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(sessions.CustomListener.class)			

public class TestngTest3 extends Basepage {

	
	@Test(groups={"regression"})
	public void openFacebook() {
	
		
		String url = "https://www.facebook.com/";
		driver.navigate().to(url);
		System.out.println("navigating to "+url);
		driver.manage().window().maximize();
		
		WebElement login = driver.findElement(By.xpath("//button[@name='login']"));
		Assert.assertFalse(login.isDisplayed(),"check login button");
//		Assert.assertEquals("9", age.getText())
	
//		Assert.assertTrue(false);
//		Integer.toString(0);
//		Double.parseDouble(url)
//		Float.par
	}


}
