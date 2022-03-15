package sessions;

import java.util.Hashtable;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestDataProvider {
	
	
	@Test(dataProvider = "dp", dataProviderClass = Utils.class)
	public void testDataProvider(Hashtable<String, String> data) {
		
		System.out.println(data.get("fullname"));
		System.out.println(data.get("email"));

//		WebElement name =driver.f;
		
//		name.sendKeys(data.get("fullname"));
		
	}
	
	
	
	
	

}
