package sessions;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DatePickerMakemytrip extends Basepage {

	
	
	@Test
	public void test() {

		driver.get("https://www.makemytrip.com/flights");
		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		
		driver.findElement(By.xpath("//label[@for='fromCity']/input")).sendKeys("pune");
		
	}
}
