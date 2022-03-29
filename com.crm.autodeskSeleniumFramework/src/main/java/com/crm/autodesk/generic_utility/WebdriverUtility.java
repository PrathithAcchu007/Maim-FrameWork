package com.crm.autodesk.generic_utility;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * this is used for webdriver specific actions
 * @author Prathith paul
 *
 */
public class WebdriverUtility {
	/**
	 * @author Prathith paul
	 * this is used for element to be loaded in the page
	 * @param driver
	 */

	public void waitForPagetobeLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	/**
	 * @author Prathith paul
	 * this is used for perticular element to be satisfied
	 * @param driver
	 */

	public void waitForElementtobeclickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * @author Prathith paul
	 * this is used for identifying the assynchronized element [Java Script]
	 * @param driver
	 */
	public void waitFortheJavaScriptElement(WebDriver driver ) {
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	}

	public void waitForElementforCustomTimeout(WebDriver driver,WebElement element,int pollingtime) throws Throwable {
		FluentWait wait= new FluentWait(driver);
		wait.pollingEvery(pollingtime, TimeUnit.SECONDS);
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**@author Prathith paul
	 * this is used for switching wiindow based on window title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWindowTitle ) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String win=it.next();
			driver.switchTo().window(win);
			if(driver.getTitle().contains(partialWindowTitle)) {
				break;
			}
		}
	}
	/**
	 * @author Prathith paul
	 * this is used to perform action on perticular element
	 * @param driver
	 * @param element
	 */
	public void mouseovertoElement(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();

	}
	/**
	 * @author Prathith paul
	 * this is used to perform dropdown and list based on index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * @author Prathith paul
	 * this is used to perform dropdown and list based on visible text
	 * @param element
	 * @param text
	 */
	public void select(WebElement element,String text) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	/**
	 * @author Prathith paul
	 * this is used to switch to alert window and accept
	 * @param driver
	 */
	public void switchToAlertWindowandAccept(WebDriver driver) {
		Alert alert= driver.switchTo().alert();
		alert.accept();
	}
	/**
	 * @author Prathith paul
	 * this is used to switch to alert window and dismiss
	 * @param driver
	 */
	public void switchToAlertWindowDismiss(WebDriver driver) {
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
	}
	/**
	 * @author Prathith paul
	 * @param driver
	 * this is used for switching the frame by using index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);

	}
	/**
	 * @author Prathith paul
	 * @param driver
	 * this is used for switching the frame by using String id_name_Attribute
	 * @param id_name_Attribute
	 */
	public void switchToFrame(WebDriver driver, String id_name_Attribute) {
		driver.switchTo().frame(id_name_Attribute);
	}
	
	/**
	 * @author Prathith paul
	 * this is used for taking screen shot 
	 * @param driver
	 * @param screenShotname
	 * @throws Throwable
	 */
	public String toTakeScreenshot(WebDriver driver,String screenShotname ) throws Throwable {
		
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		 JavaUtility jlib=new JavaUtility();
		//String date=Calendar.getInstance().getTime().toString().replace(":", "-");
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File ("./screenshot/"+screenShotname+jlib.getsystemDateandTimeFormat()+".png"));
		File destination = new File ("./screenshot/"+screenShotname+jlib.getsystemDateandTime()+".png");
		return destination.getAbsolutePath();

//		Date d = new Date();
//		String date = d.toString();
//		String d1 =date.replace(" ", "-").replace(":", "-");
//		screenShotname = screenShotname + d;
	
		
	}
	/**
	 * @author Prathith paul
	 * this is used for executing the javascript
	 * @param driver
	 * @param javascript
	 */
	public void executejavascript(WebDriver driver,String javascript) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeAsyncScript(javascript, null);
	}
	
	/**
	 * @author Prathith paul
	 * thid is used for handling multiple webelements
	 * @param driver
	 * @param element
	 * @param text
	 */
	public void multipleWebElement(WebDriver driver,List<WebElement> element,String text) {

		List<WebElement> list=element;
		for (WebElement web : list) {
			if(web.getText().contains(text)){

				web.click();
				break;
			}	}	
	}


}





