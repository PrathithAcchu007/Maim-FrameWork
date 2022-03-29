package com.crm.autodesk.campaigns.Test;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.generic_utility.BaseClass;
import com.vtiger.ObjectRepository.CampaignInformationPage;
import com.vtiger.ObjectRepository.CampaignPage;
import com.vtiger.ObjectRepository.CreateNewCampaignPage;
import com.vtiger.ObjectRepository.HomePage;

public class Create_CampaignTest extends BaseClass{
	@Test(groups="regressionTest")
	public void createCampaign() throws Throwable{
	
		/*click on campaign link*/
		HomePage homepage=new HomePage(driver);
		homepage.moreLinkandClickonCampaign(driver);
		
		/*random number*/
		int ramnum=jlib.getrandomnumber();

		/*fetching the data from the excel*/
		String campaignname=excellib.acessTheDatafromExcelSheet("Create_Campaign", 1, 0)+"_"+ramnum;
		String expectedmsg=excellib.acessTheDatafromExcelSheet("Create_Campaign", 1, 1);

		/*click on create campaign image*/
		CampaignPage campaignpage=new CampaignPage(driver);
		campaignpage.clickonCreateCampaignImage();
		
		/*create campaign name*/
		CreateNewCampaignPage createcampaign=new CreateNewCampaignPage(driver);
		createcampaign.createCampaigandSave(campaignname);
		
		/*validating the campaign name*/
		CampaignInformationPage campaigninformation=new CampaignInformationPage(driver);
		String actualcampaign = campaigninformation.campaigntext();
		Assert.assertTrue(actualcampaign.contains(expectedmsg), "campaign name is not updated");

	

		


	}


}     




