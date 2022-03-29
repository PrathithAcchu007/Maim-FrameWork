package com.vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.generic_utility.WebdriverUtility;
/**
 * this is create new contact repository
 * @author Prathith paul
 *
 */
public class CreatenewContactPage extends WebdriverUtility{

	public CreatenewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(css="input[name='lastname']")
	private WebElement lastNamefield;

	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement toSelectOrganizationName;

	@FindBy(id="search_txt")
	private WebElement searchtab;

	@FindBy(name="search")
	private WebElement searchButton;

	@FindBy(css="input[title='Save [Alt+S]']")
	private WebElement saveButton;


	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getSearchtab() {
		return searchtab;
	}

	public WebElement getLastNamefield() {
		return lastNamefield;
	}

	public WebElement getToSelectOrganizationName() {
		return toSelectOrganizationName;
	}
	/**
	 * this method is used click on the select image
	 */
	public void selectimage() {
		toSelectOrganizationName.click();
	}
	/**
	 * this method is used to input the last name
	 * @param lastname
	 */
	public void lastNameandSelectimage(String lastname) {
		lastNamefield.sendKeys(lastname);
		toSelectOrganizationName.click();
	}

	/**
	 * this method is used for switching the window
	 * @param driver
	 * @param partialtitleText
	 */

	public void switchtoWindowpage(WebDriver driver, String partialtitleText) {
		switchToWindow(driver, partialtitleText);
	}

	/**
	 * this method is used to switch and search the organization name
	 * @param orgname
	 */
	public void switchandSearchOrganization(WebDriver driver,String orgname) {
		switchtoWindowpage(driver, "Accounts&action");
		searchtab.sendKeys(orgname);
		searchButton.click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		switchtoWindowpage(driver, "Contacts&action");
		saveButton.click();

	}
	
	/**
	 * this method is used to input last name and save the information
	 */
	public void lastNameandSave(String lastname) {
		lastNamefield.sendKeys(lastname);
		saveButton.click();
	}








}