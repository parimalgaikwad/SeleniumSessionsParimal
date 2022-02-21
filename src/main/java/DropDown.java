

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {
	

	WebDriver driver;

	@Test
	public void test() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		driver.manage().window().maximize();
//		WebDriverWait wait = new WebDriverWait(driver,10);
		
		WebElement dropdown = driver.findElement(By.xpath("//select"));
		Select select = new Select(dropdown);
	String optionSelected= select.getFirstSelectedOption().getText()	;
		select.selectByVisibleText("Albania");
//		select.selectByValue(null)
		System.out.println(select.getFirstSelectedOption().getText());
//		select.
		List<WebElement> countries = select.getOptions();
		for(WebElement w :countries)
			System.out.println(w.getText());
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		driver.close();
	
	}



}