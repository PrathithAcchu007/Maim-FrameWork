package com.vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this is Campaign obeject repository
 * @author Prathith paul
 *
 */
public class CampaignPage {
public CampaignPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
    @FindBy(css="img[title='Create Campaign...']")
    private WebElement clickonCampaignimage;
    
	public WebElement getClickonCampaignimage() {
		return clickonCampaignimage;
	}
    
   /**
    * this method is used to click on create campaign image 
    */
  public void clickonCreateCampaignImage() {
	  clickonCampaignimage.click();
  }


}
