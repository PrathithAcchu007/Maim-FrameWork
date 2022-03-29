package com.vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.generic_utility.WebdriverUtility;
/**
 * this is create Campaign object repository
 * @author Prathith paul
 *
 */
public class CreateNewCampaignPage extends WebdriverUtility{
	public CreateNewCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement campaignName;
	
	@FindBy(xpath="//input[@name='product_name']/following-sibling::img[@title='Select']")
	private WebElement clickonselectproductimage;
	
	@FindBy(id="search_txt")
	private WebElement searchtextbar;
	
	@FindBy(css="input[title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(name="search")
	private WebElement searchButton;
	

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getClickonselectproductimage() {
		return clickonselectproductimage;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	/**
	 * this is used create the campaign name and select image 
	 * @param campaignname
	 */
	public void createCampaignandSelectimage(String campaignname) {
		campaignName.sendKeys(campaignname);
		clickonselectproductimage.click();

	}
	/**
	 * this is used create the campaign name and save
	 * @param campaignname
	 */
	public void createCampaigandSave(String campaignname) {
		campaignName.sendKeys(campaignname);
		saveButton.click();


	}
	/**
	 * this method is used click on the select image
	 */
	public void selectimage() {
		clickonselectproductimage.click();
	}
	/**
	 * this method is used to search the product name
	 * @param productname
	 */
	public void switchandSearchProduct(WebDriver driver, String productname) {
        switchtoWindowpage(driver, "Products");

		searchtextbar.sendKeys(productname);
		searchButton.click();
		driver.findElement(By.xpath("//a[text()='"+productname+"']")).click();
        switchtoWindowpage(driver, "Campaigns");
		saveButton.click();


	}
	/**
	 * this method is used to switch window
	 * @param driver
	 * @param partialtitleText
	 */
	public void switchtoWindowpage(WebDriver driver, String partialtitleText) {
		switchToWindow(driver, partialtitleText);
	}
	/**
	 * this method is used to save the information
	 */
	public void save() {
		saveButton.click();
	}
	
	
	


}
