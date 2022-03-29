package com.vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this is create product obejct repository
 * @author Prathith paul
 *
 */
public class CreateProductPage {
	public CreateProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[name='productname']")
	private WebElement productNamefield;
	
	@FindBy(css="input[title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(name="qtyinstock")
	private WebElement quantityinStock;
	
	@FindBy(id="qty_per_unit")
	private WebElement quantityorUnit;
	
	public WebElement getQuantityorUnit() {
		return quantityorUnit;
	}


	public WebElement getQuantityinStock() {
		return quantityinStock;
	}
	

	public WebElement getProductNamefield() {
		return productNamefield;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	/**
	 * this method is used to create the product and quantity
	 * @param productname
	 */
	public void createProductandQuantity(String productname,String quantity ) {
		productNamefield.sendKeys(productname);
		quantityinStock.sendKeys(quantity);
		saveButton.click();

	}
	/**
	 * this method is used to set the quantity
	 * @param quantity
	 */
	public void quantity(String quantity) {
		quantityinStock.sendKeys(quantity);
		saveButton.click();
	}
	/**
	 * this method is used to set the quantity/unit
	 * @param unit
	 */
	public void createProductandUnit(String productname, String unit) {
		productNamefield.sendKeys(productname);
		quantityorUnit.sendKeys(unit);	
		saveButton.click();
	}
	/**
	 * this method is used to save the information
	 */
	public void save() {
		saveButton.click();
	}
	/**
	 * this method is used to create the product
	 * @param productname
	 */
	public void createProduct(String productname) {
		productNamefield.sendKeys(productname);
		saveButton.click();
	
	}

}

