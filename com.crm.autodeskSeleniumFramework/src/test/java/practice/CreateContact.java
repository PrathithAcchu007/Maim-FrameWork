package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.autodesk.generic_utility.PropertiesFileUtility;
import com.crm.autodesk.generic_utility.WebdriverUtility;
import com.vtiger.ObjectRepository.ContactsPage;
import com.vtiger.ObjectRepository.HomePage;
import com.vtiger.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {
	@Test(dataProvider ="getData" )
	public void createContactwithDataprovider(String name ,String mobileNumber) throws Throwable {
		/*object creation for all the utilities*/
		PropertiesFileUtility filelib=new PropertiesFileUtility();
		WebdriverUtility weblib=new WebdriverUtility();
	
        /*fetching the data from properties file*/
		String browser=filelib.accessTheDatafromPropertiesFile("browser");
		String url=filelib.accessTheDatafromPropertiesFile("url");
		String username=filelib.accessTheDatafromPropertiesFile("username");
		String password=filelib.accessTheDatafromPropertiesFile("password");

        /*launching the browser*/
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("specify valid browser");
		}
		
		/*maximizing the window*/
		driver.manage().window().maximize();
		
		/*implicitly wait*/
		weblib.waitForPagetobeLoad(driver);	
		
		/*launching the application*/
		driver.get(url);
		
		/*login to the application */
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username, password);
		
		/*click on contact link*/
		HomePage homepage=new HomePage(driver);
		homepage.clickOnContactsLink();
		
		/*click on create contact image*/
		ContactsPage contactpage=new ContactsPage(driver);
		contactpage.clickonCreateContact();
		
		driver.findElement(By.name("lastname")).sendKeys(name);
		driver.findElement(By.id("mobile")).sendKeys(mobileNumber);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		weblib.mouseovertoElement(driver, driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']")));
		driver.findElement(By.linkText("Sign Out")).click();
		
	}
	@DataProvider
	public Object[][] getData() {
		Object[][] object = new Object[5][2];
		
		object[0][0]="Acchu";
		object[0][1]="8914532697";
		
		object[1][0]="Prathith";
		object[1][1]="7965412478";
		
		object[2][0]="Paul";
		object[2][1]="8967541515";
		
		object[3][0]="Dhoni";
		object[3][1]="9871717171";
		
		object[4][0]="Mahi";
		object[4][1]="8917777797";
		
		return object;
		
		
		
		
		
		
		
		
		
	}

}
