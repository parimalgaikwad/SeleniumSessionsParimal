package sessions;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	WebDriver driver;

	@Test
	public void test() throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 10);

		String parentWindow = driver.getWindowHandle();   // stores Parent window handle 
		WebElement newTab = driver.findElement(By.id("tabButton"));    // stores new Tab button
		WebElement newWindow = driver.findElement(By.id("windowButton"));  // stores new Window button
		WebElement newWindowMessage = driver.findElement(By.id("messageWindowButton"));  // stores new Window message button
		System.out.println(parentWindow);
		newTab.click();                 // clicked on new tab button
		Set<String> Handles = driver.getWindowHandles();   // stores Handles of all windows opened at moment in Set 
		System.out.println(Handles);

		for (String s : Handles) {			// Iterating over set of Window Handle to switch to child Window
			if (!s.equalsIgnoreCase(parentWindow))     // checks if handle is same as Parent handle if not then only will move to switch To command
				driver.switchTo().window(s);           // switches focus to child window
		}
		String currentWindow = driver.getWindowHandle();    // storing handle of child window
		System.out.println(currentWindow);  
		WebElement heading = driver.findElement(By.id("sampleHeading"));
		System.out.println(heading.getText());
		driver.close();                           // closing child window
		driver.switchTo().window(parentWindow);   // switching back to parent window to continue operation on parent window
		newWindow.click();						// clicked on new window to open new window	
		for (String s : driver.getWindowHandles()) {
			if (!s.equalsIgnoreCase(parentWindow))
				driver.switchTo().window(s);
		}
		System.out.println(driver.findElement(By.id("sampleHeading")).getText());
		driver.close();
		driver.switchTo().window(parentWindow);
		Thread.sleep(5000);
		driver.close();
	}
}
