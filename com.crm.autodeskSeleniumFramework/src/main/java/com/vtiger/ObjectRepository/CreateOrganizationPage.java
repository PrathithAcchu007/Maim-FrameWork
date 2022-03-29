package com.vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.generic_utility.WebdriverUtility;

/**
 * this is create Organization Repository
 * @author Prathith paul
 *
 */
public class CreateOrganizationPage extends WebdriverUtility{
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="accountname")
	private WebElement organizationNamefield;

	@FindBy(xpath="//select[@name='industry']")
	private WebElement selectindustry;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getOrganizationNamefield() {
		return organizationNamefield;
	}

	public WebElement getSelectindustry() {
		return selectindustry;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	/**
	 * this is used for creating the organization with industry
	 * @param organizationName
	 * @param industryname
	 */

	public void createOrganization(String organizationName,String industryname ) {
		organizationNamefield.sendKeys(organizationName);
		select(selectindustry, industryname);
		saveButton.click();
	}
	/**
	 * this is used for creating the organization name
	 * @param organizationName
	 */
	public void createOrganization(String organizationName) {
		organizationNamefield.sendKeys(organizationName);
		saveButton.click();
	}
}
