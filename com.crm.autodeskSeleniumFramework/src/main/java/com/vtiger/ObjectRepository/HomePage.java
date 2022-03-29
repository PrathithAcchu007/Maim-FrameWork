package com.vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.generic_utility.WebdriverUtility;
/**
 * this is Home Page object Repository
 * @author Prathith paul
 *
 */
public class HomePage extends WebdriverUtility {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;

	@FindBy(linkText="Contacts")
	private WebElement contactsLink;

	@FindBy(linkText="Products")
	private WebElement productLink;


	@FindBy(linkText="Leads")
	private WebElement leadsLink;
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(css="a[name='Campaigns']")
	private WebElement clickonCampaign;
	
	@FindBy(css="img[src='themes/softed/images/user.PNG']")
	private WebElement signoutimage;

	@FindBy(linkText="Sign Out")
	private WebElement signout;
	
	public WebElement getMoreLink() {
		return moreLink;
	}
	
	public WebElement getClickonCampaign() {
		return clickonCampaign;
	}

	public WebElement getSignoutlink() {
		return signoutimage;
	}


	public WebElement getLogout() {
		return signout;
	}


	public WebElement getOrganizationLink() {
		return organizationLink;
	}


	public WebElement getContactsLink() {
		return contactsLink;
	}


	public WebElement getProductLink() {
		return productLink;
	}


	public WebElement getLeadsLink() {
		return leadsLink;
	}
    /**
     * this method is used to click on organization link
     */
	public void clickOnOrganizationLink() {
		organizationLink.click();
	}
    /**
     * this method is used to click on the contact link
     */
	public void clickOnContactsLink() {
		contactsLink.click();
	}
	/**
	 * this method is used click on the product link
	 */
	public void clickOnProductsLink() {
		productLink.click();
	}
	/**
	 * this method is used for mouseover to the more link and click on campaign link
	 * @param driver
	 */
	public void moreLinkandClickonCampaign(WebDriver driver) {
		mouseovertoElement(driver, moreLink);
		clickonCampaign.click();
		
	}
	
	/**
	 * this method is used to click on the leads link
	 */
	public void clickOnLeadsLink() {
		leadsLink.click();	
	}
	/**
	 * this method is used for logout the application
	 * @param driver
	 */

	public void logout(WebDriver driver) {
		mouseovertoElement(driver, signoutimage);
		signout.click();
	}










}







