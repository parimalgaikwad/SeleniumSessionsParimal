package sessions;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {

	

	static WebDriver driver;

	@Test
	public void test() throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://mvnrepository.com/artifact/log4j/log4j/1.2.17");
		driver.manage().window().maximize();

		Thread.sleep(2000);
		
		captureScreenshot();
	}
	
	public static void captureScreenshot() {
		
		File screenshot = 	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yy_hh_mm_ss_");
		LocalDateTime now = LocalDateTime.now();
		String filename = 	dtf.format(now)+"Screenshot.png";
		System.out.println(filename);
		File Dest = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\images\\"+filename);
		
//		C:\Users\hp\eclipse-workspace\SeleniumSessions+++++\src\test\resources\screenshots
		
        try {
        	
			FileUtils.copyFile(screenshot, Dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        System.out.println("screenshot captured");

	}
	
	
	
}
