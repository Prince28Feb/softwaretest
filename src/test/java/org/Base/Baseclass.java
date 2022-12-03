package org.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static WebDriver driver;

	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void windowMaximize() {
		driver.manage().window().maximize();
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static void pageTitle() {
		String title = driver.getCurrentUrl();
		System.out.println(title);
	}

	public static void pageUrl() {
		String Url = driver.getCurrentUrl();
		System.out.println(Url);
	}

	public static void passText(String txt, WebElement ele) {
		ele.sendKeys(txt);
	}

	public static void CloseEntireBrowser() {
		driver.quit();
	}

	public static void ClickBtn(WebElement ele) {
		ele.click();
	}

	public static void ScreenShot(String imgname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File image = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("location+imgName.png");
		FileUtils.copyFile(image, f);
	}

	public static Actions a;

	public static void moveToCursor(WebElement targetWebElement) {
		a = new Actions(driver);
		a.moveToElement(targetWebElement).perform();
	}

	public static void dragDrop(WebElement dragWebElement, WebElement dropWebElement) {
		a = new Actions(driver);
		a.dragAndDrop(dragWebElement, dropWebElement).perform();
	}

	public static JavascriptExecutor js;

	public static void ScrollThePage(WebElement tarWebEle) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].ScrollIntoView(true)", tarWebEle);

	}

	public static void Scroll(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].ScrollIntoView(false)", element);
	}

	public static void excelRead(String SheetName, int rowNum, int cellNum) throws IOException {
		File f = new File("excelllocation.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet mysheet = wb.getSheet("datas");
		Row r = mysheet.getRow(rowNum);
		Cell c = r.getCell(cellNum);
		int CellType = c.getCellType();
		String value = " ";
		if (CellType == 1) {
			String value2 = c.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(c)) {
			Date dd = (Date) c.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat(value);
			String value1 = s.format(dd);
		} else {
			double d = c.getNumericCellValue();
			long l = (long) d;
			String valueof = String.valueOf(l);
		}
	}

	public static void CreateNewExcelFile(int rownum, int cellnum, String newData) throws IOException {
		File f = new File("C:\\Users\\hp\\eclipse-workspace\\Javaactions\\Sampleexl\\myselffile\\newfile.xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet newsheet = w.createSheet("datas");
		Row newrow = newsheet.createRow(rownum);
		Cell newcell = newrow.createCell(cellnum);
		newcell.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
	}

	public static void CreateCell(int getRow, int Cellnum, String newData) throws IOException {
		File f = new File("C:\\Users\\hp\\eclipse-workspace\\Javaactions\\Sampleexl\\myselffile\\newfile.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("datas");
		Row r = s.getRow(getRow);
		Cell c = r.createCell(Cellnum);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}

	public static void CreateRow(int creRow, int creCell, String newData) throws IOException {
		File f = new File("C:\\Users\\hp\\eclipse-workspace\\Javaactions\\Sampleexl\\myselffile\\newfile.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("datas");
		Row r = s.createRow(creRow);
		Cell c = r.createCell(creCell);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}

	public static void UpdateDataToParticularCell(int getTheRow, int getTheCell, String existingData,
			String writeNewData) throws IOException {
		File f = new File("C:\\Users\\hp\\eclipse-workspace\\Javaactions\\Sampleexl\\myselffile\\newfile.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fis);
		Sheet s = w.createSheet("datas");
		Row r = s.getRow(getTheRow);
		Cell c = r.createCell(getTheCell);
		String str = c.getStringCellValue();
		if (str.equals(existingData)) {
			c.setCellValue(writeNewData);
		}
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);

	}

	public class DatadrivenSample extends Baseclass {
		public void main(String[] args) throws IOException {
			File f = new File("C:\\Users\\hp\\eclipse-workspace\\Javaactions\\Sampleexl\\myselffile\\newfile.xlsx");
			Workbook w = new XSSFWorkbook();
			Sheet newsheet = w.createSheet("datas");
			Row newRow = newsheet.createRow(0);
			Cell newCell = newRow.createCell(0);
			newCell.setCellValue("selenium");
			FileOutputStream fos = new FileOutputStream(f);
			w.write(fos);

		}

	}
}
