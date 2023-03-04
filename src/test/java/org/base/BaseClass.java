package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;

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

public class BaseClass {
	
public static WebDriver driver;
	


public static void lanuchBrowser() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	
	
}
public static void windowMaximize() {
	driver.manage().window().maximize();
	
}
public static void launchurl(String url) {
	driver.get(url);
	
}
public static void pageTitle() {
	String title = driver.getTitle();
	System.out.println(title);
	
}
public static void pageUrl() {
	String url = driver.getCurrentUrl();
	System.out.println(url);
	
}
public static void passText(String txt, WebElement ele) {
	ele.sendKeys(txt);
	
}
public static void closeEntireBrowser() {
	driver.quit();
	
}
public static void clickBtn(WebElement ele) {
	ele.click();
	
}
public static void screenShot(String imgName) throws IOException {
	TakesScreenshot ts =  (TakesScreenshot) driver;
	File image = ts.getScreenshotAs(OutputType.FILE);
	File f = new File("location+imgName.png");
	FileUtils.copyFile(image, f);
	
}
public static Actions a;

public static void moveTheCursor(WebElement targetwebElement) {
	a = new Actions (driver);
	a.moveToElement(targetwebElement).perform();
}
public static void dragDrop(WebElement drgweElement, WebElement dropElement) {
	a = new Actions (driver);
	a.dragAndDrop(drgweElement, dropElement).perform();
	
}
public static JavascriptExecutor js;

public static void scrollThepage(WebElement tarwebele) {
	js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrolltoView(true)", tarwebele);
	
}
public static void scroll(WebElement element) {
	js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(false)", element);
	
}
public static void excellRead(String sheetName, int rowNUm, int cellNum ) throws IOException {
	File f = new File("excellocation.xlsx");
	FileInputStream fis = new FileInputStream(f);
	 Workbook wb = new XSSFWorkbook(fis);
	 Sheet mySheet = wb.getSheet("datas");
	 Row r = mySheet.getRow(rowNUm);
	 Cell c = r.getCell(cellNum);
	 int celltype = c.getCellType();
	 
	 String value = " ";
	
	if (celltype==1) {
		 String value2 = c.getStringCellValue();
		 
		 
		 
		
	}
	  else if (DateUtil.isCellDateFormatted(c)) {
		 Date dd = (Date) c.getDateCellValue();
		 SimpleDateFormat s = new SimpleDateFormat();
		 String value1 = s.format(dd);
		
	}
	  else {
		double d = c.getNumericCellValue();
		long l = (long) d;
		String valueof = String.valueOf(l);
	}
	
	
}
public static void createNewExcelFile(int rowNum,int cellNum,String writeData) throws IOException {
	File f = new  File("C:\\Users\\Sakthivel\\eclipse-workspace\\MavenProject\\Excel\\newfile.xlsx");
	Workbook w = new XSSFWorkbook();
	Sheet newsheet = w.createSheet("datas");
	Row newRow = newsheet.createRow(rowNum);
	Cell newcell = newRow.createCell(cellNum) ;
	newcell.setCellValue(writeData);
	FileOutputStream fos = new FileOutputStream(f);
	w.write(fos);
	
}
public static void createCell(int rowNum,int cellNum,String newData) throws IOException {
	File f = new File("C:\\Users\\Sakthivel\\eclipse-workspace\\MavenProject\\Excel\\newfile.xlsx");
	FileInputStream fis = new FileInputStream(f);
	Workbook wb = new XSSFWorkbook(fis);
	Sheet s = wb.getSheet("Datas");
	Row r = s.getRow(rowNum);
	Cell c = r.createCell(cellNum);
	c.setCellValue(newData);
	FileOutputStream fos = new FileOutputStream(f);
	wb.write(fos);
}

public static void createRow(int creRow,int creCell,String newData) throws IOException {
	File f = new File("C:\\Users\\Sakthivel\\eclipse-workspace\\MavenProject\\Excel\\newfile.xlsx");
	FileInputStream fis = new FileInputStream(f);
	Workbook wb = new XSSFWorkbook(fis);
	Sheet s = wb.getSheet("Datas");
	Row r = s.createRow(creRow);
	Cell c = r.createCell(creCell);
	c.setCellValue(newData);
	FileOutputStream fos = new FileOutputStream(f);
	wb.write(fos);
}
public static void updateDataToParticularCell(int getTheRow,int getTheCell,String exisitingData,String writeNewData) throws IOException {
	File f = new File("C:\\Users\\Sakthivel\\eclipse-workspace\\MavenProject\\Excel\\newfile.xlsx");
	FileInputStream fis = new FileInputStream(f);
	Workbook wb = new XSSFWorkbook(fis);
	Sheet s = wb.getSheet("Datas");
	Row r = s.getRow(getTheRow);
	Cell c = r.getCell(getTheCell);
	String str = c.getStringCellValue();
	if (str.equals(exisitingData)) {
		c.setCellValue(writeNewData);
	}
	FileOutputStream fos = new FileOutputStream(f);
	wb.write(fos);
}














	
}


