package com.crm.autodesk.contact.Test;



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

public class Choose_Organization_in_contactTest extends BaseClass {
	@Test(groups="regressionTest")
	public void organizationinContact() throws Throwable{
		
		/*random number*/
		int ramnum=jlib.getrandomnumber();
		
		/*fetching the data from the excel*/
		String lastname=excellib.acessTheDatafromExcelSheet("Create_Contact", 1, 0)+"_"+ramnum;
		String organization=excellib.acessTheDatafromExcelSheet("Create_Contact", 1, 2)+"_"+ramnum;
		System.out.println("Last name is"+ lastname);
		
		/*click on organization link*/
		HomePage homepage=new HomePage(driver); 
		homepage.clickOnOrganizationLink();

		/*click on create organization image*/
		OrganizationPage organizationpage=new OrganizationPage(driver); 
		organizationpage.clickoncreateOrganization();

		/*create organization name*/
		CreateOrganizationPage createorganization=new CreateOrganizationPage(driver);
		createorganization.createOrganization(organization);
		
		/*validating the organization*/
		OrganizationInformationPage organizationInformation= new OrganizationInformationPage (driver); 
		String actualorgname=organizationInformation.actualOrganizationName();
       Assert.assertTrue(actualorgname.contains(organization), "Organization is not updated");
	
		/*click on contact link*/
		homepage.clickOnContactsLink();
		
		/*click on create contact image*/
		ContactsPage contactspage= new ContactsPage(driver);
		contactspage.clickonCreateContact();
		
		/*create contact name*/
		CreatenewContactPage createcontact=new CreatenewContactPage(driver);
		createcontact.lastNameandSelectimage(lastname);
		
		/*switch and search organization*/
		createcontact.switchandSearchOrganization(driver, organization);
		
		/*validation the contact name*/
		ContactInformationPage contactinformation= new ContactInformationPage(driver);
		String actualtext = contactinformation.headertext();
		Assert.assertTrue(actualtext.contains(lastname), "Contact name is not updated");
	
		/*validating the organization name*/
		String actualorgname1 = contactinformation.organizationName();
	       Assert.assertTrue(actualorgname1.contains(organization), "Organization is not updated");








	}

}
