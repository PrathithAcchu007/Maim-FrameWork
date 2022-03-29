package com.vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.generic_utility.WebdriverUtility;
/**
 * this is product object repository
 * @author Prathith paul
 *
 */
public class ProductsPage extends WebdriverUtility{
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="img[title='Create Product...']")
	private WebElement clickonProductImage;
	
	@FindBy(name="search_text")
	private WebElement searchForProduct;
	
	@FindBy(xpath="//select[@id='bas_searchfield']")
	private WebElement selectbyQuantity;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement searchButton;
	

	public WebElement getSelectbyQuantity() {
		return selectbyQuantity;
	}
	public WebElement getSearchForProduct() {
		return searchForProduct;
	}
	public WebElement getClickonProductImage() {
		return clickonProductImage;
	}
	/**
	 * this methid is used to click on the product image
	 */
	public void clickonCreateProduct() {
		clickonProductImage.click();
	}
	/**
	 * this method is used to search the product by quantity
	 * @param quantity
	 * @param quantityname
	 */
	public void searchProduct(String quantity,String quantityname) {
		searchForProduct.sendKeys(quantity);
		select(selectbyQuantity, quantityname);
		searchButton.click();
	}
	
}

	
	


	
   
    	  
      