package sessions;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

public class Utils extends Basepage {

	public ExcelReader excel;

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

	@DataProvider(name = "dp")
	public Object[][] getDataAsMethod(Method m) {
		excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\bulk_candidates.xlsx");

		return getDataFromExcel(excel, m.getName());
	}

	public Object[][] getDataFromExcel(ExcelReader excel, String sheetname) {

		String sheet = sheetname;
		int rows = excel.getRowCount(sheet);
		int cols = excel.getColumnCount(sheet);
		Object[][] data = new Object[rows - 1][1];

		for (int rownum = 2; rownum <= rows; rownum++) {
			Hashtable<String, String> table = new Hashtable<String, String>();
			for (int colnum = 0; colnum < cols; colnum++) {
				{
					table.put(excel.getCellData(sheet, colnum, 1), excel.getCellData(sheet, colnum, rownum));
					data[rownum - 2][0] = table;
//					System.out.println(data[rownum-2][0]);

				}
			}
		}

		return data;
	}

}
