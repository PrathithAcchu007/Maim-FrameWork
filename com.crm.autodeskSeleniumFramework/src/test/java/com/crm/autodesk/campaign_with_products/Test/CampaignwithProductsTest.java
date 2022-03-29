package com.crm.autodesk.campaign_with_products.Test;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.generic_utility.BaseClass;

import com.vtiger.ObjectRepository.CampaignInformationPage;
import com.vtiger.ObjectRepository.CampaignPage;
import com.vtiger.ObjectRepository.CreateNewCampaignPage;
import com.vtiger.ObjectRepository.CreateProductPage;
import com.vtiger.ObjectRepository.HomePage;
import com.vtiger.ObjectRepository.ProductInformationPage;
import com.vtiger.ObjectRepository.ProductsPage;

public class CampaignwithProductsTest extends BaseClass{
	@Test(groups="smokeTest")
	public void campaignwithProduct() throws Throwable{
		
		/*random number*/
		int ramnum=jlib.getrandomnumber();
		
		/*click on products link*/
		HomePage homepage=new HomePage(driver);
		homepage.clickOnProductsLink();
		
		/*click on create product image*/
		ProductsPage productspage=new ProductsPage(driver);
		productspage.clickonCreateProduct();

		/*fetching the data from the excel*/
		String productname=excellib.acessTheDatafromExcelSheet("Create_Campaign", 1, 2)+"_"+ramnum;
		String campaignname=excellib.acessTheDatafromExcelSheet("Create_Campaign", 1, 0)+"_"+ramnum;

		/*create product*/
		CreateProductPage createproductpage=new CreateProductPage(driver);
		createproductpage.createProduct(productname);
		
		/*validating the product name*/
		ProductInformationPage productinfo=new ProductInformationPage(driver);
		String actualProduct = productinfo.productInformation();
		if(actualProduct.contains(productname)) {
			System.out.println("validation pass");
		}
		else {
			System.out.println("validation fail");
		}
		/*click on Campaign link*/
        homepage.moreLinkandClickonCampaign(driver);
        
        /*click on create campaign image*/
        CampaignPage campaignpage=new CampaignPage(driver);
        campaignpage.clickonCreateCampaignImage();

	    /*create campaign*/
        CreateNewCampaignPage createCampaign=new CreateNewCampaignPage(driver);
        createCampaign.createCampaignandSelectimage(campaignname);
        
        /*switch and search for the product*/
        createCampaign.switchandSearchProduct(driver, productname);
        
        /*validating the campaign name*/
        CampaignInformationPage campaigninfo=new CampaignInformationPage(driver);
        String actualcampaignname = campaigninfo.campaigntext();
        Assert.assertTrue(actualcampaignname.contains(campaignname), "campaign name is not updated");
		/*validating the product name*/
		String actualproductname = campaigninfo.productName();
		Assert.assertTrue(actualproductname.contains(productname), "product name is not updated");
		
		








	}

}
