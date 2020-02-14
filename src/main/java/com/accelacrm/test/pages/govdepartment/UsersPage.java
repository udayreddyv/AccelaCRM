package com.accelacrm.test.pages.govdepartment;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.accelacrm.test.framework.selenium.DefaultWebDriver;
import com.accelacrm.test.framework.selenium.exception.FrameworkException;
import com.accelacrm.test.pages.BasePage;

public class UsersPage extends BasePage {

	public UsersPage(DefaultWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private static final Logger log = LogManager.getLogger(UsersPage.class);
	private static final By firstNameTextBox = By.id("firstname");
	private static final By lastNameTextBox = By.id("lastname");
	private static final By userNameTextBox = By.id("username");
	private static final By emailAddressTextBox = By.id("email");
	private static final By administraivePerDropdown = By.id("");
	
	private static final By requestEditPerDropdown = By.id("");
	private static final By saveButton = By.id("save-user-btn");
	private static final By statusMessage = By.xpath("//div[@class='alert alert-success pull-right']");
	
	 public String details;
	public String createUser() {
		//String details;
		String statusMessageForUser;
		log.info("Start Method for - createUser");
		try {
			details = RandomStringUtils.randomAlphabetic(8);
			driver.typeText(firstNameTextBox, details);
			driver.typeText(lastNameTextBox, details);
			driver.typeText(userNameTextBox, details);
			driver.typeText(emailAddressTextBox, details+"@gmail.com");
			driver.clickOnElement(saveButton);
			 statusMessageForUser = driver.getTextFromElement(statusMessage);
			 log.info("**************** :  "+statusMessageForUser);
			
		} catch (Exception ex) {
			log.error("Failed to go createUser");
			throw new FrameworkException(ex.toString());
			// TODO: handle exception
		}
		log.info("End Method for - createUser");
		return statusMessageForUser;
	}

}
