package com.vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this is contact page object repository
 * @author Prathith paul
 *
 */
public class ContactsPage {
    public ContactsPage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
    
    @FindBy(css="img[title='Create Contact...']")
    private WebElement clickonCreateContactimage;

	public WebElement getClickonCreateContactimage() {
		return clickonCreateContactimage;
	}
    
	/**
	 * this method is used to click on ceate contacts image
	 */
    public void clickonCreateContact() {
    	clickonCreateContactimage.click();
    }
}
