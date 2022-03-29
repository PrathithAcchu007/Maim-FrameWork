package com.crm.autodesk.products.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.generic_utility.BaseClass;
import com.vtiger.ObjectRepository.CreateProductPage;
import com.vtiger.ObjectRepository.HomePage;
import com.vtiger.ObjectRepository.ProductInformationPage;
import com.vtiger.ObjectRepository.ProductsPage;



//@Listeners(com.crm.autodesk.generic_utility.ListenersImplimentationClass.class)
public class Create_ProductTest extends BaseClass{

	@Test(groups="smokeTest")
	public void createProduct() throws Throwable{
		/*random number*/
		int ramnum=jlib.getrandomnumber();

		/*Fetching the data from the Excel*/
		String productname=excellib.acessTheDatafromExcelSheet("Create_Product", 1, 0)+"_"+ramnum;
		String expectedproduct=excellib.acessTheDatafromExcelSheet("Create_Product", 1, 1);

		/*click on product link*/
		HomePage homepage=new HomePage(driver); 
		homepage.clickOnProductsLink();
	
		/*click on create product image*/
		ProductsPage productpage=new ProductsPage (driver);
		productpage.clickonCreateProduct();

		/*create product*/
		CreateProductPage product=new CreateProductPage(driver);
		product.createProduct(productname);

		/*validating product*/
		ProductInformationPage productinformation=new ProductInformationPage (driver);
		String actualproduct = productinformation.productInformation();
		Assert.assertTrue(actualproduct.contains(expectedproduct), "product is not matching");






	}

}
