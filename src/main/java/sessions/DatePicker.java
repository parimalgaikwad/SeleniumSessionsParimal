package sessions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	WebDriver driver;

	@Test
	public void test() throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.switchTo().frame(0);
		WebElement datepicker = driver.findElement(By.xpath("//*[@id='datepicker']"));
		datepicker.click();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();

		String currentDate = dtf.format(now);

		int currentDay = Integer.parseInt(currentDate.substring(currentDate.lastIndexOf("/") + 1));
		System.out.println(currentDay);
		int currentMonth = Integer
				.parseInt(currentDate.substring(currentDate.indexOf("/") + 1, currentDate.lastIndexOf("/")));
		System.out.println(currentMonth);
		int currentYear = Integer.parseInt(currentDate.substring(0, currentDate.indexOf("/")));
		System.out.println(currentYear);

		int targetYear = 2025;
		int targetMonth = 12;
		int targetDay = 1;

		if ((targetYear * 12 + targetMonth) > (currentYear * 12 + currentMonth)) {
			int count = (targetYear * 12 + targetMonth) - (currentYear * 12 + currentMonth);
			System.out.println(count);
			while (count != 0) {
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='Next']/span"))))
						.click();
				count--;
			}

			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath("//*[@data-date='" + targetDay + "']")))).click();

		}

		if ((targetYear * 12 + targetMonth) < (currentYear * 12 + currentMonth)) {
			int count = (currentYear * 12 + currentMonth) - (targetYear * 12 + targetMonth);
			System.out.println(count);
			while (count != 0) {
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='Prev']/span"))))
						.click();
				count--;
			}

			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath("//*[@data-date='" + targetDay + "']")))).click();
			//*[@data-date='25']
		}
		
		Thread.sleep(10000);

		driver.close();
	
			}
	
	

}
