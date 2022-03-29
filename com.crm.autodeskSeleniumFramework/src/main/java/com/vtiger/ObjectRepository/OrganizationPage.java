package com.vtiger.ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this is Organization object Repository
 * @author Prathith paul
 *
 */
public class OrganizationPage {
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement clickonCreateOrganizationImage;



	@FindBy (xpath="//a[@title='Next']/child::img[@align='absmiddle']")
	private WebElement clickOnNextButton;


	public WebElement getClickOnNextButton() {
		return clickOnNextButton;
	}

	public WebElement getClickonCreateOrganizationImage() {
		return clickonCreateOrganizationImage;
	}
	/**
	 * this method is used to click on the create Organization image
	 */
	public void clickoncreateOrganization() {
		clickonCreateOrganizationImage.click();
	}

	public void captureallOrganization(WebDriver driver ,String orgName) {
		List<WebElement> actualorg = driver.findElements(By.xpath("//a[text()='"+orgName+"']"));
        int count=0;
		for (WebElement web : actualorg) {

			if(web.getText().contains(orgName)){
				System.out.println("name exists");
				break;
			}else {
				clickOnNextButton.click();	
				count++;
			}
		}
	}
}









