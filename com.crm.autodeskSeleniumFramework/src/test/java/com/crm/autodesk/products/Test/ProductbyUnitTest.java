package com.crm.autodesk.products.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.generic_utility.BaseClass;
import com.vtiger.ObjectRepository.CreateProductPage;
import com.vtiger.ObjectRepository.HomePage;
import com.vtiger.ObjectRepository.ProductInformationPage;
import com.vtiger.ObjectRepository.ProductsPage;


public class ProductbyUnitTest extends BaseClass {
	
	@Test(groups="regressionTest")
	public void productbyUnit() throws Throwable{
		
		/*random number*/
		int ramnum=jlib.getrandomnumber();
		
		/*Fetching data from Excel*/
		String productname=excellib.acessTheDatafromExcelSheet("Product by Quantity", 1, 0)+"_"+ramnum;
		String qntUnit=excellib.acessTheDatafromExcelSheet("Product by Quantity", 1, 2);
		String searchbyQntUnit=excellib.acessTheDatafromExcelSheet("Product by Quantity", 1, 4);

        /*click on product link*/
		HomePage homepage=new HomePage(driver); 
		homepage.clickOnProductsLink();
		
        /*click on create product image*/
		ProductsPage productpage=new ProductsPage (driver);
		productpage.clickonCreateProduct();
		
        /*create product and input the quantity unit*/
		CreateProductPage createproduct=new CreateProductPage(driver);
		createproduct.createProductandUnit(productname,qntUnit);
		
	    /*Validating the product*/
		ProductInformationPage productinformation=new ProductInformationPage (driver);
		String actualproductname=productinformation.productInformation();
		Assert.assertTrue(actualproductname.contains(productname), "Product name is not matching");
	
        /*Validating the quantity unit*/
		String actualunit = productinformation.unitInformation();
		Assert.assertTrue(actualunit.contains(qntUnit), "Quantity unit is not matching");
	
		/*click on product link*/
		homepage.clickOnProductsLink();
		
		/*search the product by quantity unit*/
		productpage.searchProduct(qntUnit,searchbyQntUnit);
		
	






	}
}

