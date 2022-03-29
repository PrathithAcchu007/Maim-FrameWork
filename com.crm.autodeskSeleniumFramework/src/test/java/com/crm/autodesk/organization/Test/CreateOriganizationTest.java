package com.crm.autodesk.organization.Test;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

import com.crm.autodesk.generic_utility.JavaUtility;
import com.crm.autodesk.generic_utility.PropertiesFileUtility;
import com.crm.autodesk.generic_utility.WebdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOriganizationTest {
	public static void main(String[] args) throws Throwable {

		PropertiesFileUtility filelib=new PropertiesFileUtility();
		JavaUtility jlib=new JavaUtility();
		WebdriverUtility weblib=new WebdriverUtility();

		FileInputStream fil = new FileInputStream(".//src//test//resources//OrgData.xlsx");
		Workbook wb = WorkbookFactory.create(fil);
		Sheet sheet = wb.getSheet("Sheet1");
		int rowcount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();

		System.out.println("total number of rows "+rowcount);
		System.out.println("total number of columns "+columnCount);

		for (int i = 0; i <= rowcount; i++) {
			for (int j = 0; j < columnCount; j++) {
				Row row = sheet.getRow(i);
				Cell cell = row.getCell(j);
				String data = cell.getStringCellValue();
				System.out.print(data+"		");
			}
			System.out.println();

		}

		System.out.println("================================================");

		String orgName = sheet.getRow(1).getCell(0).getStringCellValue();
		System.out.println("organization name is "+orgName);


		String browser = filelib.accessTheDatafromPropertiesFile("browser");
		String url = filelib.accessTheDatafromPropertiesFile("url");
		String username = filelib.accessTheDatafromPropertiesFile("username");
		String password = filelib.accessTheDatafromPropertiesFile("password");

		System.out.println(browser);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);

		/*run time polymorphism*/
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("launched browser is "+ browser);
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("launched browser is "+ browser);
		}else {
			System.out.println("specify a valid browser");
		}
		weblib.waitForPagetobeLoad(driver);		
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		/*click on organization link*/
		driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Organizations']")).click();
		/*click on "+" image*/
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		/*enter orgname*/
		int randomNum = jlib.getrandomnumber();
		orgName = orgName + randomNum;
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		/*click on save*/
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String text=driver.findElement(By.className("dvHeaderText")).getText();
		String msg=wb.getSheet("Organization informtion").getRow(1).getCell(0).getStringCellValue();

		SoftAssert sf=new SoftAssert();
		sf.assertTrue(text.contains(msg), "organizationname is not valid");

		//		if(text.contains(msg)) {
		//			System.out.println("validation pass");
		//		}else {
		//			System.out.println("validation fail");
		//		}

		weblib.mouseovertoElement(driver, driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']")));
		driver.findElement(By.linkText("Sign Out")).click();
		sf.assertAll();
		driver.quit();




	}


}
