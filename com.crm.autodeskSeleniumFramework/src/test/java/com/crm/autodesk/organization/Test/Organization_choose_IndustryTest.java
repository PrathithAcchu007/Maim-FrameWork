package com.crm.autodesk.organization.Test;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.generic_utility.BaseClass;
import com.vtiger.ObjectRepository.CreateOrganizationPage;
import com.vtiger.ObjectRepository.HomePage;
import com.vtiger.ObjectRepository.OrganizationInformationPage;
import com.vtiger.ObjectRepository.OrganizationPage;


public class Organization_choose_IndustryTest extends BaseClass {

	@Test(groups="smokeTest")
	public void orgwithIndustry() throws Throwable{

		
        /*random number*/
		int randomNum =jlib.getrandomnumber();
		
        /*Fetching the data from the Excel*/
		String orgName = excellib.acessTheDatafromExcelSheet("Sheet1", 1, 0)+"_"+randomNum;
		String industryname=excellib.acessTheDatafromExcelSheet("Sheet1", 1, 3);
		System.out.println("organization name is "+orgName);


		/*click on organization link */
		HomePage homepage=new HomePage(driver); 
		homepage.clickOnOrganizationLink();

		/*click on "+" image*/ 
		OrganizationPage organizationpage=new OrganizationPage(driver); 
		organizationpage.clickoncreateOrganization();
		
		/*enter organization name and choose industry*/ 
		CreateOrganizationPage createorganization=new CreateOrganizationPage(driver);
		createorganization.createOrganization(orgName, industryname);

		/*validating the organization name*/
		OrganizationInformationPage organizationInformation= new OrganizationInformationPage (driver); 
		String actualorgname=organizationInformation.actualOrganizationName();
        Assert.assertTrue(actualorgname.contains(orgName), "organization is not updated");
		
		/*validating industry*/
		String actualindustryname=organizationInformation.actualIndustryName();
		Assert.assertTrue(actualindustryname.contains(industryname), "industry name is not updated");
		




	}
}

