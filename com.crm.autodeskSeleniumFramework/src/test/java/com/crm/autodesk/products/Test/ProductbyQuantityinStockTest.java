package com.crm.autodesk.products.Test;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.generic_utility.BaseClass;
import com.vtiger.ObjectRepository.CreateProductPage;
import com.vtiger.ObjectRepository.HomePage;
import com.vtiger.ObjectRepository.ProductInformationPage;
import com.vtiger.ObjectRepository.ProductsPage;

public class ProductbyQuantityinStockTest extends BaseClass {

	@Test(groups="regressionTest")
	public void productbyQuantity() throws Throwable{ 
		
		/*random number*/
		int ramnum=jlib.getrandomnumber();
		
        /*Fetching the data from Excel*/
		String productname=excellib.acessTheDatafromExcelSheet("Product by Quantity", 1, 0)+"_"+ramnum;
		String quantity=excellib.acessTheDatafromExcelSheet("Product by Quantity", 1, 1);
		String selectbyquantity=excellib.acessTheDatafromExcelSheet("Product by Quantity", 1, 3);
		
        /*click on product link*/
		HomePage homepage=new HomePage(driver); 
		homepage.clickOnProductsLink();
		
        /*click on create product link*/
		ProductsPage productpage=new ProductsPage (driver);
		productpage.clickonCreateProduct();
		
        /*create product along with quantity*/
		CreateProductPage createproduct=new CreateProductPage(driver);
		createproduct.createProductandQuantity(productname,quantity);
	
		/*Validating the product*/
		ProductInformationPage productinformation=new ProductInformationPage (driver);
		String actualproductname=productinformation.productInformation();
		Assert.assertTrue(actualproductname.contains(productname), "product name is not matching");
	
		/*validating the quantity*/
		String actualquantity = productinformation.quantityInformation();
		Assert.assertTrue(actualquantity.contains(quantity), "Quantity is not matching");
	
		/*click on product link*/
		homepage.clickOnProductsLink();
		
		/*search the product by quantity*/
		productpage.searchProduct(quantity,selectbyquantity);	
		
		


	




	}
}