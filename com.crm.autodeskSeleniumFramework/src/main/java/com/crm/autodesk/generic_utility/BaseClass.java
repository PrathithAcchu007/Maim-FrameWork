package com.crm.autodesk.generic_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.vtiger.ObjectRepository.HomePage;
import com.vtiger.ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver=null;
	public PropertiesFileUtility filelib=new PropertiesFileUtility();
	public JavaUtility jlib=new JavaUtility();
	public WebdriverUtility weblib=new WebdriverUtility();
	public ExcelUtility excellib=new ExcelUtility();
    public static WebDriver monitorDriver;
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void configureBS() {
		System.out.println("database connection establishment");
	}
	@BeforeTest(groups= {"smokeTest","regressionTest"})
	public void configureBT() {
		System.out.println("execute script in parallel mode");
	}
	//@Parameters("browser")
	@BeforeClass (groups= {"smokeTest","regressionTest"})
	public void configureBC() throws Throwable {
		String browser=filelib.accessTheDatafromPropertiesFile("browser");
		String url=filelib.accessTheDatafromPropertiesFile("url");

		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}

		/*maximizing the window*/
		driver.manage().window().maximize();

		/*implicitly wait*/
		weblib.waitForPagetobeLoad(driver);	

		/*launching the application*/
		driver.get(url);
		
		monitorDriver=driver;

	}

	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void configureBM() throws Throwable {
		String username=filelib.accessTheDatafromPropertiesFile("username");
		String password=filelib.accessTheDatafromPropertiesFile("password");
		LoginPage loginpage=new LoginPage (driver);
		loginpage.login(username, password);

	}
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void configureAM() {
		HomePage homepage=new HomePage(driver); 
		homepage.logout(driver);	

	}
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void configureAC() {
		driver.quit();

	}
	@AfterTest(groups= {"smokeTest","regressionTest"})
	public void configureAT() {
		System.out.println("close parallel execution");
	}

	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void configureAS() {
		System.out.println("close database connection");
	}








}
