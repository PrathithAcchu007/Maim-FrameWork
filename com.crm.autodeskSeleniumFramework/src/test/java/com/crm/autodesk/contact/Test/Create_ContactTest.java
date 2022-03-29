package com.crm.autodesk.contact.Test;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.generic_utility.BaseClass;
import com.vtiger.ObjectRepository.ContactInformationPage;
import com.vtiger.ObjectRepository.ContactsPage;
import com.vtiger.ObjectRepository.CreatenewContactPage;
import com.vtiger.ObjectRepository.HomePage;

public class Create_ContactTest extends BaseClass {
	@Test(groups="smokeTest")
	public void creteContact() throws Throwable{
	
		/*click on contact link*/
		HomePage homepage=new HomePage(driver);
		homepage.clickOnContactsLink();
		
		/*click on create contact image*/
		ContactsPage contactpage=new ContactsPage(driver);
		contactpage.clickonCreateContact();

		/*random number*/
		int ramnum=jlib.getrandomnumber();
		
		/*fetching the data from the excel*/
		String lastname=excellib.acessTheDatafromExcelSheet("Create_Contact", 1, 0)+"_"+ramnum;
		
		/*create contact name*/
		CreatenewContactPage createcontact=new CreatenewContactPage(driver);
		createcontact.lastNameandSave(lastname);
		
		/*validating the contact name*/
		ContactInformationPage contactinformation=new ContactInformationPage(driver);
		String actualtext = contactinformation.headertext();
		Assert.assertTrue(actualtext.contains(lastname), "contact name is not updated");
		
	
	}
}
