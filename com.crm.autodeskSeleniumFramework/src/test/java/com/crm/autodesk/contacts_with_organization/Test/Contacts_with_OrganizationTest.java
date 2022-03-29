package com.crm.autodesk.contacts_with_organization.Test;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.generic_utility.BaseClass;
import com.vtiger.ObjectRepository.ContactInformationPage;
import com.vtiger.ObjectRepository.ContactsPage;
import com.vtiger.ObjectRepository.CreateOrganizationPage;
import com.vtiger.ObjectRepository.CreatenewContactPage;
import com.vtiger.ObjectRepository.HomePage;
import com.vtiger.ObjectRepository.OrganizationInformationPage;
import com.vtiger.ObjectRepository.OrganizationPage;


public class Contacts_with_OrganizationTest extends BaseClass {
	@Test(groups="regressionTest")
	public void contactswithOrganization() throws Throwable{
	
		/*random number*/
		int ramnum=jlib.getrandomnumber();

		/*fetching the from the excel */
		String lastname=excellib.acessTheDatafromExcelSheet("Create_Contact", 1, 0)+"_"+ramnum;
		String orgName =excellib.acessTheDatafromExcelSheet("Create_Contact", 1, 2)+"_"+ramnum;
		
		/*click on the organization link*/
		HomePage homepage=new HomePage(driver); 
        homepage.clickOnOrganizationLink();
        
        /*clcick on the create organization image*/
		OrganizationPage organizationpage=new OrganizationPage(driver); 
        organizationpage.clickoncreateOrganization();
		
        /*create organization name*/
    	CreateOrganizationPage createorgname= new CreateOrganizationPage(driver);
        createorgname.createOrganization(orgName);
        
        /*validating thr organization name*/
		OrganizationInformationPage organizationInformation= new OrganizationInformationPage (driver); 
        String actualorgname = organizationInformation.actualOrganizationName();
        Assert.assertTrue(actualorgname.contains(orgName), "organization name is not updated");
		
		/* click on contacts link*/
		homepage.clickOnContactsLink();
		
		/*click on create contacts image*/
		ContactsPage contactpage=new ContactsPage(driver);
		contactpage.clickonCreateContact();
		
		/*create contact name and click on select image*/
		CreatenewContactPage createNewContact=new CreatenewContactPage(driver);
		createNewContact.lastNameandSelectimage(lastname);
	
		/*capture window id and switch*/
		createNewContact.switchandSearchOrganization(driver, orgName);
		
		/*validating the contact name*/
		ContactInformationPage contactinformation=new ContactInformationPage(driver);
		String headerTitletext = contactinformation.headertext();
		Assert.assertTrue(headerTitletext.contains(lastname), "last name is not updated");
		
		
		

























	}
}

