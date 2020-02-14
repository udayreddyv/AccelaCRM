package com.accelacrm.test.pages.citizen.login;

import com.accelacrm.test.framework.selenium.DefaultWebDriver;
import com.accelacrm.test.framework.selenium.exception.FrameworkException;
import com.accelacrm.test.pages.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

	private static final Logger log = LogManager.getLogger(LoginPage.class);
	private static final By userNameTextField = By.xpath("//input[@name = 'email']");
	private static final By passwordTextField = By.xpath("//input[@name = 'password']");
	private static final By loginButton = By.xpath("//input[@type = 'submit']");
	
	private static final By logOutButton = By.xpath("//a[contains(text(),'Log Out')]");

	public LoginPage(DefaultWebDriver driver) {
		super(driver);
	}

	/**
	 * login : To application login
	 * 
	 * @param userName : UserName in String format
	 * @param password : Password in String format
	 */

	public void login(String userName, String password) {
		log.info("Start of the method - login");
		try {
			switch (module) {
			case "GOVADMIN":

				logInApplication(userName, password);
				break;
			case "GOVUSER":
				logInApplication(userName, password);
				break;
			case "IFRAME":
				logInApplication(userName, password);
				break;
			default:
				log.info("invalid URL");
				break;
			}
			/*
			 * driver.typeText(userNameTextField, userName);
			 * driver.typeText(passwordTextField, password);
			 * driver.clickOnElement(loginButton);
			 */
		} catch (Exception ex) {
			log.error("Failed to login");
			throw new FrameworkException(ex.toString());
		}
		log.info("End of the method - login");
	}

	/**
	 * logInApplication : To do logIn Application
	 * 
	 * @param userName : userName as string format
	 * @param password : password as string format
	 */
	 private String userNameData;
	public void logInApplication(String userName, String password) {
		driver.typeText(userNameTextField, userName);		
		driver.typeText(passwordTextField, password);		
		driver.clickOnElement(loginButton);
		

	}

	/**
	 * logout : To click on logout Button
	 */
	public void logout() {
		log.info("Start of the method - logout");
		try {
			driver.clickOnElement(logOutButton);
		} catch (Exception ex) {
			log.error("Failed to login");
			throw new FrameworkException(ex.toString());
		}
		log.info("End of the method - login");
	}

	public String getUserNameData() {
		return userNameData;
	}

	public void setUserNameData(String userNameData) {
		this.userNameData = userNameData;
	}
}
