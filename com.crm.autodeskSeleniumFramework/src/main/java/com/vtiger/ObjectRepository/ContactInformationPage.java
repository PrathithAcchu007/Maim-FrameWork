package com.vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this is contact information object repository
 * @author Prathith paul
 *
 */
public class ContactInformationPage {
	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//td[@id='mouseArea_Organization Name']/a")
	private WebElement organizationname;
	
	@FindBy(className="dvHeaderText")
	private WebElement headerText;

	public WebElement getOrganizationname() {
		return organizationname;
	}

	public WebElement getHeaderText() {
		return headerText;
	}
	/**
	 * this method is used to validate the organization name
	 * @return
	 */
	public String organizationName() {
	return organizationname.getText();
	}
	
	/**
	 * this method is used to validate the header text 
	 * @return
	 */
	public String headertext() {
	return headerText.getText();
	
}
}
