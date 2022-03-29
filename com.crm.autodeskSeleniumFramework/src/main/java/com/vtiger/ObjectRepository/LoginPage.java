package com.vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this is login repository
 * @author Prathith paul
 *
 */
public class LoginPage {
	
public LoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
	//Initialization of web elements
	

	//Decleration of web elements
	@FindBy(name="user_name")
	private WebElement userNamefield;

	@FindBy(name="user_password")
	private WebElement passwordfield;

	@FindBy(id="submitButton")
	private WebElement loginButton;

	//getters method to use it in the test scripts
	public WebElement getUserNamefield() {
		return userNamefield;
	}

	public WebElement getPasswordfield() {
		return passwordfield;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	//Business Logic
	/**
	 * this method is used for login the application
	 * @param username
	 * @param password
	 */
	public void login(String username,String password) {
		userNamefield.sendKeys(username);
		passwordfield.sendKeys(password);
		loginButton.click();





	}



}

