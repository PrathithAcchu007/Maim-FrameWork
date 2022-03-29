package com.crm.autodesk.organization.Test;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.generic_utility.BaseClass;
import com.vtiger.ObjectRepository.CreateOrganizationPage;
import com.vtiger.ObjectRepository.HomePage;
import com.vtiger.ObjectRepository.OrganizationInformationPage;
import com.vtiger.ObjectRepository.OrganizationPage;

public class CreateOrganizationandValidateTest extends BaseClass {
	@Test(groups="regressionTest")
	public void createOrganization() throws Throwable{
	
		/*random number*/
		int randomNum =jlib.getrandomnumber();

		/*fetching the data rom excel */
		String orgName = excellib.acessTheDatafromExcelSheet("Sheet1", 1, 0)+"_"+randomNum;
		System.out.println("organization name is "+orgName);

		/*click on organization link*/
		HomePage homepage=new HomePage(driver); 
		homepage.clickOnOrganizationLink();

		/*click on create organization image*/
		OrganizationPage organizationpage=new OrganizationPage(driver); 
		organizationpage.clickoncreateOrganization();

		/*create organization name*/
		CreateOrganizationPage createorganization=new CreateOrganizationPage(driver);
		createorganization.createOrganization(orgName);
		
		/*validating the organization*/
		OrganizationInformationPage organizationInformation= new OrganizationInformationPage (driver); 
		String actualorgname=organizationInformation.actualOrganizationName();
        Assert.assertTrue(actualorgname.contains(orgName), "organization is  not updated");
		

	}
}
