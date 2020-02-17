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
	
	
	private static final By cityDropdown = By.cssSelector(".select2-container");
	private static final By cityNameTextBox = By.cssSelector("input#s2id_autogen2_search");
	//private static final By cityNameTextBox = By.xpath("//div[@class='select2-search']");
	private static final By selectCityNameFromDropdown = By.cssSelector("div#select2-result-label-3");
	//private static final By selectCityNameFromDropdown = By.xpath("//ul[@class='select2-results']");
	private static final By selectLocationButton = By.xpath("//button[text()='Select Location']");
	private static final By prelogInButton = By.xpath("//*[text()='Log In']");
	private static final By loginButtonForCitizen = By.xpath("//span[text() = 'Log In']");

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
				selectCity();
				logInApplicationForCitizen(userName, password);
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
	public void logInApplication(String userName, String password) {
		driver.typeText(userNameTextField, userName);
		driver.typeText(passwordTextField, password);
		driver.clickOnElement(loginButton);

	}
	public void logInApplicationForCitizen(String userName, String password) {
		String cityname = "neverland";
		driver.clickOnElement(cityDropdown);
		driver.typeText(cityNameTextBox, cityname);
		driver.clickOnElement(selectCityNameFromDropdown);
		driver.clickOnElement(selectLocationButton);
		driver.clickOnElement(prelogInButton);
		driver.wait(WAIT_SMALL);
		driver.typeText(userNameTextField, userName);
		driver.typeText(passwordTextField, password);
		driver.clickOnElement(loginButtonForCitizen);
		driver.wait(WAIT_SMALL);
		
	}
	public void selectCity() {
		
		
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
}
