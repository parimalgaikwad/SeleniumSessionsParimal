package sessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Framehandling {

	WebDriver driver;

	@Test
	public void test() throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.globalsqa.com/demo-site/frames-and-windows/#iFrame");
		driver.manage().window().maximize();
//		WebDriverWait wait = new WebDriverWait(driver,10);
		
		WebElement frame = driver.findElement(By.xpath("//*[@data-src='https://www.globalsqa.com/trainings/']"));
//		driver.switchTo().frame("globalSqa");

		driver.switchTo().frame(frame);
		WebElement All = driver.findElement(By.xpath("//*[@id='current_filter']"));
		All.click();
		
		driver.switchTo().parentFrame();
		
	Thread.sleep(10000);	
		driver.close();

	}
}
