package com.vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this is product information object repository
 * @author Prathith paul
 *
 */
public class ProductInformationPage {
	public ProductInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(className="lvtHeaderText")
	private WebElement actualProductName;

	@FindBy(xpath="//span[@id='dtlview_Qty. in Stock']")
	private WebElement actualQuantity;

	@FindBy(xpath="//span[@id='dtlview_Qty/Unit']")
	private WebElement actualUnit;

	public WebElement getActualUnit() {
		return actualUnit;
	}
	public WebElement getActaualProductName() {
		return actualProductName;


	}
	public WebElement getActualQuantity() {
		return actualQuantity;
	}
	/**
	 * this method is used for validating the product name
	 * @return
	 */
	public String productInformation() {
		return actualProductName.getText();

	}
	/**
	 * this method is used for validating the quantity
	 * @return
	 */
	public String quantityInformation() {
		return actualQuantity.getText();

	}
	/**
	 * this method is used to validate the qnt/unit
	 * @return
	 */
	public String unitInformation() {
		return actualUnit.getText();
	}

}