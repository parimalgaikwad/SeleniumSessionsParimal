package sessions;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Utils extends Basepage {

	

	public static String captureScreenshot() {

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yy_hh_mm_ss_");
		LocalDateTime now = LocalDateTime.now();
		String filename = dtf.format(now) + "Screenshot.png";
//		System.out.println(filename);
		String destFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\images\\" + filename;
		File Dest = new File(destFilePath);
		try {
			FileUtils.copyFile(screenshot, Dest);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("screenshot captured");
		return destFilePath;

	}


	
}
