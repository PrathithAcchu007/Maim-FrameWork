package com.vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this is campaign information object repository
 * @author Prathith paul
 *
 */
public class CampaignInformationPage {
	public CampaignInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath="//td[@id='mouseArea_Product']//span")
	private WebElement actualproduct;

	@FindBy(className="dvHeaderText")
	private WebElement actualCampaignname;

	public WebElement getActualproduct() {
		return actualproduct;
	}

	public WebElement getActualCampaignname() {
		return actualCampaignname;
	}

	/**
	 * this method is used to validate the product name
	 * @return
	 */
	public String productName() {
		return actualproduct.getText();
	}

	/**
	 * this method is used to validate the campaign text 
	 * @return
	 */
	public String campaigntext() {
		return actualCampaignname.getText();

	}


}
