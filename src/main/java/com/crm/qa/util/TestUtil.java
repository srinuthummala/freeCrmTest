package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;
import org.apache.commons.io.FileUtils;

public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 20;
	public static String TESTDATA_SHEET_PATH="C:\\Users\\CHOWDARY\\eclipse-workspace\\freeCRMTest\\src\\main\\java\\com\\crm\\qa\\testData\\testData.xlsx";
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public Object[][] getTestData() {
		try {
			workbook = new XSSFWorkbook(new FileInputStream(TESTDATA_SHEET_PATH));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		sheet = workbook.getSheet("Sheet0");

		int rowNum = sheet.getLastRowNum();
		Row row = sheet.getRow(0);
		int colNum  = row.getLastCellNum();

		Object[][] data = new Object[rowNum][colNum];
		for(int i=1;i<=rowNum; i++) {
			for(int j=0; j<colNum; j++) {
				Cell cell = sheet.getRow(i).getCell(j);
				data[i-1][j] = cell.toString();
			}

		}
		return data;
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		//TakesScreenshot screenShot = (TakesScreenshot) driver;
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"/screenShots/"+System.currentTimeMillis()+".png"));
	}
}
