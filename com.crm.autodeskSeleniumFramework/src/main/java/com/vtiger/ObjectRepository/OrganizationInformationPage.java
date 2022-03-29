package com.vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this is organization information repository
 * @author Prathith paul
 *
 */
public class OrganizationInformationPage {
	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//span[@id='dtlview_Organization Name']")
	private WebElement actualOrganizationName;
	
	@FindBy(id="dtlview_Industry")
	private WebElement actualIndustryName;

	public WebElement getActualOrganizationName() {
		return actualOrganizationName;
	}

	public WebElement getActualIndustryName() {
		return actualIndustryName;
	}
	/**
	 * this method is used for validating the organizationName
	 * @return
	 */
	public String  actualOrganizationName() {
		return actualOrganizationName.getText();
		
	}
	/**
	 * this method is used for validating the industry 
	 * @return
	 */
	public String  actualIndustryName() {
		return actualIndustryName.getText();
}
}
