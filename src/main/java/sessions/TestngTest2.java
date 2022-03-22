package sessions;

import org.testng.Assert;
import org.testng.annotations.Test;

//@Listeners(sessions.CustomListener.class)			


public class TestngTest2 extends Basepage {

	@Test(priority=2)
	public void openInstagram() {

		driver.navigate().to("https://www.instagram.com/?hl=en");
		driver.manage().window().maximize();
		Assert.assertTrue(false);
	}
	
	@Test(priority=3)
	public void openYoutube()  {

		driver.navigate().to("https://www.youtube.com/");
		driver.manage().window().maximize();
		Assert.assertTrue(false);

	}	
	
	
	

}
